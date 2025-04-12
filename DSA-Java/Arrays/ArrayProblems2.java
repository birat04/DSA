import java.util.*;

public class ArrayProblems2 {
    
    // 1. Find Minimum in Rotated Sorted Array
    public static int findMinInRotatedArray(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        
        return nums[left];
    }
    
    // 2. Search in Rotated Sorted Array
    public static int searchInRotatedArray(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] == target) {
                return mid;
            }
            
            // Left half is sorted
            if (nums[left] <= nums[mid]) {
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        
        return -1;
    }
    
    // 3. Find Peak Element
    public static int findPeakElement(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
    
    // 4. Find First and Last Position of Element in Sorted Array
    public static int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        
        // Find first position
        int left = 0;
        int right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] >= target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        if (left < nums.length && nums[left] == target) {
            result[0] = left;
        } else {
            return result;
        }
        
        // Find last position
        right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (nums[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        result[1] = right;
        return result;
    }
    
    // 5. Kth Largest Element in Array
    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        
        for (int num : nums) {
            minHeap.offer(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        
        return minHeap.peek();
    }
    
    // 6. Find All Numbers Disappeared in Array
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> result = new ArrayList<>();
        
        // Mark numbers as negative
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        
        // Find positive numbers
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        
        return result;
    }
    
    // 7. Subarray Sum Equals K
    public static int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> prefixSum = new HashMap<>();
        prefixSum.put(0, 1);
        
        int sum = 0;
        int count = 0;
        
        for (int num : nums) {
            sum += num;
            if (prefixSum.containsKey(sum - k)) {
                count += prefixSum.get(sum - k);
            }
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    
    // 8. Maximum Subarray
    public static int maxSubarray(int[] nums) {
        int maxSoFar = nums[0];
        int maxEndingHere = nums[0];
        
        for (int i = 1; i < nums.length; i++) {
            maxEndingHere = Math.max(nums[i], maxEndingHere + nums[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        
        return maxSoFar;
    }
    
    // 9. Best Time to Buy and Sell Stock
    public static int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        
        for (int price : prices) {
            if (price < minPrice) {
                minPrice = price;
            } else if (price - minPrice > maxProfit) {
                maxProfit = price - minPrice;
            }
        }
        
        return maxProfit;
    }
    
    // 10. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        
        int longestStreak = 0;
        
        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                
                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1;
                    currentStreak += 1;
                }
                
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        
        return longestStreak;
    }
    
    public static void main(String[] args) {
        // Test cases
        
        // 1. Find Minimum in Rotated Sorted Array
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Minimum in rotated array: " + findMinInRotatedArray(rotatedArray));
        
        // 2. Search in Rotated Sorted Array
        System.out.println("Search in rotated array (target=0): " + searchInRotatedArray(rotatedArray, 0));
        
        // 3. Find Peak Element
        int[] peakArray = {1, 2, 3, 1};
        System.out.println("Peak element index: " + findPeakElement(peakArray));
        
        // 4. Find First and Last Position
        int[] rangeArray = {5, 7, 7, 8, 8, 10};
        System.out.println("Range of target 8: " + Arrays.toString(searchRange(rangeArray, 8)));
        
        // 5. Kth Largest Element
        int[] kthArray = {3, 2, 1, 5, 6, 4};
        System.out.println("3rd largest element: " + findKthLargest(kthArray, 3));
        
        // 6. Find Disappeared Numbers
        int[] disappearedArray = {4, 3, 2, 7, 8, 2, 3, 1};
        System.out.println("Disappeared numbers: " + findDisappearedNumbers(disappearedArray));
        
        // 7. Subarray Sum Equals K
        int[] sumArray = {1, 1, 1};
        System.out.println("Number of subarrays with sum 2: " + subarraySum(sumArray, 2));
        
        // 8. Maximum Subarray
        int[] maxSubarray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Maximum subarray sum: " + maxSubarray(maxSubarray));
        
        // 9. Best Time to Buy and Sell Stock
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println("Maximum profit: " + maxProfit(prices));
        
        // 10. Longest Consecutive Sequence
        int[] sequenceArray = {100, 4, 200, 1, 3, 2};
        System.out.println("Longest consecutive sequence: " + longestConsecutive(sequenceArray));
    }
} 