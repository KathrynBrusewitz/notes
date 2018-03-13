Info 340
===

Midterm
---
__1. Cite the three major phases of database development and include high-level objectives of each.__  

Conceptual database design creates the conceptual model of the data. It ignores all physical details (e.g. programming languages, hardware platform and application programs). The data model is built on the information specified by the users' requirements.

Logical database design builds off of the conceptual database design. The underlying data model of the target DBMS is identified (e.g. relational, network, or hierarchical). It ignores all physical details (e.g. storage structures or indexes). Normalization is used to test its correctness.

Physical database design identifies the target DBMS system and has a description of the physical implementation on secondary storage: relations, file organization, indexes, integrity constraints, and security measures.


__2. Explain the purpose of associative entities and provide an example.__  

Associative entities maps 2 or more tables together to resolve many-to-many relationships. For example, an actor can act in many films, and a film can have many actors. If this was illustrated, there would be an actor table with the primary key `actor_id` and a name attribute, as well as a film table with the primary key `film_id` and a film name attribute:  

    Actor
    -----
    actor_id
    name

    Film
    ----
    film_id
    name

An associative entity to resolve this into a one-to-many relationship would reference the primary keys from both tables: `actor_id` and `film_id`:  

    ActorFilm
    ---------
    actor_id
    film_id

As an aside, an associative relationship attribute could be added to ActorFilm, like a `date_casted` timestamp, because it would not fit in the Actor table nor the Film table:  

    ActorFilm
    ---------
    actor_id
    film_id
    date_casted


__3. Explain the benefits of the Relational database design when compared to Hierarchical design.__  

Hierarchical are:  
- difficult to scale  
- inefficient with large data collection  
- difficult to do complex relationships  
- prone to bad data, anomalies, and redundancy  
- file locations are hard-coded; moving files is problematic  
- requires specialized skills to set-up, modify, and maintain  

Relational databases solve all these issues:  
- easy to scale  
- efficient with large data collections  
- can adapt and customize for complex relationships  
- guarantees accurate data and integrity of data  
- does not require specialized skills to set up, modify, and maintain because standards have allowed platform-independence  

__4. Explain how we ended-up with inefficient ‘hierarchical’ database systems.__  

For nearly the entire history of mankind, information was tracked and written down in rock or on paper. It was only recently that we've had the ability to store information and data on computers. IBM created the first database model on computers in the 60s, which was hierarchical. This was based on the thousands-year-old paper-based system, where single copies are organized by topic and stored in cabinets. This is a parent-child (one-to-many) relationship, which is difficult to update and vulnerable to destruction.

__5. Explain what is meant by ‘paper-based’ systems.__  

Paper-based systems were an early attempt to computerize the manual filing system. A filing system could contain receipts, invoices, bank statements, or products, tasks, clients, or employees. When we need to look something up, we search through the system starting from the first entry until we find what we want. There may have an indexing system that helps locate what we want more quickly. For security, the cabinets may have locks or may be located in secure areas of the building.

__6. What was the ‘brilliant breakthrough’ that defines relational theory? Why has it not changed in structure or design in nearly 50 years?__  

Concept of primary/foreign key brought _referential integrity_. Can take one key from one table to another table in order to connect the two. Ability to find a unique row out of a billion rows very quickly. We no longer had to build reports like we did in Hierarchical databases.

__7. Discuss the purpose and benefits of following the normalization process during database design.__  

Normalization makes the database easier to access and maintain data and take up minimal storage space. It helps ensure that the relations derived from the data model do not have redundant data, which can cause update anomalies.

What: process for determining which attributes belong in specific entities. Identifies optimal grouping for attributes.  

How: A math exercise where we look for nouns that are misplaced. Look for attributes that are dependents of columns other than the primary key  

Why:  
- Efficiency in writing speed, because it writes in one location  
- Efficiency in storage  
- More tables = fewer collisions. For example if you have one street to get into a city, it is going to be very crowded, whereas if you have 10 streets to get into a city it won’t be as crowded. Same thing as if you have 1 table with thousands of objects. Your database will be too crowded, so it is best to split these up into many different tables  
- Transactions are smaller  
- Look up data as needed  
- Fewer anomalies  

