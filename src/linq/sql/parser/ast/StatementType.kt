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
package linq.sql.parser.ast

/**
 * Created by Tom Needham on 12/03/2016.
 */
interface StatementType {
    enum class EnumStatementType{
        @NumberOfParameters(1)
        SELECT,
        @NumberOfParameters(1)
        FROM,
        @NumberOfParameters(3)
        WHERE,
        @NumberOfParameters(1)
        INNER_JOIN,
        @NumberOfParameters(1)
        OUTER_JOIN,
        @NumberOfParameters(1)
        LEFT_JOIN,
        @NumberOfParameters(1)
        RIGHT_JOIN,
        @NumberOfParameters(1)
        JOIN,
        @NumberOfParameters(1)
        IN,
        @NumberOfParameters(1)
        ON,
        @NumberOfParameters(1)
        IF,
        @NumberOfParameters(1)
        AND,
        @NumberOfParameters(1)
        OR,
        @NumberOfParameters(1)
        NOT,
        @NumberOfParameters(1)
        ELSE,
        @NumberOfParameters(1)
        BY,
        @NumberOfParameters(1)
        ORDER,
        @NumberOfParameters(1)
        LIKE,
        @NumberOfParameters(2)
        ORDERBY,
        @NumberOfParameters(2)
        GROUPBY,
        @NumberOfParameters(0)
        DISTINCT,
        @NumberOfParameters(1)
        IS_NULL,
        @NumberOfParameters(0)
        ALL,
        @NumberOfParameters(0)
        ANY,
        @NumberOfParameters(1)
        BETWEEN,
        @NumberOfParameters(0)
        UNIQUE,
        @NumberOfParameters(1)
        IDENTIFIER,
        @NumberOfParameters(1)
        OPERATOR,
        @NumberOfParameters(0)
        STRING_LITERAL,
        @NumberOfParameters(0)
        NUMERIC_LITERAL;
    }
}