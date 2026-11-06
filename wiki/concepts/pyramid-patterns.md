# Pyramid patterns

## Summary

`PrintPyramids` prints upright and inverted star or number patterns. The common design uses nested loops: an outer loop chooses a row, one inner loop emits leading spaces, and one or two inner loops emit the row's values. The row number, displayed sequence, and global counter vary by method.

## How the loops shape a row

For upright patterns, the outer loop counts down from the requested row count while a separate `rowCount` rises from one. The descending loop controls indentation; the rising value controls how many entries are printed. That split lets the code shift the pattern toward the center while the content grows downward.

- `printEquilateralStarPatternPyramid` emits a growing number of `* ` cells per row.
- `printEquilateralNumberPyramidIncrementalOne` repeats the row number across its row; `...DecrementalOne` repeats a descending row value.
- `...IncrementalTwo` prints `1` through the current row length; `...DecrementalTwo` prints down from the requested maximum.
- `...IncrementalThree` prints each row's sequence in reverse; `...DecrementalThree` starts each row at its row-dependent value and increases.
- The mirrored methods print an ascending or descending run, then a second run back toward the center. They use two leading spaces per indentation step to align the wider number cells.
- The `IncrementalFour`/`DecrementalFour` methods maintain one counter across rows and complete the final row even if that carries past the input boundary. The corresponding `Five` methods stop at the boundary and leave the last row incomplete.
- The reversed methods count the number of entries down as rows progress, shifting each row inward. Mirrored reversed variants build a peak by combining a forward half and a backward half.

## Input and execution

Most methods call `CommonUtil.getSingleDigitNonZeroRowInputFromUser`, so they expect an interactive integer from 1 to 9 (the code rejects zero and values above nine, but does not reject negative values). Decremental counter patterns use a different helper that rejects only zero, so large and negative values are accepted by the input loop even though the pattern logic may behave unexpectedly.

`CodingPracticeApplication.run` currently invokes just `printEquilateralNumberPyramidIncrementalOne`. The application therefore pauses for console input after Spring starts. Tests also redirect or provide input for selected pyramid methods; this page describes source behavior rather than claiming every pattern has been validated for every value.

## Sources

- `src/main/java/<base-package>/string_manipulation/PrintPyramids.java`
- `src/main/java/<base-package>/util/CommonUtil.java`
- `src/main/java/<base-package>/CodingPracticeApplication.java`
- Selected interactive examples are in `src/test/java/<base-package>/string_manipulation/PrintPyramidsTest.java`.

## Related pages

- [[console-input-and-application-startup]]
- [[string-exercises]]

## Open questions

- The source does not define desired formatting for multi-digit row values or terminal widths.
- The source does not establish whether all 20 pattern methods are intended to remain independently callable.
