# Test suite map

## Summary

The JUnit 5 tests under `src/test/java/` are a mixture of assertions for algorithm examples and demonstrations that print or log behavior. Several test methods do not assert an expected result, so passing the test run does not prove every printed result or edge case is correct.

## Coverage by topic

- `string_manipulation/StringManipulationTest.java` exercises reversal variants, space-preserving reversal, whitespace removal, duplicate counts, anagrams, character measurement, and immutability.
- `string_manipulation/PrintPyramidsTest.java` supplies small values through replacement `System.in` streams and invokes selected upright and mirrored patterns. It does not call every pattern variant.
- `number_manipulation/NumberManipulationTest.java` exercises powers, digit methods, Armstrong checks, excluded-digit search, console parsing, trigonometry, decimal splitting, reverse-and-add, and Roman conversion.
- `number_manipulation/NumberBaseManipulationTest.java` covers binary recognition and selected decimal-to-binary, decimal-to-octal, and decimal-to-hex examples. Its “decimal from binary” test currently reflects the source method's stringify-only behavior.
- `data_structures_and_algorithms/ArrayManipulationTest.java` covers comparisons, duplicates, ranks, matrix operations, pair/subarray search, list deduplication, intersections, X movement, leaders, missing values, and nested-array formatting.
- `data_structures_and_algorithms/SortingTest.java` checks selection sort.
- `concurrency/RunnableDemoTest.java` starts three threads that share one `RunnableDemo` instance. The task has no shared mutable state, so each thread prints its own two-pass sequence.
- `concurrency/ThreadManipulationTest.java` demonstrates thread start, liveness polling, `join`, and daemon configuration. These examples sleep in real time; one method starts a final worker without joining it.
- `io_and_misc/MiscTest.java` contains a call to the process-launch demonstration, but the call is commented out.
- `VerifyShellTest.java` logs numeric literal examples rather than asserting them.

## Reading test results carefully

The test sources are useful as examples of intended inputs and expected outcomes where assertions are present. Output-only methods should be read alongside their implementation. Tests that replace `System.in`, start OS processes, or sleep are interactive or environment-sensitive and should not be treated as pure unit tests. No tests were run while preparing this guide.

## Sources

- `src/test/java/<base-package>/` (the test tree)
- Corresponding production behavior is described in [[project-map]] and the topic pages linked there.

## Related pages

- [[project-map]]
- [[console-input-and-application-startup]]
- [[threads-and-runnables]]

## Open questions

- The source does not state which printed demonstrations are considered verified outputs versus exploratory examples.
- The source does not establish whether process-launch and long-running thread examples should remain in the default test suite.
