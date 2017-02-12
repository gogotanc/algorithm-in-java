package org.tanc.algorithm.sort;

/**
 * 排序算法
 * Created by tanc on 2017/2/12.
 */
public interface BaseSortAlgorithm<E extends Comparable<? super E>> {

    E[] sort(E[] array);
}
