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

package linq.testprogram;
import linq.collections.LinqListFunctionsKt;

import java.util.ArrayList;

/**
 * Created by Tom Needham on 02/02/2016.
 *
 */
public class Main {
    public static void main(String[] args)
    {
        System.out.println("Hello World");
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list.add(10);
        list.add(2);
        list.add(5);
        list2.add(7);
        list2.add(4);
        list2.add(5);
        list = new ArrayList<>(LinqListFunctionsKt.Concat(list,list2));
        try {
            int result = LinqListFunctionsKt.First(list, (x) -> x == 5);
            boolean equal = LinqListFunctionsKt.All(list,(x) -> x == 10);
            boolean hasany = LinqListFunctionsKt.HasAny(list);
            boolean hasanyCond = LinqListFunctionsKt.HasAny(list, (x) -> x == 12);
            boolean contains = LinqListFunctionsKt.Contains(list,3);
            int count = LinqListFunctionsKt.Count(list);
            System.out.println("There are " + count + " items in the list");
            list2 = new ArrayList<>(LinqListFunctionsKt.Distinct(list));
            count = LinqListFunctionsKt.Count(list2);
            System.out.println("There are " + count + " distinct items in the list");
            list2 = new ArrayList<>(LinqListFunctionsKt.Intersect(list,list2));
            count = LinqListFunctionsKt.Count(list2);
            System.out.println("There are " + count + " distinct items in both lists");
            System.out.println("First item in the list is: " + list.indexOf(result));
            System.out.println("Are All items in the list equal: " + equal);
            System.out.println("Does the list contain any items: " + hasany);
            System.out.println("Does the list contain any items that meet this condition: " + hasanyCond);
            System.out.println("Does the list contain any items equal to 3: " + contains);
            int average = LinqListFunctionsKt.Average(list2);
            System.out.println("The average value in the list is :" + average);

        }
        catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }
}
