//Problem description:
// Given a positive integer n.
//find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

public class Solution {
    public int numSquares(int n) {
        
        Deque<Integer> queue = new LinkedList<Integer>();
        
        int ans = 1;
        boolean flag = false;
        
        queue.offer(n);
        queue.offer(-1);
        
        while(!queue.isEmpty() && flag == false) {
            
            int temp = queue.poll();
            if(temp == -1) {
                ans++;
                queue.offer(-1);
            } else {
                int m = (int)Math.sqrt(temp);
                for(int i = m; i > 0; i--) {
                    if(i * i == temp) {
                        queue.clear();
                        return ans;
                    } else {
                        queue.offer(temp - i * i);
                    }
                }
            }
        }
        throw new IllegalArgumentException("no solution");
    }
}

//----------------------------------------------------------------------------------------
//==============================Describe Deque<E> & Queue<E>==============================
//----------------------------------------------------------------------------------------
//Deque<E> : A linear collection that supports element insertion and removal at both ends.
//Queue<E> : A collection designed for holding elements prior to processing.

//------------------------------------------------------------------------------------------------------------
//==============================Deque<Integer> queue = new LinkedList<Integer>()==============================
//------------------------------------------------------------------------------------------------------------
//public class LinkedList<E> extends AbstractSequentialList<E> implements List<E>, Deque<E>, Cloneable, Serializable {
//	
//	/**
//	 * Use office () to add elements, and poll () to get and remove elements. 
//	 * We can know the operation is succesded or failed according to the return value.
//	 */
//	
//	//Removes all of the elements from this list.
//	void clear(){};
//	
//	//Adds the specified element as the tail (last element) of this list.
//	boolean offer(E e){};
//	
//	//Retrieves and removes the head (first element) of this list.
//	E poll(){};
//	
//	//Retrieves, but does not remove, the head (first element) of this list.
//	E peek(){};
//	
//	//Retrieves, but does not remove, the head (first element) of this list.
// 	E element(){};
//}
