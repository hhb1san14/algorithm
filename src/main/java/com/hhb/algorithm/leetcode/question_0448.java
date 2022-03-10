package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @description:
 * @author: huanghongbo
 * @date: 2021-07-29 16:32
 **/
public class question_0448 {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> list = new ArrayList<>();
        boolean[] booleans = new boolean[nums.length + 1];
        for (int num : nums) {
            booleans[num] = true;
        }
        for (int i = 1; i < booleans.length; i++) {
            if (!booleans[i]) {
                list.add(i);
            }
        }
        return list;
    }
}