__8. Explain what the instructor means by the phrase ‘organize or die’.__  

Over history, those that developed systems survived e.g. groups, cities. Farmers developed systems to grow more food and increase efficiency, societies developed systems of economies and markets and specialized roles and labor, cities developed systems of irrigation, sewage, roads, and so on.

These systems help optimize society and organizations so that they can learn and innovate and gain a competitive advantage over those that do not. Organizations will be better able to adapt to a dynamic marketplace if they can track, control, manage, and obtain data.

__9. Explain what is meant by ‘referential integrity’__  

The concept of primary key/foreign key is essential to referential integrity.

In simple terms, 'referential integrity' is a guarantee that the target it 'refers' to will be found. A lack of referential integrity in a database can lead relational databases to return incomplete data, usually with no indication of an error. When a foreign key value is used it must reference a valid, existing primary key in the parent table.

__10. Describe the difference between a natural key and a surrogate key. Why might one be preferred over the other?__  

Natural Key: The same as a composite key. A key that is formed of attributes that already exist in the real world.  
Surrogate Key: a unique identifier for either an entity in the modeled world or an object in the database.  

__11. Explain what data types are and provide examples; when might one be preferred over another?__  

A data type defines what kind of value a column can contain. Character, Varchar, and Integer are common string types.

Use Character if you have a fixed length: e.g. phone number.  
Otherwise, use Varchar: e.g. names, because names do not have the same length.
Use Integer for numbers: e.g. age

__12. Explain what is meant by cardinality and provide an example.__  

Cardinality is the number of occurrences of one entity when involved with the relationship of another. Either one-to-one, many-to-many, or one-to-many.  

One-to-One: A person has only one driver license, and a driver license belongs to only one person.  
One-to-Many: A car can only have one registered owner, but an owner can have many registered cars.  
Many-to-Many: A film can have many actors, and an actor can be in many films.  

__13. Explain what a relation is and cite the conditions that make one.__  

Relation is always a table but a table is not always a relation. A relation:  
- does not have a cell that has multivalued attributes  
- does not have a row dependency  
- does not have a domain violation  

__14. Describe what is meant by ‘domain’ and provide an example. __  

A data domain refers to all the values which a data element may contain. Determining the domain boundary can be as simple as a data type with an enumerated list of values.

For example, a database table that has information about people, with one record per person, might have a "gender" column. This gender column might be declared as a string data type, and allowed to have one of two known code values: "M" for male, "F" for female—and NULL for records where gender is unknown or not applicable (or arguably "U" for unknown as a sentinel value). The data domain for the gender column is: "M", "F".

__15. Explain what a constraint is and provide an example.__  

Constraints are part of a database schema definition. A constraint is usually associated with a table and is created with a CREATE CONSTRAINT or CREATE ASSERTION SQL statement. They define certain properties that data in a database must comply with. Constraints enforce limits to the data or type of data that can be inserted/updated/deleted in a table. Helps maintain data integrity.

http://stackoverflow.com/questions/2570756/what-are-database-constraints

__16. Explain differences between composite, multi-valued and derived attributes and provide examples of each.__  

A composite attribute has multiple components, or rather, multiple simple attributes. A complete name, such as "Kathryn Brusewitz", has composite attributes "Kathryn" and "Brusewitz". These composite attributes can be further divided into a tree like structure, so that each attribute has an independent existence on their own. Another example is an address. An address is a composite attribute, since it can be broken down into street, apartment or housing number, city, and state attributes.

A multi-valued attribute has more than one value for each occurrence of an entity. Every occurrence of a student can have multiple values for a phone number attribute, since a student could have more than one phone number; thus, phone number attribute in this case is multi-valued. Another example can be TA's leading different lab-sections. A lab-section is a multi-valued attribute, since a TA could be leading more than one lab-section.

A derived attribute can be obtained from the value of a related attribute or a set of attributes. The radius of a sphere, for example, can be derived from another attribute, the circumference. As another example, the age of a person can be derived from finding the difference between the current date and their birthdate. A derived attribute can also be calculated from counting the number occurrences of that entity. The number of staff can be derived from counting the total number of staff entity occurrences.

