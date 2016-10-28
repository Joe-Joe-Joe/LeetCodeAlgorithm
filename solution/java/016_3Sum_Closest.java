//Problem description:(K Sum)
//Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. 
//Return the sum of the three integers. You may assume that each input would have exactly one solution.
public class Solution {    
    public int threeSumClosest(int[] nums, int target) {
        
        qSort(nums, 0, nums.length - 1);
        //Arrays.sort(nums);               //quickly sort
        int minValue = Math.abs(target - nums[0] - nums[1] - nums[2]);
        int minSum = nums[0] + nums[1] + nums[2];
        int left, right;
        int tempSum;
        
        for(int i = 0; i < nums.length - 2; i++) {
            
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }            
            left = i + 1;
            right = nums.length - 1;
            while(left < right) {
                tempSum = nums[i] + nums[left] + nums[right];
                if(tempSum > target) {
                    if(minValue > tempSum - target) {
                        minValue = tempSum - target;
                        minSum = tempSum;
                    }
                    right--;
                } else if(tempSum < target) {
                    if(minValue > target - tempSum) {
                        minValue = target - tempSum;
                        minSum = tempSum;
                    }
                    left++;
                } else {
                    return tempSum;
                }
            }
        }        
        return minSum;
    }
    
    public void qSort(int[] nums, int left, int right) {
        if(left >= right) {
            return;
        }
        
        int first = left;
        int last = right;
        int key = nums[first];
        while(first < last) {
            while(nums[last] >= key && first < last) {
                last--;
            }
            nums[first] = nums[last];
            while(nums[first] <= key && first < last) {
                first++;
            }
            nums[last] = nums[first];
        }
        nums[first] = key;
        qSort(nums, left, first - 1);
        qSort(nums, first + 1, right);
    }
}