package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyComparator;
import java.util.Arrays;

// Sorts elements using MyComparator to compare them
public class SortDecorator extends SmartArrayDecorator {
    private MyComparator comp;

    public SortDecorator(SmartArray smartArray, MyComparator comp) {
        super(smartArray);
        this.comp = comp;
    }

    @Override
    public Object[] toArray() {
        Object[] res = smartArray.toArray();
        Arrays.sort(res, comp);
        return res;
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