Composite: More than one element (an address has a street number, house number, city, zipcode)  
Multivalued: anything that is redundant therefore it has multiple values (phone number)  
Derived: something that we calculate (age based off of birth date and current date)  

__17. Explain decisions designers make in regards to establishing each primary key; what is the preferred data type and configuration settings? Why?__  

Because it is possible for there to be more than one candidate key to be chosen to uniquely identify each occurrence of an entity type, a decision has to be made in regards to choosing which to establish as the primary key. As a general guideline, the designer then chooses the candidate key with: 1. the most minimal set of attributes; 2. values least likely to change; 3. the fewest characters; 4. the smallest maximum value; and 5. easiest usage for the user.

A primary key with the most minimal set of attributes will have the most brief index entries. This is optimal, because the server can perform the lookups and comparisons much faster. The primary key should have values that do not change in the future, because if a primary key value is changed, then the associated foreign key values must be changed in many tables, otherwise the links built into the database will be lost. Additionally, the primary key should ideally have the fewest characters and smallest maximum value, as this makes it processing for the server easier and faster as well as makes joining tables and creating links easier for the user. Additionally, the ideal primary key has no embedded spaces, special characters, or differential capitalization, in order to ease difficulty and prevent user-errors. Finally, the designer should prefer fixed-length character over variable-length character data types because the server will need to use valuable processing power to decompress variable-length data before processing.

__18. Explain what is meant by 'business rules' and provide an example.__  

Business rules are also known as the constraints on the data that is to be stored in the database, which can be determined by considering the views of the data (or rather, policies) held by the organization. A database for properties may have the following business rules: a staff member cannot manage more than 50 properties at one time, and a solicitor cannot work for both the buyer and seller. Another example, for any general business, could have a business rule that states a staff member's salary must not be greater than $80,000 and no less than $30,0000. Such business rules specify conditions and relationships that must always be true or false. These rules are enforced by constraints on the data, so that all data in the table conforms to the business rule.

In other words, business rules are essentially policies and conditions that the organization follows, and the constraints on the data reflect these business rules in order to keep the integrity of the data. Data integrity relies on the consistency of the data. If there are business rules that the database is not permitted to violate, data integrity stays intact and valid.

These rules are intended to prevent disruption in a company or business. Usually business rules are used for the organization that stores or uses data to be an explanation of a policy, procedure, or principle. Business rules are restrictions. For example, a student cannot register for classes if they have too many parking tickets.

__19. Explain the use of a sub-query; which clauses/statements can a sub-query be used?__  

A sub-query is simply a complete SELECT statement inside a SELECT, INSERT, UPDATE, or DELETE statement, or inside another sub-query. More specifically, a sub-query can be inside the WHERE and HAVING clauses of a SELECT statement. The results of the sub-query is used in the outer SELECT statement, as a condition to further filter the data to be retrieved.

There are three types of sub-queries: scalar, row, and table. A scalar sub-query returns a single value. A row sub-query returns a single row (with multiple columns). A table sub-query returns one or more columns and multiple rows. Sub-queries provide an alternate and more readable way to perform operations that might otherwise need complex joins and unions.

Subquery (a.k.a. Inner query or Nested query) is a query in a query. SQL subquery is usually added in the WHERE Clause of the SQL statement. Most of the time, a subquery is used when you know how to search for a value using a SELECT statement, but do not know the exact value in the database.

Subqueries are an alternate way of returning data from multiple tables. Select, Insert, Update, Delete can be used with comparison operators (=, <, > etc)

__20. Explain what is meant by 'data independence' and how relational database design addresses it.__  

Data independence refers to the separation of the data descriptions from the applications. In other words, a change to the structure of the data or how the data is stored on disk, does not affect the applications that use the data in such a way that it requires substantial alteration. A relational database provides data independence by decomposing data into entities and relationships. So when a value changes, it only changes in one place.

