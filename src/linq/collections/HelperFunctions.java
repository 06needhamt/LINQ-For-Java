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

package linq.collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tom Needham on 20/02/2016.
 */
public final class HelperFunctions {
    public static List<String> CastStringList(List<Object> list){
        List<String> cast = new ArrayList<String>();
        for(Object str : list)
            if(str instanceof String)
                cast.add((String)str);
        return cast;
    }
    public static List<Double> CastDoubleList(List<Object> list){
        List<Double> cast = new ArrayList<Double>();
        for(Object str : list)
            if(str instanceof Double)
                cast.add((Double)str);
        return cast;
    }
    public static List<Float> CastFloatList(List<Object> list){
        List<Float> cast = new ArrayList<Float>();
        for(Object str : list)
            if(str instanceof Float)
                cast.add((Float)str);
        return cast;
    }
    public static List<Long> CastLongList(List<Object> list){
        List<Long> cast = new ArrayList<Long>();
        for(Object str : list)
            if(str instanceof Long)
                cast.add((Long)str);
        return cast;
    }
    public static List<Integer> CastIntegerList(List<Object> list){
        List<Integer> cast = new ArrayList<Integer>();
        for(Object str : list)
            if(str instanceof Integer)
                cast.add((Integer)str);
        return cast;
    }
    public static List<Short> CastShortList(List<Object> list){
        List<Short> cast = new ArrayList<Short>();
        for(Object str : list)
            if(str instanceof Short)
                cast.add((Short)str);
        return cast;
    }
    public static List<Boolean> CastBooleanList(List<Object> list){
        List<Boolean> cast = new ArrayList<Boolean>();
        for(Object str : list)
            if(str instanceof Boolean)
                cast.add((Boolean)str);
        return cast;
    }
}
