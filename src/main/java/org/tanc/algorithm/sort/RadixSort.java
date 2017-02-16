package org.tanc.algorithm.sort;

import java.util.ArrayList;

/**
 * 基数排序
 * Created by tanc on 2017/2/16.
 */
public class RadixSort {

    @SuppressWarnings("unchecked")
    public static String[] sort(String[] arr, int len) {

        ArrayList<String>[] lists = new ArrayList[256];

        for (int i = 0; i < 256; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int a = 0; a < len; a++) {

            for (String anArr : arr) {
                lists[anArr.charAt(a)].add(anArr);
            }

            int index = 0;
            for (ArrayList<String> list : lists) {
                for (String s : list) {
                    arr[index++] = s;
                }
                list.clear();
            }
        }
        return arr;
    }
}
