//Problem description
//Given an array of integers, every element appears three times except for one.
//Find that single one. 
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

//extra memory O(n) && linear runtime.
public class Solution {
    public int singleNumber(int[] nums) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            
            if(map.containsKey(nums[i])) {
                int temp = (int)map.get(nums[i]);
                if(temp == 1) {
                    map.put(nums[i], 2);
                } else if (temp == 2) {
                    map.remove(nums[i]);
                }
            } else {
                map.put(nums[i], 1);
            }
        }
        
        if(!map.isEmpty()) {
            Set<Integer> key = map.keySet();
            for(Integer i : key) {
                return i;
            }
        }
    }
}

//extra memory o(2) && linear runtime O(32 * n).
public class Solution {
    public int singleNumber(int[] nums) {
        
        int res = 0;
        int temp;
        
        for(int i = 0; i < 32; i++) {
            temp = 0;
            for(int j = 0; j < nums.length; j++) {
                temp += (nums[j] >> i) & 1;
            }
            res |= (temp % 3) << i;
        }
        return res;
    }
}

//extra memory o(3) && linear runtime O(n).
public class Solution {
    public int singleNumber(int[] nums) {
        
        int one = 0;
        int two = 0;
        int three = 0;
        
        for(int i = 0; i < nums.length; i++) {
            
            two |= one & nums[i];
            one ^= nums[i];
            three = one & two;
            
            one &= ~three;
            two &= ~three;
        }
        return one;
    }
}
