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
        int len = data.length;
        Object[] res = new Object[len];
        int ind = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (data[i].equals(data[j])) {
                    break;
                }
                if (j == len - 1) {
                    res[ind] = data[i];
                    ind++;
                }
            }
        }
        res[ind] = data[len - 1];
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
