# String exercises

## Summary

`StringManipulation` is a collection of independent demonstrations: reversing text in several ways, preserving spaces while reversing letters, removing literal spaces, counting repeated characters, testing anagrams, measuring character proportions, and observing Java string immutability.

## Reversal strategies

- `reverseUsingRecursive1` removes the first character, reverses the remaining suffix, then appends the removed character. Its base case returns `null`, empty, or one-character input unchanged.
- `reverseUsingRecursive2` takes the final character first and recursively processes the prefix. It reaches the same conceptual result by peeling from the opposite end.
- Both recursive versions allocate substrings and create one call frame per character; they are useful for illustrating recursion, not for large input.
- `reverseUsingLoopIteration1` copies characters from the end of a char array into a new array. It lowercases the result, so it is not case-preserving.
- `reverseUsingLoopIteration2` repeatedly inserts each character at index zero of a `StringBuilder`. Earlier characters shift on each insertion, making this needlessly costly compared with appending backward or calling `reverse()`.
- `reverseUsingStringBuilder` delegates reversal to `StringBuilder.reverse()` and retains letter case.
- `reverseWhilePreservingSpace` first reserves each original space position, then fills remaining positions with non-space characters encountered from left to right. The visible letters are reversed while spaces remain anchored.

## Whitespace, duplicates, and anagrams

- `removeAllWhiteSpaceUsingLoopIterations` skips only the ordinary space character and writes retained characters into a same-sized char array. Unfilled array cells become NUL characters, so the printed string can contain invisible trailing characters. It also prints instead of returning a value.
- `removeAllWhiteSpaceUsingRegex` returns no value either; when non-null, it prints the result of removing ordinary spaces with `replaceAll(" ", "")`. Tabs and other whitespace remain.
- `findAndCountDuplicateChars` uppercases input, ignores ordinary spaces, counts characters in a `HashMap`, and logs only counts greater than one. Uppercasing behavior depends on Java's Unicode case conversion.
- Both anagram methods remove ordinary spaces and lowercase before comparing. One sorts character arrays; the other builds sorted frequency maps. Punctuation is retained, and null is not handled.
- In the frequency-map version, only keys from the first string are compared, but equal lengths plus matching first-string frequencies imply the same frequency multiset for the second string.

## Character proportions and immutability

- `measureCharsInString` classifies every UTF-16 `char` as digit, uppercase letter, lowercase letter, or other. Spaces fall into “other.” It stores the total length with scale two, meaning the denominator is length divided by 100; dividing an integer category count by that value yields a percentage. The result is rounded to two decimal places.
- Empty input makes the denominator zero; the method has no guard for that case.
- `checkIfImmutable` calls `concat` and discards the returned string. Since `String` is immutable, the original reference keeps its length and the method returns true. The method demonstrates immutability, although the result would also be true simply because the returned concatenation was ignored.

## Sources

- `src/main/java/<base-package>/string_manipulation/StringManipulation.java`
- Selected examples are exercised in `src/test/java/<base-package>/string_manipulation/StringManipulationTest.java`.

## Related pages

- [[pyramid-patterns]]
- [[project-map]]

## Open questions

- The source does not define whether “whitespace” should include tabs, newlines, or all Unicode whitespace.
- The source does not specify how null inputs should be handled for most methods.
