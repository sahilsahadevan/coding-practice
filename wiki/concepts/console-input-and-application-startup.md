# Console input and application startup

## Summary

`CommonUtil` owns two small console prompts used by the pyramid examples. `CodingPracticeApplication` is a Spring Boot entry point and a `CommandLineRunner`; its runner starts one pyramid exercise once application startup completes.

## Shared input helpers

- `getSingleDigitNonZeroRowInputFromUser` creates a `Scanner` on `System.in`, prompts for a row count, and repeats while the value is zero or greater than nine. The prompt says 1 through 9, but negative numbers pass the condition. Non-integer input raises a scanner input exception because there is no parsing or recovery path.
- `getNonZeroDecrementalPyramidMaxNumberFromUser` likewise reads an integer and repeats only for zero. It accepts negative values and has no upper bound.
- Both methods create a new scanner without closing it. Closing a scanner on `System.in` would close the shared console stream, so the project needs a deliberate shared-input policy if more prompts are added.
- Each logs the calling method name by inspecting the current stack trace and logs the entered value.

## Spring Boot launch path

`main` calls `SpringApplication.run(CodingPracticeApplication.class, args)`. The `@SpringBootApplication` annotation marks configuration and component scanning. After startup, `CommandLineRunner.run` invokes the incremental one-value-per-row pyramid. That call blocks for terminal input through `CommonUtil`; running in a non-interactive environment may therefore fail or wait for input.

## Sources

- `src/main/java/<base-package>/util/CommonUtil.java`
- `src/main/java/<base-package>/CodingPracticeApplication.java`
- `src/main/java/<base-package>/string_manipulation/PrintPyramids.java`

## Related pages

- [[pyramid-patterns]]
- [[project-map]]

## Open questions

- The source does not state whether negative row counts should be rejected or how invalid text should be handled.
- The source does not describe a non-interactive startup mode.
