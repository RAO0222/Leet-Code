<h2><a href="https://leetcode.com/problems/contains-duplicate">217. Contains Duplicate</a></h2>

<p>Given an integer array <code>nums</code>, return <code>true</code> if any value appears <strong>at least twice</strong> in the array, and return <code>false</code> if every element is distinct.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,1]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>

<p><strong>Explanation:</strong></p>

<p>The element 1 occurs at the indices 0 and 3.</p>
</div>

<p><strong class="example">Example 2:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,2,3,4]</span></p>

<p><strong>Output:</strong> <span class="example-io">false</span></p>

<p><strong>Explanation:</strong></p>

<p>All elements are distinct.</p>
</div>

<p><strong class="example">Example 3:</strong></p>

<div class="example-block">
<p><strong>Input:</strong> <span class="example-io">nums = [1,1,1,3,3,4,3,2,4,2]</span></p>

<p><strong>Output:</strong> <span class="example-io">true</span></p>
</div>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>5</sup></code></li>
	<li><code>-10<sup>9</sup> &lt;= nums[i] &lt;= 10<sup>9</sup></code></li>
</ul>


---

# 🛍️ Contains-Duplicate | Explained

## Approach 1: Frequency Counting via Hash Map (Two-Pass)

### Intuition
Imagine you are a clerk taking inventory of items in a warehouse. Every time you pull an item out of a box (`nums`), you write its identifier down on a tally sheet (`HashMap`), incrementing its tally mark count by one. Once you have finished unboxing every single item, you flip through your tally sheet page by page. If you spot any item with two or more tally marks, you immediately raise a flag indicating a duplicate exists. If you reach the end of the sheet and all items have only one tally mark, you declare that all items are unique.

While effective, this approach completes all counting first before checking for duplicates, rather than raising the flag the second a duplicate is seen.

### Algorithm Visualized

```mermaid
flowchart TD
    Start([Start: containsDuplicate]) --> InitMap[Initialize empty HashMap 'ans']
    InitMap --> Loop1[Start Iteration over 'nums']
    
    subgraph Pass 1: Population Phase
        Loop1 --> GetOrDefault[Fetch count of 'x' using getOrDefault]
        GetOrDefault --> PutMap[Put 'x' into 'ans' with count + 1]
        PutMap --> NextNum{More numbers in 'nums'?}
        NextNum -- Yes --> Loop1
    end

    NextNum -- No --> Loop2[Start Iteration over 'ans.entrySet()']

    subgraph Pass 2: Verification Phase
        Loop2 --> CheckFreq{entry.getValue >= 2?}
        CheckFreq -- Yes --> ReturnTrue[Return true]
        CheckFreq -- No --> NextEntry{More entries in map?}
        NextEntry -- Yes --> Loop2
    end

    NextEntry -- No --> ReturnFalse[Return false]
```

### Approach
1. **Frequency Mapping (Pass 1):** Iterate through the input array `nums`. For each integer `x`, update its frequency count in the `HashMap` named `ans`. Use `getOrDefault(x, 0)` to retrieve the existing count (defaulting to `0` if unseen) and add `1`.
2. **Frequency Verification (Pass 2):** Iterate through the entry set (`Map.Entry<Integer, Integer>`) of `ans`.
3. Check the frequency stored in `entry.getValue()`. If any frequency is $\ge 2$, a duplicate exists, so immediately return `true`.
4. **Fallback:** If the map traversal finishes without encountering any frequency $\ge 2$, return `false`.

### Detailed Code Analysis

* **Line 3:** `HashMap <Integer,Integer> ans = new HashMap<>();`
  * Initializes a hash-table-based `Map` implementation. The keys represent the unique numbers from `nums`, and the values represent their respective occurrence counts.
  * *Note:* Using object wrappers (`Integer`) incurs auto-boxing and unboxing overhead in Java compared to primitive types.
* **Lines 4–7:** 
  ```java
  for(int x : nums) {
      ans.put(x, ans.getOrDefault(x, 0) + 1);
  }
  ```
  * An enhanced `for` loop iterates through every primitive `int x` in `nums`.
  * `ans.getOrDefault(x, 0)` performs an $O(1)$ average-time lookup to retrieve the current frequency of `x`.
  * `ans.put(...)` writes the incremented value back into the hash map.
* **Lines 8–15:**
  ```java
  for(Map.Entry<Integer,Integer> entry : ans.entrySet()) {
      int freq = entry.getValue();
      if(freq >= 2) {
          return true;
      }
  }
  ```
  * Iterates over `ans.entrySet()`, which yields key-value pairs (`Map.Entry`).
  * `entry.getValue()` unboxes the frequency `Integer` into a primitive `int freq`.
  * If `freq >= 2`, execution terminates immediately and returns `true`.
* **Line 16:** `return false;`
  * If the loop exits naturally, no number appeared more than once. The method returns `false`.

### Code

```java
class Solution {
    public boolean containsDuplicate(int[] nums) {
        HashMap <Integer,Integer> ans = new HashMap<>();
        for(int x : nums)
        {
            ans.put(x,ans.getOrDefault(x,0)+1);
        }
        for(Map.Entry<Integer,Integer>entry:ans.entrySet())
        {
            int freq= entry.getValue();
            if(freq>=2)
            {
                return true;
            }
        }
        return false;
    }
}
```

### Complexity

- **Time Complexity:** $\mathcal{O}(N)$
  * **Pass 1:** Iterating over `nums` of length $N$ takes $\mathcal{O}(N)$ time. Inserting into and reading from a `HashMap` takes $\mathcal{O}(1)$ average time.
  * **Pass 2:** Iterating over `ans.entrySet()` takes $\mathcal{O}(U)$ time, where $U$ is the number of unique elements ($U \le N$).
  * Total time complexity simplifies to $\mathcal{O}(N + U) = \mathcal{O}(N)$.

- **Space Complexity:** $\mathcal{O}(N)$
  * In the worst-case scenario (where all elements in `nums` are unique), the `HashMap` will store $N$ distinct key-value pairs, requiring $\mathcal{O}(N)$ auxiliary memory.

---

## 🕵️‍♂️ Follow-up Questions

### 1. How can we optimize this solution to be faster and use less memory overhead?
**Answer:** Instead of counting full frequencies in two passes with a `HashMap`, we can use a `HashSet` in a single pass. A `HashSet` only stores unique keys. As we iterate through `nums`, we attempt to insert each number into the set using `Set.add(x)`. If `add(x)` returns `false` (or if `Set.contains(x)` is checked prior to insertion), we know immediately that a duplicate exists and can early-exit on the spot. This eliminates the second loop and reduces memory usage since we don't store frequency counters (`Integer` values).

### 2. Can we solve this problem with $\mathcal{O}(1)$ auxiliary space?
**Answer:** Yes, if we are allowed to modify the input array, we can sort `nums` in-place using `Arrays.sort(nums)` in $\mathcal{O}(N \log N)$ time. After sorting, duplicate elements will be placed adjacent to each other. We can then do a single linear scan checking if `nums[i] == nums[i - 1]`. This achieves $\mathcal{O}(1)$ extra space (or $\mathcal{O}(\log N)$ space for the sorting stack) at the expense of higher time complexity.