package array.factory;

import array.entity.ArrayEntity;

public interface ArrayFactory {
    ArrayEntity create(int[] values);
}