There are two kinds of data independence: Physical Data Independence and Logical Data Independence. The former states that physical changes, e.g. data structures, will not affect applications that depend on the database. As an example, originally the database used Hash Index, but for performance reasons, the database is switched to using a B-Tree Index instead. The application depends on this database does not need to change. The only change the user might see will be performance change. On the other hand, Logical Data Independence requires that logical changes, e.g. adding columns and rows, will not adversely affect applications that depend on the database.

Final - Part A
---

10 questions drawn from the following:

__1. Describe the components of the N-Tier application architecture.__

Separating application components into separate tiers increases the maintainability and scalability of the application. It does this by enabling easier adoption of new technologies that can be applied to a single tier without the requirement to redesign the whole solution. In addition, n-tier applications typically store sensitive information in the middle-tier, which maintains isolation from the presentation tier.

Early computers had 1-tier, client/server is 2-tier, and client/server/middle is 3-tier, where middle tier contains business logic so only valid requests are sent to the database. The better we understand the stack and the middle-tier, better we can support development.

__2. Explain what the instructor means by the phrase ‘organize or die’.__

Over history, those that developed systems survived e.g. groups, cities. Farmers developed systems to grow more food and increase efficiency, societies developed systems of economies and markets and specialized roles and labor, cities developed systems of irrigation, sewage, roads, and so on.

These systems help optimize society and organizations so that they can learn and innovate and gain a competitive advantage over those that do not. Organizations will be better able to adapt to a dynamic marketplace if they can track, control, manage, and obtain data.

Better data, better outcomes. Optimize over time. Systems provide control of environment.


__3. Explain what a M:M relationship is and why relational theory does not allow them.__


An example of an M:M relationship is an actor can act in many films and a film can have many actors. You'd have to add multiple ActorID columns to the Films table, one for each actor. But how many do you add? 2? 3? 10? However many you choose, you'll probably end up with a lot of sparse rows where many of the ActorID values are NULL and there's a good chance that you'll run across a case where you need "just one more." So then you're either constantly modifying the schema to try to accommodate or you're imposing some artificial restriction ("no film can have more than 3 actors") to force things to fit.


__4. Explain the purpose of associative entities and provide an example.__


Associative entities maps 2 or more tables together to resolve many-to-many relationships. For example, an actor can act in many films, and a film can have many actors. If this was illustrated, there would be an actor table with the primary key actor_id and a name attribute, as well as a film table with the primary key film_id and a film name attribute:

```
Actor
-----
actor_id
name
```

```
Film
----
film_id
name
```

An associative entity to resolve this into a one-to-many relationship would reference the primary keys from both tables: actor_id and film_id:

```
ActorFilm
---------
actor_id
film_id
```

As an aside, an associative relationship attribute could be added to ActorFilm, like a date_casted timestamp, because it would not fit in the Actor table nor the Film table:

```
ActorFilm
---------
actor_id
film_id
date_casted
```

__5. Explain the benefits of the Relational database design when compared to Hierarchical design.__


Hierarchical are:


- difficult to scale
- inefficient with large data collection
- difficult to do complex relationships
- prone to bad data, anomalies, and redundancy
- file locations are hard-coded; moving files is problematic
- requires specialized skills to set-up, modify, and maintain


Relational databases solve all these issues:


- easy to scale
- efficient with large data collections
- can adapt and customize for complex relationships
- guarantees accurate data and integrity of data
- does not require specialized skills to set up, modify, and maintain because standards have allowed platform-independence




__6. Discuss the purpose and benefits of following the normalization process during database design.__


Normalization makes the database easier to access and maintain data and take up minimal storage space. It helps ensure that the relations derived from the data model do not have redundant data, which can cause update anomalies.


What: process for determining which attributes belong in specific entities. Identifies optimal grouping for attributes.


How: A math exercise where we look for nouns that are misplaced. Look for attributes that are dependents of columns other than the primary key


Why:


- Efficiency in writing speed, because it writes in one location
- Efficiency in storage
- More tables = fewer collisions. For example if you have one street to get into a city, it is going to be very crowded, whereas if you have 10 streets to get into a city it won’t be as crowded. Same thing as if you have 1 table with thousands of objects. Your database will be too crowded, so it is best to split these up into many different tables
- Transactions are smaller
- Look up data as needed
- Fewer anomalies


