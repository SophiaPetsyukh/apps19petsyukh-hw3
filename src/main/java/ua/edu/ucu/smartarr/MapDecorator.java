package ua.edu.ucu.smartarr;

import ua.edu.ucu.functions.MyFunction;

// Map every element to another object using MyFunction
public class MapDecorator extends SmartArrayDecorator {
    private MyFunction myfunc;

    public MapDecorator(SmartArray smartArray, MyFunction myfunc) {
        super(smartArray);
        this.myfunc = myfunc;
    }

    @Override
    public Object[] toArray() {
        Object[] res = smartArray.toArray();
        int len = res.length;
        for (int i = 0; i < len; i++) {
            res[i] = myfunc.apply(res[i]);
        }
        return res;
    }

    @Override
    public String operationDescription() {
        return "MapDecorator; Map every element to another object using MyFunction";
    }

    @Override
    public int size() {
        return toArray().length;
    }

}
