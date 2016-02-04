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


import java.util.*
import kotlin.internal.getProgressionFinalElement

/**
 * Created by thoma on 02/02/2016.
 */

/**
 * Determines whether all elements of a sequence satisfy a condition.
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether all elements meet the condition
 * @return whether all elements meet the condition
 */
fun<ElementType> All(list: AbstractList<ElementType>, condition: (ElementType) -> Boolean) : Boolean
{
    for(item: ElementType in list){
        if(!condition.invoke(item)){
            return false
        }
    }
    return true
}

/**
 * Determines whether all elements of a sequence satisfy a condition.
 * @param list The collection to search
 * @return whether the collection contains any elements
 **/
fun<ElementType> HasAny(list: AbstractList<ElementType>) : Boolean
{
    return list.size > 0
}
/**
 * Determines whether all elements of a sequence satisfy a condition.
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether the collection contains any elements
 * that meet the specified condition
 * @return whether the collection contains any elements that meet the specified condition
 **/
fun<ElementType> HasAny(list: AbstractList<ElementType>, condition: (ElementType) -> Boolean) : Boolean
{
    if(list.size == 0){
        return false
    }
    for(item: ElementType in list){
        if(condition.invoke(item)){
            return true
        }
    }
    return false
}

/**
 * Retuns the inputted list as an AbstractList<Any>
 * @param list The collection to convert
 * @return the inputted list as an AbstractList<Any>
 */
fun<ElementType> AsAbstractList(list: AbstractList<ElementType>) : AbstractList<Any>{
    return list as AbstractList<Any>
}

/**
 * Returns the average of a list of doubles
 * @param list the list to average
 * @return the average value of the list
 */
fun Average(list: AbstractList<Double>) : Double
{
    var total : Double = 0.0
    for(item: Double in list){
        total += item
    }
    total /= list.size
    return total
}

/**
 * Returns the average of a list of floats
 * @param list the list to average
 * @return the average value of the list
 */
fun Average(list: AbstractList<Float>) : Float
{
    var total : Float = 0.0f
    for(item: Float in list){
        total += item
    }
    total /= list.size
    return total
}

/**
 * Returns the average of a list of ints
 * @param list the list to average
 * @return the average value of the list
 */
fun Average(list: AbstractList<Int>) : Int
{
    var total : Int = 0
    for(item: Int in list){
        total += item
    }
    total /= list.size
    return total
}

/**
 * Returns the average of a list of longs
 * @param list the list to average
 * @return the average value of the list
 */
fun Average(list: AbstractList<Long>) : Long
{
    var total : Long = 0
    for(item: Long in list){
        total += item
    }
    total /= list.size
    return total
}



///**
// * Returns the average of a list of shorts
// * @param list the list to average
// * @return the average value of the list
// */
//fun Average(list: AbstractList<Short>) : Short
//{
//    var total : Short = 0
//    for(item: Short in list){
//        total += item
//    }
//    total /= list.size as Short
//    return total
//}

/**
 * Casts all items in the list to the specified type
 * @param list the collection to cast
 * @return a collection containing the casted values
 */
fun<ElementType> Cast(list: AbstractList<Any>) : AbstractList<ElementType>
{
    var ret : ArrayList<ElementType> = ArrayList<ElementType>()
    for(item: Any in list){
        if(item as ElementType? != null){
            ret.add(item)
        }
    }
    return ret
}

/**
 * Concatenates two collections
 * @param list the first list
 * @param list2 the second list
 * @return the Concatenated collection
 */
fun<ElementType> Concat(list: AbstractList<ElementType>, list2: AbstractList<ElementType>) : AbstractList<ElementType>
{
    var ret : ArrayList<ElementType> = ArrayList<ElementType>()
    ret.addAll(list)
    ret.addAll(list2)
    return ret;
}

/**
 * Determines whether a sequence contains a specified element by using the default equality function
 * @param list the collection to search
 * @param element the element to check for
 * @return whether the collection contains the item
 */
fun<ElementType> Contains(list: AbstractList<ElementType>, element: ElementType) : Boolean
{
    for(item: ElementType in list){
        if(element?.equals(item)!!){
            return true
        }
    }
    return false
}
/**
 * Determines whether a sequence contains a specified element by using the passed equality function [comparitor]
 * @param list the collection to search
 * @param element the element to check for
 * @param comparitor the comparison function to use
 * @return whether the collection contains the item
 */
fun<ElementType> Contains(list: AbstractList<ElementType>,element: ElementType,
                          comparitor: (ElementType,ElementType) -> Boolean ) : Boolean
{
    for(item: ElementType in list){
        if(comparitor.invoke(element,item)){
            return true
        }
    }
    return false
}

/**
 * Returns the amount of items in the list
 * @param list the list to count
 * @return the number of items in the list
 */
fun<ElementType> Count(list: AbstractList<ElementType>) : Int
{
    return list.size
}

/**
 * Returns the amount of items in the list that meet the condition
 * @param list the list to count
 * @param condition the required condition
 * @return the number of items in the list that meet the condition
 */
fun<ElementType> Count(list: AbstractList<ElementType>,condition: (ElementType) -> Boolean) : Int
{
    var count : Int = 0
    for(item: ElementType in list){
        if(condition.invoke(item)){
            count++
        }
    }
    return count
}

/**
 * Returns the collection or the default value if it is empty
 * @param list the list to return
 * @return the list or the types default value if it is empty
 */
fun<ElementType> DefaultIfEmpty(list: AbstractList<ElementType>) : AbstractList<ElementType>
{
    if(list.isEmpty()){
        return ArrayList<ElementType>()
    }
    return list
}
/**
 * Returns the collection or the passed value if it is empty
 * @param list the list to return
 * @param element the value to return if the list is empty
 * @return the list or the passed value if it is empty
 */
fun<ElementType> DefaultIfEmpty(list: AbstractList<ElementType>,element: ElementType) : AbstractList<ElementType>
{
    if(list.isEmpty()){
        var def : ArrayList<ElementType> = ArrayList<ElementType>()
        def.add(element)
        return def
    }
    return list
}

/**
 * Returns a list containing all distinct elements
 * @param list the collection to search
 * @return a list containing the distinct items
 */
fun<ElementType> Distinct(list: AbstractList<ElementType>) : AbstractList<ElementType>
{
    var ret : AbstractList<ElementType> = ArrayList<ElementType>()
    for(item: ElementType in list){
        if(!Contains(ret,item)) {
            ret.add(item);
        }
    }
    return ret;
}

/**
 * Returns the first Element in the collection that meets the specified condition
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether the condition is met
 * @return The First element that matches the condition
 */
fun<ElementType> First(list: AbstractList<ElementType>, condition: (ElementType) -> Boolean) : ElementType?
{
    for(item: ElementType in list){
        if(condition.invoke(item)){
            return item
        }
    }
    return null
}
/** Returns the first Element in the collection that meets the specified condition
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether the condition is met
 * @return The First element that matches the condition or null
 */
fun<ElementType> FirstOrDefault(list: AbstractList<ElementType>, condition: (ElementType) -> Boolean) : ElementType?
{
    for(item: ElementType in list){
        if(condition.invoke(item)){
            return item
        }
    }
    return null
}