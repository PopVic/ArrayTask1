package array.service.impl;
import array.exception.ArrayException;

import array.entity.ArrayEntity;
import array.service.ArrayService;

import java.util.Optional;

public class ArrayServiceImpl implements ArrayService {

    @Override
    public Optional<Integer> findMin(ArrayEntity array) {
        validate(array);

        int[] values = array.getValues();
        int min = values[0];

        for (int value : values) {
            if (value < min) {
                min = value;
            }
        }

        return Optional.of(min);
    }

    @Override
    public Optional<Integer> findMax(ArrayEntity array) {
        validate(array);

        int[] values = array.getValues();
        int max = values[0];

        for (int value : values) {
            if (value > max) {
                max = value;
            }
        }

        return Optional.of(max);
    }

    @Override
    public Optional<Integer> sum(ArrayEntity array) {
        validate(array);
        int sum = 0;

        for (int v : array.getValues()) {
            sum += v;
        }

        return Optional.of(sum);
    }

    @Override
    public Optional<Double> average(ArrayEntity array) {
        validate(array);

        double sum = 0;
        int[] values = array.getValues();

        for (int v : values) {
            sum += v;
        }

        return Optional.of(sum / values.length);
    }

    @Override
    public void bubbleSort(ArrayEntity array) {
        validate(array);

        int[] v = array.getValues();

        for (int i = 0; i < v.length - 1; i++) {
            for (int j = 0; j < v.length - 1 - i; j++) {
                if (v[j] > v[j + 1]) {
                    int temp = v[j];
                    v[j] = v[j + 1];
                    v[j + 1] = temp;
                }
            }
        }
    }

    @Override
    public void selectionSort(ArrayEntity array) {
        validate(array);

        int[] v = array.getValues();

        for (int i = 0; i < v.length; i++) {
            int minIndex = i;

            for (int j = i + 1; j < v.length; j++) {
                if (v[j] < v[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = v[i];
            v[i] = v[minIndex];
            v[minIndex] = temp;
        }
    }

    private void validate(ArrayEntity array) {
        if (array == null || array.getValues() == null || array.getValues().length == 0) {
            throw new ArrayException("Array is empty or null");
        }
    }
}
