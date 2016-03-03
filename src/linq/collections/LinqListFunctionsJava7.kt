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

package linq.collections

import linq.lamdba.LINQLambda
import java.util.*

/**
 * Created by thoma on 23/02/2016.
 */
class LinqListFunctionsJava7 {
    companion object LINQJava7 {
        /**
         * Determines whether all elements of a sequence satisfy a [condition].
         * @param list The collection to search
         * @param condition a lambda that returns true or false to indicate whether all elements meet the [condition]
         * @return whether all elements meet the condition
         */
        @JvmStatic()
        fun<ElementType> All(list: AbstractList<ElementType?>, condition: LINQLambda<Boolean>): Boolean {
            for (item: ElementType? in list) {
                val cond: Boolean? = condition.Call();
                if (cond == null || !cond) {
                    return false
                }
            }
            return true
        }

        /**
         * Returns the element at the specified [index] in [list]
         * @param list the collection
         * @param index the index of the item to return
         * @return the item at the specified [index] in [list]
         */
        @JvmStatic()
        fun<ElementType> ElementAt(list: AbstractList<ElementType?>, index: Int): ElementType? {
            if (list.size - 1 < index)
                return null
            else
                return list[index]
        }

        /**
         * Returns the first Element in [list]
         * @param list The collection to search
         * @return The First element in [list]
         */
        @JvmStatic()
        fun<ElementType> First(list: AbstractList<ElementType?>): ElementType? {
            if (list.size > 0)
                return ElementAt(list, 0)
            else
                throw IllegalArgumentException("List must contain at least one element")
        }
    }
}
