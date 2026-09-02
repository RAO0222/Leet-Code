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
12    public ListNode oddEvenList(ListNode head) {
13        if(head==null||head.next==null)return head;
14        ListNode current=head;
15        ListNode curr=head.next;
16        ListNode eh = head.next;
17        while(curr!=null&&curr.next!=null)
18        {
19            current.next =curr.next;
20            current=current.next;
21            curr.next=current.next;
22            curr=curr.next;
23            
24        }
25       current.next=eh;
26      
27        return head;
28        
29    }
30}