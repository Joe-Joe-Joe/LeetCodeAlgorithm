//Problem description:(K Sum)
//Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? 
//Find all unique quadruplets in the array which gives the sum of target.
//Note:
//The solution set must not contain duplicate quadruplets.
public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        int left, right;
        int tempSum;
        
        for(int i = 0; i < nums.length - 3; i++) {
            
            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for(int j = i + 1; j < nums.length - 2; j++) {
                
                if(j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                left = j + 1;
                right = nums.length - 1;
                while(left < right) {
                    tempSum = nums[i] + nums[j] + nums[left] + nums[right];
                    if(tempSum == target) {
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(nums[i]);
                        tempList.add(nums[j]);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);
                        res.add(tempList);
                        
                        while(left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        
                        while(left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        left++;
                        right--;
                    } else if(tempSum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }        
        return res;
    }
}