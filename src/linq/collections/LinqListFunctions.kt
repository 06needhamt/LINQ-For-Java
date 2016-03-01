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


import java.lang.reflect.ParameterizedType
import java.util.*
import kotlin.jvm.internal.iterator

/**
 * Created by Tom Needham on 02/02/2016.
 */

/**
 * Returns a class name of a type parameter [T]
 * @return The class name of type parameter [T]
 */
inline fun <reified T : Any> GetType() = T::class.java.simpleName

//TODO Implement Aggregate
/**
 * Determines whether all elements of a sequence satisfy a [condition].
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether all elements meet the [condition]
 * @return whether all elements meet the condition
 */
fun<ElementType> All(list: AbstractList<ElementType?>, condition: (ElementType?) -> Boolean) : Boolean
{
    for(item: ElementType? in list){
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
fun<ElementType> HasAny(list: AbstractList<ElementType?>) : Boolean
{
    return list.size > 0
}
/**
 * Determines whether all elements of a sequence satisfy a [condition].
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether the collection contains any elements
 * that meet the specified [condition]
 * @return whether the collection contains any elements that meet the specified [condition]
 **/
fun<ElementType> HasAny(list: AbstractList<ElementType?>, condition: (ElementType?) -> Boolean) : Boolean
{
    if(list.size == 0){
        return false
    }
    for(item: ElementType? in list){
        if(condition.invoke(item)){
            return true
        }
    }
    return false
}

/**
 * Retuns the inputted list as an [AbstractList<Any>]
 * @param list The collection to convert
 * @return the inputted list as an [AbstractList<Any>]
 */
fun<ElementType> AsAbstractList(list: AbstractList<ElementType?>) : AbstractList<ElementType?>{
    return list
}

/**
 * Returns the average of a list of numbers
 * @param list the list to average
 * @return the average value of the numbers
 */
fun<ElementType : Number> Average(list: AbstractList<ElementType?>) : ElementType?
{
    var dtotal : Double = 0.0
    var ftotal : Float = 0.0f
    var itotal : Int = 0
    var ltotal : Long = 0L
    var stotal : Short = 0
    if(list.size == 0)
    {
        println("Cannot take average of 0 elements")
        return null
    }
    for(item: Any? in list){
        if(item is Double) {
            dtotal += item
            dtotal /= list.size
        }
        else if(item is Float){
            ftotal += item
            ftotal /= list.size
        }
        else if(item is Int){
            itotal += item
            itotal /= list.size
        }
        else if(item is Long){
            ltotal += item
            ltotal /= list.size
        }
        else if(item is Short){
            stotal = (stotal + item).toShort()
            stotal = (stotal / list.size).toShort()
        }
        else
            println("ERROR: Cannot Take average of type " + item!!.javaClass.toString())
    }
    if(list[0] is Double)
        return dtotal as ElementType?
    else if(list[0] is Float)
        return ftotal as ElementType?
    else if(list[0] is Int)
        return itotal as ElementType?
    else if(list[0] is Long)
        return ltotal as ElementType?
    else if(list[0] is Short)
        return stotal as ElementType?
    else
        return null

}
/**
 * Casts all items in the list to the specified type
 * @param list the collection to cast
 * @return a collection containing the casted values
 */
fun<ElementType> Cast(list: AbstractList<Any?>) : AbstractList<ElementType?>
{
    var ret : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: Any? in list){
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
fun<ElementType> Concat(list: AbstractList<ElementType?>, list2: AbstractList<ElementType?>) : AbstractList<ElementType?>
{
    var ret : ArrayList<ElementType?> = ArrayList<ElementType?>()
    ret.addAll(list)
    ret.addAll(list2)
    return ret
}

/**
 * Determines whether a sequence contains a specified [element] by using the default equality function
 * @param list the collection to search
 * @param element the element to check for
 * @return whether the collection contains the item
 */
fun<ElementType> Contains(list: AbstractList<ElementType?>, element: ElementType?) : Boolean
{
    for(item: ElementType? in list){
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
fun<ElementType> Contains(list: AbstractList<ElementType?>,element: ElementType?,
                          comparitor: (ElementType?,ElementType?) -> Boolean ) : Boolean
{
    for(item: ElementType? in list){
        if(comparitor.invoke(element,item)){
            return true
        }
    }
    return false
}

/**
 * Returns the amount of items in the [list]
 * @param list the list to count
 * @return the number of items in the [list]
 */
fun<ElementType> Count(list: AbstractList<ElementType?>) : Int
{
    return list.size
}

/**
 * Returns the amount of items in the list that meet the [condition]
 * @param list the list to count
 * @param condition the required condition
 * @return the number of items in the list that meet the [condition]
 */
fun<ElementType> Count(list: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : Int
{
    var count : Int = 0
    for(item: ElementType? in list){
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
fun<ElementType> DefaultIfEmpty(list: AbstractList<ElementType?>) : AbstractList<ElementType?>
{
    if(list.isEmpty()){
        return ArrayList<ElementType?>()
    }
    return list
}
/**
 * Returns the collection or [element] if it is empty
 * @param list the list to return
 * @param element the value to return if the list is empty
 * @return the List or [element] if it is empty
 */
fun<ElementType> DefaultIfEmpty(list: AbstractList<ElementType?>,element: ElementType?) : AbstractList<ElementType?>
{
    if(list.isEmpty()){
        var def : ArrayList<ElementType?> = ArrayList<ElementType?>()
        def.add(element)
        return def
    }
    return list
}

/**
 * Returns a list containing all distinct elements
 * @param list the collection to search
 * @return a [AbstractList] containing the distinct items
 */
fun<ElementType> Distinct(list: AbstractList<ElementType?>) : AbstractList<ElementType?>
{
    var ret : AbstractList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(!Contains(ret,item)) {
            ret.add(item)
        }
    }
    return ret
}
/**
 * Returns a list containing all distinct elements that meet the specified [comparitor]
 * @param list the collection to search
 * @param comparitor the comparison function to use
 * @return a [AbstractList] containing the distinct items
 */
fun<ElementType> Distinct(list: AbstractList<ElementType?>
                          ,comparitor: (ElementType?) -> Boolean) : AbstractList<ElementType?>
{
    var ret : AbstractList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(!Contains(ret,item) && !comparitor.invoke(item)){
            ret.add(item)
        }
    }
    return ret
}

/**
 * Returns the element at the specified [index] in [list]
 * @param list the collection
 * @param index the index of the item to return
 * @return the item at the specified [index] in [list]
 */
fun<ElementType> ElementAt(list: AbstractList<ElementType?>,index: Int) : ElementType?{
    if(list.size - 1 < index)
        return null
    else
        return list[index]
}

/**
 * Returns the element at the specified [index] in [list] or null if the index is out of range
 * @param list the collection
 * @param index the index of the item to return
 * @return the item at the specified [index] in [list]
 */
fun<ElementType> ElementAtOrDefault(list: AbstractList<ElementType?>,index: Int) : ElementType?{
    return list[index]
}

/**
 * Returns an empty list of the specified type
 * @return an empty list of the specified type
 */
fun<ElementType> Empty() : AbstractList<ElementType?>{
    return ArrayList()
}

/**
 * Returns a collection containing items that are not contained in both [list] and [list2]
 * @param list the first collection
 * @param list2 the second collection
 * @return An [AbstractList] containing items that are not contained in both [list] and [list2]
 */
fun<ElementType> Except(list: AbstractList<ElementType?>,list2: AbstractList<ElementType?>) : AbstractList<ElementType?>{
    var ret : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(!Contains(list2,item)){
            ret.add(item)
        }
    }
    return ret
}

/**
 * Returns a collection containing items that are not contained in both [list] and [list2]
 * @param list the first collection
 * @param list2 the second collection
 * @param condition the condition to compare the items with
 * @return An [AbstractList] containing items that are not contained in both [list] and [list2]
 */
fun<ElementType> Except(list: AbstractList<ElementType?>,list2: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : AbstractList<ElementType?>{
    var ret : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(!Contains(list2,item) && condition.invoke(item)){
            ret.add(item)
        }
    }
    return ret
}

/**
 * Returns the first Element in the collection that meets the specified [condition]
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether the [condition] is met
 * @return The First element that matches the [condition]
 */
fun<ElementType> First(list: AbstractList<ElementType?>, condition: (ElementType?) -> Boolean) : ElementType?
{
    for(item: ElementType? in list){
        if(condition.invoke(item)){
            return item
        }
    }
    throw IllegalArgumentException("List must contain at least one element")
}

/**
 * Returns the first Element in [list]
 * @param list The collection to search
 * @return The First element in [list]
 */
fun<ElementType> First(list: AbstractList<ElementType?>) : ElementType?
{
    if(list.size > 0)
        return ElementAt(list,0)
    else
        throw IllegalArgumentException("List must contain at least one element")
}

/**
 * Returns the first Element in the collection
 * @param list The collection to search
 * @return The First element in the collection
 */
fun<ElementType> FirstOrDefault(list: AbstractList<ElementType?>) : ElementType?
{
    if(list.size > 0)
        return ElementAt(list,0)
    else
        return null
}
/** Returns the first Element in the collection that meets the specified condition
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether the condition is met
 * @return The First element that matches the condition or null
 */
fun<ElementType> FirstOrDefault(list: AbstractList<ElementType?>, condition: (ElementType?) -> Boolean) : ElementType?
{
    for(item: ElementType? in list){
        if(condition.invoke(item)){
            return item
        }
    }
    return null
}

//TODO Add GroupBy
/**
 * Returns a list containing all of the distinct items in [list] that also appear in [list2]
 * @param list the first collection
 * @param list2 the second collection
 * @return list containing all of the distinct items in [list] that also appear in [list2]
 */
fun<ElementType> Intersect(list: AbstractList<ElementType?>,list2: AbstractList<ElementType?>) : AbstractList<ElementType?>{
    var ret : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in Distinct(list)){
        if(Contains(Distinct(list2),item)){
            ret.add(item)
        }
    }
    return ret
}

/**
 * Returns a list containing all of the distinct items in [list] that also appear in [list2]
 * @param list the first collection
 * @param list2 the second collection
 * @param condition the condition to compare the elements against
 * @return list containing all of the distinct items in [list] that also appear in [list2]
 */
fun<ElementType> Intersect(list: AbstractList<ElementType?>,list2: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : AbstractList<ElementType?>{
    var ret : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in Distinct(list,condition)){
        if(Contains(Distinct(list2,condition),item)){
            ret.add(item)
        }
    }
    return ret
}

//TODO Implement Join
/**
 * Returns the last item contained in [list]
 * @param list The Collection
 * @return the last item contained in [list]
 */
fun<ElementType> Last(list: AbstractList<ElementType?>) : ElementType?{
    return list[list.count() - 1]
}

/**
 * Returns the last item contained in [list] that meets the [condition]
 * @param list The Collection
 * @param condition the condition to check the items against
 * @return the last item contained in [list] that meets the [condition]
 */
fun<ElementType> Last(list: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : ElementType?{
    var lastMatch : ElementType? = null
    for(item: ElementType? in list){
        if(item != null && condition.invoke(item)){
            lastMatch = item
        }
    }
    return lastMatch
}

/**
 * Returns the Largest item in the list
 * @param list the list to search
 * @return the Largest item in the list
 */
fun<ElementType : Number> Max(list: AbstractList<ElementType?>) : ElementType?{
    var dmax : Double = Double.MIN_VALUE
    var fmax : Float = Float.MIN_VALUE
    var imax : Int = Int.MIN_VALUE
    var lmax : Long = Long.MIN_VALUE
    var smax : Short = Short.MIN_VALUE
    
    if(list.size == 0)
    {
        println("Cannot take maximum of 0 elements")
        return null
    }
    for(item: ElementType? in list){
        if(item is Double){
            if(item > dmax)
                dmax = item.toDouble()
        }
        else if(item is Float){
            if(item > fmax)
                fmax = item.toFloat()
        }
        else if(item is Int){
            if (item > imax)
                imax = item.toInt()
        }
        else if (item is Long){
            if(item > lmax)
                lmax = item.toLong()
        }
        else if(item is Short){
            if(item > smax)
                smax.toShort()
        }
        else
            println("ERROR: Cannot Take maximum of type " + item!!.javaClass.toString())
    }
    if(list[0] is Double)
        return dmax as ElementType?
    else if(list[0] is Float)
        return fmax as ElementType?
    else if(list[0] is Int)
        return imax as ElementType?
    else if(list[0] is Long)
        return lmax as ElementType?
    else if(list[0] is Short)
        return smax as ElementType?
    else
        return null
}

/**
 * Returns the maximum double value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the maximum double value in the list based on [comparitor]
 */
fun<ElementType : Number> Max(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Double) : Double{
    var max : Double = 0.0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) > max )
                max = item.toDouble()
        }
    }
    return max
}
/**
 * Returns the maximum float value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the maximum float value in the list based on [comparitor]
 */fun<ElementType : Number> Max(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Float) : Float{
    var max : Float = 0.0f
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) > max )
                max = item.toFloat()
        }
    }
    return max
}

