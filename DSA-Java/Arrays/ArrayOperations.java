import java.util.*;

public class ArrayOperations {
    
   
    public static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
   
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
    
   
    public static int maxSubarraySum(int[] nums, int k) {
        int maxSum = 0;
        int windowSum = 0;
        
        
        for (int i = 0; i < k; i++) {
            windowSum += nums[i];
        }
        maxSum = windowSum;
        
       
        for (int i = k; i < nums.length; i++) {
            windowSum = windowSum + nums[i] - nums[i - k];
            maxSum = Math.max(maxSum, windowSum);
        }
        
        return maxSum;
    }
    
   
    public static int[] prefixSum(int[] nums) {
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        
        return prefix;
    }
    
   
    public static void moveZeroes(int[] nums) {
        int nonZeroIndex = 0;
        
        
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[nonZeroIndex++] = nums[i];
            }
        }
        
        
        while (nonZeroIndex < nums.length) {
            nums[nonZeroIndex++] = 0;
        }
    }
    
   
    public static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        
        for (int num : nums) {
            actualSum += num;
        }
        
        return expectedSum - actualSum;
    }
    
    
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
    
    
    public static int maxProductSubarray(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        
        int maxProduct = nums[0];
        int minProduct = nums[0];
        int result = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            int temp = maxProduct;
            maxProduct = Math.max(Math.max(maxProduct * nums[i], minProduct * nums[i]), nums[i]);
            minProduct = Math.min(Math.min(temp * nums[i], minProduct * nums[i]), nums[i]);
            result = Math.max(result, maxProduct);
        }
        
        return result;
    }

   
    public static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            int currentArea = Math.min(height[left], height[right]) * (right - left);
            maxArea = Math.max(maxArea, currentArea);
            
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }

    
    public static int trapRainWater(int[] height) {
        if (height == null || height.length < 3) return 0;
        
        int left = 0;
        int right = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;
        int water = 0;
        
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= leftMax) {
                    leftMax = height[left];
                } else {
                    water += leftMax - height[left];
                }
                left++;
            } else {
                if (height[right] >= rightMax) {
                    rightMax = height[right];
                } else {
                    water += rightMax - height[right];
                }
                right--;
            }
        }
        
        return water;
    }

   
    public static int[][] mergeIntervals(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) return intervals;
        
        
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        List<int[]> merged = new ArrayList<>();
        int[] current = intervals[0];
        merged.add(current);
        
        for (int[] interval : intervals) {
            if (interval[0] <= current[1]) {
                current[1] = Math.max(current[1], interval[1]);
            } else {
                current = interval;
                merged.add(current);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }

  
    public static void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        
       
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        if (i >= 0) {
            int j = nums.length - 1;
            
            while (j >= 0 && nums[j] <= nums[i]) {
                j--;
            }
            swap(nums, i, j);
        }
        
        
        reverse(nums, i + 1, nums.length - 1);
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                result.add(Math.abs(nums[i]));
            } else {
                nums[index] = -nums[index];
            }
        }
        
        return result;
    }

    
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        
       
        result[0] = 1;
        for (int i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
       
        int rightProduct = 1;
        for (int i = n - 1; i >= 0; i--) {
            result[i] = result[i] * rightProduct;
            rightProduct *= nums[i];
        }
        
        return result;
    }

    public static void main(String[] args) {
       
        int[] arr = {1, 2, 3, 4, 5};
        System.out.println("Original array:");
        printArray(arr);
        
       
        int[] twoSumResult = twoSum(new int[]{2, 7, 11, 15}, 9);
        System.out.println("\nTwo Sum indices: " + Arrays.toString(twoSumResult));
        
       
        int maxSum = maxSubarraySum(new int[]{1, 2, 3, 4, 5}, 3);
        System.out.println("Maximum subarray sum: " + maxSum);
        
        
        int[] prefix = prefixSum(new int[]{1, 2, 3, 4, 5});
        System.out.println("Prefix sum array: " + Arrays.toString(prefix));
        
        
        int[] zeroArray = {0, 1, 0, 3, 12};
        moveZeroes(zeroArray);
        System.out.println("After moving zeroes: " + Arrays.toString(zeroArray));
        
       
        int missing = findMissingNumber(new int[]{0, 1, 3});
        System.out.println("Missing number: " + missing);
        
        
        int[] rotateArray = {1, 2, 3, 4, 5};
        rotateArray(rotateArray, 2);
        System.out.println("After rotation: " + Arrays.toString(rotateArray));

       
        System.out.println("\nAdditional Array Problems:");
        
       
        int[] productArray = {2, 3, -2, 4};
        System.out.println("Maximum Product Subarray: " + maxProductSubarray(productArray));
        
      
        int[] heightArray = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Maximum Area: " + maxArea(heightArray));
        
        
        int[] rainArray = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Trapped Rain Water: " + trapRainWater(rainArray));
        
        
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = mergeIntervals(intervals);
        System.out.println("Merged Intervals: " + Arrays.deepToString(merged));
        
        int[] permArray = {1, 2, 3};
        nextPermutation(permArray);
        System.out.println("Next Permutation: " + Arrays.toString(permArray));
        
        
        int[] dupArray = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Duplicates: " + findDuplicates(dupArray));
        
        
        int[] productSelfArray = {1, 2, 3, 4};
        System.out.println("Product Except Self: " + Arrays.toString(productExceptSelf(productSelfArray)));
    }
} 