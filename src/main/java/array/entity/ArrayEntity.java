package array.entity;
import java.util.Arrays;

public class ArrayEntity {
    private int[] values;

    public ArrayEntity(int[] values) {
        this.values = values;
    }

    public int[] getValues() {
        return values;
    }

    public void setValues(int[] values) {
        this.values = values;
    }

    @Override
    public String toString() {
        return Arrays.toString(values);
    }

}
