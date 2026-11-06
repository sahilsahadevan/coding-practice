# Project map

## Summary

This repository is a Spring Boot shell around a set of small Java practice exercises. The main classes are utility-style demonstrations: most methods can be understood independently, while the application runner currently launches one interactive pyramid exercise at startup.

## How the code is arranged

- `string_manipulation/` contains string transformations, character counting, and console pyramid printers.
- `number_manipulation/` contains arithmetic, digit, numeral, and radix exercises.
- `data_structures_and_algorithms/` contains array, matrix, collection, and sorting examples.
- `concurrency/` contrasts a `Runnable` task with a class extending `Thread`.
- `io_and_misc/` contains an operating-system process example.
- `util/CommonUtil.java` supplies console input shared by pyramid methods.
- `CodingPracticeApplication.java` is the Spring Boot entry point; `VerifyShell.java` is a temporary empty verification shell.

## Startup path

`main` delegates to `SpringApplication.run`, which creates the Spring application. After startup, Spring invokes `CommandLineRunner.run`. That method calls `PrintPyramids.printEquilateralNumberPyramidIncrementalOne`, which asks for a row count through `CommonUtil` and prints one row per loop pass. Thus the normal application launch is interactive and waits for console input; the other exercise methods are not automatically invoked by this runner.

## Reading the exercise classes

These classes are a learning notebook in executable form, not a uniform production library. Names and comments explain intended exercises, but some implementations contain edge-case limitations or mismatches. The topic pages below distinguish the apparent intent from the behavior visible in the method bodies.

## Related pages

- [[string-exercises]]
- [[number-exercises]]
- [[number-base-conversions]]
- [[arrays-and-matrices]]
- [[sorting-and-collections]]
- [[pyramid-patterns]]
- [[threads-and-runnables]]
- [[console-input-and-application-startup]]
- [[miscellaneous-and-empty-scaffolds]]
- [[test-suite-map]]

## Sources

- `src/main/java/<base-package>/CodingPracticeApplication.java`
- `src/main/java/<base-package>/VerifyShell.java`
- `src/main/java/<base-package>/{string_manipulation,number_manipulation,data_structures_and_algorithms,concurrency,io_and_misc,util}/`
- Test behavior is summarized in [[test-suite-map]]; coverage is selective and not every test asserts outcomes.

## Open questions

- The source does not state whether this project is intended to grow into a reusable library or remain a practice notebook.
- No behavior is established here for packaging or deployment beyond the Spring Boot launch path.
