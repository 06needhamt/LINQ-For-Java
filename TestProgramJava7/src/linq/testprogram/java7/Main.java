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

package linq.testprogram.java7;

import static linq.collections.LinqListFunctionsJava7.LINQJava7;
import linq.lamdba.Java7Lambda;

import java.util.ArrayList;

/**
 * Created by thoma on 23/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(10);
            int result = LINQJava7.First(list);
            Java7Lambda<Boolean> lambda = new Java7Lambda<Boolean>(LambdaFunctions.class.getMethod("Test", Integer.TYPE)
                    ,null
                    ,new Object[]{10});
            boolean all = LINQJava7.All(list, lambda);
            lambda = new Java7Lambda<Boolean>(LambdaFunctions.class.getMethod("InRange",Integer.TYPE,Integer.TYPE),
                    null,
                    new Object[]{10,15});
            boolean contains = LINQJava7.Contains(list,10,lambda);
            System.out.println(all);
            System.out.println(contains);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }


}


