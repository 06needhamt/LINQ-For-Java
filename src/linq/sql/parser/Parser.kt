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
package linq.sql.parser

import linq.collections.LinqListFunctions
import linq.sql.parser.ast.Statement
import linq.sql.parser.ast.WhereStatement
import linq.sql.tokens.KeywordToken
import linq.sql.tokens.Token
import linq.sql.tokens.TokenType
import java.util.*

/**
 * Created by Tom Needham on 10/03/2016.
 */
class Parser {
    val lexical : Lexer
    val statements : ArrayList<Statement?> = ArrayList<Statement?>()

    constructor(lexical: Lexer){
        this.lexical = lexical
    }

    fun CreateStatements() : ArrayList<Statement?>{
        val statementList = ArrayList<Statement?>()
        var i : Int = 0
        while(i < lexical.tokens.size - 1){
            val tok : Token? = lexical.tokens.get(i)
            if(tok is KeywordToken){
                when (tok.type){
                    TokenType.EnumKeywordToken.WHERE -> {
                        val tokens : ArrayList<Token?> = ArrayList(LinqListFunctions.Take(lexical.tokens,3))
                        val smt : WhereStatement = WhereStatement(tokens,3)
                        i += 2
                    }
                }
            }
        }
        return statementList
    }
    fun ReturnsValue() : Boolean{
        val tok = LinqListFunctions.First(lexical.tokens)
        if(tok is KeywordToken)
            return tok.type == TokenType.EnumKeywordToken.SELECT
        else
            return false
    }

}