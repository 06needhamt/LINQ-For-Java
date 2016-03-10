/* The MIT License (MIT)

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
package linq

import linq.sql.tokens.Token
import linq.sql.tokens.TokenType

/**
 * Created by Tom Needham on 10/03/2016.
 */
class EnumHelperFunctions {
    companion object Functions{
        fun SafeContainsValueKeyword(value: String) : Boolean{
            var bool : Boolean
            try{
                bool = TokenType.EnumKeywordToken.values().contains(TokenType.EnumKeywordToken.valueOf(value.toString()))
            }
            catch (ex: IllegalArgumentException){
                bool = Token.ResolveNameKeyword(value) != null
                return bool
            }
            return bool
        }
        fun SafeContainsValueOperator(value: String) : Boolean{
            var bool : Boolean
            try{
                bool = TokenType.EnumOperatorToken.values().contains(TokenType.EnumOperatorToken.valueOf(value.toString()))
            }
            catch (ex: IllegalArgumentException){
                bool = Token.ResolveNameOperator(value) != null
            }
            return bool
        }

        fun SafeContainsValueGeneric(value: String) : Boolean{
            val bool : Boolean
            try{
                bool = TokenType.EnumGenericToken.values().contains(TokenType.EnumGenericToken.valueOf(value.toString()))
            }
            catch (ex: IllegalArgumentException){
                return false
            }
            return bool
        }
    }
}