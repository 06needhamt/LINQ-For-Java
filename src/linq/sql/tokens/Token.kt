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

import linq.sql.SQLParseException

/**
 * Created by Tom Needham on 09/03/2016.
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
    companion object HelperFunctions {
        /**
         * resolves the name of the operator by the typed operator
         * @return Returns the [EnumOperatorToken] type of a typed operator
         */
        fun ResolveNameOperator(str : String?) : TokenType.EnumOperatorToken? {
            if (str == null)
                throw SQLParseException("Cannot parse operator")
            var result : TokenType.EnumOperatorToken
            when (str) {
                "=" -> result = TokenType.EnumOperatorToken.EQUAL
                "!=" -> result = TokenType.EnumOperatorToken.NOT_EQUAL
                "<" -> result = TokenType.EnumOperatorToken.LESS_THAN
                "!<" -> result = TokenType.EnumOperatorToken.NOT_LESS_THAN
                "!>" -> result = TokenType.EnumOperatorToken.NOT_GREATER_THAN
                ">=" -> result = TokenType.EnumOperatorToken.GREATER_OR_EQUAL
                "<=" -> result = TokenType.EnumOperatorToken.LESS_OR_EQUAL
                "*" -> result = TokenType.EnumOperatorToken.ALL
                else -> return null
            }
            return result
        }

        fun ResolveNameKeyword(str : String?) : TokenType.EnumKeywordToken? {
            if (str == null)
                throw SQLParseException("Cannot parse operator")
            var result : TokenType.EnumKeywordToken
            when (str) {
                "*" -> result = TokenType.EnumKeywordToken.ALL
                else -> return null
            }
            return result
        }

        fun ResolveNameGeneric(str : String?) : TokenType.EnumGenericToken? {
            if (str == null)
                throw SQLParseException("Cannot parse operator")
            var result : TokenType.EnumGenericToken
            when (str) {
                "\n" -> result = TokenType.EnumGenericToken.NEW_LINE
                "\t" -> result = TokenType.EnumGenericToken.TAB
                " " -> result = TokenType.EnumGenericToken.SPACE
                "," -> result = TokenType.EnumGenericToken.COMMA
                "." -> result = TokenType.EnumGenericToken.DOT
                ";" -> result = TokenType.EnumGenericToken.SEMICOLON
                "(" -> result = TokenType.EnumGenericToken.OPEN_BRACKET
                ")" -> result = TokenType.EnumGenericToken.CLOSE_BRACKET
                else -> result = TokenType.EnumGenericToken.IDENTIFIER
            }
            return result
        }

        /**
         * resolves the typed operator by the type
         * @return Returns the [String] representation of the typed operator
         */
        fun ResolveOperator(enum: TokenType.EnumOperatorToken?) : String? {
            var result : String
            when(enum) {
                TokenType.EnumOperatorToken.EQUAL -> result = "="
                TokenType.EnumOperatorToken.NOT_EQUAL -> result = "!="
                TokenType.EnumOperatorToken.GREATER_THAN -> result = ">"
                TokenType.EnumOperatorToken.LESS_THAN -> result = "<"
                TokenType.EnumOperatorToken.NOT_LESS_THAN -> result = "!<"
                TokenType.EnumOperatorToken.NOT_GREATER_THAN -> result = "!>"
                TokenType.EnumOperatorToken.GREATER_OR_EQUAL -> result = ">="
                TokenType.EnumOperatorToken.LESS_OR_EQUAL -> result = "<="
                TokenType.EnumOperatorToken.ALL -> result = "*"
                else -> return null
            }
            return result
        }

    }
}
