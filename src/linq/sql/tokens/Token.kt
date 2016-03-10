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

/**
 * Created by thoma on 09/03/2016.
 */
abstract class Token {
    /**
     * Property for the string representation of the [Token] i.e. "="
     */
    abstract var value: String

    /**
     * Resolves the type of this token i.e keyword or operator
     * @param token the [Token] to resolve the type of
     */
    abstract fun ResolveType(token: Token) : Unit

    /**
     * Returns whether the [Token] is a keyword i.e WHERE or SELECT
     * @param token the [Token] to check
     * @return whether the [Token] is a keyword
     */
    abstract fun IsKeyword(token : Token) : Boolean
    /**
     * Returns whether the [Token] is a operator i.e = or >
     * @param token the [Token] to check
     * @return whether the [Token] is a operator
     */
    abstract fun IsOperator(token : Token) : Boolean
    /**
     * Returns whether the [Token] is whitespace i.e ' ' or \n
     * @param token the [Token] to check
     * @return whether the [Token] is whitespace
     */
    abstract fun IsWhitespace(token : Token) : Boolean
    /**
     * Returns whether the [Token] is a string literal i.e "Hello"
     * @param token the [Token] to check
     * @return whether the [Token] is a string literal
     */
    abstract fun IsStringLiteral(token : Token) : Boolean
    /**
     * Returns whether the [Token] is a numeric literal i.e 12345
     * @param token the [Token] to check
     * @return whether the [Token] is a numeric literal
     */
    abstract fun IsNumericLiteral(token : Token) : Boolean
    /**
     * Returns whether the [Token] is an identifier
     * an identifier is any token that does not match any other token types
     * @param token the [Token] to check
     * @return whether the [Token] is a string literal
     */
    abstract fun IsIdentifier(token : Token) : Boolean
}