__7. Explain the difference between an implicit and explicit transaction and provide examples.__


Implicit Transaction: the next DML command you send starts a new transaction. Those changes are pending until you either COMMIT or ROLLBACK. If you disconnect without sending COMMIT, it automatically rolls back.

Explicit Transaction has the beginning, ending and rollback of transactions with the command Begin Transaction, Commit Transaction and Rollback Transaction.

In the explicit transaction, if an error occurs in between we can rollback to the beginning of the transaction which cannot be done in implicit transaction.


__8. Discuss the advantages of introducing SuperType/SubTypes into an ERD and provide examples.__


Supertype - an entity type that has a relationship with one or more subtypes.

Subtype - a subgroup of entities with unique attributes.


A data model for PEOPLE. There can be a supertype entity of PEOPLE and its subtype entities can be vendor, customer, and employee. The PEOPLE entity can have attributes like Name, Address, and Phone, which are common to its subtypes. The entities employee, vendor, and customer can then have further unique attributes.


Supertypes and subtypes give a hierarchy to the data through generalization and specialization.


Advantages:
- Used to create a more concise and readable ERD
- Best maps to object oriented approaches either to databases or related applications
- Attributes common to different entity sets need not be repeated
- They can be grouped in one place as attributes of the supertype
- Attributes of sibling subtypes are likely to be different (and should be for this to be very useful)


__9. Cite and describe the high-level objectives of the major phases of database development.__


Conceptual database design creates the conceptual model of the data. It ignores all physical details (e.g. programming languages, hardware platform and application programs). The data model is built on the information specified by the users' requirements.


Logical database design builds off of the conceptual database design. The underlying data model of the target DBMS is identified (e.g. relational, network, or hierarchical). It ignores all physical details (e.g. storage structures or indexes). Normalization is used to test its correctness.


Physical database design identifies the target DBMS system and has a description of the physical implementation on secondary storage: relations, file organization, indexes, integrity constraints, and security measures.


__10. Explain the major differences between scalability and high-availability; what are the goals and measurements of each?__


Clustering for scalability versus clustering for high availability (HA). HA means that the application will be available without interruption.


Scalability:
- ability of a system to provide throughput limited only by available hardware resources.
- a scalable system is one that can handle increasing numbers of requests without adversely affecting response time and throughput
- vertical scaling: increasing cpu within one operating environment
- horizontal scaling: leveraging multiple systems to work together in parallel


High Availability:
- availability is defined as the percentage of time that it works normally
- Unfortunately, measuring availability is not as simple as selecting one of the availability percentages. You must first decide what metric you want to use to qualify downtime. For example, one organization may consider downtime to occur when one database is not mounted. Another organization may consider downtime to occur only when more than half of its users are affected by an outage.


__11. Explain the conditions that are required for a relation.__


- A relation must have a primary key (either auto-numbered, single-field, or multiple-field with 2+ foreign keys).
- Fields must only contain one item of data to eliminate redundant data and to contain only data directly related to the primary key
- Relate each field directly to the subject of the table
- Don’t include derived or calculated data
- Store information in its smallest logical parts (e.g. FirstName and LastName not Name)
- Should not contain duplicate information and information should not be duplicated between tables


__12. Explain the concept of data independence in the context of relational theory.__


Data independence refers to the separation of the data descriptions from the applications. In other words, a change to the structure of the data or how the data is stored on disk, does not affect the applications that use the data in such a way that it requires substantial alteration. A relational database provides data independence by decomposing data into entities and relationships. So when a value changes, it only changes in one place.


There are two kinds of data independence: Physical Data Independence and Logical Data Independence. The former states that physical changes, e.g. data structures, will not affect applications that depend on the database. As an example, originally the database used Hash Index, but for performance reasons, the database is switched to using a B-Tree Index instead. The application depends on this database does not need to change. The only change the user might see will be performance change. On the other hand, Logical Data Independence requires that logical changes, e.g. adding columns and rows, will not adversely affect applications that depend on the database.


__13. Explain how people tracked data before computers; what were the limitations of these systems?__