/**
 * Returns the maximum Int value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the maximum Int value in the list based on [comparitor]
 */fun<ElementType : Number> Max(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Int) : Int{
    var max : Int = 0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) > max )
                max = item.toInt()
        }
    }
    return max
}

/**
 * Returns the maximum Long value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the maximum Long value in the list based on [comparitor]
 */fun<ElementType : Number> Max(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Long) : Long{
    var max : Long = 0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) > max )
                max = item.toLong()
        }
    }
    return max
}

/**
 * Returns the maximum Short value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the maximum Short value in the list based on [comparitor]
 */fun<ElementType : Number> Max(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Short) : Short{
    var max : Short = 0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) > max )
                max = item.toShort()
        }
    }
    return max
}
/**
 * Returns the Smallest item in the list
 * @param list the list to search
 * @return the Smallest item in the list
 */
fun<ElementType : Number> Min(list: AbstractList<ElementType?>) : ElementType?{
    var dmin : Double = Double.MAX_VALUE
    var fmin : Float = Float.MAX_VALUE
    var imin : Int = Int.MAX_VALUE
    var lmin : Long = Long.MAX_VALUE
    var smin : Short = Short.MAX_VALUE
    if(list.size == 0)
    {
        println("Cannot take minimum of 0 elements")
        return null
    }
    for(item: ElementType? in list){
        if(item is Double){
            if(item < dmin)
                dmin = item.toDouble()
        }
        else if(item is Float){
            if(item < fmin)
                fmin = item.toFloat()
        }
        else if(item is Int){
            if (item < imin)
                imin = item.toInt()
        }
        else if (item is Long){
            if(item < lmin)
                lmin = item.toLong()
        }
        else if(item is Short){
            if(item < smin)
                smin.toShort()
        }
        else
            println("ERROR: Cannot Take minimum of type " + item!!.javaClass.toString())
    }
    if(list[0] is Double)
        return dmin as ElementType?
    else if(list[0] is Float)
        return fmin as ElementType?
    else if(list[0] is Int)
        return imin as ElementType?
    else if(list[0] is Long)
        return lmin as ElementType?
    else if(list[0] is Short)
        return smin as ElementType?
    else
        return null
}

