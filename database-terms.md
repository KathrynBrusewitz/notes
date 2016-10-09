Definitions
-----------

__Relational database__ - A collection of normalized relations with distinct relation names

__Entity__

__Relation__ - A table. Tables not relations are:
	
	- Multi-valued attributes - if needed, this means a new entity for that attribute should be created

	- Required order of rows, which would also mean missing primary keys

	- Values of varying length - e.g. comments. Better to create a new entity for comments

__Attribute__ - A named column of a relation

__Domain__ - The set of allowable values for one or more attributes

__Tuple__ - A row of a relation

__Degree__ - Number of attributes in a relation

__Cardinality__ - Number of tuples in a relation

__Functional dependency__ - All attributes are defined by the primary key.

__Determinant__

__Superkey__ - Attribute or set of attributes that uniquely identify a tuple within a relation

__Candidate key__ - Superkey (K) such that no proper subset is a superkey within the relation. In each tuple of R, values of K uniquely identify that tuple. No proper subset of K has the uniqueness property.

__Composite key__

__Primary key__ - Candidate key _selected_ to identify tuples uniquely in relation

__Alernate keys__ - Candidate keys that are _not selected_ to be primary key

__Surrogate key__

__Foreign key__ - Attribute or set of attributes within one relation that matches candidate key of some relation. It is possible to have a foreign key relating to the PK in the same relation.

__Referential integrity constraint__

__Normal form__

__Multivalued dependency__

__Entity integrity__ - In a base relation, no attribute of a primary key can be null

__Referential integrity__ - If there is FK, value must match a key value of some tuple in its home relation or foreign key value must be wholly null.

![Example Entity–Relationship diagram](img/erd-example-1.png)
