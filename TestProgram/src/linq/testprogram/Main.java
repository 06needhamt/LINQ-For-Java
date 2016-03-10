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

import static linq.CastHelperFunctions.Functions;
import static linq.collections.LinqListFunctions.LINQ;
import static linq.sql.functions.SQLFunctions.SQL;

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
        ArrayList<Object> list3 = new ArrayList<Object>();
        ArrayList<String> list4 = new ArrayList<String>();
        list.add(10000);
        list.add(2);
        list.add(5);
        list2.add(7);
        list2.add(4);
        list2.add(5);
        list3.add(50);
        list3.add("Hello World");
        list3.add(100);
        list = new ArrayList<>(LINQ.Concat(list,list2));
        try {
            int result = LINQ.First(list, (x) -> x == 5);
            boolean equal = LINQ.All(list,(x) -> x == 10);
            boolean hasany = LINQ.HasAny(list);
            boolean hasanyCond = LINQ.HasAny(list, (x) -> x == 12);
            boolean contains = LINQ.Contains(list,3);
            int count = LINQ.Count(list);
            System.out.println("There are " + count + " items in the list");
            list2 = new ArrayList<>(LINQ.Distinct(list));
            count = LINQ.Count(list2);
            System.out.println("There are " + count + " distinct items in the list");
            list2 = new ArrayList<>(LINQ.Intersect(list,list2));
            count = LINQ.Count(list2);
            System.out.println("There are " + count + " distinct items in both lists");
            System.out.println("First item in the list is: " + list.indexOf(result));
            System.out.println("Are All items in the list equal: " + equal);
            System.out.println("Does the list contain any items: " + hasany);
            System.out.println("Does the list contain any items that meet this condition: " + hasanyCond);
            System.out.println("Does the list contain any items equal to 3: " + contains);
            int average = LINQ.Average(list2);
            int last = LINQ.Last(list2);
            int max = LINQ.Max(list2);
            int min = LINQ.Min(list2);
            ArrayList<String> strings = new ArrayList<String>(Functions.CastStringList(LINQ.OfType(list3)));
            System.out.println("The average value in the list is : " + average);
            System.out.println("The Last item in the list is : " + last);
            System.out.println("The Largest item in the list is : " + max);
            System.out.println("The Smallest item in the list is : " + min);
            for(String str : strings)
                System.out.println(str);
            ArrayList<Integer> range = LINQ.Range(100,50);
            for(Integer num : range)
                System.out.print(num + ",");
            System.out.println();
            ArrayList<Integer> repeat = LINQ.Repeat(100,10);
            for(Integer num : repeat)
                System.out.print(num + ",");
            System.out.println();
            range = new ArrayList<>(LINQ.Reverse(range));
            for(Integer num : range)
                System.out.print(num + ",");
            System.out.println();
            try {
                ArrayList<Integer> single1 = new ArrayList<>();
                single1.add(50);
                Integer item = LINQ.Single(single1);
                System.out.println(item);
                single1.add(100);
                item = LINQ.Single(single1);
                System.out.println(item);
            }
            catch (Exception e){
                e.printStackTrace(System.err);
            }
            System.out.println("After Exception");
            list4.add("Hello");
            boolean string = LINQ.HasAny(list4, x -> x.equals("Hello"));
            System.out.println(string);
            Integer[] array = Functions.CastIntegerArray(LINQ.ToArray(list2));
            System.out.println("Items in array");
            for(Integer item : array)
                System.out.println(item);
            TestSQL("SELECT * FROM list WHERE value = 10");
        }
        catch(Exception ex) {
            ex.printStackTrace(System.err);
        }
    }

    private static void TestSQL(String sql){
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10);
        SQL.ExecSQL(list,sql);
    }
}
