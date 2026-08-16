<h2><a href="https://leetcode.com/problems/maximum-product-of-three-numbers">628. Maximum Product of Three Numbers</a></h2>

<p>Given an integer array <code>nums</code>, <em>find three numbers whose product is maximum and return the maximum product</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3]
<strong>Output:</strong> 6
</pre><p><strong class="example">Example 2:</strong></p>
<pre><strong>Input:</strong> nums = [1,2,3,4]
<strong>Output:</strong> 24
</pre><p><strong class="example">Example 3:</strong></p>
<pre><strong>Input:</strong> nums = [-1,-2,-3]
<strong>Output:</strong> -6
</pre>
<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>3 &lt;= nums.length &lt;=&nbsp;10<sup>4</sup></code></li>
	<li><code>-1000 &lt;= nums[i] &lt;= 1000</code></li>
</ul>


---

# 🛍️ Maximum-Product-of-Three-Numbers | Explained

## Approach 1: Sorting-Based Extremes Comparison

### Intuition
When looking for the maximum product of three numbers in an array, our natural instinct is to pick the three largest positive numbers. However, multiplication has a special property: the product of two negative numbers is positive. If an array contains very large negative numbers (e.g., `-100` and `-90`), multiplying them together yields a massive positive number (`+9000`). If we multiply that with the largest positive number in the array, it could easily exceed the product of the three largest positive numbers.

Think of this like an investment portfolio where debt can be canceled out: you either take your three largest standard gains, or you pair your two largest negative balances (which cancel into a massive positive credit) and multiply them by your single highest asset.

### Algorithm Visualized

```mermaid
flowchart TD
    A["Input Array: nums"] --> B["Sort Array in Ascending Order: Arrays.sort(nums)"]
    B --> C{"Evaluate Two Potential Candidates"}
    
    C -->|Candidate 1: Three Largest Elements| D["nums[n-1] * nums[n-2] * nums[n-3]"]
    C -->|Candidate 2: Two Smallest (Negatives) * Largest| E["nums[0] * nums[1] * nums[n-1]"]
    
    D --> F["Math.max(Candidate 1, Candidate 2)"]
    E --> F
    F --> G["Return Maximum Product"]
```

### Approach
1. **Sort the array** in ascending order.
2. After sorting, identify the two possible configurations that can produce the maximum product:
   - **Case A (All Positives or Mixed):** The product of the three largest numbers at the end of the array: `nums[n-1] * nums[n-2] * nums[n-3]`.
   - **Case B (Two Large Negatives):** The product of the two smallest (most negative) numbers at the beginning of the array, combined with the largest positive number at the end: `nums[0] * nums[1] * nums[n-1]`.
3. Return the maximum of these two values using `Math.max()`.

### Detailed Code Analysis

```java
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max((nums[n-1]*nums[n-2]*nums[n-3]),(nums[0]*nums[1]*nums[n-1]));
    }
}
```

- **Line 3 (`int n = nums.length;`)**:
  Captures the total number of elements in the array to easily index from the end (`n - 1`, `n - 2`, `n - 3`).
  
- **Line 4 (`Arrays.sort(nums);`)**:
  Sorts the primitive integer array in-place in ascending order using Java's Dual-Pivot Quicksort. This repositions the smallest values (potential negative magnitudes) to indices `0` and `1`, and the largest values to indices `n-3`, `n-2`, and `n-1`.

- **Line 5 (`return Math.max(...);`)**:
  Calculates both candidate products:
  - `nums[n-1] * nums[n-2] * nums[n-3]`: Product of the three largest elements.
  - `nums[0] * nums[1] * nums[n-1]`: Product of the two most negative elements multiplied by the largest element.
  
  `Math.max` evaluates both expressions and returns the greater value directly.

### Code
```java
class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        return Math.max((nums[n-1] * nums[n-2] * nums[n-3]), (nums[0] * nums[1] * nums[n-1]));
    }
}
```

### Complexity
- **Time:** $\mathcal{O}(N \log N)$ — Sorting the array of size $N$ dominates the runtime. The subsequent multiplication and comparison operations run in $\mathcal{O}(1)$ time.
- **Space:** $\mathcal{O}(\log N)$ — Java's `Arrays.sort()` for primitive types implements Dual-Pivot Quicksort, which requires $\mathcal{O}(\log N)$ auxiliary stack space for recursion. No extra heap memory is allocated.

---

## 🕵️‍♂️ Follow-up Questions

### 1. Can we optimize this solution to $\mathcal{O}(N)$ time complexity?
Yes. We only need five specific values to compute the answer: the 3 maximum values (`max1`, `max2`, `max3`) and the 2 minimum values (`min1`, `min2`). Instead of sorting the entire array in $\mathcal{O}(N \log N)$, we can scan the array in a single linear pass ($\mathcal{O}(N)$ time, $\mathcal{O}(1)$ space) while maintaining these five variables.

### 2. What happens if all numbers in the array are negative?
The mathematical logic still holds. 
- `nums[n-1] * nums[n-2] * nums[n-3]` will yield the product of the three least negative numbers (e.g., `[-5, -4, -3, -2, -1]` $\rightarrow -3 \times -2 \times -1 = -6$).
- `nums[0] * nums[1] * nums[n-1]` will produce a more negative number (e.g., `-5 \times -4 \times -1 = -20$).
- `Math.max(-6, -20)` correctly picks `-6`.