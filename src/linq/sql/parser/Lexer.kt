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

/**
 * Created by Tom Needham on 09/03/2016.
 */
import linq.EnumHelperFunctions
import linq.NumberHelperFunctions
import linq.sql.SQLParseException
import linq.sql.tokens.*
import java.io.*
import java.util.*

class Lexer {
    val inputString : String
    val file : File?
    var tokenStrings : LinkedList<String?> = LinkedList<String?>()
    var tokens : LinkedList<Token?> = LinkedList<Token?>()

    constructor(inputString : String) {
        this.inputString = inputString
        file = null
    }

    constructor(file : File) {
        this.file = file
        val input = FileInputStream(file)
        inputString = file.readText()
    }

    fun Start() : Boolean {
        if (inputString == "")
            return false
        tokenStrings = Tokenize()
        tokens = CreateTokens()
        PrintTokens()
        return true
    }

    fun Tokenize() : LinkedList<String?> {
        //val list : LinkedList<String?> = LinkedList(inputString.split(String.format(WITH_DELIMITER,' ', ',', '\n', '\"', '(', ')', '"')).toList())
        val list : LinkedList<String?> = SplitString(inputString, ' ', ',', '\n', '\t', '\"', '(', ')', '"')
        for (value : String? in list) {
            if (value == "\n" || value == "\t")
                list.remove(value)
        }
        for (item : String? in list) {
            println(item)
        }
        return list
    }

    fun CreateTokens() : LinkedList<Token?> {
        var list : LinkedList<Token?> = LinkedList<Token?>()
        var stringLiteralBuffer : String = ""
        for (str : String? in tokenStrings) {
            if (str == null)
                throw SQLParseException("Found invalid token")
            if (EnumHelperFunctions.SafeContainsValueKeyword(str)) {
                val token : KeywordToken = KeywordToken(str)
                list.add(token as Token)
            }
            else if (EnumHelperFunctions.SafeContainsValueOperator(str)) {
                val token : OperatorToken = OperatorToken(str)
                list.add(token as Token)
            }
            else if (NumberHelperFunctions.SafeParseDouble(str)) {
                val token : NumericLiteralToken = NumericLiteralToken(str)
                list.add(token as Token)
            }
            else if (str.startsWith("\"", true)) {
                while (!stringLiteralBuffer.endsWith("\"")) {
                    stringLiteralBuffer += str
                    continue
                }
                stringLiteralBuffer.removePrefix("\"")
                stringLiteralBuffer.removeSuffix("\"")
                val token : StringLiteralToken = StringLiteralToken(stringLiteralBuffer)
                list.add(token as Token)
            }
            else if (EnumHelperFunctions.SafeContainsValueGeneric(str)) {
                when (str) {
                    "(", ")", ";", ",", "." -> {
                        val token : GenericToken = GenericToken(str)
                        list.add(token as Token)
                    }

                    "\n", "\t", " " -> {
                        val token : WhitespaceToken = WhitespaceToken(str)
                        list.add(token as Token)
                    }
                    else -> throw SQLParseException("Found Unknown Token")
                }
            }
            else{
                val token : IdentifierToken = IdentifierToken(str)
                list.add(token as Token);
            }

        }
        return list
    }

    fun PrintTokens() : Unit {
        for (tok : Token? in tokens) {
            if (tok is GenericToken) {
                println(tok?.value + " : " + tok?.type.toString())
            } else if (tok is IdentifierToken) {
                println(tok?.value + " : " + "IDENTIFIER")
            } else if (tok is KeywordToken) {
                println(tok?.value + " : " + tok?.type.toString())
            } else if (tok is NumericLiteralToken) {
                println(tok?.value + " : " + tok?.type.toString())
            } else if (tok is StringLiteralToken) {
                println(tok?.value + " : " + tok?.type.toString())
            } else if (tok is OperatorToken) {
                println(tok?.value + " : " + tok.type.toString())
            } else if (tok is WhitespaceToken) {
                println(tok?.value + " : " + tok?.type.toString())
            } else {
                throw SQLParseException("Invalid Token Type")
            }
        }
    }

    private fun SplitString(str : String, vararg delim : Char) : LinkedList<String?> {
        var build : String = ""
        val result : LinkedList<String?> = LinkedList<String?>()
        for (item : Char in str) {
            for (j : Char in delim) {
                if (item == j) {
                    result.addLast(build)
                    build = ""
                    if (j != '\n' && j != ' ')
                        build += j
                    break
                } else {
                    build += item
                    break
                }
            }
        }
        result.addLast(build)
        return result
    }
}