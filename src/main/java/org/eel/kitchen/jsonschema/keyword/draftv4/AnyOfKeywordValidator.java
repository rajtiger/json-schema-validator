/*
 * Copyright (c) 2012, Francis Galiegue <fgaliegue@gmail.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the Lesser GNU General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * Lesser GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.eel.kitchen.jsonschema.keyword.draftv4;

import com.fasterxml.jackson.databind.JsonNode;
import org.eel.kitchen.jsonschema.report.Message;
import org.eel.kitchen.jsonschema.report.ValidationReport;
import org.eel.kitchen.jsonschema.validator.JsonValidator;
import org.eel.kitchen.jsonschema.validator.ValidationContext;

public final class AnyOfKeywordValidator
    extends SchemaArrayKeywordValidator
{
    /**
     * Constructor
     *
     */
    public AnyOfKeywordValidator(final JsonNode schema)
    {
        super("anyOf", schema);
    }
    @Override
    protected void validate(final ValidationContext context,
        final ValidationReport report, final JsonNode instance)
    {
        JsonValidator validator;

        final ValidationReport schemaReport = report.copy();
        ValidationReport subReport;

        for (final JsonNode subSchema: subSchemas) {
            validator = context.newValidator(subSchema);
            subReport = report.copy();
            validator.validate(context, subReport, instance);
            if (subReport.isSuccess())
                return;
            schemaReport.mergeWith(subReport);
        }

        report.mergeWith(schemaReport);

        final Message.Builder msg = newMsg()
            .setMessage("instance does not validate against any schema");

        report.addMessage(msg.build());
    }

    @Override
    public String toString()
    {
        return "any of " + subSchemas.size() + " schema(s)";
    }
}
