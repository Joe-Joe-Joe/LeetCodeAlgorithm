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