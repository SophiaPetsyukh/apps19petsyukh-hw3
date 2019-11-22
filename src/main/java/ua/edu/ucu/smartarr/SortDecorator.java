package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private Object[] arr;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        //this.comp = comp;
        arr = Arrays.stream(this.smartArray.toArray()).sorted(comp).toArray();
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return "Sorts elements using MyComparator to compare them";
    }

    @Override
    public int size() {
        return toArray().length;
    }
}
