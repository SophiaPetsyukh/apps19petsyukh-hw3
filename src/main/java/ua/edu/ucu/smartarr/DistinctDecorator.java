package ua.edu.ucu.smartarr;

import java.util.Arrays;

// Remove duplicates from SmartArray. Use method equals() to compare objects
public class DistinctDecorator extends SmartArrayDecorator {

    //private Object[] array;

    public DistinctDecorator(SmartArray sArray) {
        super(sArray);
    }

    @Override
    public Object[] toArray() {
        Object[] data = smartArray.toArray();
        Object[] res = new Object[data.length];
        int ind = 0;
        for (int i = 0; i < data.length; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i].equals(data[j])) {
                    break;
                }
                if (j == data.length - 1) {
                    res[ind] = data[i];
                    ind++;
                }
            }
        }
        res[ind] = data[data.length - 1];
        ind++;
        res = Arrays.copyOf(res, ind);
        return res;
    }

    @Override
    public String operationDescription() {
        return "DistinctDecorator; Remove duplicates";
    }

    @Override
    public int size() {
        return toArray().length;
    }

}
