//Problem description
//Write a program that outputs the string representation of numbers from 1 to n.
//But for multiples of three it should output ¡°Fizz¡± instead of the number and for the multiples of five output ¡°Buzz¡±.
//For numbers which are multiples of both three and five output ¡°FizzBuzz¡±

public class Solution {
    public List<String> fizzBuzz(int n) {
        
        List<String> ans = new ArrayList<>();
        int res[] = new int[n + 1];
        int flag;
        
        flag = 3;
        for(int i = 3; i <= n; i += flag) {
            res[i] = 1;
        }
        
        flag = 5;
        for(int i = 5; i <= n; i += flag) {
            if(res[i] == 0) {
                res[i] = 2;
            } else if(res[i] == 1) {
                res[i] = 3;
            }
        }
        
        for(int i = 1; i <= n; i++) {
            
            if(res[i] == 0) {
                ans.add(i + "");
            } else if(res[i] == 1) {
                ans.add("Fizz");
            } else if(res[i] == 2) {
                ans.add("Buzz");
            } else {
                ans.add("FizzBuzz");
            }
        }
        return ans;
    }
}