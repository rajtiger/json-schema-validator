/*
 * Copyright (c) 2013, Francis Galiegue <fgaliegue@gmail.com>
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

package com.github.fge.jsonschema.messages;

public enum SyntaxMessages
{
    NOT_A_SCHEMA("document is not a JSON Schema: not an object"),
    UNKNOWN_KEYWORDS("unknown keyword(s) found; ignored"),
    INCORRECT_TYPE("keyword has incorrect type"),
    INTEGER_TOO_LARGE("integer value too large"),
    INTEGER_IS_NEGATIVE("integer value must be positive"),
    EXCLUSIVEMINIMUM("exclusiveMinimum must be paired with minimum"),
    EXCLUSIVEMAXIMUM("exclusiveMaximum must be paired with maximum"),
    INVALID_REGEX_MEMBER_NAME("member name is not a valid ECMA 262 regular expression");

    private final String message;

    SyntaxMessages(final String message)
    {
        this.message = message;
    }

    @Override
    public String toString()
    {
        return message;
    }
}
