<h2><a href="https://leetcode.com/problems/stone-game">877. Stone Game</a></h2>

<p>Alice and Bob play a game with piles of stones. There are an <strong>even</strong> number of piles arranged in a row, and each pile has a <strong>positive</strong> integer number of stones <code>piles[i]</code>.</p>

<p>The objective of the game is to end with the most stones. The <strong>total</strong> number of stones across all the piles is <strong>odd</strong>, so there are no ties.</p>

<p>Alice and Bob take turns, with <strong>Alice starting first</strong>. Each turn, a player takes the entire pile of stones either from the <strong>beginning</strong> or from the <strong>end</strong> of the row. This continues until there are no more piles left, at which point the person with the <strong>most stones wins</strong>.</p>

<p>Assuming Alice and Bob play optimally, return <code>true</code><em> if Alice wins the game, or </em><code>false</code><em> if Bob wins</em>.</p>

<p>&nbsp;</p>
<p><strong class="example">Example 1:</strong></p>

<pre><strong>Input:</strong> piles = [5,3,4,5]
<strong>Output:</strong> true
<strong>Explanation:</strong> 
Alice starts first, and can only take the first 5 or the last 5.
Say she takes the first 5, so that the row becomes [3, 4, 5].
If Bob takes 3, then the board is [4, 5], and Alice takes 5 to win with 10 points.
If Bob takes the last 5, then the board is [3, 4], and Alice takes 4 to win with 9 points.
This demonstrated that taking the first 5 was a winning move for Alice, so we return true.
</pre>

<p><strong class="example">Example 2:</strong></p>

<pre><strong>Input:</strong> piles = [3,7,2,3]
<strong>Output:</strong> true
</pre>

<p>&nbsp;</p>
<p><strong>Constraints:</strong></p>

<ul>
	<li><code>2 &lt;= piles.length &lt;= 500</code></li>
	<li><code>piles.length</code> is <strong>even</strong>.</li>
	<li><code>1 &lt;= piles[i] &lt;= 500</code></li>
	<li><code>sum(piles[i])</code> is <strong>odd</strong>.</li>
</ul>


---

# 🛍️ Stone-Game | Explained

## Approach 1: Greedy Sorting and Alternating Allocation

### Intuition
The core idea behind this approach treats the stone piles as a static set of values rather than a constrained sequence where players can only pick from the boundaries ( ends) of the array. 

Imagine a auction room where all stone piles are placed on a table and sorted by value from smallest to largest. Instead of taking turns picking from the left or right ends of a line, Alice greedily claims the absolute highest value remaining on the table. Bob then claims the second highest value, Alice claims the third, and so on. Since Alice picks first and the total number of piles is even, Alice is guaranteed to get the 1st, 3rd, 5th, ... largest piles overall. 

### Algorithm Visualized
```mermaid
graph TD
    Start[Input: piles array] --> Sort[Arrays.sort piles]
    Sort --> Init[Initialize score accumulators: a = 0, b = 0]
    Init --> LoopStart[Loop i from piles.length down to 1]
    LoopStart --> CheckEven{Is i % 2 == 0?}
    CheckEven -- Yes --> AliceScore[a = a + piles[i-1]<br/>Alice gets pile]
    CheckEven -- No --> BobScore[b = b + piles[i-1]<br/>Bob gets pile]
    AliceScore --> Decrement[i--]
    BobScore --> Decrement
    Decrement --> Condition{Is i > 0?}
    Condition -- Yes --> LoopStart
    Condition -- No --> Compare{Is a > b?}
    Compare -- Yes --> ReturnTrue[Return true]
    Compare -- No --> ReturnFalse[Return false]
```

### Approach
1. **Sort the Array:** Sort `piles` in ascending order using Java's built-in `Arrays.sort()` algorithm.
2. **Initialize Accumulators:** Maintain two integer variables, `a` (Alice's total score) and `b` (Bob's total score), both initialized to `0`.
3. **Iterate Backwards:** Loop starting from `i = piles.length` down to `i = 1` (1-based index simulation) to process elements from largest to smallest.
4. **Distribute Piles Alternately:**
   - If `i` is even (`i % 2 == 0`), the element at index `i - 1` is added to Alice's accumulator (`a`).
   - If `i` is odd (`i % 2 != 0`), the element at index `i - 1` is added to Bob's accumulator (`b`).
5. **Evaluate Winner:** Compare `a` and `b`. If `a > b`, return `true`; otherwise, return `false`.

