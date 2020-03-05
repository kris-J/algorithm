package main.java;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author fangjie
 * @Description: ${todo}
 * @date 2019/9/9 16:06
 */
public class LeetCode {

    public static void main(String[] args) {
        int[] a = {0, 1, 2, 3, 4, 5};
        rotate(a, 2);
    }

    /**
     * 旋转数组
     * 当前元素直接跳转到指定K的位置，轮训数组长度n次结束，但是当n%k==0时，所有元素在没有完成跳转时就已经到了起始位置，
     * 所以要进行下一次轮训，跳出条件就是跳转计数器count等于数组的长度
     * @param nums
     * @param k
     */
    public static void rotate(int[] nums, int k) {
        k = k > nums.length ? k % nums.length : k;
        int count = 0;
        for (int start = 0; count < nums.length; start++) {
            int currIndex = start;
            int currNum = nums[currIndex];
            do {
                int changeIndex = (currIndex + k) % nums.length;
                int temp = nums[changeIndex];
                nums[changeIndex] = currNum;
                currNum = temp;
                currIndex = changeIndex;
                count++;
            } while (currIndex != start);
        }

        System.out.println(nums);
    }

    public static int trailingZeroes(int n) {
        int re = 0;
        while (n >= 5) {
            re = re + n / 5;
            n /= 5;
        }
        return re;
    }

    public static int titleToNumber(String s) {
        int ans = 0;
        for (int i = 0; i < s.length(); i++) {
            int num = s.charAt(i) - 'A' + 1;
            ans = ans * 26 + num;
        }
        return ans;
    }

