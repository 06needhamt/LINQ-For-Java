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
 * Created by Tom Needham on 09/03/2016.
 */
class KeywordToken : Token, TokenType {
    override val name : String
        get() = value

    var type : TokenType.EnumKeywordToken? = null

    constructor(value: String){
        this.value = value
        ResolveType(this);
    }
    override fun IsIdentifier(token : Token) : Boolean {
        return false
    }

    override var value : String

    override fun ResolveType(token : Token) {
        if(TokenType.EnumKeywordToken.values().contains(Token.HelperFunctions.ResolveNameKeyword(value))){
            type =Token.HelperFunctions.ResolveNameKeyword(value)
        }
        else {
            type = TokenType.EnumKeywordToken.valueOf(value)
        }
    }

    override fun IsKeyword(token : Token) : Boolean {
        return true
    }

    override fun IsOperator(token : Token) : Boolean {
        return false
    }

    override fun IsWhitespace(token : Token) : Boolean {
        return false
    }

    override fun IsStringLiteral(token : Token) : Boolean {
        return false
    }

    override fun IsNumericLiteral(token : Token) : Boolean {
        return false
    }
}