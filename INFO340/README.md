Definitions
-----------
__System catalog__ (or __data dictionary__, or __metadata__) - Description of the data

__Data abstraction__ - Users of an object see only the external definition and are unaware of how the object is defined and how it functions.

__Entity__ - A distinct object. In ERD, the object encapsulates both state and behavior

__Attribute__ - A named column of a relation. A property that describes some aspect of the object (columns). Each tuple (row) contains one value per attribute.

__Relationship__ - An association between entities. Each relation has a name and is made up of named attributes of data.

__Relation__ - A 2-dimensional table with columns and rows. Elements of a relation are the tuples in the table.

__Domain__ - The set of allowable values for one or more attributes.

__Degree__ - The number of attributes a relation contains.

__Cardinality__ - The number of tuples a relation contains.

[ERD Example 1]: /img/erd-example-1.png

Example Entity–Relationship diagram: ![ERD Example 1](/images/erd-example-1.png "Example Entity–Relationship diagram")

The relational data model requires only thtat the database be perceived by the user as tables. 

Perceive the logical structure of relational databases as tables.

| Formal terms | Alternative 1 | Alternative 2 |
|--------------|---------------|---------------|
| Relation     | Table         | File          |
| Tuple        | Row           | Record        |
| Attribute    | Column        | Field         |

Mathematical Relations
----------------------
The Cartesian product of two sets D<sub>1</sub>  and D<sub>2</sub>:

D<sub>1</sub> x D<sub>2</sub> = {(2,1),(2,3),(2,5),(4,1),(4,3),(4,5)}

Examples
--------

List all flats with a monthly rent greater than $400:

    SELECT *
    FROM PropertyForRent
    WHERE type = 'Flat' AND rent > 400


__Simple Table Query__

    SELECT *
    FROM [Person].[Person] P

_P is like a variable name for the table object_