/**
 * Returns the minimum double value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the minimum double value in the list based on [comparitor]
 */
fun<ElementType : Number> Min(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Double) : Double{
    var min : Double = 0.0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) < min )
                min = item.toDouble()
        }
    }
    return min
}
/**
 * Returns the minimum float value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the minimum float value in the list based on [comparitor]
 */
fun<ElementType : Number> Min(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Float) : Float{
    var min : Float = 0.0f
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) < min )
                min = item.toFloat()
        }
    }
    return min
}

/**
 * Returns the minimum Int value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the minimum Int value in the list based on [comparitor]
 */
fun<ElementType : Number> Min(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Int) : Int{
    var min : Int = 0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) < min )
                min = item.toInt()
        }
    }
    return min
}

/**
 * Returns the minimum Long value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the minimum Long value in the list based on [comparitor]
 */
fun<ElementType : Number> Min(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Long) : Long{
    var min : Long = 0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) < min )
                min = item.toLong()
        }
    }
    return min
}

/**
 * Returns the minimum Short value in the list based on [comparitor]
 * @param list the list to search
 * @param comparitor the comparison function to use
 * @return the minimum Short value in the list based on [comparitor]
 */
fun<ElementType : Number> Min(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> Short) : Short{
    var min : Short = 0
    for(item: ElementType? in list){
        if(item is Number) {
            if (comparitor.invoke(item) < min )
                min = item.toShort()
        }
    }
    return min
}
///**
// * Returns all the elements of a specified type from the list [list]
// * @param list the list to search
// * @return an [AbstractList] containing all the elements of the specified type
// */
//
//inline fun<reified ElementType> OfType(list: AbstractList<Any?>) : AbstractList<ElementType?>{
//    var result : AbstractList<ElementType?> = ArrayList<ElementType?>()
//    for(item: Any? in list){
//        if(item is ElementType?){
//            result.add(item)
//        }
//    }
//    return result
//}
///**

