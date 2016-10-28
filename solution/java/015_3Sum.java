//Problem description:(K Sum)
//Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? 
//Find all unique triplets in the array which gives the sum of zero.
//Note:
//The solution set must not contain duplicate triplets.
public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
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
                if(tempSum == 0) {
                    List<Integer> tempList = new ArrayList<>();
                    tempList.add(nums[i]);
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
                } else if(tempSum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }        
        return res;
    }
}