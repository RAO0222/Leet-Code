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
12    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
13        ListNode head = new ListNode(0);
14        ListNode current= head;
15        while(list1!=null&&list2!=null)
16        {
17            if(list1.val>list2.val)
18            {
19                
20                ListNode newNode=new ListNode(list2.val);
21                current.next=newNode;
22                current=current.next;
23                list2=list2.next;
24            }
25            else
26            {
27              ListNode newNode=new ListNode(list1.val);
28                current.next=newNode;
29                current=current.next;
30                list1=list1.next;
31            }
32        }
33        if(list1!=null)current.next=list1;
34        else current.next=list2;
35        head=head.next;
36        return head;
37
38        
39    }
40}