/**
 * Returns all the elements of a specified type from the list [list]
 * @param list the list to search
 * @return an [ArrayList] containing all the elements of the specified type
 */
fun<ElementType> OfType(list: AbstractList<Any?>) : ArrayList<Any?>{
    var result : ArrayList<Any?> = ArrayList<Any?>()
    for(i in list.indices){
        val item : ElementType? = list.get(i) as ElementType?
        if(item != null)
            result.add(item)
    }
    return result
}
//TODO Implement Order By

//fun<ElementType,KeyType> OrderBy(list: AbstractList<ElementType?>, key: String) : AbstractList<ElementType?>{
//    val persistentClass : Class<ElementType> = (ElementType::class.java as ParameterizedType).javaClass.genericSuperclass.typeName as Class<ElementType>

/**
 * Generates a sequence of [amount] integers starting with value [start]
 * @param start the number at the start of the sequence
 * @param amount the amount of numbers that should be in the sequence
 * @return An [ArrayList] containing the sequence of integers
 */
fun Range(start: Int, amount: Int) : ArrayList<Int>{
    var sequence : ArrayList<Int> = ArrayList<Int>(amount)
    for(i in IntRange(start,start + amount)){
        sequence.add(i)
    }
    return sequence
}

/**
 * Returns a list containing the [element] repeated [times] times
 * @param element the value to repeat
 * @param times the amount of times to repeat the [element]
 * @return An [ArrayList] containing the [element] repeated [times] times
 */
