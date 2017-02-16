package org.tanc.algorithm.sort;

import org.junit.Test;
import org.tanc.algorithm.sort.impl.*;

import static org.junit.Assert.*;

/**
 * 排序算法测试
 * Created by tanc on 2017/2/12.
 */
public class BaseSortAlgorithmTest {

    @Test
    public void bubbleSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new BubbleSort<>();
        long start = System.nanoTime();
        sortAlgorithm.sort(array);
        long end = System.nanoTime();
        printArray(array);
        printTime(start, end);
    }


    @Test
    public void insertionSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new InsertionSort<>();
        long start = System.nanoTime();
        sortAlgorithm.sort(array);
        long end = System.nanoTime();
        printArray(array);
        printTime(start, end);
    }

    @Test
    public void selectionSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new SelectionSort<>();
        long start = System.nanoTime();
        sortAlgorithm.sort(array);
        long end = System.nanoTime();
        printArray(array);
        printTime(start, end);
    }

    @Test
    public void shellSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new ShellSort<>();
        long start = System.nanoTime();
        sortAlgorithm.sort(array);
        long end = System.nanoTime();
        printArray(array);
        printTime(start, end);
    }

    @Test
    public void heapSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new HeapSort<>();
        long start = System.nanoTime();
        sortAlgorithm.sort(array);
        long end = System.nanoTime();
        printArray(array);
        printTime(start, end);
    }

    @Test
    public void mergeSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new MergeSort<>();
        long start = System.nanoTime();
        sortAlgorithm.sort(array);
        long end = System.nanoTime();
        printArray(array);
        printTime(start, end);
    }

    @Test
    public void quickSort() throws Exception {
        Integer[] array = {9, 3, 4, 6, 5, 8, 7, 2, 1, 0};
        BaseSortAlgorithm<Integer> sortAlgorithm = new QuickSort<>();
        long start = System.nanoTime();
        sortAlgorithm.sort(array);
        long end = System.nanoTime();
        printArray(array);
        printTime(start, end);
    }

    /**
     * 打印运行时间
     * @param start 开始时间
     * @param end 结束时间
     */
    private void printTime(long start, long end) {
        long time = end - start;
        System.out.println("运行时间为： + " + time + " ns");
    }

    /**
     * 打印数组
     * @param array 待打印数组
     */
    private void printArray(Object[] array) {
        for (Object o : array) {
            System.out.print(o + ",");
        }
        System.out.println();
    }
}