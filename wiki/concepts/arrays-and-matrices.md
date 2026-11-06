# Arrays and matrices

## Summary

`ArrayManipulation` combines array comparisons, duplicate detection, order statistics, matrix operations, pair and subarray searches, list deduplication, intersections, stable-looking rearrangements, leaders, a missing-number search, and nested-array formatting. Several methods are useful algorithm sketches but have important preconditions and implementation defects.

## Comparing and inspecting arrays

- “Weak” comparison means same entries regardless of order; “exact” comparison means same entries in the same positions.
- `weakCompareArraysUsingIteration` checks equal, nonempty lengths, then compares each item against every item in the second array. It does not consume a matched item, so duplicates can be counted repeatedly. In case-sensitive mode it uses `==` for strings (reference identity), not `String.equals`, so equal text in different objects may fail. The insensitive path uses `equalsIgnoreCase`.
- `weakCompareArraysUsingUtil` sorts both input arrays in place and then calls `Arrays.equals`. It is case-sensitive and mutates caller-owned arrays.
- `exactCompareArraysUsingIteration` checks position by position and supports case sensitivity, but rejects empty arrays and assumes non-null elements. `exactCompareArraysUsingUtil` delegates directly to `Arrays.equals`, which permits null arrays and treats two null arrays as equal.
- `findDuplicatesFromArrays` uppercases each value and records repeats in sets, making detection case-insensitive. Null input or null elements cause failures; output order is unspecified.

## Order statistics

- `getSecondLargestNumberUsingUtils` sorts the input array in place and returns the penultimate element. It means second position from the end, not necessarily the second distinct value; arrays of length two return the first element. Empty or one-item arrays return -1.
- `getSecondLargestNumberUsingIteration` scans once, tracking largest and second largest, but initializes both to zero. That makes all-negative arrays incorrect and can return zero when no zero exists.
- The nth smallest/largest methods insert values into a `TreeSet`, which sorts and removes duplicates. Their rank is therefore among distinct values. They reject empty input and `n > input.length`, but do not reject `n <= 0` or `n > number of distinct values`; these cases can produce indexing errors or null unboxing failures.

## Matrix routines

- `printMatrixValues`, `addMatrix`, `subtractMatrix`, `multiplyMatrix`, and `getTranspose` read the column count from row index 1. A matrix with fewer than two rows fails before useful work; ragged rows are not validated.
- Addition and subtraction require matching dimensions and return an empty `0 x 0` array when they do not match.
- Multiplication checks that the first matrix's column count matches the second's row count and allocates a result with one row per first-matrix row and one column per second-matrix column. Inside the innermost loop, however, it assigns each individual product to `value` rather than adding it. The returned cell is only the final product in the dot product, not the sum of products.
- Transpose allocates swapped dimensions and copies `[row][column]` into `[column][row]`; it explicitly handles null or zero-row input, but the one-row case still fails when looking up row 1.

## Searches and transformations

- `getSumPairOfGivenNumber` checks all distinct index pairs and writes matches into an array preallocated to half the input length. If there are more matches, it can overrun the result; if fewer, trailing `[0, 0]` cells remain.
- `getSubArraySumPairOfGivenNumber` starts at each index, grows a contiguous sum, and records the first matching slice for each start. It assumes the input makes this increasing-window search useful; with negative numbers, a sum can pass the target and later return to it, but the inner loop does not stop only for monotonicity—it continues until equality or end. It does not return multiple matching slices from one start after the first match.
- `removeDuplicatesFromList1` clears and repopulates the caller's list from a `HashSet`, losing order. `removeDuplicatesFromList2` returns a new list backed by `LinkedHashSet` ordering, preserving first-seen order without mutating the input.
- The utility intersection uses case-sensitive `contains` checks and can return repeated matches when the second array repeats a value. The iteration version compares ignoring case and can emit duplicates from either side's repeated values.
- The zero and X movers allocate new arrays and partition values into the requested side. Zero-moving methods keep nonzero values in encounter order when moving zeros last; moving zeros first writes nonzero values backward, reversing their order. X movers preserve the relative order within each partition.
- `getLeaderNumbers` only compares each value with its immediate neighbor, rather than with every value to its right. It can therefore include a value that is followed later by a larger value. The rightmost value is always included.
- `findMissingNum` checks candidates from 1 through `input.length`, although the comment describes a range of 1 through n for an array of length n-1. It can miss the true upper-bound value and is quadratic. `convertTheseMultiDArraysToString` contrasts default array identity text, shallow `Arrays.toString`, and recursive `Arrays.deepToString` output.

## Sources

- `src/main/java/<base-package>/data_structures_and_algorithms/ArrayManipulation.java`
- Selected behavior is exercised by `src/test/java/<base-package>/data_structures_and_algorithms/ArrayManipulationTest.java`.

## Related pages

- [[sorting-and-collections]]
- [[number-exercises]]

## Open questions

- The source does not define a consistent policy for nulls, empty arrays, duplicates, or invalid ranks.
- The intended semantics of “second largest,” “leader,” and array intersection are not fully specified beyond comments and tests.
