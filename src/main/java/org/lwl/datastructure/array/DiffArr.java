package org.lwl.datastructure.array;

/**
 * @author: lwl
 * @date: 2022/8/24
 * @description: 差分数组：对原数据区间反复加减
 *
 **/
public class DiffArr {

    public static void main(String[] args) {

    }


    int[] getModifiedArray(int length, int[][] updates) {
        // nums 初始化为全 0
        int[] nums = new int[length];
        // 构造差分解法
        Difference df = new Difference(nums);

        for (int[] update : updates) {
            int i = update[0];
            int j = update[1];
            int val = update[2];
            df.increment(i, j, val);
        }

        return df.result();
    }


    // 差分数组工具类
    public class Difference {
        // 差分数组
        private int[] diff;

        /* 输入一个初始数组，区间操作将在这个数组上进行 */
        public Difference(int[] nums) {
            assert nums.length > 0;
            diff = new int[nums.length];
            // 根据初始数组构造差分数组
            diff[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                diff[i] = nums[i] - nums[i - 1];
            }
        }

        /* 给闭区间 [i, j] 增加 val（可以是负数）*/
        public void increment(int i, int j, int val) {
            diff[i] += val;
            if (j + 1 < diff.length) {
                diff[j + 1] -= val;
            }
        }

        /* 返回结果数组 */
        public int[] result() {
            int[] res = new int[diff.length];
            // 根据差分数组构造结果数组
            res[0] = diff[0];
            for (int i = 1; i < diff.length; i++) {
                res[i] = res[i - 1] + diff[i];
            }
            return res;
        }
    }
}