Paper-based systems. They were quick to establish, easy to use, and cheap. Disadvantages were:
- Vulnerable --- single-copy of important, mission-critical data (fire, theft, misplacement
- Difficult to query --- not easy to compare and analyze ranges of data
- Difficult to transfer data --- mail a hardcopy, tough to maintain organization of logical data sets
- Scalability limitations --- limited to physical ability of people


__14. Explain what is meant by cardinality, degree, multiplicity and participation.__


Cardinality is the number of occurrences of one entity when involved with the relationship of another. A cardinality is how many elements are in a set.

A multiplicity is made up of a lower and an upper cardinality. A multiplicity tells you the minimum and maximum allowed members of the set.

Degree: In every relationship how many entities are participating.

Participation - Two types: total and partial.

Total Participation: The participation of entity set E in a relationship set R is total if every entity in E participates in at least one relationship in R.

Partial Participation: If only some entities in E participate in relationships in R, the participation of entity set E in relationship R is said to be partial.




__15. Describe how entity integrity and referential integrity are enforced.__


Entity integrity:
- Ensures that each row of a table is uniquely identified, so that it can be retrieved separately if necessary
- The primary key is used to uniquely identify each row of the table. No two primary keys can be the same and no primary key can be null
- The primary key enforces entity integrity. These rules guarantee that every row of a table is accessible


Referential integrity:
- Ensures that a value in one table references an existing value in another table
- The value of a foreign key must be within the domain of its related primary key or it must be null (domain is the set of valid values for any column)
- Foreign keys are the implementation of a one-to-many relationship between two tables. A foreign key must always have a corresponding primary key
- The domain of a foreign can’t fall outside the domain of its corresponding primary key. Domain must be same or the foreign key can be null


__16. Explain what is meant by ‘ACID principles’.__


Atomicity:
- Requires that each transaction be “all or nothing”
- If one part fails, the entire transaction fails and the database is left unchanged

Consistency:
- Ensures that any transaction will bring the database from one valid state to another valid state
- Any data written to the database must be valid according to constraints and any defined rules


Isolation:
- Ensures that the concurrent execution of transactions results in a system state that would be obtained if transactions were executed serially
- Uses a concurrency control method

Durability:
- Ensures that once a transaction has been committed, it will remain so, even in the event of power loss, crashes, or errors
- Results need to be stored permanently
- To defend against power loss, transactions and their effects must be recorded in a non-volatile memory


__17. Give 3 examples of the mechanisms RDBMS implement to enforce ACID properties.__


Example 1:

For durability, to defend against power loss, transactions and their effects must be recorded in a non-volatile memory. Durability can be achieved by flushing the transaction's log records to non-volatile storage before acknowledging commitment.


Example 2:

For consistency, any data written to the database must be valid according to constraints and any defined rules. If the entire transaction is inconsistent with the rules of the database, the entire transaction must be cancelled and the affected rows rolled back to their pre-transaction state.


Example 3:

For atomicity, if one part fails, the entire transaction fails and the database is left unchanged. The series of operations cannot be divided apart and executed partially from each other, which makes the series of operations "indivisible", hence the name. A guarantee of atomicity prevents updates to the database occurring only partially, which can cause greater problems than rejecting the whole series outright. In other words, atomicity means indivisibility and irreducibility.




__18. According to Connolly & Begg, what is the difference between a subquery and a join? Under what circumstances would you not be able to use a subquery?__


Joins and subqueries are both used to combine data from different tables into a single result.


Subqueries can be used to return either a scalar (single) value or a row set.


Joins are used to return rows.

Joins are advantageous over subqueries if the SELECT list in a query contains columns from more than one table.


__19. Explain what is meant by 'write-ahead logging'. Which ACID principle is it enforcing?__


Write-ahead logging (WAL) is a family of techniques for providing atomicity and durability.


All modifications are written to a log before they are applied. Usually both redo and undo information is stored in the log.


The purpose of this can be illustrated by an example. Imagine a program that is in the middle of performing some operation when the machine it is running on loses power. Upon restart, that program might well need to know whether the operation it was performing succeeded, half-succeeded, or failed.


If a write-ahead log is used, the program can check this log and compare what it was supposed to be doing when it unexpectedly lost power to what was actually done. Based on this comparison, the program could decide to undo what it had started, complete what it had started, or keep things as they are.


__20. Compare the uses of a View to a stored procedure; when might one be preferred over the other?__


Stored procedures are best used for INSERT-UPDATE-DELETE statements. A stored procedure is used when simple SQL just isn't enough.


Views are used for SELECT statements. In views, you cannot alter the data, but it is a simple way to save a complex SELECT.


A stored procedure:


- accepts parameters
- can NOT be used as building block in a larger query
- can contain several statements, loops, IF ELSE, etc.
- can perform modifications to one or several tables
- can NOT be used as the target of an INSERT, UPDATE or DELETE statement.


A view:


- does NOT accept parameters
- can be used as building block in a larger query
- can contain only one single SELECT query
- can NOT perform modifications to any table
- but can (sometimes) be used as the target of an INSERT, UPDATE or DELETE statement.




__21. Describe the difference between optimistic and pessimistic concurrency control.__


The pessimistic concurrency control approach is to have the database server lock the row on User A’s behalf, so User B has to wait until User A has finished its work before proceeded. We effectively solve the problem by not allowing two users to work on the same piece of data at the same time. It just prevents the conflict.

The optimistic concurrency control approach doesn’t actually lock anything – instead, it asks User A to remember what the row looked like when he first saw it, and when it’s time to update it, the user asks the database to go ahead only if the row still looks like he remembers it. It doesn’t prevent a possible conflict, but it can detect it before any damage is done and fail safely.


The pessimistic approach is a user thinking "I’m sure someone will try to update this row at the same time as I will, so I better ask the database server to not let anyone touch it until I’m done with it."


The optimistic approach is a user thinking "I’m sure it’s all good and there will be no conflicts, so I’m just going to remember this row to double-check later, but I’ll let the database server do whatever it wants with the row." Instead of locking every record every time that it is used, the system merely looks for indications that two users actually did try to update the same record at the same time. If that evidence is found, then one user's updates are discarded and the user is informed.


Optimistic locking allows fast performance and high concurrency (access by multiple users), at the cost of occasionally refusing to write data that was initially accepted but was found at the last second to conflict with another user's changes.

Pessimistic locking requires overhead for every operation, whether or not two or more users are actually trying to access the same record. The overhead is small but adds up because every row that is updated requires a lock. Furthermore, every time that a user tries to access a row, the system must also check whether the requested row(s) are already locked by another user or connection.




__22. Describe the major differences between OLTP/Relational Model and OLAP/Dimensional Model.__


OLTP = Online Transactional Processing

OLAP = Online Analytical Processing


OLTP:
- High number of short online transactions (INSERT UPDATE DELETE)
- Very fast query processing
- Maintain data integrity in multi-access environments
- Effectiveness = number of transactions per second
- Detailed and current data


OLAP:
- Low number of transactions
- Queries are often complex
- Effectiveness = response time
- Aggregated, historical data stored in a multi-dimensional schema (usually star schema)


Final - Part B
---

Create the SQL queries based on the following questions and ERD:

![Final ERD](img/final-erd.png)


__1. Write the code to CREATE a stored procedure with the following:__  

- Takes in 6 parameters (FirstName, LastName, IncidentName, IncidentTypeName, IncidentDate, IncidentDescr)
- Inserts a new row into INCIDENT and INCIDENT_ CONTACT in a single explicit transaction


```sql
CREATE PROCEDURE uspNewIncident
@FirstName VARCHAR (30)
@LastName VARCHAR (30)
@IncidentName VARCHAR (30)
@IncidentTypeName VARCHAR (20)
@IncidentDate DATE
@IncidentDescr VARCHAR (500)

-- Declare and initiate IDs for transaction(s)
AS
DECLARE @IncidentID INT
DECLARE @ContactID INT
DECLARE @IncidentTypeID INT

SET @ContactID = (SELECT ContactID FROM CONTACT WHERE FirstName = @FirstName AND LastName = @LastName)
SET @IncidentTypeID = (SELECT IncidentTypeID FROM INCIDENT_TYPE WHERE IncidentTypeName = @IncidentTypeName)

BEGIN Transaction
  -- Insert a new row into INCIDENT
  INSERT INTO INCIDENT (IncidentName, IncidentDate, IncidentTypeID, IncidentDescr)
  VALUES (@IncidentName, @IncidentDate, @IncidentTypeID, @IncidentDescr)

  SET @IncidentID = (SELECT SCOPE_IDENTITY())

  -- Insert a new row into INCIDENT_CONTACT
  INSERT INTO INCIDENT_CONTACT (IncidentID, ContactID)
  VALUES (@IncidentID, @ContactID)

IF @@ERROR <> 0
  ROLLBACK Transaction
ELSE
  COMMIT Transaction
```

__2. Write the code to create a new entity called SCHOOL_TYPE:__  

- Include auto-increment feature
- Include code to establish a foreign key to SCHOOL

```sql
CREATE TABLE SCHOOL_TYPE
(
  SchoolTypeID INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
  SchoolTypeName VARCHAR (40) NULL,
  SchoolTypeDescr VARCHAR (500) NULL,
  SchoolID INT FOREIGN KEY REFERENCES SCHOOL(SchoolID)
)
```



__3. Write the code to create a computed column in SCHOOL that has the following:__  

- Includes the use of a user-defined function
- Tracks number of ‘student incidents’ (number of incidents that have involved students from each particular school)


```sql
CREATE FUNCTION fnTotalStudentIncidents(@School VARCHAR (40))
RETURNS INT
AS
BEGIN
DECLARE @numOfIncidents INT

SELECT @numOfIncidents = COUNT(I.IncidentID)
FROM INCIDENT I
JOIN INCIDENT_CONTACT IC ON I.IncidentID = IC.IncidentID
JOIN CONTACT C ON IC.ContactID = C.ContactID
JOIN STUDENT S ON C.ContactID = S.ContactID
JOIN CONTACT_SCHOOL CS ON C.ContactID = CS.ContactID
JOIN SCHOOL SC ON CS.SchoolID = SC.SchoolID
WHERE SC.SchoolName = @School

RETURN @numOfIncidents
END

ALTER TABLE SCHOOL
ADD TotalStudentIncidents INT
AS (dbo.fnTotalStudentIncidents(SchoolName))
```



__4. Write the code to create a business rule that restricts a person from serving more than two terms on the Board of Directors in the title of ‘President’:__  

```sql
CREATE FUNCTION ckPresHasLessThanThreeTerms()
RETURNS INT
AS
BEGIN

DECLARE @RET INT = 0
IF EXISTS (
  SELECT *
  FROM CONTACT C
  JOIN BOARD B ON C.ContactID = B.ContactID
  JOIN CONTACT_BOARD_POSITION CBP ON B.ContactID = CBP.ContactID
  JOIN BOARD_POSITION BP ON CBP.BoardPositionID = BP.BoardPositionID
  WHERE BP.BoardPositionName LIKE '%President%'
  AND DATEDIFF(year , CBP.BeginDate , CBP.EndDate) > 2
)

SET @RET = 1
RETURN @RET
END

ALTER TABLE CONTACT
ADD CONSTRAINT ckPresHasLessThanThreeTerms
CHECK (dbo.ckPresHasLessThanThreeTerms(Person) = 0)
```



__5. Write the code to create a business rule that restricts a fundraising events to December or January only:__  


```sql
CREATE FUNCTION ckFundraisingOnlyInDecemberJanuary()
RETURNS INT
AS
BEGIN
DECLARE @RET INT = 0
IF EXISTS (
  SELECT *
  FROM EVENT E
  JOIN EVENT_TYPE ET ON E.EventTypeID = ET.EventTypeID
  WHERE ET.EventTypeName LIKE '%fundrais%'
  AND DATEPART(mm, E.EventDate) NOT LIKE '1'
  AND DATEPART(mm, E.EventDate) NOT LIKE '12'
)

SET @RET = 1
RETURN @RET
END

ALTER TABLE EVENT
ADD CONSTRAINT ckFundraisingOnlyInDecemberJanuary
CHECK (dbo.ckFundraisingOnlyInDecemberJanuary() = 0)
```
