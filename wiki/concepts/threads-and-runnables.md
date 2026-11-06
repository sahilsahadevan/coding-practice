# Threads and runnables

## Summary

The concurrency package contrasts two ways to describe work that can run on a Java thread: implement `Runnable`, as `RunnableDemo` does, or subclass `Thread`, as `ThreadManipulation` does. Both examples log thread names and daemon state, sleep, then report completion.

## `RunnableDemo`

`RunnableDemo` is a task object, not itself a thread. A caller would normally pass an instance to a `Thread` and start that thread; calling `run()` directly would execute on the current thread. Its no-argument constructor does nothing beyond the implicit superclass construction. The string constructor changes the *current thread's* name during object construction, rather than storing the supplied name for a future worker. If constructed on the main thread, it renames the main thread; this likely differs from the constructor's apparent intent.

The `run` method repeats twice. Each pass logs the current thread's name and daemon flag, prints a running line, then sleeps for two seconds. After the loop it prints completion. If interrupted, it prints a stack trace and continues to the next loop step without restoring the interrupt flag or stopping the task.

## `ThreadManipulation`

`ThreadManipulation` is itself a `Thread`. Its named constructor calls `setName`, so the new Thread object receives the name. Its `run` method logs the name and daemon status, sleeps once for five seconds, logs awakening, then logs the running-state message. The `catch` block prints the exception but does not restore the interrupted flag.

## What the examples teach—and omit

Both classes make thread activity visible through logs and console output, but neither configures daemon status, coordinates with another thread, shares mutable data, or demonstrates `join`. `Thread.sleep` pauses the current worker; it does not guarantee precise scheduling. A caller must use `start()` to create concurrent execution. The source does not show a production task lifecycle or cancellation policy.

## Sources

- `src/main/java/<base-package>/concurrency/RunnableDemo.java`
- `src/main/java/<base-package>/concurrency/ThreadManipulation.java`
- Selected behavior is exercised by concurrency tests in `src/test/java/<base-package>/concurrency/`.

## Related pages

- [[project-map]]

## Open questions

- The source does not establish the intended caller or the order in which these workers should be started.
- The source does not define whether interruption should end the task or be propagated.
