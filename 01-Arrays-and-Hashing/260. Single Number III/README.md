<h2><a href="https://leetcode.com/problems/single-number-iii">260. Single Number III</a></h2>

<p>Given an integer array <code>nums</code>, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once. You can return the answer in <strong>any order</strong>.</p>

<p>You must write an&nbsp;algorithm that runs in linear runtime complexity and uses&nbsp;only constant extra space.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,1,3,2,5]
<strong>Output:</strong> [3,5]
<strong>Explanation: </strong> [5, 3] is also a valid answer.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [-1,0]
<strong>Output:</strong> [-1,0]
</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [0,1]
<strong>Output:</strong> [1,0]
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= nums.length &lt;= 3 * 10<sup>4</sup></code></li>
	<li><code>-2<sup>31</sup> &lt;= nums[i] &lt;= 2<sup>31</sup> - 1</code></li>
	<li>Each integer in <code>nums</code> will appear twice, only two integers will appear once.</li>
</ul>


---

# 🛍️ Single-Number-III | Explained

## Approach 1: Frequency Counting via Hash Map

### Intuition
Think of this approach like sorting items into named cubbies at a daycare. As you inspect each item in a pile (`nums`), you place it into its designated cubby (the `HashMap`) and increment a counter on that cubby. Items that appear twice will end up with a counter value of `2`. Items that appear only once will have a counter value of `1`. After sorting through all items, you simply walk past all cubbies, look for the ones marked with `1`, and pull those specific items out into your output tray (`p`).

### Algorithm Visualized

```mermaid
flowchart TD
    A[Start: Input Array nums] --> B[Initialize HashMap 'ans' & Result Array 'p']
    B --> C[Populate HashMap]
    C --> D[Iterate x through nums]
    D --> E[ans.put x, freq + 1]
    E --> F{More elements in nums?}
    F -- Yes --> D
    F -- No --> G[Extract Single Numbers]
    G --> H[Iterate entry through ans.entrySet]
    H --> I{entry.getValue == 1?}
    I -- Yes --> J[p[l] = entry.getKey; l++]
    I -- No --> K[Skip Entry]
    J --> L{More entries in Map?}
    K --> L
    L -- Yes --> H
    L -- No --> M[Return Array p]
```

### Approach
1. **Frequency Tracking**: Instantiate a `HashMap<Integer, Integer>` named `ans` to store each unique number as a key and its total occurrences as the value.
2. **Frequency Population**: Loop through the input array `nums`. For each integer `x`, update its count in the map using `getOrDefault(x, 0) + 1`.
3. **Target Extraction**: Create an integer array `p` of fixed size `2` (since the problem guarantees exactly two unique elements) and a pointer `l` set to `0` to track the insert position.
4. **Map Iteration**: Loop through the key-value pairs (`Map.Entry`) of `ans`. If a pair's value equals `1`, assign its key to `p[l]` and increment `l`.
5. **Return**: Return the array `p` containing the two non-repeating numbers.

### Detailed Code Analysis

* **Line 3:** `HashMap<Integer,Integer>ans=new HashMap<>();`  
  Instantiates the hash map. Hash tables provide $O(1)$ average-time complexity for insertions and lookups.
* **Lines 4–5:** `int[] p=new int[2]; int l=0;`  
  Allocates fixed space for the output result array since the problem statement guarantees exactly two unique numbers. `l` serves as an explicit writing index.
* **Lines 6–9:**  
  ```java
  for(int x:nums) {
      ans.put(x,ans.getOrDefault(x,0)+1);
  }
  ```  
  Enhanced `for` loop iterating over all input elements. `getOrDefault` handles new keys seamlessly by initializing unassigned keys to `0` before adding `1`.
* **Lines 10–17:**  
  ```java
  for(Map.Entry<Integer,Integer>entry:ans.entrySet()) {
      if(entry.getValue()==1) {
          p[l]=entry.getKey();
          l++;
      }
  }
  ```  
  Iterates over the `entrySet()` view of the map. Using `entrySet()` is more efficient than iterating over `keySet()` and re-querying the map with `.get(key)`, as it avoids extra hash lookup overhead. When `entry.getValue() == 1`, the key is copied to `p[l]` and `l` is incremented.
* **Line 18:** `return p;`  
  Returns the array containing the two isolated unique numbers.

### Code

```java
class Solution {
    public int[] singleNumber(int[] nums) {
        HashMap<Integer, Integer> ans = new HashMap<>();
        int[] p = new int[2];
        int l = 0;

        // Phase 1: Count frequencies of each number
        for (int x : nums) {
            ans.put(x, ans.getOrDefault(x, 0) + 1);
        }

        // Phase 2: Identify the two numbers with a frequency of 1
        for (Map.Entry<Integer, Integer> entry : ans.entrySet()) {
            if (entry.getValue() == 1) {
                p[l] = entry.getKey();
                l++;
            }
        }

        return p;
    }
}
```

### Complexity

- **Time Complexity:** $\mathcal{O}(N)$  
  Populating the hash map takes $\mathcal{O}(N)$ time to process $N$ elements. Iterating over the `entrySet` takes $\mathcal{O}(U)$ time, where $U$ is the number of unique elements ($U \le N$). Thus, total time complexity is linear, $\mathcal{O}(N)$.
- **Space Complexity:** $\mathcal{O}(N)$  
  In the worst-case scenario where nearly all elements are unique before pairing up, the `HashMap` will store $\frac{N - 2}{2} + 2$ key-value entries, which scales linearly with the input size $\mathcal{O}(N)$.

---

## 🕵️‍♂️ Follow-up Questions

### 1. Can we optimize the auxiliary space to $\mathcal{O}(1)$ constant memory?
**Answer:** Yes. By leveraging **Bit Manipulation (XOR)**, we can eliminate the `HashMap` entirely. 
1. XORing all elements together cancels out numbers appearing twice ($x \oplus x = 0$), leaving `XOR_sum = a ^ b` (where `a` and `b` are the two unique numbers).
2. Find any set bit (typically the lowest set bit) in `XOR_sum` via `diffBit = XOR_sum & -XOR_sum`. This bit represents a position where `a` and `b` differ (one has `0`, the other has `1`).
3. Partition all numbers in `nums` into two groups based on whether that specific bit is set or not, and XOR the numbers within each group separately. The duplicate pairs in each group cancel out, isolating `a` in one group and `b` in the other.

### 2. How do you prevent integer overflow when isolating the lowest set bit in Java for the bitwise optimal solution?
**Answer:** Calculating `diff = xorSum & -xorSum` can cause integer overflow in standard two's complement arithmetic if `xorSum` equals `Integer.MIN_VALUE` (`-2147483648`). To prevent signed integer overflow exceptions or undefined behavior in strict environments, you cast `xorSum` to a `long` before negation, or use `xorSum & ~(xorSum - 1)` / Bitwise shift methods.