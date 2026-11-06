# Number base conversions

## Summary

`NumberBaseManipulation` demonstrates recognizing binary-looking decimal text and converting decimal integers to binary, octal, and hexadecimal strings using repeated division. The reverse-direction methods currently return their integer argument as text; they do not perform a conversion.

## Binary recognition and integer conversion

- `isBinary` turns the `long` into decimal digits and accepts the value only when every character is `0` or `1`. This checks the written digits, not whether the value fits a particular binary width. Since a `long` cannot preserve leading zeroes, those are naturally absent.
- `getBinaryIntFromDecimalUsingSimpleMath` repeatedly records remainder modulo two, divides by two, then reverses the collected digits. Negative input is first treated by magnitude, followed by appending `1` characters until the buffer reaches length 32. This is a custom negative representation and is not Java's standard two's-complement bit string; the method also misses the zero case, returning an empty string.

## Fractional binary conversion

`getBinaryDoubleFromDecimalUsingSimpleMath` handles the integer portion by repeated division and approximates the fractional portion by multiplying it by two up to three times. It converts the fractional part through a scale of three decimal places, so the result is deliberately limited and subject to floating-point quirks. A special check for exactly `0.1` returns before appending a fractional suffix. Negative handling is based on `intValue() < -1`, leaving values between -1 and 0 on a different path from other negatives. Treat this as an algorithm demonstration, not a general IEEE-754 converter.

## Octal and hexadecimal

- `getOctalFromDecimal` follows the same repeated-remainder method with base eight. It converts negative values by magnitude, does not include a sign, and returns an empty string for zero.
- `getHexadecimalFromDecimal` uses base sixteen remainders and a digit chart for `0` through `f`. It also converts a negative value by magnitude and has the same zero behavior.
- `getDecimalFromBinary` and `getDecimalFromOctal` simply stringify the integer passed in. They do not interpret the digits as binary or octal, so a value such as `1010` remains the text `1010` instead of becoming decimal ten.
- Comments list binary, octal, and hexadecimal arithmetic topics, but no corresponding implementations are present in this class.

## Sources

- `src/main/java/<base-package>/number_manipulation/NumberBaseManipulation.java`
- Selected examples are exercised by `src/test/java/<base-package>/number_manipulation/NumberBaseManipulationTest.java`.

## Related pages

- [[number-exercises]]

## Open questions

- The source does not specify whether conversions should follow signed numeric values, unsigned magnitudes, or fixed-width bit representations.
- The source does not define supported precision for fractional binary output.