    public static int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
            }
        }
        int max = -1;
        int majority = -1;
        for (Integer key : map.keySet()) {
            if (map.get(key) > max) {
                majority = key;
                max = map.get(key);
            }
        }
        return majority;
    }

    public static String convertToTitle(int n) {
        StringBuilder result = new StringBuilder();
        while (n != 0) {
            n -= 1;
            int a = n % 26 + 'A';
            result.append(String.valueOf((char) a));
            n = n / 26;
        }
        return result.reverse().toString();
    }

    public static int[] twoSum2(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (target - numbers[left] < numbers[right]) {
                right--;
            }
            if (target - numbers[right] > numbers[left]) {
                left++;
            }
            if (target - numbers[right] == numbers[left]) {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
//                return result;
            }
        }
        return result;
    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if (numRows == 0) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        result.get(0).add(1);

        for (int i = 1; i < numRows; i++) {
            List<Integer> column = new ArrayList<>();
            column.add(1);
            List<Integer> prev = result.get(i - 1);
            for (int j = 1; j < i; j++) {
                column.add(prev.get(j - 1) + prev.get(j));
            }
            column.add(1);
            result.add(column);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static TreeNode sortedArrayToBST(int[] nums) {
        TreeNode treeNode = sortedArrayToBST(nums, 0, nums.length);
        return treeNode;
    }

    public static TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (right == left) {
            return null;
        }
        int middle = (left + right) >>> 1;//left+(right-left)/2
        TreeNode t = new TreeNode(nums[middle]);
        t.left = sortedArrayToBST(nums, left, middle);
        t.right = sortedArrayToBST(nums, middle + 1, right);
        return t;
    }

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int len1 = m - 1;
        int len2 = n - 1;
        int len = m + n - 1;
        while (len1 >= 0 && len2 >= 0) {
            // 注意--符号在后面，表示先进行计算再减1，这种缩写缩短了代码
            nums1[len--] = nums1[len1] > nums2[len2] ? nums1[len1--] : nums2[len2--];
        }
        // 表示将nums2数组从下标0位置开始，拷贝到nums1数组中，从下标0位置开始，长度为len2+1
        System.arraycopy(nums2, 0, nums1, 0, len2 + 1);
        System.out.println(nums1);
    }

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        // 注意：针对特殊测试用例，例如 2147395599
        // 要把搜索的范围设置成长整型
        long left = 1;
        long right = x / 2;
        while (left < right) {
            // 注意：这里一定取右中位数，如果取左中位数，代码会进入死循环
            // long mid = left + (right - left + 1) / 2;
            long mid = (left + right + 1) >>> 1;
            long square = mid * mid;
            if (square > x) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        // 因为一定存在，因此无需后处理
        return (int) left;
    }

    public static String addBinary(String a, String b) {
        int prefixCount = Math.abs(a.length() - b.length());
        StringBuilder prefix = new StringBuilder();
        for (int i = 0; i < prefixCount; i++) {
            prefix.append("0");
        }
        if (a.length() < b.length()) {
            a = prefix.toString() + a;
        } else {
            b = prefix.toString() + b;
        }
        int carry = 0;
        String resultBinary = "";
        for (int i = a.length() - 1; i >= 0; i--) {
            int result = Integer.valueOf(String.valueOf(a.charAt(i))) + Integer.valueOf(String.valueOf(b.charAt(i))) + carry;
            if (result == 3) {
                result = 1;
                carry = 1;
            } else if (result == 2) {
                result = 0;
                carry = 1;
            } else {
                carry = 0;
            }
            resultBinary = result + resultBinary;
        }
        if (carry == 1) {
            resultBinary = carry + resultBinary;
        }
        return resultBinary;
    }

    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        double num = 0;
        for (int i = 0; i < len; i++) {
            num += digits[i] * Math.pow(10, len - i - 1);
        }
        num += 1;
        String numStr = new BigDecimal(num).toString();
        int[] result = new int[numStr.indexOf(".")];
        for (int i = 0; i < numStr.length(); i++) {
            if (".".equals(String.valueOf(numStr.charAt(i)))) {
                break;
            }
            result[i] = Integer.valueOf(String.valueOf(numStr.charAt(i)));
        }
        return result;
    }

    public static int lengthOfLastWord(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(" ");
        if (lastIndex == -1) {
            return s.length();
        } else if (lastIndex == s.length() - 1) {
            return 0;
        } else {
            return s.substring(lastIndex, s.length()).length();
        }
    }

    /**
     * 最大和子序
     * 1.子序的开始和结束必为正数
     * 2.子序的子序中，如果包含了第一个数或者最后一个数的和必为正数
     * 3.最大子序列外左边第一个数开始往左任意连续多个数之和以及最大子序列外右边第一个数开始任意多个数之和，一定都是小于零的，否则最大子序列可以加上这一段数变得更大
     *
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int thisNum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            thisNum += nums[i];
            if (thisNum < 0) {
                thisNum = 0;
            } else if (thisNum > sum) {
                sum = thisNum;
            }
        }
        return sum;
    }

    public static String countAndSay(int n) {
        if (n < 1) {
            return "";
        }
        String[] arr = new String[n];
        arr[0] = "1";
        for (int i = 1; i < n; i++) {
            arr[i] = sayCount(arr[i - 1]);
        }
        return arr[n - 1];
    }

    public static String sayCount(String str) {
        StringBuilder say = new StringBuilder();
        int count = 1;
        for (int i = 0; i < str.length(); i++) {
            if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
                count++;
            } else {
                say.append(count).append(str.charAt(i));
                count = 1;
            }
        }
        return say.toString();
    }

    public static int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public static int strIndexOf(String haystack, String needle) {
        if (needle == null || "".equals(needle)) {
            return 0;
        }
        int index = -1;
        for (int i = 0; i < haystack.length(); i++) {
            int lastIndex = haystack.length() - 1;
            int findIndex = i + needle.length() - 1;
            int max = lastIndex < findIndex ? lastIndex : findIndex;
            String sub = haystack.substring(i, max + 1);
            if (needle.equals(sub)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static int removeElement(int[] nums, int val) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int first = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                first = i;
                break;
            }
        }
        if (first == -1) {
            return nums.length;
        }
        int last = -1;
        for (int i = nums.length - 1; i > -1; i--) {
            if (nums[i] != val) {
                last = i;
                break;
            }
        }
        if (first == -1) {
            return 0;
        }
        for (int i = first + 1; i <= last; i++) {
            if (nums[i] != val) {
                nums[first] = nums[i];
                first++;
            }
        }
        return first;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static boolean isValid(String s) {
        boolean valid = true;
        Map<String, String> map = new HashMap<String, String>() {{
            put(")", "(");
            put("}", "{");
            put("]", "[");
        }};
        Stack stack = new Stack();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsValue(String.valueOf(s.charAt(i)))) {
                stack.push(String.valueOf(s.charAt(i)));
            } else if (!stack.isEmpty() && stack.peek().equals(map.get(String.valueOf(s.charAt(i))))) {
                stack.pop();
            } else {
                valid = false;
                break;
            }
        }
        if (!stack.isEmpty()) {
            valid = false;
        }
        return valid;
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0 || strs == null) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String first = strs[0];
        int tag = -1;
        for (int i = 1; i < strs.length; i++) {
            String compare = strs[i];
            int tagTemp = -1;
            for (int j = 0; j < Math.min(first.length(), compare.length()); j++) {
                if (first.charAt(j) == compare.charAt(j)) {
                    tagTemp = j;
                } else {
                    break;
                }
            }
            if (i == 1 || tag > tagTemp) {
                tag = tagTemp;
            }
        }
        String result = first.substring(0, tag + 1);
        return result;
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("I", 1);
            put("V", 5);
            put("X", 10);
            put("L", 50);
            put("C", 100);
            put("D", 500);
            put("M", 1000);
        }};
        int result = 0;
        int lastValue = 0;
        for (int i = 0; i < s.length(); i++) {
            String value = String.valueOf(s.charAt(i));
            if (lastValue > 0 && map.get(value) > lastValue) {
                result = result + map.get(value) - lastValue * 2;
            } else {
                result += map.get(value);
            }
            lastValue = map.get(value);
        }
        return result;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x % 10 == 0) {
            return false;
        }

        long result = 0;

        while (x != 0) {
            result = result * 10 + x % 10;
            x /= 10;
        }

        if (result == Long.valueOf(String.valueOf(x))) {
            return true;
        } else {
            return false;
        }
    }

    public static int reverse(int x) {

        boolean tag = false;
        if (x < 0) {
            tag = true;
        }
        char[] arr = String.valueOf(Math.abs(x)).toCharArray();
        for (int i = 0; i < arr.length / 2; i++) {
            char temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
        }
        int result = 0;
        try {
            result = Integer.valueOf(String.valueOf(arr));
            if (tag) {
                result = 0 - result;
            }
        } catch (NumberFormatException e) {

        }
        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int diff = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + diff == target) {
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }
}
