//Problem describtion:
//Given an array of integers, every element appears twice except for one.
//Find that single one.
//Note:
//Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory? 

//extra memory O(n) && linear runtime
public class Solution {
    public int singleNumber(int[] nums) {
        
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
        
        if(!map.isEmpty()) {
            Set<Integer> key = map.keySet();
            for(Integer i : key) {
                return i;
            }
        }

        throw new IllegalArgumentException("no solution");
    }
}

//extra memory o(1) && linear runtime
public class Solution {
    public int singleNumber(int[] nums) {
        
        int temp = nums[0];
        for(int i = 1; i < nums.length; i++) {
            
            temp = temp ^ nums[i];   //OR
        }
        return temp;
    }
}

//----------------------------------------------------------------------------
//==============================Iterator HashMap==============================
//----------------------------------------------------------------------------
//entrySet() Each element traverses once.
//Iterator iter = map.entrySet().iterator();
//while (iter.hasNext()) {
//	Map.Entry entry = (Map.Entry) iter.next();
//	Object key = entry.getKey();
//	Object val = entry.getValue();
//}
//----------------------------------------------------------------------------
//keySet() Each element traverses twice.
//Iterator iter = map.keySet().iterator();
//while (iter.hasNext()) {
//	Object key = iter.next();
//	Object val = map.get(key);
//}