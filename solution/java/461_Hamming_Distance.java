//Problem description:
//The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
//Given two integers x and y, calculate the Hamming distance.

//Note:
//0 ¡Ü x, y < 2^31.

public class Solution {
    public int hammingDistance(int x, int y) {
        
        int sum = 0;
        int flag = 1;
        int a, b;
        for(int i = 0; i < 32; i++) {
            a = (x >> i) & flag;
            b = (y >> i) & flag;
            if(a != b) {
                sum++;
            }
        }
        return sum;
    }
}