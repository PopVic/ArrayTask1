package array.service;

import array.entity.ArrayEntity;
import java.util.Optional;

public interface ArrayService {

    Optional<Integer> findMin(ArrayEntity array);
    Optional<Integer> findMax(ArrayEntity array);
    Optional<Integer> sum(ArrayEntity array);
    Optional<Double> average(ArrayEntity array);

    void bubbleSort(ArrayEntity array);
    void selectionSort(ArrayEntity array);
}
