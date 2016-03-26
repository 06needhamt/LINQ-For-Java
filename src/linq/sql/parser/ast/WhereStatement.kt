package linq.sql.parser.ast

import linq.sql.parser.ast.exceptions.InvalidStatementParametersException
import linq.sql.tokens.Token
import java.util.*

/**
 * Created by Thomas Needham on 12/03/2016.
 */
class WhereStatement : Statement, StatementType {
    override val type : StatementType.EnumStatementType
    override val numberOfParameters : Int
    override val parameterStatements : ArrayList<Statement?>
    override val parameterTokens : ArrayList<Token?>

    constructor(parameterStatements : ArrayList<Statement?>, numberOfParameters : Int){
        val annotation : Class<NumberOfParameters> = NumberOfParameters::class.java
        this.type = ResolveType()
        this.parameterStatements = parameterStatements
        this.numberOfParameters = numberOfParameters
        this.parameterTokens = ArrayList<Token?>()
        if(this.numberOfParameters != this.type.javaClass.getAnnotation(annotation).parameters)
            throw InvalidStatementParametersException(this.numberOfParameters, this.type.javaClass.getAnnotation(annotation).parameters)
    }
    constructor(parameterTokens : ArrayList<Token?>, numberOfParameters : Int, returnsValue: Boolean = true){
        val annotation : Class<NumberOfParameters> = NumberOfParameters::class.java
        this.type = ResolveType()
        this.parameterStatements = ArrayList<Statement?>()
        this.numberOfParameters = numberOfParameters
        this.parameterTokens = parameterTokens
        if(this.numberOfParameters != this.type.javaClass.getAnnotation(annotation).parameters)
            throw InvalidStatementParametersException(this.numberOfParameters, this.type.javaClass.getAnnotation(annotation).parameters)
    }

    override fun ResolveType() : StatementType.EnumStatementType {
        return StatementType.EnumStatementType.WHERE
    }

    override fun Statement.IsQuery() : Boolean {
        throw UnsupportedOperationException()
    }

    override fun Statement.ToQuery() : Query? {
        throw UnsupportedOperationException()
    }
}