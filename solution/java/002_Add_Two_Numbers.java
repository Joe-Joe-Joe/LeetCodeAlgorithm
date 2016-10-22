//Problem description:
//You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. 
//Add the two numbers and return it as a linked list.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int flag = 0;
        
        ListNode res = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode curr = res;
        
        while(p != null && q != null) {
            
            ListNode temp = new ListNode((p.val + q.val + flag) % 10);
            curr.next = temp;
            curr = temp;

            flag = (p.val + q.val + flag) / 10;
            p = p.next;
            q = q.next;
        }
        
        while(p != null) {
            
            ListNode temp = new ListNode((p.val + flag) % 10);
            curr.next = temp;
            curr = temp;
            
            flag = (p.val + flag) / 10;
            p = p.next;
        } 
        
        while(q != null) {
            
            ListNode temp = new ListNode((q.val + flag) % 10);
            curr.next = temp;
            curr = temp;

            flag = (q.val + flag) / 10;
            q = q.next;
        }
        
        if(flag > 0) {
            ListNode temp = new ListNode(flag);
            curr.next = temp;
            curr = temp;
        }
        
        return res.next;
    }
}

//------------------------------------------------------------------------
//==============================Linked Lists==============================
//------------------------------------------------------------------------
//public class ListNode {
//	  int val;
//    ListNode next;
//    ListNode(int x) { val = x; }
//}

//-----------------------------------------------------------------------
//==============================How to use===============================
//-----------------------------------------------------------------------
//ListNode temp = new ListNode(0);
//ListNode curr = temp;
//curr = temp.next;