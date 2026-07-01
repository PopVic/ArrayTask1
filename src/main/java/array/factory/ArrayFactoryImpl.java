package array.factory;
import array.entity.ArrayEntity;

public class ArrayFactoryImpl implements ArrayFactory {
    @Override
    public ArrayEntity create(int[] values) {
        return new ArrayEntity(values);
    }


}
