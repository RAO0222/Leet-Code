<h2><a href="https://leetcode.com/problems/find-pivot-index">724. Find Pivot Index</a></h2>

<p>Given an array of integers <code>nums</code>, calculate the <strong>pivot index</strong> of this array.</p>

<p>The <strong>pivot index</strong> is the index where the sum of all the numbers <strong>strictly</strong> to the left of the index is equal to the sum of all the numbers <strong>strictly</strong> to the index's right.</p>

<p>If the index is on the left edge of the array, then the left sum is <code>0</code> because there are no elements to the left. This also applies to the right edge of the array.</p>

<p>Return <em>the <strong>leftmost pivot index</strong></em>. If no such index exists, return <code>-1</code>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> nums = [1,7,3,6,5,6]
<strong>Output:</strong> 3
<strong>Explanation:</strong>
The pivot index is 3.
Left sum = nums[0] + nums[1] + nums[2] = 1 + 7 + 3 = 11
Right sum = nums[4] + nums[5] = 5 + 6 = 11
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> -1
<strong>Explanation:</strong>
There is no index that satisfies the conditions in the problem statement.</pre>

<p><strong class="example">Example 3:</strong></p>

<pre><strong>Input:</strong> nums = [2,1,-1]
<strong>Output:</strong> 0
<strong>Explanation:</strong>
The pivot index is 0.
Left sum = 0 (no elements to the left of index 0)
Right sum = nums[1] + nums[2] = 1 + -1 = 0
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>1 &lt;= nums.length &lt;= 10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
</ul>

<p>&nbsp;</p>
<p><strong>Note:</strong> This question is the same as&nbsp;1991:&nbsp;<a href="https://leetcode.com/problems/find-the-middle-index-in-array/" target="_blank">https://leetcode.com/problems/find-the-middle-index-in-array/</a></p>


---

# 🛍️ Find-Pivot-Index | Explained

## Approach 1: Total Sum & Running Prefix Sum

### Intuition
Imagine a seesaw loaded with weights at distinct slots along its plank. You are tasked with finding a single slot where you can place a fulcrum so that the seesaw balances horizontally. When the fulcrum is placed directly beneath a slot, the weight sitting at that exact position exerts no tilt to either the left or the right side.

Instead of recalculating the weights on both sides from scratch at every possible fulcrum position, you first find the total weight of all objects combined. As you test slots sequentially from left to right, the weight on the left is simply the running total of weights you have already moved past. The weight remaining on the right is whatever is left after subtracting both the left side's weight and the current slot's weight from the grand total. The moment both sides balance, you have found your pivot index.

### Algorithm Visualized

```mermaid
flowchart TD
    A[Start: Calculate Total Sum] --> B[Initialize leftSum = 0, i = 0]
    B --> C{i < n?}
    C -- No --> D[Return -1]
    C -- Yes --> E{i == 0?}
    E -- Yes --> F{sum - nums[i] == 0?}
    F -- Yes --> G[Return i]
    F -- No --> H[i = i + 1]
    E -- No --> I[leftSum += nums[i - 1]]
    I --> J{sum - nums[i] - leftSum == leftSum?}
    J -- Yes --> G
    J -- No --> H
    H --> C
```

---

### Approach
1. **Compute Grand Total:** Traverse the array once to calculate `sum`, representing the sum of all elements in `nums`.
2. **Track Running Left Sum:** Maintain a variable `leftSum` initialized to `0`.
3. **Scan for Equilibrium:** Iterate through each index `i` from `0` to `n - 1`:
   - **Index 0 Edge Case:** If `i == 0`, no elements exist to the left (`leftSum = 0`). The right sum is `sum - nums[0]`. If `sum - nums[0] == 0`, index `0` is the pivot.
   - **General Case ($i > 0$):** Add the element directly behind the current pointer (`nums[i - 1]`) to `leftSum`.
   - Compute the right side sum implicitly via `sum - nums[i] - leftSum`.
   - Compare if `(sum - nums[i] - leftSum) == leftSum`. If equal, return `i`.