fun<ElementType> Repeat(element: ElementType?, times: Int) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>(times)
    for(i in IntRange(0,times)){
        result.add(element)
    }
    return result
}

/**
 * Reverses the order of the items in list[list]
 * @param list the list to reverse
 * @return the reversed list
 */
fun<ElementType> Reverse(list: AbstractList<ElementType?>) : AbstractList<ElementType?>{
    list.reverse()
    return list
}

//TODO implement Select

/**
 * Returns the only element of [list], and throws an exception if there is not exactly one element in the [list].
 * @throwsan exception if there is not exactly one element in the [list]
 * @param list the list to return the only element of
 * @return the only element of the [list]
 */
fun<ElementType> Single(list: AbstractList<ElementType?>) : ElementType?{
    if(list.size == 1)
        return First(list)
    else
        throw Exception("There was more than one element in the list")
}

/**
 * Returns the only element of [list] or null if there were no items in the list that met the condition
 * and throws an exception if there is not exactly one element in the [list].
 * @throwsan exception if there is not exactly one element in the [list]
 * @param list the list to return the only element of or null
 * @return the only element of the [list] or null
 */
fun<ElementType> Single(list: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : ElementType?{
    var matches : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(condition.invoke(item)){
            matches.add(item)
        }
    }
    if(matches.size > 1)
        throw Exception("There was more than one element in the list")
    else
        return First(list)
}

/**
 * Returns the only element of [list] or null if there were no items in the list
 * and throws an exception if there is not exactly one element in the [list].
 * @throwsan exception if there is not exactly one element in the [list]
 * @param list the list to return the only element of or null
 * @return the only element of the [list] or null
 */
