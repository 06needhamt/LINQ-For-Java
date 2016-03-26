/*
The MIT License (MIT)

Copyright (c) 2016 Tom Needham

Permission is hereby granted, free of charge, to any person obtaining a
copy of this software and associated documentation files (the
"Software"), to deal in the Software without restriction, including
without limitation the rights to use, copy, modify, merge, publish,
distribute, sublicense, and/or sell copies of the Software, and to
permit persons to whom the Software is furnished to do so, subject to
the following conditions:

The above copyright notice and this permission notice shall be included
in all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS
OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY
CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE
SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package linq.sql.tokens

import linq.sql.exceptions.SQLParseException

/**
 * Created by Tom Needham on 09/03/2016.
 */

interface TokenType {
    val name : String

    /**
     * This enum class contains information about keywords
     */
    enum class EnumKeywordToken {
        SELECT,
        WHERE,
        FROM,
        INNER,
        OUTER,
        LEFT,
        RIGHT,
        JOIN,
        ON,
        IN,
        IF,
        AND,
        OR,
        NOT,
        ELSE,
        BY,
        ORDER,
        LIKE,
        ORDERBY,
        GROUPBY,
        DISTINCT,
        IS_NULL,
        ALL,
        ANY,
        BETWEEN,
        UNIQUE;
    }
    /**
     * This enum class contains information about operators
     */
    enum class EnumOperatorToken{
        EQUAL,
        NOT_EQUAL,
        GREATER_THAN,
        LESS_THAN,
        NOT_LESS_THAN,
        NOT_GREATER_THAN,
        GREATER_OR_EQUAL,
        LESS_OR_EQUAL,
        ALL;
    }
    enum class EnumGenericToken {
        IDENTIFIER,
        OPEN_BRACKET,
        CLOSE_BRACKET,
        COMMA,
        DOT,
        SEMICOLON,
        STRING_LITERAL,
        NUMERIC_LITERAL,
        NEW_LINE,
        SPACE,
        TAB;
    }
    /**
     * Returns the name of the [TokenType]
     * @return Returns the [String] representation of the [TokenType]
     */
    fun TokenType.ToString() : String {
        return name
    }

    /**
     * Compares two [Token] by their type
     * @param otherName other tokens type
     * @return whether the two [Token] have the same [TokenType]
     */
    fun TokenType.EqualsName(otherName : String?) : Boolean{
        if(otherName == null)
            return false
        else
            return name == (otherName)
    }
}