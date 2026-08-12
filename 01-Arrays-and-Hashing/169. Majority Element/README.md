<h2><a href="https://leetcode.com/problems/majority-element">169. Majority Element</a></h2>

<p>Given an array <code>nums</code> of size <code>n</code>, return <em>the majority element</em>.</p>

<p>The majority element is the element that appears more than <code>⌊n / 2⌋</code> times. You may assume that the majority element always exists in the array.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [3,2,3]
<strong>Output:</strong> 3
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [2,2,1,1,1,2,2]
<strong>Output:</strong> 2
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>n == nums.length</code></li>
	<li><code>1 &lt;= n &lt;= 5 * 10<sup>4</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
	<li>The input is generated such that a majority element will exist in the array.</li>
</ul>

<p>&nbsp;</p>
<strong>Follow-up:</strong> Could you solve the problem in linear time and in <code>O(1)</code> space?

---

# 🛍️ Majority-Element | Explained

## Approach 1: Frequency Counting using Hash Map
### Intuition
Imagine you are counting votes in an election where one candidate is guaranteed to hold more than half of all total votes cast. To keep track of the results, you set up a tally board (a Hash Map) where every unique candidate name (array element) has a corresponding tally mark counter (frequency count). As you draw each vote out of the ballot box (iterate through `nums`), you update that candidate's tally on the board. Once all votes are counted, you scan through your board to find the candidate whose tally exceeds half the total number of votes cast ($\lfloor N/2 \rfloor$).

### Algorithm Visualized
```mermaid
flowchart TD
    A[Input Array: nums] --> B[Initialize HashMap 'ans']
    B --> C[Pass 1: Traverse 'nums']
    C --> D["Update Map: key = x, value = getOrDefault(x, 0) + 1"]
    D --> E{End of 'nums' reached?}
    E -- No --> C
    E -- Yes --> F[Pass 2: Traverse HashMap 'ans.entrySet()']
    F --> G{"Is freq > nums.length / 2?"}
    G -- Yes --> H[Return Key as Majority Element]
    G -- No --> I{More entries?}
    I -- Yes --> F
    I -- No --> J[Return 0 Default/Fallback]
```

### Approach
1. **Frequency Mapping (First Pass):** Iterate through the given array `nums`. For each integer `x`, update its frequency count inside a HashMap `ans`. We use `getOrDefault` to handle newly encountered numbers gracefully without requiring an explicit key existence check.
2. **Majority Threshold Check (Second Pass):** Calculate the majority threshold, which is strictly greater than `nums.length / 2`. Iterate through all `(key, value)` pairs in `ans.entrySet()`.
3. **Identification & Termination:** As soon as an entry is found where `freq > (nums.length / 2)`, return its corresponding `element` (`key`) immediately.
4. **Fallback:** If no majority element exists (though the problem guarantees one exists), return `0` as a default return value to satisfy the compiler.

### Detailed Code Analysis
- **Line 3:** `HashMap<Integer, Integer> ans = new HashMap<>();`
  - Initializes an empty hash-table-based map where the `key` represents an element from `nums` and the `value` represents its frequency.
- **Lines 4–7:** 
  ```java
  for(int x : nums) {
      ans.put(x, ans.getOrDefault(x, 0) + 1);
  }
  ```
  - An enhanced `for` loop iterates through every integer `x` in `nums`.
  - `ans.getOrDefault(x, 0)` checks if `x` is already in the map. If present, it returns its current frequency; if not, it returns `0`.
  - `.put(...)` increments this count by `1` and updates the map entry.
- **Lines 8–16:** 
  ```java
  for(Map.Entry<Integer, Integer> entry : ans.entrySet()) {
      int element = entry.getKey();
      int freq = entry.getValue();
      if(freq > (nums.length / 2)) {
          return element;
      }
  }
  ```
  - We iterate through `ans.entrySet()`, which avoids repeating key lookups (`ans.get(key)`).
  - For each entry, `entry.getKey()` extracts the unique array element and `entry.getValue()` extracts its accumulated count.
  - The condition `if(freq > (nums.length / 2))` checks if the frequency strictly exceeds half the array length. The first element meeting this condition is returned.
- **Line 17:** `return 0;`
  - Serves as a unreachable fallback return statement required by Java's static type checker.

### Code
```java
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        for(int x : nums)
        {
          ans.put(x, ans.getOrDefault(x, 0) + 1);
        }
        for(Map.Entry<Integer, Integer> entry : ans.entrySet())
        {
            int element = entry.getKey();
            int freq = entry.getValue();
            if(freq > (nums.length / 2))
            {
                return element;
            }
        }
        return 0;
    }
}
```

### Complexity
- **Time:** $\mathcal{O}(N)$
  - First pass over `nums` takes $\mathcal{O}(N)$ time, where $N$ is `nums.length`. Insertion and lookup in a `HashMap` take $\mathcal{O}(1)$ average time.
  - Second pass over `ans.entrySet()` iterates over at most $N$ unique entries, taking $\mathcal{O}(U)$ where $U \le N$ is the number of unique elements.
  - Total Time Complexity: $\mathcal{O}(N) + \mathcal{O}(U) = \mathcal{O}(N)$.
- **Space:** $\mathcal{O}(N)$
  - In the worst-case scenario (e.g., all elements are distinct except one majority element), the `HashMap` will store up to $\lfloor N/2 \rfloor + 1$ distinct keys.
  - Total Auxiliary Space Complexity: $\mathcal{O}(N)$.

---

## 🕵️‍♂️ Follow-up Questions

### 1. How can we optimize this to solve the problem in $\mathcal{O}(1)$ auxiliary space?
**Answer:** We can use **Boyer-Moore Voting Algorithm**.
Since the majority element appears more than $\lfloor N/2 \rfloor$ times, its frequency will always outweigh the combined frequencies of all other elements.
- Maintain a `candidate` variable and a `count` variable initialized to `0`.
- Iterate through `nums`:
  - If `count == 0`, set `candidate = num`.
  - Increment `count` if `num == candidate`, otherwise decrement `count`.
- Return `candidate`. This reduces space complexity to $\mathcal{O}(1)$ while keeping time complexity at $\mathcal{O}(N)$.

### 2. Can we optimize the solution without Boyer-Moore if space isn't a restriction, but code brevity is?
**Answer:** Yes, by single-pass early exit inside the first loop:
```java
for (int x : nums) {
    int count = ans.getOrDefault(x, 0) + 1;
    if (count > nums.length / 2) return x;
    ans.put(x, count);
}
```
This avoids the second loop over `entrySet()` entirely and exits early as soon as the majority threshold is breached.