fun<ElementType> SingleOrDefault(list: AbstractList<ElementType?>) : ElementType?{
    if(list.isEmpty())
        return null
    else if(list.size == 1)
        return First(list)
    else
        throw Exception("There was more than one element in the list")
}

/**
 * Returns the only element of [list] or null if there were no items in the list that met the condition
 * and throws an exception if there is not exactly one element in the [list].
 * @throwsan exception if there is not exactly one element in the [list]
 * @param list the list to return the only element of or null
 * @return the only element of the [list] or null
 */
fun<ElementType> SingleOrDefault(list: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : ElementType?{
    var matches : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(condition.invoke(item)){
            matches.add(item)
        }
    }
    if(matches.isEmpty())
        return null
    else if(matches.size > 1)
        throw Exception("There was more than one element in the list")
    else
        return First(list)
}

/**
 * Returns the contents of [list] after skipping [amount] items
 * @param list The list of items
 * @param amount the amount of items to skip
 * @return the contents of [list] after skipping [amount] items
 */
fun<ElementType> Skip(list: AbstractList<ElementType?>,amount: Int) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    if(list.size < amount)
        return result
    for(i in IntRange(amount,list.size - 1)){
        result.add(list[i])
    }
    return result
}

/**
 * Returns the contents of [list] after skipping items while the [condition] is true
 * @param list The list of items
 * @param condition the condition to skip items while true
 * @return the contents of [list] after skipping items while [condition] is true
 */
fun<ElementType> SkipWhile(list: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(condition.invoke(item))
            continue
        else
            result.add(item)
    }
    return result
}


/**
 * Returns the contents of [list] after skipping items while the [condition] is true
 * @param list The list of items
 * @param condition the condition to skip items while true
 * @return the contents of [list] after skipping items while [condition] is true
 */
fun<ElementType> SkipWhile(list: AbstractList<ElementType?>,condition: (ElementType?,Int) -> Boolean) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(i in IntRange(0,list.size - 1)){
        if(condition.invoke(list.get(i),i))
            continue
        else
            result.add(list.get(i))
    }
    return result
}

/**
 * Returns the sum of all items within the [list]
 * @param list the list to sum
 * @return the sum of all the items within the [list]
 */
fun<ElementType : Number> Sum(list: AbstractList<ElementType?>) : ElementType?{
    var dtotal : Double = 0.0
    var ftotal : Float = 0.0f
    var itotal : Int = 0
    var ltotal : Long = 0L
    var stotal : Short = 0

    for(item: ElementType? in list){
        if(item is Double){
            dtotal += item
        }
        else if(item is Float){
            ftotal += item
        }
        else if(item is Int) {
            itotal += item
        }
        else if(item is Long){
            ltotal += item
        }
        else if(item is Short){
            stotal = (stotal + item).toShort()
        }
        else
            println("ERROR: Cannot Take sum of type " + item!!.javaClass.toString())
    }
    if(list[0] is Double)
        return dtotal as ElementType?
    else if(list[0] is Float)
        return ftotal as ElementType?
    else if(list[0] is Int)
        return itotal as ElementType?
    else if(list[0] is Long)
        return ltotal as ElementType?
    else if(list[0] is Short)
        return stotal as ElementType?
    else
        return null
}
/**
 * Returns the sum of all items within the [list] after applying transform function [comparitor]
 * @param list the list to sum
 * @param comparitor a transform function to apply to each element
 * @return the sum of all the items within the [list] after applying transform function [comparitor]
 */
fun<ElementType> Sum(list: AbstractList<ElementType?>, comparitor: (ElementType?) -> ElementType?) : ElementType?{
    var dtotal : Double = 0.0
    var ftotal : Float = 0.0f
    var itotal : Int = 0
    var ltotal : Long = 0L
    var stotal : Short = 0

    for(item : ElementType? in list){
        val value : ElementType? = comparitor.invoke(item)
        if(value is Double){
            dtotal += value
        }
        else if(value is Float){
            ftotal += value
        }
        else if(value is Int) {
            itotal += value
        }
        else if(value is Long){
            ltotal += value
        }
        else if(value is Short){
            stotal = (stotal + value).toShort()
        }
        else
            println("ERROR: Cannot Take sum of type " + (value!! as Any).javaClass.toString())
    }
    if(list[0] is Double)
        return dtotal as ElementType?
    else if(list[0] is Float)
        return ftotal as ElementType?
    else if(list[0] is Int)
        return itotal as ElementType?
    else if(list[0] is Long)
        return ltotal as ElementType?
    else if(list[0] is Short)
        return stotal as ElementType?
    else
        return null
}

