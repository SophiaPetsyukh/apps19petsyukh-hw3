package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

import java.util.Arrays;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private Object[] arr;

    public MapDecorator(SmartArray smartArray, MyFunction myfunc) {
        super(smartArray);
        //this.myfunc = myfunc;
        arr = Arrays.stream(smartArray.toArray()).map(myfunc::apply).toArray();
    }

    @Override
    public Object[] toArray() {
        return arr.clone();
    }

    @Override
    public String operationDescription() {
        return "Map every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return toArray().length;
    }

}
