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
 * Created by thoma on 09/03/2016.
 */
import java.io.*;
import java.util.*

class Lexer {
    val inputString : String
    val file : File?

    constructor(inputString: String){
        this.inputString = inputString
        file = null
    }

    constructor(file: File){
        this.file = file
        val input = FileInputStream(file)
        inputString = file.readText()
    }

    fun Start() : Boolean{
        if(inputString == "")
            return false
        Tokenize()
        return true
    }

    fun Tokenize() : LinkedList<String?>{
        //val list : LinkedList<String?> = LinkedList(inputString.split(String.format(WITH_DELIMITER,' ', ',', '\n', '\"', '(', ')', '"')).toList())
        val list : LinkedList<String?> = SplitString(inputString,' ', ',', '\n', '\"', '(', ')', '"')
        for (value: String? in list){
            if(value == "\n")
                list.remove(value)
        }
        for(item: String? in list){
            println(item)
        }
        return list
    }

    private fun SplitString(str: String, vararg delim: Char ) : LinkedList<String?>{
        var build : String = ""
        val result : LinkedList<String?> = LinkedList<String?>()
        for(item: Char in str){
            for(j: Char in delim){
                if(item == j) {
                    result.addLast(build)
                    build = ""
                    if(j != '\n' && j != ' ')
                        build += j
                    break
                }
                else {
                    build += item
                    break
                }
            }
        }
        result.addLast(build)
        return result
    }
}