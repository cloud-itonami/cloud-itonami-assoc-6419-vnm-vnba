# ADR 0001: Kotoba is the VNBA catalog source authority

- Status: Accepted
- Date: 2026-07-21

`src/association_facts.kotoba` is the sole production source. It preserves the
official complete 1994-05-14 approval and 1995-09-29 ASEAN admission dates,
keeps both revision dates absent, and does not invent a third catalog entry from
the separately documented 1994-08-23 launch. Both entries retain governance
topics and the official VNBA citation. Unknown associations, aliases, fields,
topics, and indexes fail closed; no effects are declared.

Conformance is observable semantics across the reference evaluator, restricted
JavaScript, and instantiated typed WebAssembly, including the typed ABI, bounds,
effects, and rejection behavior. Compiler-output byte identity is not a language
gate. Clojure and the JVM are compiler/test hosts only.
