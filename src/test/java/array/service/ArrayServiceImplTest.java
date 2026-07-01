package array.service;

import org.junit.jupiter.api.Test;
import array.service.impl.ArrayServiceImpl;
import array.entity.ArrayEntity;

import static org.junit.jupiter.api.Assertions.*;

class ArrayServiceImplTest {
    private final ArrayServiceImpl service = new ArrayServiceImpl();


    @Test
    void findMin() {
        ArrayEntity entity = new ArrayEntity(new int[]{10, -5, 20});
        int result = service.findMin(entity).get();
        assertEquals(-5, service.findMin(entity).orElseThrow());
    }

    @Test
    void findMax() {
        ArrayEntity entity = new ArrayEntity(new int[]{10, 5, 20});
        int result = service.findMax(entity).get();
        assertEquals(20, result);
    }

    @Test
    void sum() {
        ArrayEntity entity = new ArrayEntity(new int[]{10, 5, 5});
        int result = service.sum(entity).get();
        assertEquals(20, result);
    }

    @Test
    void average() {
        ArrayEntity entity = new ArrayEntity(new int[]{10, 20, 30});
        double result = service.average(entity).get();
        assertEquals(15.0, result, 0.0001);
    }

    @Test
    void bubbleSort() {
        ArrayEntity entity = new ArrayEntity(new int[]{5, 1, 7});
        service.bubbleSort(entity);
        assertArrayEquals(new int[]{1, 5, 7}, entity.getValues());
    }

    @Test
    void selectionSort() {
        ArrayEntity entity = new ArrayEntity(new int[]{5, 9, 1});
        service.selectionSort(entity);
        assertArrayEquals(new int[]{1, 5, 9}, entity.getValues());
    }
}