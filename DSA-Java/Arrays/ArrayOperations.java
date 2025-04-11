import java.util.*;

public class ArrayOperations {
    
    // 1. Basic Operations
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    // 2. Two Pointer Technique
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
    
    // 3. Sliding Window
    public static int maxSubarraySum(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;
        
        // Calculate first window sum
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        
        // Slide window and update max sum
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
    // 4. Prefix Sum
    public static int[] prefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        return prefix;
    }
    
    // 5. Common Interview Problems
    
    // Problem 1: Move Zeroes
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        
        // Move all non-zero elements to the front
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        
        // Fill remaining positions with zeroes
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }
    
    // Problem 2: Find Missing Number
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    // Problem 3: Rotate Array
    public static void rotateArray(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }
    
    private static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
    
    public static void main(String[] args) {
        // Test cases
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array:");
        printArray(arr);
        
        // Two Sum
        int[] twoSumResult = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("\nTwo Sum indices: " + Arrays.toString(twoSumResult));
        
        // Sliding Window
        int maxSum = maxSubarraySum(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println("Maximum subarray sum: " + maxSum);
        
        // Prefix Sum
        int[] prefix = prefixSum(new int[]{1, 2, 3, 4, 5});
        System.out.println("Prefix sum array: " + Arrays.toString(prefix));
        
        // Move Zeroes
        int[] zeroArray = {0, 1, 0, 3, 12};
        moveZeroes(zeroArray);
        System.out.println("After moving zeroes: " + Arrays.toString(zeroArray));
        
        // Find Missing Number
        int missing = findMissingNumber(new int[]{0, 1, 3});
        System.out.println("Missing number: " + missing);
        
        // Rotate Array
        int[] rotateArray = {1, 2, 3, 4, 5};
        rotateArray(rotateArray, 2);
        System.out.println("After rotation: " + Arrays.toString(rotateArray));
    }
} 