/**
 * Returns [amount] items from the [list]
 * @param list the list to return items from
 * @param [amount] the amount of items to return
 * @throws Exception when there are less than [amount] items in the [list]
 * @return the first [amount] items in the [list]
 */
fun<ElementType> Take(list: AbstractList<ElementType?>, amount: Int) : ArrayList<ElementType?>{
    if(list.size < amount)
        throw Exception("Can not take " + amount + " Elements form a list with " + list.size + " Elements")
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>(amount)
    for(i in IntRange(0,amount)){
        result.add(list.get(i))
    }
    return result
}

/**
 * Returns items from the [list] while the [condition] is true
 * @param list the list to return items from
 * @param condition the condition on which to return items
 * @return the items which meet [condition]
 */
fun<ElementType> TakeWhile(list: AbstractList<ElementType?>, condition: (ElementType?) -> Boolean) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(condition.invoke(item)){
            result.add(item)
        }
        else
            break
    }
    return result
}

//TODO Implement ThenBy
/**
 * Converts a list of items to an array of items
 * @param list the list of items
 * @return an array containing all the items contained in the list
 */
fun<ElementType> ToArray(list: AbstractList<ElementType?>) : Array<ElementType?>{
    var result : Array<Any?> = list.toTypedArray()
    return result as Array<ElementType?>
}

//TODO implement ToDictionary

//TODO implement ToLookup

/**
 * Performs a Union between [list] and [list2] using the default equality function
 * @param list the first list
 * @param list2 the second list
 * @return the result of the union
 */
fun<ElementType> Union(list: AbstractList<ElementType?>,list2: AbstractList<ElementType?>) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        for(item2: ElementType? in list2){
            if(item != null && item2 != null)
                result.add(item2)
        }
    }
    return result
}
/**
 * Performs a Union between [list] and [list2] using [comparitor]
 * @param list the first list
 * @param list2 the second list
 * @param comparitor the comparison function to use
 * @return the result of the union
 */
fun<ElementType> Union(list: AbstractList<ElementType?>,list2: AbstractList<ElementType?>,
                       comparitor: (ElementType?, ElementType?) -> Boolean) : ArrayList<ElementType?>
{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        for(item2: ElementType? in list2){
            if(comparitor.invoke(item,item2))
                result.add(item2)
        }
    }
    return result
}

/**
 * Filters a [list] of values based on a [condition].
 * @param list the list to filter
 * @param condition the condition to filter the elements with
 * @return the filtered list
 */
fun<ElementType> Where(list: AbstractList<ElementType?>,condition: (ElementType?) -> Boolean) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(item: ElementType? in list){
        if(condition.invoke(item)){
            result.add(item)
        }
    }
    return result
}
/**
 * Filters a [list] of values based on a [condition] and the elements index.
 * @param list the list to filter
 * @param condition the condition to filter the elements with
 * @return the filtered list
 */
fun<ElementType> Where(list: AbstractList<ElementType?>,condition: (ElementType?, Int) -> Boolean) : ArrayList<ElementType?>{
    var result : ArrayList<ElementType?> = ArrayList<ElementType?>()
    for(i in IntRange(0,list.size)){
        if(condition.invoke(list.get(i),i)){
            result.add(list.get(i))
        }
    }
    return result
}

fun<TypeFirst,TypeSecond,TypeResult> Zip(list: AbstractList<TypeFirst?>,list2: AbstractList<TypeSecond?>) : ArrayList<TypeResult?>{
    var result : ArrayList<TypeResult?> = ArrayList<TypeResult?>()
    throw Exception("Not Implemented Yet")
}