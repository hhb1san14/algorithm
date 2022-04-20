package com.hhb.algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hhb
 * @date 2022/4/20
 * @description388. 文件的最长绝对路径 https://leetcode-cn.com/problems/longest-absolute-file-path/
 * 假设有一个同时存储文件和目录的文件系统。下图展示了文件系统的一个示例：
 * 这里将 dir 作为根目录中的唯一目录。dir 包含两个子目录 subdir1 和 subdir2 。subdir1 包含文件 file1.ext 和子目录 subsubdir1；subdir2 包含子目录 subsubdir2，该子目录下包含文件 file2.ext 。
 * <p>
 * 在文本格式中，如下所示(⟶表示制表符)：
 * <p>
 * dir
 * ⟶ subdir1
 * ⟶ ⟶ file1.ext
 * ⟶ ⟶ subsubdir1
 * ⟶ subdir2
 * ⟶ ⟶ subsubdir2
 * ⟶ ⟶ ⟶ file2.ext
 * 如果是代码表示，上面的文件系统可以写为 "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext" 。'\n' 和 '\t' 分别是换行符和制表符。
 * <p>
 * 文件系统中的每个文件和文件夹都有一个唯一的 绝对路径 ，即必须打开才能到达文件/目录所在位置的目录顺序，所有路径用 '/' 连接。上面例子中，指向 file2.ext 的 绝对路径 是 "dir/subdir2/subsubdir2/file2.ext" 。每个目录名由字母、数字和/或空格组成，每个文件名遵循 name.extension 的格式，其中 name 和 extension由字母、数字和/或空格组成。
 * <p>
 * 给定一个以上述格式表示文件系统的字符串 input ，返回文件系统中 指向 文件 的 最长绝对路径 的长度 。 如果系统中没有文件，返回 0。
 * <p>
 *  
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：input = "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"
 * 输出：20
 * 解释：只有一个文件，绝对路径为 "dir/subdir2/file.ext" ，路径长度 20
 * 示例 2：
 * <p>
 * <p>
 * 输入：input = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
 * 输出：32
 * 解释：存在两个文件：
 * "dir/subdir1/file1.ext" ，路径长度 21
 * "dir/subdir2/subsubdir2/file2.ext" ，路径长度 32
 * 返回 32 ，因为这是最长的路径
 * 示例 3：
 * <p>
 * 输入：input = "a"
 * 输出：0
 * 解释：不存在任何文件
 * 示例 4：
 * <p>
 * 输入：input = "file1.txt\nfile2.txt\nlongfile.txt"
 * 输出：12
 * 解释：根目录下有 3 个文件。
 * 因为根目录中任何东西的绝对路径只是名称本身，所以答案是 "longfile.txt" ，路径长度为 12
 *  
 * <p>
 * 提示：
 * <p>
 * 1 <= input.length <= 104
 * input 可能包含小写或大写的英文字母，一个换行符 '\n'，一个制表符 '\t'，一个点 '.'，一个空格 ' '，和数字。
 */
public class question_0388 {
    public static int lengthLongestPath(String input) {
        if (!input.contains(".")) {
            return 0;
        }
        String[] arr = input.split("\n");
        int result = Integer.MIN_VALUE;
        // 用来存放从根目录当前层级目录的长度，不算每个层级之间的 \ 的值
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            // 获取层级
            int level = getLevel(arr[i]);
            // 获取从更目录当前文件或文件的长度
            //  map.getOrDefault(level - 1, 0):上一级目录的长度
            // arr[i].length()当前目录的长度
            // level:表示有几个/t
            int length = map.getOrDefault(level - 1, 0) + arr[i].length() - level;
            if (isFile(arr[i])) {
                result = Math.max(result, length + level);
            } else {
                map.put(level, length);
            }
        }
        return result;
    }

    /**
     * 判断是不是文件
     *
     * @param s
     * @return
     */
    private static boolean isFile(String s) {
        // 如果不存在. 或 .在文件末尾，说明不是文件
        if (s.lastIndexOf(".") < 0 || s.lastIndexOf(".") == s.length() - 1) {
            return false;
        }
        return true;
    }

    /**
     * 获取当前这个目录或者文件所在层级，有一个\t就表示在第一层级，有两个表示在第二个层级，这样
     * level的值要是要拼接目录是需要 \ 的数量
     *
     * @param s
     * @return
     */
    private static int getLevel(String s) {
        int level = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '\t') {
                break;
            }
            level++;
        }
        return level;
    }

    public static void main(String[] args) {
        System.err.println(lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
        System.err.println(lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.err.println(lengthLongestPath("a"));
        System.err.println(lengthLongestPath("file1.txt\nfile2.txt\nlongfile.txt"));



    }
}
