//Problem description:
//Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. 
//Find the two elements that appear only once. 
//Note:
//The order of the result is not important.
//Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?

//extra memory O(n) && linear runtime.
public class Solution {
    public int[] singleNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(map.containsKey(nums[i])) {
                int temp = (int)map.get(nums[i]);
                if(temp == 1) {
                    map.remove(nums[i]);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        
        int[] temp = new int[2];
        int k = 0;
        if(!map.isEmpty()) {
            Set<Integer> key = map.keySet();
            for(Integer i : key) {
                temp[k] = i;
                k++;
            }
        }

        return temp;
    }
}

//extra memory O(1) && linear runtime.
public class Solution {
    public int[] singleNumber(int[] nums) {
        
        int temp = 0;
        int[] res = new int[2];
        
        for(int i = 0; i < nums.length; i++) {
            temp ^= nums[i];
        }
        
        temp &= -temp;
        for(int i = 0; i < nums.length; i++) {
            if((temp & nums[i]) != 0) {
                res[0] ^= nums[i];
            } else {
                res[1] ^= nums[i];
            }
        }
        return res;
    }
}
