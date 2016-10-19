//Problem description:
//Given an array of integers.
//return indices of the two numbers such that they add up to a specific target.

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        
        for(int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i]) && map.get(target - nums[i]) != i){
                return new int[] {i, map.get(target - nums[i])};
            }
        }
        throw new IllegalArgumentException("no two sum solution");
    }
}

//structure description:java.util.HashMap<K, V>
//public class HashMap<K, V> extends AbstractMap<K, V> implements Map<K, V>, Cloneable, Serializable {
//    
//   //Returns true if this map contains a mapping for the specified key.
//    boolean containsKey(Object key){};
//    
//    //Returns true if this map maps one or more keys to the specified value
//    boolean containsValue(Object value){};
//    
//    //Returns the value to which the specified key is mapped, or null if this map contains no mapping for the key.
//    V get(Object key){};
//    
//    //Returns true if this map contains no key-value mappings.
//    boolean isEmpty(){};
//    
//    //Associates the specified value with the specified key in this map.
//    V put(K key, V value){};
//    
//    //Removes the mapping for the specified key from this map if present.
//    V remove(Object key){};
//    
//    //Returns the number of key-value mappings in this map.
//    int size(){};
//}
