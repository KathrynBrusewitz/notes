Basics
===
    SELECT column, another_column, …
    FROM mytable
    WHERE condition(s)
    ORDER BY column ASC/DESC
    LIMIT num_limit OFFSET num_offset;

Number Operators
---
| Operator | Condition |
| --- | --- |
| `=`, `!=`, `<`, `<=`, `>`, `>=` | Standard numerical operators |
| `BETWEEN … AND …` | Number is within range of two values (inclusive) |
| `NOT BETWEEN … AND …` | Number is not within range of two values (inclusive) |
| `IN (…)` | Number exists in a list |
| `NOT IN (…)` | Number does not exist in a list |

String Operators
---
| Operator | Condition |
| --- | --- |
| `=` | Case sensitive exact string comparison |
| `!=` or `<>` | Case sensitive exact string inequality comparison |
| `LIKE` | Case insensitive exact string comparison |
| `NOT LIKE` |  Case insensitive exact string inequality comparison |
| `%` | Used anywhere in a string to match a sequence of zero or more characters (only with `LIKE` or `NOT LIKE`) |
| `_` | Used anywhere in a string to match a single character (only with `LIKE` or `NOT LIKE`) |
| `IN (...)` |  String exists in a list |
| `NOT IN (...)` |  String does not exist in a list |

Limiting results to a subset
---
`LIMIT`
:  Reduce the number of rows to return

`OFFSET`
: Specify where to begin counting the number rows from

Removing Duplicates
---
`DISTINCT`
:  Discard rows that have a duplicate column value

    SELECT DISTINCT column, another_column, …
    FROM mytable
    WHERE condition(s)

Since the `DISTINCT` keyword will blindly remove duplicate rows, you can discard duplicates based on specific columns using grouping and the `GROUP BY` clause.