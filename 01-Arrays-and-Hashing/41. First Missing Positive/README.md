<h2><a href="https://leetcode.com/problems/first-missing-positive">41. First Missing Positive</a></h2>

<p>Given an unsorted integer array <code>nums</code>. Return the <em>smallest positive integer</em> that is <em>not present</em> in <code>nums</code>.</p>

<p>You must implement an algorithm that runs in <code>O(n)</code> time and uses <code>O(1)</code> auxiliary space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,0]
<strong>Output:</strong> 3
<strong>Explanation:</strong> The numbers in the range [1,2] are all in the array.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [3,4,-1,1]
<strong>Output:</strong> 2
<strong>Explanation:</strong> 1 is in the array but 2 is missing.
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [7,8,9,11,12]
<strong>Output:</strong> 1
<strong>Explanation:</strong> The smallest positive integer 1 is missing.
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
</ul>


---

# 🛍️ First-Missing-Positive | Explained

## Approach 1: Hash Set with Maximum Value Tracking

### Intuition
Imagine you are managing an event where attendees receive numbered badges starting from $1$. Some attendees lost their badges, some received negative numbers by mistake, and some received randomly large numbers. To find the lowest badge number that was never handed out, you dump all assigned badge numbers into an instant lookup ledger (a Hash Set) while keeping note of the highest badge number observed. 

You then walk through numbers starting from $1$ upward: the very first number not found in your ledger is the missing positive integer. If every number from $1$ up to the maximum observed badge is present, then the next available badge is simply `max + 1`.

### Algorithm Visualized

```mermaid
flowchart TD
    A[Start: Input Array nums] --> B[Initialize max = 0, HashSet ans]
    B --> C[Loop through nums]
    C --> D[Add nums[i] to HashSet & update max]
    D --> E{Finished array?}
    E -- No --> C
    E -- Yes --> F[Loop i from 1 to max - 1]
    F --> G{Is i in HashSet?}
    G -- No --> H[Return i]
    G -- Yes --> I{Reached max?}
    I -- No --> F
    I -- Yes --> J[Return max + 1]
```

### Approach
1. **Initialize State:**
   - Create a `HashSet<Integer>` named `ans` for $O(1)$ average time lookups.
   - Initialize an integer variable `max = 0` to track the upper bound of the positive numbers present in the array.
2. **Populate and Find Bound:**
   - Iterate through every element in `nums`.
   - Insert each element into `ans`.
   - Update `max` to be the maximum of its current value and the current element `nums[i]`.
3. **Sequential Search for the Missing Positive:**
   - Iterate with an index `i` starting from `1` up to `max - 1`.
   - Check if `i` is present in the `ans` set using `ans.contains(i)`.
   - The first `i` that returns `false` is the smallest missing positive integer; return it immediately.
4. **Fallback Return:**
   - If the loop completes without finding any missing integer (meaning all integers from `1` to `max` are in the set), return `max + 1`.
   - Note: If all numbers in `nums` are negative or zero, `max` remains `0`. The second loop does not execute, and the function returns `0 + 1 = 1`, which is the correct smallest positive integer.

### Detailed Code Analysis

```java
1class Solution {
2    public int firstMissingPositive(int[] nums) {
3        int n=nums.length;
4        int max=0;
5        HashSet<Integer> ans=new HashSet<>();
```
- **Lines 3–5:** We capture the length of the array `n`, initialize `max` to `0` (which ensures non-positive numbers do not artificially inflate our upper search boundary), and instantiate the `HashSet<Integer>` to store our numbers.

```java
6        for(int i=0;i<n;i++)
7        {
8            ans.add(nums[i]);
9            max=Math.max(max,nums[i]);
10       }
```
- **Lines 6–10:** In a single linear pass over the input array:
  - `ans.add(nums[i])` stores each element. Duplicates are automatically handled by the set properties.
  - `max = Math.max(max, nums[i])` tracks the largest value. If all numbers are negative, `max` remains `0`.

```java
11        for(int i=1;i<max;i++)
12        {
13            if(!ans.contains(i))return i;
14        }
15        return max+1;
16    }
17}
```
- **Lines 11–14:** We check sequential positive integers starting from `1` up to `max - 1`. 
  - `!ans.contains(i)` performs an $O(1)$ average time lookup. If `i` is absent, it is the first missing positive, so we return `i`.
- **Line 15:** If no gap was found within the range $[1, \text{max} - 1]$, the answer must be `max + 1`.

### Code
```java
class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int max = 0;
        HashSet<Integer> ans = new HashSet<>();
        
        for (int i = 0; i < n; i++) {
            ans.add(nums[i]);
            max = Math.max(max, nums[i]);
        }
        
        for (int i = 1; i < max; i++) {
            if (!ans.contains(i)) return i;
        }
        
        return max + 1;
    }
}
```

### Complexity
- **Time Complexity:** 
  - Populating the set takes $O(N)$ time where $N$ is `nums.length`.
  - The second loop runs up to $\max(\text{nums})$. In cases where `max` is proportional to $N$, this runs in $O(N)$. However, if `nums` contains a sparse large value (e.g., `[1, 1000000000]`), the loop iterates up to $10^9$ times, making the time complexity $O(N + \max(\text{nums}))$.
- **Space Complexity:** 
  - $O(N)$ auxiliary space to store the elements in the `HashSet`.

---

## 🕵️‍♂️ Follow-up Questions

### 1. How can this be solved in $O(1)$ auxiliary space and $O(N)$ deterministic time?
The standard LeetCode constraint requires an $O(N)$ time and $O(1)$ auxiliary space solution. 
- **In-place Index Placement (Cycle Sort):** Since an array of length $N$ can only contain positive integers from $1$ to $N+1$, we can place each valid number `x` (where $1 \le x \le N$) at its target index `x - 1` by swapping.
- After rearranging, a second scan finds the first index `i` where `nums[i] != i + 1`. The answer is `i + 1`. If all match, the answer is `N + 1`.

### 2. What edge cases might cause this HashSet implementation to fail or time out?
- **Sparse Large Numbers (TLE / High Latency):** If `nums = [1, 2147483646]`, the second loop will iterate over $2 \times 10^9$ times, causing a Time Limit Exceeded (TLE).
- **Integer Overflow:** If `nums` contains `Integer.MAX_VALUE` ($2^{31}-1$), `max + 1` overflows to `Integer.MIN_VALUE` (a negative number).