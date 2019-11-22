package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyPredicate;
import java.util.Arrays;

// Tests every element and removes it if it doesn't satisfy MyPredicate
public class FilterDecorator extends SmartArrayDecorator{
   private Object[] arr;

   public FilterDecorator(SmartArray smartArray, MyPredicate myPred) {
       super(smartArray);
       arr = Arrays.stream(smartArray.toArray()).filter(myPred::test).toArray();
   }

   @Override
    public Object[] toArray() {
       return arr.clone();
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
