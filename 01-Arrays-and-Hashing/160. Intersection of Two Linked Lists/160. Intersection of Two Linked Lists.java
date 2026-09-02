1/**
2 * Definition for singly-linked list.
3 * public class ListNode {
4 *     int val;
5 *     ListNode next;
6 *     ListNode(int x) {
7 *         val = x;
8 *         next = null;
9 *     }
10 * }
11 */
12public class Solution {
13    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
14        HashSet<ListNode> ans = new HashSet<>();
15        ListNode current=headA;
16        while(current!=null)
17        {
18            ans.add(current);
19            current=current.next;
20        }
21        ListNode curr=headB;
22        while(curr!=null)
23        {
24            if(ans.contains(curr))return curr;
25            curr=curr.next;
26        }
27        return null;
28        
29        
30    }
31}