package com.hhb.algorithm.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author hhb
 * @date 2022/4/23
 * @description 47. 全排列 II https://leetcode-cn.com/problems/permutations-ii/
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 * [1,2,1],
 * [2,1,1]]
 * 示例 2：
 * <p>
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/permutations-ii
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class question_0047 {


    private boolean[] vis;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        vis = new boolean[nums.length];
        Arrays.sort(nums);
        permuteUnique(nums, list, new ArrayList<>());
        return list;
    }

    private void permuteUnique(int[] nums, List<List<Integer>> list, List<Integer> temp) {
        if (temp.size() == nums.length) {
            list.add(new ArrayList<>(temp));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            // vis[i] == true 表示当前元素被访问过
            // i > 0 时，当本次循环的元素与上一个索引位置的元素相等时，且前一个元素没有被访问过
            if (vis[i] || (i > 0 && nums[i - 1] == nums[i] && vis[i - 1])) {
                continue;
            }
            temp.add(nums[i]);
            vis[i] = true;
            permuteUnique(nums, list, temp);
            vis[i] = false;
            temp.remove(temp.size() - 1);
        }

    }


    public static void main(String[] args) {
        question_0047 question_0047 = new question_0047();
        List<List<Integer>> lists = question_0047.permuteUnique(new int[]{1, 2, 1, 1});
        System.err.println(lists);
    }


}
