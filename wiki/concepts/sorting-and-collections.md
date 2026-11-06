# Sorting and collections

## Summary

`Sorting` implements ascending and descending selection sort. `CollectionsManipulation` currently has no methods or behavior; related list operations are instead implemented inside `ArrayManipulation`.

## Selection sort, one pass at a time

Selection sort divides the array into a finished prefix and an unsorted suffix. On each pass, it scans the suffix for the smallest value (ascending) or largest value (descending), then swaps that candidate into the first unsorted slot. After each pass, the finished prefix grows by one position.

Both methods mutate the supplied array and return the same array reference. They do not allocate a sorted copy. The nested scans give quadratic time, approximately n-squared comparisons for n elements; the algorithm uses constant extra storage and is not stable in the general sense because a distant swap can change equal values' order.

## Collection examples elsewhere

The collection-specific exercises are in `ArrayManipulation`: one deduplication method clears and refills the input list using `HashSet`, while another returns a new list based on `LinkedHashSet` and retains first-seen order. These explain the practical distinction between an unordered set and an insertion-ordered set.

## Sources

- `src/main/java/<base-package>/data_structures_and_algorithms/Sorting.java`
- `src/main/java/<base-package>/data_structures_and_algorithms/CollectionsManipulation.java`
- Related methods: `src/main/java/<base-package>/data_structures_and_algorithms/ArrayManipulation.java`
- Sorting examples are exercised in `src/test/java/<base-package>/data_structures_and_algorithms/SortingTest.java`.

## Related pages

- [[arrays-and-matrices]]
- [[project-map]]

## Open questions

- The empty `CollectionsManipulation` class does not establish which collection exercises are planned for it.
