# Local LLM Wiki

This workspace keeps original material separate from generated wiki pages.

## Folders

- notes/, raw/, src/, target/, assets/ - basically any file/folder not under wiki/ :These are original/raw notes, references, and attachments; keep these unchanged.
- wiki/sources/: generated summaries of source files.
- wiki/concepts/: generated topic and concept pages.
- wiki/questions/: saved answers, only when requested.
- wiki/index.md: catalog of generated pages.
- wiki/log.md: append-only record of wiki operations.

## Using the wiki

- To ingest a source, ask to ingest a specific file. Its summary and supported concepts will be added to the wiki, with links in the index and an entry in the log.
- To ask a question, ask about the wiki. Answers use the index and relevant sources; they are not saved unless you request it.
- To request maintenance, ask to check the wiki. The check covers links, citations, duplicate concepts, and contradictions; findings are reported before any deletion or merge.

See [AGENTS.md](AGENTS.md) for the full rules and workflows.
