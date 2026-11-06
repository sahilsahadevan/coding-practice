# Number exercises

## Summary

`NumberManipulation` explores decimal digit arithmetic and numeric formatting. Its methods cover powers, digit sums and counts, place-value floors, Armstrong numbers, searching below a value while excluding a digit, numeric text input, trigonometric values, decimal splitting, reverse-and-add palindromes, and Roman numerals.

## Digit arithmetic

- `getPowersOfNum` multiplies an accumulator by the input a requested number of times. A zero or negative exponent returns `1`; negative exponents are not represented as fractions.
- `getSumOfDigits` repeatedly extracts the last decimal digit with remainder and removes it with integer division. It only loops while the value is positive, so zero and negative values return zero.
- `getNumberOfDigits` grows a power-of-ten base until it reaches the input. It counts positive magnitudes as intended for positive inputs, but zero returns one and negative inputs also return one. Large values risk integer overflow in `base * 10`.
- `getFloorOfNumber` performs the same power-of-ten growth and returns the greatest decimal place not exceeding a positive input. For zero or negative input it returns one.
- The two Armstrong checks raise each digit to the number of decimal digits, sum the powers, then compare the sum to the original. One computes powers with multiplication; the other uses `Math.pow`. Both are framed around nonnegative input and use `int` conversion/arithmetic that can overflow for larger values.

## Excluding a digit

The `getNextLargestNumberWithoutGivenDigit...` methods seek the largest positive integer below or equal to the input that omits a requested digit. The recursive and logical versions inspect decimal positions and subtract a suffix/prefix adjustment; the brute-force version checks candidates downward one by one. Their intended example is a value like 145 with the digit 4 excluded, yielding 139.

These methods are not interchangeable general-purpose validators: their loops and decimal-place calculations assume positive inputs and a sensible single digit. The second logical version mutates `input` in one place while comparing `result` elsewhere. `test` is a small helper returning the last index of the digit text in the number text; it is not part of the search algorithm.

## Parsing, trigonometry, and fractions

- `isNumber` prompts for one token, removes commas, and attempts `Double.parseDouble`; `isNumberUsingUtils` uses Apache Commons `NumberUtils.isParsable`. Both consume console input directly. The `hasNext("")` check in `isNumber` does not reliably express “the token is empty” after `next()` has already read a token.
- `printTrigonometricValues` passes the integer directly to `Math.sin`, `cos`, and `tan`, which interpret input in radians. The derived reciprocal labels are swapped in the code: `sec` is calculated as `1/sine`, while `cosec` is `1/cosine`. Division near zero can produce very large values or infinities.
- `getPositive` negates negative integers; the minimum `int` cannot be represented as a positive `int`, so that extreme remains negative due to overflow.
- `splitDecimalsInDouble` stores the integer portion and a two-digit-scaled fractional portion in a map. Floating-point precision and negative-value truncation can make this surprising. `splitBDecimalsInBigDecimal` separates the integer portion from the exact remainder represented by the input `BigDecimal`.

## Reverse-and-add and Roman numerals

- `getReverse` builds a decimal reversal by repeatedly moving the last digit into a growing result. It only handles positive values and has no overflow checks.
- The recursive and iterative palindrome methods add a number to its reversal until the sum equals its own reversal. They stop early for zero; negative values are outside the loop's intended model. The recursive version can exhaust the call stack or overflow if no practical limit is reached.
- `convertToRomanNumerals` splits a positive input by decimal place, then maps each place's value to Roman chunks. `convertToRomanNumeralsUsingTreeMapAndRecursive` repeatedly takes the greatest supported Roman value not exceeding the remainder. Both mapping tables stop at 1000, and neither defines validation for zero, negatives, or values above the conventional Roman range.

## Sources

- `src/main/java/<base-package>/number_manipulation/NumberManipulation.java`
- Selected methods are exercised by `src/test/java/<base-package>/number_manipulation/NumberManipulationTest.java`.

## Related pages

- [[number-base-conversions]]
- [[arrays-and-matrices]]

## Open questions

- The source does not establish supported input ranges or overflow policy for these integer algorithms.
- The source does not define whether trigonometric inputs should be degrees or radians; Java's API behavior is radians.
