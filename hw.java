//2540
// class Solution {
//     public int getCommon(int[] nums1, int[] nums2) {
//         int i = 0, j = 0;
//         while (i < nums1.length && j < nums2.length) {
//             if (nums1[i] == nums2[j]) {
//                 return nums1[i];
//             } else if (nums1[i] < nums2[j]) {
//                 i++;
//             } else {
//                 j++;
//             }
//         }
//         return -1;
//     }
// }

//860
// class Solution {
//     public boolean lemonadeChange(int[] bills) {
//         int five = 0;  // To track the number of $5 bills
//         int ten = 0;   // To track the number of $10 bills

//         for (int bill : bills) {
//             if (bill == 5) {
//                 // If customer pays with a $5 bill, just collect it
//                 five++;
//             } else if (bill == 10) {
//                 // If customer pays with a $10 bill, give them back a $5 bill
//                 if (five > 0) {
//                     five--;
//                     ten++;
//                 } else {
//                     return false;  // No $5 bill to give as change
//                 }
//             } else {
//                 // If customer pays with a $20 bill, give them $10 + $5 or 3 x $5 as change
//                 if (ten > 0 && five > 0) {
//                     ten--;
//                     five--;
//                 } else if (five >= 3) {
//                     five -= 3;
//                 } else {
//                     return false;  // No valid change to give
//                 }
//             }
//         }
//         return true;  // Successfully provided change to all customers
//     }
// }
//
// //2706
// class Solution {
//     public int buyChoco(int[] prices, int money) {
//         Arrays.sort(prices);
// 	int sum=prices[0];
// 	for(int i=1;i<prices.length;i++) {
// 		sum+=prices[i];
// 		if(sum<=money) {
// 			return money-sum;
// 		}
// 		sum-=prices[i];
// 	}
// 	return money;
//     }
// }

// //455
// class Solution {
//     public int findContentChildren(int[] g, int[] s) {

//         Arrays.sort(g);
//         Arrays.sort(s);

//         int childIndex = 0;
//         int cookieIndex = 0;
//         while (cookieIndex < s.length && childIndex < g.length) {

//             if (g[childIndex] <= s[cookieIndex]) { childIndex++; }
//             cookieIndex++;
//         }    

//         return childIndex; 
//     }
// }
//845
// class Solution {
//     public int longestMountain(int[] A) {
// int N = A.length, res = 0;
// int[] up = new int[N], down = new int[N];
// for (int i = N - 2; i >= 0; --i) if (A[i] > A[i + 1]) down[i] = down[i + 1] + 1;
// for (int i = 0; i < N; ++i) {
//     if (i > 0 && A[i] > A[i - 1]) up[i] = up[i - 1] + 1;
//     if (up[i] > 0 && down[i] > 0) res = Math.max(res, up[i] + down[i] + 1);
// }
// return res;

// }
// }
//16
// class Solution {
//     public int threeSumClosest(int[] nums, int target) {
//         Arrays.sort(nums);
//         int closest_sum = Integer.MAX_VALUE / 2;  // A large value but not overflow
        
//         for (int i = 0; i < nums.length - 2; ++i) {
//             int left = i + 1, right = nums.length - 1;
//             while (left < right) {
//                 int current_sum = nums[i] + nums[left] + nums[right];
//                 if (Math.abs(current_sum - target) < Math.abs(closest_sum - target)) {
//                     closest_sum = current_sum;
//                 }
//                 if (current_sum < target) {
//                     ++left;
//                 } else if (current_sum > target) {
//                     --right;
//                 } else {
//                     return current_sum;
//                 }
//             }
//         }
        
//         return closest_sum;
//     }
// }
//15
// class Solution {
//     public List<List<Integer>> threeSum(int[] nums) {
//         List<List<Integer>> res = new ArrayList<>();
//         Arrays.sort(nums);

//         for (int i = 0; i < nums.length; i++) {
//             if (i > 0 && nums[i] == nums[i-1]) {
//                 continue;
//             }
            
//             int j = i + 1;
//             int k = nums.length - 1;

//             while (j < k) {
//                 int total = nums[i] + nums[j] + nums[k];

//                 if (total > 0) {
//                     k--;
//                 } else if (total < 0) {
//                     j++;
//                 } else {
//                     res.add(Arrays.asList(nums[i], nums[j], nums[k]));
//                     j++;

//                     while (nums[j] == nums[j-1] && j < k) {
//                         j++;
//                     }
//                 }
//             }
//         }
//         return res;        
//     }
// }
//523
// class Solution {
//     public boolean checkSubarraySum(int[] nums, int k) {
//         int n = nums.length;
//         Map<Integer, Integer> remainderMap = new HashMap<>();
//         int cumulativeSum = 0;
        
//         // Step 1: Initialize Remainder Map
//         remainderMap.put(0, -1);
        
//         // Step 2: Iterate Through the List
//         for (int i = 0; i < n; i++) {
//             // Step 3: Calculate Cumulative Sum
//             cumulativeSum += nums[i];
            
//             // Step 4: Calculate Remainder
//             int remainder = k == 0 ? cumulativeSum : cumulativeSum % k;
            
//             // Step 5: Update Remainder Map
//             if (remainderMap.containsKey(remainder)) {
//                 // Check if segment length is at least two
//                 if (i - remainderMap.get(remainder) > 1) {
//                     return true;
//                 }
//             } else {
//                 remainderMap.put(remainder, i);
//             }
//         }
        
//         // Step 6: Return the Result
//         return false;
//     }
// // }
// //1248
// class Solution {
//     public int numberOfSubarrays(int[] nums, int k) {
//         int n = nums.length;
//         int[] cnt = new int[n + 1];
//         cnt[0] = 1;
//         int ans = 0, t = 0;
//         for (int v : nums) {
//             t += v & 1;
//             if (t - k >= 0) {
//                 ans += cnt[t - k];
//             }
//             cnt[t]++;
//         }
//         return ans;
//     }
// }
//560
// class Solution {
//     public int subarraySum(int[] nums, int k) {
//         return pos(nums,k);
//     }
//     public static int pos(int[] arr,int k) {
//             int ch=0;
//             for(int i=0;i<arr.length;i++){
// 	if(arr[i]==k) {
// 		ch++;
// 	}
//             }
// 	for(int i=0;i<arr.length-1;i++) {
// 		arr[i]+=arr[i+1];
// 		if(arr[i]==k) {
// 			ch++;
// 		}
// 	}
// 	return ch;

// }
// }
//152
// class Solution {
//     public int maxProduct(int[] nums) {
        
//         int max = nums[0], min = nums[0], ans = nums[0];
//         int n = nums.length;
        
//         for (int i = 1; i < n; i++) {
        
// 			// Swapping min and max
//             if (nums[i] < 0){
//                 int temp = max;
//                 max = min;
//                 min = temp;
//             }
                


//             max = Math.max(nums[i], max * nums[i]);
//             min = Math.min(nums[i], min * nums[i]);


//             ans = Math.max(ans, max);
//         }
        
//         return ans;

//     }
// }
//11
// class Solution {
//     public int maxArea(int[] height) {
//         int left = 0;
//         int right = height.length - 1;
//         int maxArea = 0;

//         while (left < right) {
//             int currentArea = Math.min(height[left], height[right]) * (right - left);
//             maxArea = Math.max(maxArea, currentArea);

//             if (height[left] < height[right]) {
//                 left++;
//             } else {
//                 right--;
//             }
//         }

//         return maxArea;
//     }
// }