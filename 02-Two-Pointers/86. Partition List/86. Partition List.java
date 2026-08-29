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
12    public ListNode partition(ListNode head, int x) {
13        ListNode small = new ListNode(0);
14        ListNode Large = new ListNode(0);
15        ListNode sp=small;
16        ListNode lp=Large;
17        ListNode current =head;
18        while(current!=null)
19        {
20            if(current.val<x)
21            {
22                sp.next=new ListNode(current.val);
23                sp=sp.next;
24            }
25            else
26            {
27                lp.next =new ListNode(current.val);
28                lp=lp.next;
29            }
30            current=current.next;
31        }
32        sp.next=Large.next;
33        return small.next;
34
35        
36    }
37}