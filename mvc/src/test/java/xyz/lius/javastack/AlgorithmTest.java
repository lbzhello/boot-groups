package xyz.lius.javastack;

import java.util.Arrays;

public class AlgorithmTest {
    public int[][] merge(int[][] intervals) {
        if (intervals == null) return null;

        int len = intervals.length;

        // e.g. [[1 2]]
        if (len < 2) return intervals;

        int[][] rst = new int[len][2];

        // rst 长度，当前索引
        int rstLen = 0;

        // 比较元素
        int[] leftElement = intervals[0];

        int i = 1;
        while (i < len) {
            int[] rightElement = intervals[i];
            // 生成
            if (leftElement[1] < rightElement[0]) { // [1 2] [4 6] -> [1 2]
                rst[rstLen++] = leftElement;
                leftElement = rightElement;
            } else if (leftElement[1] >= rightElement[0] && leftElement[1] <= rightElement[1]) {
                // [2 6] [3 7] -> [2 7]
                leftElement = new int[]{leftElement[0], rightElement[1]};
            }
            i++;
        }

        // 最后一个元素放入结果
        // 可能出现 [... [2 6] [3 12] [6 8]] 此时舍弃
        if (rstLen > 0 && rst[rstLen - 1][1] < leftElement[1]) {
            rst[rstLen++] = leftElement;
        }

        return Arrays.copyOf(rst, rstLen);
    }

    public boolean valid(String word, String abbr) {
        // 根据 abbr 计算出的 word 字符个数
        int count = 0;
        for (int i = 0; i < abbr.length(); ) {
            char curChar = abbr.charAt(i);
            if (Character.isDigit(curChar)) {
                // 用于提取 abbr 中的数字
                StringBuilder sb = new StringBuilder();
                sb.append(curChar);
                i++;
                char nextChar;
                while (i < abbr.length() && Character.isDigit(nextChar = abbr.charAt(i))) {
                    sb.append(nextChar);
                    i++;
                }
                int num = Integer.parseInt(sb.toString());
                count += num;
                if (count > word.length()) return false; // "hello" "h88"
            } else if (count >= word.length() //e.g.  "hello" h88o
                    || word.charAt(count) != curChar) {
                return false;
            } else {
                count++;
                i++;
            }
        }
        return true;
    }


    public int steal(int[] nums) {
        int len = nums.length;

        if (len <= 1) {
            return 0;
        } else if (len == 2) { //中间
            return Math.max(nums[0], nums[1]);
        }

        // 相邻的三个数必定有一个被选取
        int sum1 = nums[0], sum2 = nums[1], sum3 = nums[2];

        // sum1, sum2, sum3 的当前索引(最后一个加数的索引)
        int index1 = 0, index2 = 1, index3 = 3;

        // 间隔后的两个必定有一个被选取
        int sum11 = sum1, sum12 = sum1;
        int sum21 = sum2, sum22 = sum2;
        int sum31 = sum3, sum32 = sum3;

        int i = 2;
        while (i < len) {
            // 0 开头，间隔, 首尾, 偶数位
            if (i > index1 + 1 && i != len - 1) {
                if (i % 2 == 0) { // 偶数位
                    sum11 += nums[i];
                } else { // 奇数位
                    sum12 += nums[i];
                }
            }

            // 1 开头， 间隔
            if (i > index2 + 1) {
                if (i % 2 == 0) { // 偶数位
                    sum21 += nums[i];
                } else { // 奇数位
                    sum22 += nums[i];
                }
            }

        }

        return Math.max(Math.max(sum1, sum2), sum3);
    }

    public static void main(String[] args) {
        AlgorithmTest test = new AlgorithmTest();
        int[][] merge = test.merge(new int[][]{new int[]{1, 3}, new int[]{2, 6}, new int[]{8, 10}, new int[]{15, 18}});
        System.out.println(merge);
        System.out.println(test.valid("internationalization", "i12i6"));
    }
}
