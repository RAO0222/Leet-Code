<h2><a href="https://leetcode.com/problems/majority-element-ii">229. Majority Element II</a></h2>

<p>Given an integer array of size <code>n</code>, find all elements that appear more than <code>⌊n / 3⌋</code> times.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> [3]
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1]
<strong>Output:</strong> [1]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [1,2]
<strong>Output:</strong> [1,2]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Follow up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?</p>


---

# 🛍️ Majority-Element-II | Explained

## Approach 1: Frequency Counting via Hash Map and Hash Set

### Intuition
Imagine an election where multiple candidates are competing, and we want to find every candidate who receives strictly more than $1/3$ of the total votes. 

The most straightforward way to solve this is by using a tally sheet (a Hash Map) to count every candidate's votes. Once all votes are counted, we inspect the tally sheet. Any candidate whose total count exceeds $1/3$ of the total votes ($n / 3$) is added to a list of winners. To ensure we don't announce the same winner multiple times when iterating over the raw ballot box again, we store the winners in a set of unique candidates before compiling our final result list.

### Algorithm Visualized

```mermaid
graph TD
    A[Start: Input nums array] --> B[Initialize HashMap 'ans', HashSet 'p', List 'l']
    B --> C[Pass 1: Traverse nums & Populate Frequencies in 'ans']
    C --> D[Pass 2: Traverse nums again]
    D --> E{ans.get(x) > n/3 ?}
    E -- Yes --> F[Insert x into HashSet 'p']
    E -- No --> G[Continue to next element]
    F --> H[Finish Pass 2 Iteration]
    G --> H
    H --> I[Pass 3: Transfer elements from HashSet 'p' to List 'l']
    I --> J[Return List 'l']
```

---

### Approach
1. **Initialize Data Structures**: Create a `HashMap<Integer, Integer>` named `ans` to store frequencies, a `HashSet<Integer>` named `p` to collect unique majority elements, and an `ArrayList<Integer>` named `l` to construct the final output.
2. **Frequency Tally (Pass 1)**: Iterate through `nums`. For each element `x`, update its frequency in `ans` using `ans.getOrDefault(x, 0) + 1`.
3. **Threshold Check (Pass 2)**: Iterate through `nums` again. For each element `x`, look up its frequency in `ans`. If `ans.get(x) > n / 3`, add `x` to the set `p`.
4. **Result Assembly (Pass 3)**: Iterate through the set `p` and transfer each candidate element into the list `l`.
5. **Return**: Output the list `l`.

---

### Detailed Code Analysis

Let's break down the code step-by-step:

*   **Lines 3–6: Data Structure Setup**
    ```java
    HashMap <Integer,Integer> ans = new HashMap<>();
    HashSet <Integer> p = new HashSet<>();
    ArrayList<Integer> l = new ArrayList<>();
    int n=nums.length;
    ```
    - `ans`: Stores key-value pairs where key = element from `nums` and value = frequency.
    - `p`: Acts as a deduplication buffer. If an element appears multiple times in `nums` and its count is $> n/3$, inserting it into a `Set` prevents duplicate entries in the final result.
    - `l`: The concrete list returned by the function to match the `List<Integer>` return type interface.
    - `n`: Stores the size of the array to compute the threshold ($n/3$).

*   **Lines 7–10: Population of the Hash Map**
    ```java
    for(int x:nums)
    {
        ans.put(x,ans.getOrDefault(x,0)+1);
    }
    ```
    - Performs an $O(n)$ linear scan over `nums`.
    - `ans.getOrDefault(x, 0)` safely fetches the current count of `x` or returns `0` if `x` has not been encountered yet, incrementing it by `1`.

*   **Lines 11–18: Filtering Majority Candidates**
    ```java
    for(int x :nums)
    {
        if(ans.get(x)>n/3)
        {
            p.add(x);
        }
    }
    ```
    - Scans `nums` a second time.
    - Looks up `ans.get(x)` in $O(1)$ average time complexity.
    - If `ans.get(x) > n / 3`, `p.add(x)` inserts it into `HashSet p`. Subsequent duplicates in `nums` that also satisfy this condition will simply be ignored by the `HashSet`.

*   **Lines 19–24: Copying and Returning Results**
    ```java
    for(int i:p)
    {
        l.add(i);
    }
    return l;
    ```
    - Iterates over the set `p` (which contains at most 2 elements, since mathematically at most two numbers can have a frequency $> n/3$).
    - Adds each element to `ArrayList l` and returns it.

> 💡 **Code Optimization Note**: Iterating over `nums` a second time and using `HashSet p` is redundant. Instead, you can iterate directly over the entries of `ans` (`ans.entrySet()` or `ans.keySet()`) in a single pass after counting. This eliminates the need for `HashSet p` entirely!

---

### Code

```java
class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap <Integer,Integer> ans = new HashMap<>();
        HashSet <Integer> p = new HashSet<>();
        ArrayList<Integer> l = new ArrayList<>();
        int n=nums.length;
        for(int x:nums)
        {
            ans.put(x,ans.getOrDefault(x,0)+1);
        }
        for(int x :nums)
        {
            if(ans.get(x)>n/3)
            {
                p.add(x);
            }

        }
        for(int i:p)
        {
            l.add(i);
        }
        return l;
        
    }
}
```

---

### Complexity

- **Time Complexity:** $\mathcal{O}(n)$
  - First pass over `nums` takes $\mathcal{O}(n)$ time to build the frequency map.
  - Second pass over `nums` takes $\mathcal{O}(n)$ time to check threshold conditions.
  - Third pass over `p` takes $\mathcal{O}(k)$ time, where $k \le 2$ (at most 2 majority elements exist).
  - Total Time: $\mathcal{O}(n) + \mathcal{O}(n) + \mathcal{O}(1) = \mathcal{O}(n)$.

- **Space Complexity:** $\mathcal{O}(n)$
  - In the worst-case scenario where all elements in `nums` are unique, the `HashMap ans` will store $n$ distinct key-value pairs, requiring $\mathcal{O}(n)$ auxiliary space.

---

## 🕵️‍♂️ Follow-up Questions

### 1. How can we optimize this solution to run in $\mathcal{O}(1)$ auxiliary space complexity?
**Answer:**
We can use the **Extended Boyer-Moore Voting Algorithm**. 

Since we are looking for elements that appear strictly more than $\lfloor n/3 \rfloor$ times, there can be **at most two** such majority elements. 

We can maintain two potential candidate variables (`candidate1`, `candidate2`) and two counters (`count1`, `count2`):
1. **Pass 1 (Election)**: Traverse `nums`.
   - If `x` matches `candidate1`, increment `count1`.
   - Else if `x` matches `candidate2`, increment `count2`.
   - Else if `count1 == 0`, set `candidate1 = x` and `count1 = 1`.
   - Else if `count2 == 0`, set `candidate2 = x` and `count2 = 1`.
   - Else, decrement both `count1` and `count2`.
2. **Pass 2 (Verification)**: Reset `count1` and `count2` to 0. Traverse `nums` to manually count occurrences of `candidate1` and `candidate2`. If a candidate's actual count exceeds $n / 3$, append it to the result list.

This reduces the space complexity from $\mathcal{O}(n)$ down to $\mathcal{O}(1)$ while maintaining an $\mathcal{O}(n)$ time complexity.