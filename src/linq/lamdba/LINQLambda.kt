package linq.lamdba

import java.lang.reflect.Method

/**
 * Created by thoma on 23/02/2016.
 */

class LINQLambda<ReturnType>{
    var method : Method? = null;
    var parameters : Array<Any?> = arrayOfNulls(0)
    var objectRef : Any? = null;
    val NO_PARAMETERS : Array<Any?> = arrayOfNulls(0)

    constructor(method: Method, objectRef: Any?, pars: Array<Any?>){
        this.method = method;
        this.objectRef = objectRef;
        this.parameters = pars;
    }

    constructor(method: Method,objectRef: Any?){
        this.method = method;
        this.objectRef = objectRef;
        this.parameters = NO_PARAMETERS;
    }

    fun Call() : ReturnType?{
        return method?.invoke(objectRef,*parameters) as ReturnType?
    }
}