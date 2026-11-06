# LLM Wiki approach used for this code guide

## Summary

This source note records the structure used for the Java code guide: plain Markdown pages grouped by topic, concise summaries, explicit source links, related-page links, and clear notes where an implementation is incomplete or surprising. This follows the general LLM-Wiki idea of compiling source material into a connected, inspectable knowledge base that can be read in Obsidian and by an LLM.

## Source claims

- MindStudio describes an LLM wiki as a set of structured Markdown files that an agent can read and query, with summaries and consistent structure helping navigation.
- The Towards AI article compares an agent-instructions approach with a programmatic pipeline, describing a small Markdown wiki as flexible while larger recurring corpora can benefit from more deterministic infrastructure.
- The Medium article by Aristo Jeff could not be retrieved during this review, so no claim is attributed to it here.

## Applied editorial choices

- Pages are divided by code topic rather than combining the whole repository into one long document.
- Each page starts with a one-paragraph summary and separates algorithm intent from behavior visible in the source.
- Source paths redact the package segment that may contain a personal identifier. The final directory and filename remain, so the matching Java file is still easy to locate.
- No source examples containing personal names, credentials, or other identifying values are repeated in the generated explanations.
- Internal links use Obsidian wikilinks to make graph navigation convenient.

## Sources

- [MindStudio: What Is Andrej Karpathy's LLM Wiki?](https://www.mindstudio.ai/blog/andrej-karpathy-llm-wiki-knowledge-base-claude-code)
- [Aristo Jeff: What Is an LLM Wiki and Why Are People Paying Attention to It?](https://medium.com/@aristojeff/what-is-an-llm-wiki-and-why-are-people-paying-attention-to-it-b7e10617967d) — unavailable to retrieve during review.
- [Towards AI: I Built Karpathy’s LLM Wiki Twice](https://pub.towardsai.net/i-built-karpathys-llm-wiki-twice-once-as-code-once-as-a-md-heres-what-each-one-gives-up-08b31170999a)

## Related pages

- [[project-map]]

## Open questions

- The inaccessible Medium article may contain additional ideas that are not reflected in this note.
- The project owner may prefer YAML frontmatter or a different source-reference convention for future pages.
