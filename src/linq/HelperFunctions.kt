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

import java.util.AbstractList
import java.util.ArrayList
import java.util.StringJoiner

/**
 * Created by Tom Needham on 20/02/2016.
 */
fun CastStringList(list: List<Any>): List<String> {
    val cast = ArrayList<String>()
    for (str in list)
        if (str is String)
            cast.add(str)
    return cast
}

fun CastDoubleList(list: List<Any>): List<Double> {
    val cast = ArrayList<Double>()
    for (str in list)
        if (str is Double)
            cast.add(str)
    return cast
}

fun CastFloatList(list: List<Any>): List<Float> {
    val cast = ArrayList<Float>()
    for (str in list)
        if (str is Float)
            cast.add(str)
    return cast
}

fun CastLongList(list: List<Any>): List<Long> {
    val cast = ArrayList<Long>()
    for (str in list)
        if (str is Long)
            cast.add(str)
    return cast
}

fun CastIntegerList(list: List<Any>): List<Int> {
    val cast = ArrayList<Int>()
    for (str in list)
        if (str is Int)
            cast.add(str)
    return cast
}

fun CastShortList(list: List<Any>): List<Short> {
    val cast = ArrayList<Short>()
    for (str in list)
        if (str is Short)
            cast.add(str)
    return cast
}

fun CastBooleanList(list: List<Any>): List<Boolean> {
    val cast = ArrayList<Boolean>()
    for (str in list)
        if (str is Boolean)
            cast.add(str)
    return cast
}

fun CastStringArray(array: Array<Any>): Array<String?> {
    val cast = arrayOfNulls<String>(array.size)
    for (i in array.indices) {
        if (array[i] is String) {
            cast[i] = array[i] as String
        }
    }
    return cast
}

fun CastDoubleArray(array: Array<Any>): Array<Double?> {
    val cast = arrayOfNulls<Double>(array.size)
    for (i in array.indices) {
        if (array[i] is Double) {
            cast[i] = array[i] as Double
        }
    }
    return cast
}

fun CastFloatArray(array: Array<Any>): Array<Float?> {
    val cast = arrayOfNulls<Float>(array.size)
    for (i in array.indices) {
        if (array[i] is Float) {
            cast[i] = array[i] as Float
        }
    }
    return cast
}

fun CastLongArray(array: Array<Any>): Array<Long?> {
    val cast = arrayOfNulls<Long>(array.size)
    for (i in array.indices) {
        if (array[i] is Long) {
            cast[i] = array[i] as Long
        }
    }
    return cast
}

fun CastIntegerArray(array: Array<Any>): Array<Int?> {
    val cast = arrayOfNulls<Int>(array.size)
    for (i in array.indices) {
        if (array[i] is Int) {
            cast[i] = array[i] as Int
        }
    }
    return cast
}

fun CastShortArray(array: Array<Any>): Array<Short?> {
    val cast = arrayOfNulls<Short>(array.size)
    for (i in array.indices) {
        if (array[i] is Short) {
            cast[i] = array[i] as Short
        }
    }
    return cast
}

fun CastBooleanArray(array: Array<Any>): Array<Boolean?> {
    val cast = arrayOfNulls<Boolean>(array.size)
    for (i in array.indices) {
        if (array[i] is Boolean) {
            cast[i] = array[i] as Boolean
        }
    }
    return cast
}
