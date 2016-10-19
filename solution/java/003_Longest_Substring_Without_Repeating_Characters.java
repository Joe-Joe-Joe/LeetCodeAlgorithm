//Problem description:
//Given a string.
//find the length of the longest substring without repeating characters.

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        int length = s.length();
        Set<Character> set = new HashSet<>();
        int left, right, ans;
        
        left = 0;
        right = 0;
        ans = 0;
        
        while(right < length) {
            if(set.contains(s.charAt(right))) {
                set.remove(s.charAt(left));
                left++;
            } else {
                set.add(s.charAt(right));
                right++;
                ans = Math.max(ans, right - left);
            }
        }
        return ans;
    }
}

//--------------------------------------------------------------------------------
//==============================java.util.HashSet<E>==============================
//--------------------------------------------------------------------------------
//public class HashSet<E> extends AbstractSet<E> implements Set<E>, Cloneable, Serializable {
//
//	//Adds the specified element to this set if it is not already present.
//	boolean add(E e){};
//	
//	//Returns true if this set contains the specified element.
//	boolean contains(Object o){};
//	
//	//Returns true if this set contains no elements.
//	boolean isEmpty(){};
//	
//	//Removes the specified element from this set if it is present.
//	boolean remove(Object o){};
//	
//	//Returns the number of elements in this set (its cardinality).
//	int size(){};
//	
//	//Returns an iterator over the elements in this set.
//	Iterator<E> iterator(){};
//}