### Detailed Code Analysis

```java
1class Solution {
2    public boolean stoneGame(int[] piles) {
```
- **Line 1-2:** Class declaration and method definition `stoneGame` taking an integer array `piles` and returning a `boolean`.

```java
3        Arrays.sort(piles);
```
- **Line 3:** `Arrays.sort(piles)` sorts the array in-place in ascending order (Dual-Pivot Quicksort for primitives). The largest elements are moved to the end of the array (e.g., indices `N-1`, `N-2`, etc.).

```java
4        int a=0;
5        int b=0;
```
- **Lines 4-5:** Primitive integer variables `a` and `b` are declared to keep track of Alice's and Bob's running sum of stones, respectively.

```java
6        for(int i=piles.length;i>0;i--)
7        {
```
- **Lines 6-7:** A `for` loop iterates backwards. `i` represents a 1-based index starting at `piles.length` and terminating after `i = 1`. Iterating backwards allows access to elements from largest value to smallest value (`piles[i-1]`).

```java
8           if(i%2==0)
9           {
10            a=a+piles[i-1];
11           }
```
- **Lines 8-11:** `i % 2 == 0` checks if the current 1-based index is even. Since `piles.length` is guaranteed to be even by problem constraints, the first iteration (`i = piles.length`) will always be even, assigning the largest element `piles[i-1]` to Alice (`a`).

```java
12           else
13           {
14            b=b+piles[i-1];
15           }
16        }
```
- **Lines 12-16:** If `i` is odd, the current largest remaining element `piles[i-1]` is assigned to Bob (`b`).

```java
17        if(a>b)return true;
18        else return false;
19        
20    }
21}
```
- **Lines 17-18:** Evaluates whether Alice's accumulated stones `a` strictly exceed Bob's accumulated stones `b`. Returns `true` if Alice wins, otherwise `false`. (Note: This logic can be simplified cleanly to `return a > b;`).

### Code
```java
class Solution {
    public boolean stoneGame(int[] piles) {
        Arrays.sort(piles);
        int a=0;
        int b=0;
        for(int i=piles.length;i>0;i--)
        {
           if(i%2==0)
           {
            a=a+piles[i-1];
           }
           else
           {
            b=b+piles[i-1];
           }
        }
        if(a>b)return true;
        else return false;
        
    }
}
```

### Complexity
- **Time Complexity:** $\mathcal{O}(N \log N)$
  - Sorting the array of size $N$ takes $\mathcal{O}(N \log N)$ time using Dual-Pivot Quicksort.
  - The single `for` loop runs $N$ times, performing $\mathcal{O}(1)$ operations per iteration, resulting in $\mathcal{O}(N)$ loop execution time.
  - Total Time Complexity: $\mathcal{O}(N \log N + N) = \mathcal{O}(N \log N)$.

- **Space Complexity:** $\mathcal{O}(\log N)$
  - The space complexity is governed by Java's `Arrays.sort()` implementation for primitive types (`int[]`), which uses a Dual-Pivot Quicksort requiring $\mathcal{O}(\log N)$ stack space for recursion. No additional dynamic data structures are allocated.

---

## 🕵️‍♂️ Follow-up Questions

### 1. Does this greedy sorting approach follow the official rules of the Stone Game?
**Answer:** Technically, no. The problem constraints state that players can **only pick stones from either the beginning or the end** of the array (`piles[0]` or `piles[n-1]`). Sorting the array relaxes this constraint and allows picking arbitrary elements from anywhere in the array. 

However, because the problem guarantees that the total number of piles $N$ is even, the sum of all stones is odd (preventing ties), and Alice plays optimally, **Alice is mathematically guaranteed to win every single game**. Thus, returning `true` for any valid input is mathematically correct.

### 2. How would you solve this problem using standard Game Theory / Dynamic Programming if boundary pick rules were strictly enforced?
**Answer:** If boundary constraints must be modeled, we use Dynamic Programming (or Minimax with memoization). Define `dp[i][j]` as the maximum relative score advantage (Alice's score minus Bob's score) possible for the current player from the subarray `piles[i...j]`.

- **State Transition:** `dp[i][j] = max(piles[i] - dp[i+1][j], piles[j] - dp[i][j-1])`
- **Base Case:** `dp[i][i] = piles[i]`
- If `dp[0][N-1] > 0`, Alice wins. This yields an $\mathcal{O}(N^2)$ time and space Dynamic Programming solution.