1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode() {}
7 *     ListNode(int val) { this.val = val; }
8 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
9 * }
10 */
11class Solution {
12    public ListNode rotateRight(ListNode head, int k) {
13        if(head==null||head.next==null)return head;
14        ListNode current = head;
15        int count=1;
16        while(current.next!=null)
17        {
18          current=current.next;
19          count++;
20        }
21        current.next =head;
22        ListNode curr =head;
23        k=k%count;
24        count=count-k;
25        while(count>1)
26        {
27            curr=curr.next;
28            count--;
29        }
30        head=curr.next;
31        curr.next=null;
32        return head;
33
34       
35        
36    }
37}