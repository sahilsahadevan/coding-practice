You are turning a raw input document into a wiki entry.

The wiki entry will live at: wiki/<kebab-case-filename>.md.

The wiki entry MUST:
- Open with a single H1 stating the canonical subject.
- Include a frontmatter block with: type, source-path, ingested-at.
- Use one fact per line where facts can be enumerated.
- Use explicit named anchors (account names, concept names) not metaphors.
- End with a "Open questions" section that lists what the source does not answer.

DO NOT:
- Copy raw quotes longer than 2 sentences from the source.
- Use first-person voice; the wiki is the agent's notes, not the human's.
- Invent facts not in the source.

Source path: <RAW_PATH>
Source type: <prospect-transcript | paper-abstract | ticket-archive | pr-description | personal-note>