4. **Fallback:** If the loop terminates without finding a balance point, return `-1`.

---

### Detailed Code Analysis

- **Lines 3–5:**
  ```java
  int sum = 0;
  int leftSum = 0;
  for(int num : nums) sum += num;
  ```
  Initializes accumulator variables. The enhanced `for` loop aggregates every integer in `nums` into `sum` in $O(N)$ time. `leftSum` begins at `0` to represent the absence of elements before index `0`.

- **Line 6:**
  ```java
  int n = nums.length;
  ```
  Caches the array length to avoid repeated method invocations during loop evaluation.

- **Lines 7–8:**
  ```java
  for(int i = 0; i < n; i++) 
  {
  ```
  Iterates from left to right. This guarantees that the first valid pivot found is the leftmost pivot, satisfying the problem constraint.

- **Lines 9–13:**
  ```java
  if(i == 0)
  {
      if(sum - nums[i] == 0) return i;
  }
  ```
  Handles the boundary condition at index 0. Here, `leftSum` is strictly `0`. The elements to the right sum to `sum - nums[0]`. If this difference is `0`, index `0` is the pivot and is returned immediately.

- **Lines 14–17:**
  ```java
  else
  {
      leftSum += nums[i - 1];
      if((sum - nums[i] - leftSum) == leftSum) return i;
  }
  ```
  For any index $i > 0$, the element at $i - 1$ is now strictly to the left of the pivot, so it is accumulated into `leftSum`. The remaining right sum is derived via algebraic subtraction: 
  $$\text{rightSum} = \text{sum} - \text{nums}[i] - \text{leftSum}$$
  The condition evaluates if $\text{rightSum} == \text{leftSum}$. If true, index `i` is returned.

- **Line 19:**
  ```java
  return -1;
  ```
  Reachable only when no index satisfies the pivot condition after a full sweep.

---

### Code

```java
class Solution {
    public int pivotIndex(int[] nums) {
        int sum = 0;
        int leftSum = 0;
        for (int num : nums) {
            sum += num;
        }
        
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                if (sum - nums[i] == 0) {
                    return i;
                }
            } else {
                leftSum += nums[i - 1];
                if ((sum - nums[i] - leftSum) == leftSum) {
                    return i;
                }
            }
        }
        return -1;
    }
}
```

---

### Complexity
- **Time Complexity:** $\mathcal{O}(N)$
  - First pass computes the total sum across $N$ elements: $\mathcal{O}(N)$.
  - Second pass traverses up to $N$ elements doing constant-time $\mathcal{O}(1)$ arithmetic and comparisons: $\mathcal{O}(N)$.
  - Total Time: $\mathcal{O}(N) + \mathcal{O}(N) = \mathcal{O}(N)$, where $N$ is the number of elements in `nums`.

- **Space Complexity:** $\mathcal{O}(1)$
  - Only primitive integer variables (`sum`, `leftSum`, `n`, `i`) are stored on the call stack.
  - No auxiliary arrays or dynamically growing data structures are used.

---

## 🕵️‍♂️ Follow-up Questions

1. **Can this solution cause integer overflow in languages with fixed-width integers?**
   - In Java, 32-bit signed integers range from $-2^{31}$ to $2^{31}-1$. If the problem constraints allow `nums.length` up to $10^5$ and values up to $10^5$, `sum` could reach $10^{10}$, overflowing a standard 32-bit `int`. To mitigate this, accumulate values into a `long` for `sum` and `leftSum`.

2. **Can the loop condition be simplified to eliminate the `if (i == 0)` branch?**
   - Yes. Notice that at index `i`, `leftSum` is the sum of elements strictly before `i`. If you check the condition `leftSum == sum - nums[i] - leftSum` *before* adding `nums[i]` to `leftSum`, index `0` works without any special branching because `leftSum` is already `0`.