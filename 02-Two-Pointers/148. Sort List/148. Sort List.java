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
12    public ListNode sortList(ListNode head) {
13        ListNode current = head;
14        ArrayList<Integer>ans=new ArrayList<>();
15        while(current!=null)
16        {
17          ans.add(current.val);
18          current=current.next;
19        }
20        Collections.sort(ans);
21        ListNode curr=head;
22        int count=0;
23        while(curr!=null)
24        {
25            curr.val=ans.get(count);
26            curr=curr.next;
27            count++;
28        }
29        return head;
30    }
31}