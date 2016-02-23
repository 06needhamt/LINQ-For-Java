package linq.collections

import linq.lamdba.LINQLambda
import java.util.*

/**
 * Created by thoma on 23/02/2016.
 */

/**
 * Determines whether all elements of a sequence satisfy a [condition].
 * @param list The collection to search
 * @param condition a lambda that returns true or false to indicate whether all elements meet the [condition]
 * @return whether all elements meet the condition
 */
fun<ElementType> All(list: AbstractList<ElementType?>, condition: LINQLambda<Boolean>) : Boolean
{
    for(item: ElementType? in list){
        val cond : Boolean? = condition.Call();
        if(cond == null || !cond){
            return false
        }
    }
    return true
}
