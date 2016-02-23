package linq.testprogram.java7;

import linq.collections.LinqListFunctionsJava7Kt;
import linq.collections.LinqListFunctionsKt;
import linq.lamdba.LINQLambda;

import java.util.ArrayList;

/**
 * Created by thoma on 23/02/2016.
 */
public class Main {
    public static void main(String[] args) {
        try {
            ArrayList<Integer> list = new ArrayList<Integer>();
            list.add(10);
            int result = LinqListFunctionsKt.First(list);
            LINQLambda<Boolean> lambda = new LINQLambda<Boolean>(LambdaFunctions.class.getMethod("cond", Integer.TYPE)
                    ,null
                    ,new Object[]{11});
            boolean all = LinqListFunctionsJava7Kt.All(list, lambda);
            System.out.println(all);
        } catch (Exception ex) {
            ex.printStackTrace(System.err);
        }
    }


}


