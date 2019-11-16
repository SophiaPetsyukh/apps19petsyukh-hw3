package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
   private MyPredicate myPred;

   public FilterDecorator(SmartArray smartArray, MyPredicate myPred) {
       super(smartArray);
       this.myPred = myPred;
   }

   @Override
    public Object[] toArray() {
       Object[] data = smartArray.toArray();
       int len = data.length;
       Object[] res = new Object[len];

       int ind = 0;
       for (int i = 0; i < len; i++) {
           if (myPred.test(data[i])) {
               res[ind] = data[i];
               ind++;
           }
       }
       res = Arrays.copyOf(res, ind);
       return res;
   }

    @Override
    public String operationDescription() {
        return "Remove element if it doesn't satisfy MyPredicate";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
