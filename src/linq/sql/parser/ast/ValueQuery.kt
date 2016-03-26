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

import linq.sql.parser.ast.exceptions.InvalidQueryException
import linq.sql.parser.ast.exceptions.InvalidStatementException
import java.util.*

/**
 * Created by Tom Needham on 13/03/2016.
 */
class ValueQuery : Query {
    override val statements : ArrayList<Statement>

    constructor(statements : ArrayList<Statement>){
        if(statements.size == 0)
            throw InvalidQueryException("Can not construct a query with no statements")
        this.statements = statements
    }
    override fun Validate() : Boolean {
        var prev : Statement? = null
        for(smt: Statement in statements){
            when(smt.type){
                StatementType.EnumStatementType.SELECT -> {
                    if(prev != null)
                        throw InvalidStatementException("SELECT must be the first statement in a query")
                    prev = smt
                }
                StatementType.EnumStatementType.WHERE -> {
                    if(prev == null || prev.type != StatementType.EnumStatementType.IDENTIFIER)
                        throw InvalidStatementException("WHERE must be preceded by an identifier")
                    prev = smt
                }
                StatementType.EnumStatementType.FROM -> {
                    if(prev == null || prev.type != StatementType.EnumStatementType.ALL
                            || prev.type != StatementType.EnumStatementType.IDENTIFIER)
                        throw InvalidStatementException("FROM must be preceded by an identifier")
                    prev = smt
                }
                StatementType.EnumStatementType.ALL -> {
                    if(prev == null || prev.type != StatementType.EnumStatementType.SELECT)
                        throw InvalidStatementException("* Must be preceded by SELECT")
                    prev = smt
                }
                StatementType.EnumStatementType.IDENTIFIER -> {
                    if(prev == null)
                        throw InvalidStatementException("The first statement in a query must not be an identifier")
                    prev = smt
                }
                StatementType.EnumStatementType.IF -> {
                    if(prev == null || prev.type != StatementType.EnumStatementType.IDENTIFIER)
                        throw InvalidStatementException("IF must be preceded by an identifier")
                    prev = smt
                }
                StatementType.EnumStatementType.OPERATOR -> {
                    if(prev == null || prev.type != StatementType.EnumStatementType.IDENTIFIER)
                        throw InvalidStatementException("Operators must be preceded by an identifier")
                    prev = smt
                }
                else -> {
                    throw Exception("Not Implemented Yet!")
                }
            }
        }
        return true
    }

    override fun Execute() : ResultSet {
        throw UnsupportedOperationException()
    }
}