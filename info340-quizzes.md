1. Cite the three major phases of database development and include high-level objectives of each.
---

Conceptual database design creates the conceptual model of the data. It ignores all physical details (e.g. programming languages, hardware platform and application programs). The data model is built on the information specified by the users' requirements.

Logical database design builds off of the conceptual database design. The underlying data model of the target DBMS is identified (e.g. relational, network, or hierarchical). It ignores all physical details (e.g. storage structures or indexes). Normalization is used to test its correctness. 

Physical database design identifies the target DBMS system and has a description of the physical implementation on secondary storage: relations, file organization, indexes, integrity constraints, and security measures. 


2. Explain the purpose of associative entities and provide an example.
---

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


3. Explain the benefits of the Relational database design when compared to Hierarchical design.
---

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

4. Explain how we ended-up with inefficient ‘hierarchical’ database systems.
---

For nearly the entire history of mankind, information was tracked and written down in rock or on paper. It was only recently that we've had the ability to store information and data on computers. IBM created the first database model on computers in the 60s, which was hierarchical. This was based on the thousands-year-old paper-based system, where single copies are organized by topic and stored in cabinets. This is a parent-child (one-to-many) relationship, which is difficult to update and vulnerable to destruction.

5. Explain what is meant by ‘paper-based’ systems.
---

Paper-based systems were an early attempt to computerize the manual filing system. A filing system could contain receipts, invoices, bank statements, or products, tasks, clients, or employees. When we need to look something up, we search through the system starting from the first entry until we find what we want. There may have an indexing system that helps locate what we want more quickly. For security, the cabinets may have locks or may be located in secure areas of the building. 

6. What was the ‘brilliant breakthrough’ that defines relational theory? Why has it not changed in structure or design in nearly 50 years?
---

Concept of primary/foreign key brought _referential integrity_. Can take one key from one table to another table in order to connect the two. Ability to find a unique row out of a billion rows very quickly. We no longer had to build reports like we did in Hierarchical databases. 

7. Discuss the purpose and benefits of following the normalization process during database design.
---

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

8. Explain what the instructor means by the phrase ‘organize or die’.
---

Over history, those that developed systems survived e.g. groups, cities. Farmers developed systems to grow more food and increase efficiency, societies developed systems of economies and markets and specialized roles and labor, cities developed systems of irrigation, sewage, roads, and so on. 

These systems help optimize society and organizations so that they can learn and innovate and gain a competitive advantage over those that do not. Organizations will be better able to adapt to a dynamic marketplace if they can track, control, manage, and obtain data.

9. Explain what is meant by ‘referential integrity’
---

The concept of primary key/foreign key is essential to referential integrity.

In simple terms, 'referential integrity' is a guarantee that the target it 'refers' to will be found. A lack of referential integrity in a database can lead relational databases to return incomplete data, usually with no indication of an error. When a foreign key value is used it must reference a valid, existing primary key in the parent table.

10. Describe the difference between a natural key and a surrogate key. Why might one be preferred over the other?
---

Natural Key: The same as a composite key. A key that is formed of attributes that already exist in the real world.  
Surrogate Key: a unique identifier for either an entity in the modeled world or an object in the database.  

11. Explain what data types are and provide examples; when might one be preferred over another?
---

A data type defines what kind of value a column can contain. Character, Varchar, and Integer are common string types.

Use Character if you have a fixed length: e.g. phone number.  
Otherwise, use Varchar: e.g. names, because names do not have the same length.
Use Integer for numbers: e.g. age

12. Explain what is meant by cardinality and provide an example.
---

Cardinality is the number of occurrences of one entity when involved with the relationship of another. Either one-to-one, many-to-many, or one-to-many.  

One-to-One: A person has only one driver license, and a driver license belongs to only one person.  
One-to-Many: A car can only have one registered owner, but an owner can have many registered cars.  
Many-to-Many: A film can have many actors, and an actor can be in many films.  

13. Explain what a relation is and cite the conditions that make one.
---

Relation is always a table but a table is not always a relation. A relation:  
- does not have a cell that has multivalued attributes  
- does not have a row dependency  
- does not have a domain violation  

14. Describe what is meant by ‘domain’ and provide an example. 
---

A data domain refers to all the values which a data element may contain. Determining the domain boundary can be as simple as a data type with an enumerated list of values. 

For example, a database table that has information about people, with one record per person, might have a "gender" column. This gender column might be declared as a string data type, and allowed to have one of two known code values: "M" for male, "F" for female—and NULL for records where gender is unknown or not applicable (or arguably "U" for unknown as a sentinel value). The data domain for the gender column is: "M", "F".

15. Explain what a constraint is and provide an example.
---

Constraints are part of a database schema definition. A constraint is usually associated with a table and is created with a CREATE CONSTRAINT or CREATE ASSERTION SQL statement. They define certain properties that data in a database must comply with. Constraints enforce limits to the data or type of data that can be inserted/updated/deleted in a table. Helps maintain data integrity.

http://stackoverflow.com/questions/2570756/what-are-database-constraints

16. Explain differences between composite, multi-valued and derived attributes and provide examples of each.
---

A composite attribute has multiple components, or rather, multiple simple attributes. A complete name, such as "Kathryn Brusewitz", has composite attributes "Kathryn" and "Brusewitz". These composite attributes can be further divided into a tree like structure, so that each attribute has an independent existence on their own. Another example is an address. An address is a composite attribute, since it can be broken down into street, apartment or housing number, city, and state attributes.

A multi-valued attribute has more than one value for each occurrence of an entity. Every occurrence of a student can have multiple values for a phone number attribute, since a student could have more than one phone number; thus, phone number attribute in this case is multi-valued. Another example can be TA's leading different lab-sections. A lab-section is a multi-valued attribute, since a TA could be leading more than one lab-section. 

A derived attribute can be obtained from the value of a related attribute or a set of attributes. The radius of a sphere, for example, can be derived from another attribute, the circumference. As another example, the age of a person can be derived from finding the difference between the current date and their birthdate. A derived attribute can also be calculated from counting the number occurrences of that entity. The number of staff can be derived from counting the total number of staff entity occurrences.

Composite: More than one element (an address has a street number, house number, city, zipcode)  
Multivalued: anything that is redundant therefore it has multiple values (phone number)  
Derived: something that we calculate (age based off of birth date and current date)  

17. Explain decisions designers make in regards to establishing each primary key; what is the preferred data type and configuration settings? Why?
---

Because it is possible for there to be more than one candidate key to be chosen to uniquely identify each occurrence of an entity type, a decision has to be made in regards to choosing which to establish as the primary key. As a general guideline, the designer then chooses the candidate key with: 1. the most minimal set of attributes; 2. values least likely to change; 3. the fewest characters; 4. the smallest maximum value; and 5. easiest usage for the user.

A primary key with the most minimal set of attributes will have the most brief index entries. This is optimal, because the server can perform the lookups and comparisons much faster. The primary key should have values that do not change in the future, because if a primary key value is changed, then the associated foreign key values must be changed in many tables, otherwise the links built into the database will be lost. Additionally, the primary key should ideally have the fewest characters and smallest maximum value, as this makes it processing for the server easier and faster as well as makes joining tables and creating links easier for the user. Additionally, the ideal primary key has no embedded spaces, special characters, or differential capitalization, in order to ease difficulty and prevent user-errors. Finally, the designer should prefer fixed-length character over variable-length character data types because the server will need to use valuable processing power to decompress variable-length data before processing.

18. Explain what is meant by 'business rules' and provide an example.
---

Business rules are also known as the constraints on the data that is to be stored in the database, which can be determined by considering the views of the data (or rather, policies) held by the organization. A database for properties may have the following business rules: a staff member cannot manage more than 50 properties at one time, and a solicitor cannot work for both the buyer and seller. Another example, for any general business, could have a business rule that states a staff member's salary must not be greater than $80,000 and no less than $30,0000. Such business rules specify conditions and relationships that must always be true or false. These rules are enforced by constraints on the data, so that all data in the table conforms to the business rule.

In other words, business rules are essentially policies and conditions that the organization follows, and the constraints on the data reflect these business rules in order to keep the integrity of the data. Data integrity relies on the consistency of the data. If there are business rules that the database is not permitted to violate, data integrity stays intact and valid. 

These rules are intended to prevent disruption in a company or business. Usually business rules are used for the organization that stores or uses data to be an explanation of a policy, procedure, or principle. Business rules are restrictions. For example, a student cannot register for classes if they have too many parking tickets. 

19. Explain the use of a sub-query; which clauses/statements can a sub-query be used?
---

A sub-query is simply a complete SELECT statement inside a SELECT, INSERT, UPDATE, or DELETE statement, or inside another sub-query. More specifically, a sub-query can be inside the WHERE and HAVING clauses of a SELECT statement. The results of the sub-query is used in the outer SELECT statement, as a condition to further filter the data to be retrieved. 

There are three types of sub-queries: scalar, row, and table. A scalar sub-query returns a single value. A row sub-query returns a single row (with multiple columns). A table sub-query returns one or more columns and multiple rows. Sub-queries provide an alternate and more readable way to perform operations that might otherwise need complex joins and unions.

Subquery (a.k.a. Inner query or Nested query) is a query in a query. SQL subquery is usually added in the WHERE Clause of the SQL statement. Most of the time, a subquery is used when you know how to search for a value using a SELECT statement, but do not know the exact value in the database.

Subqueries are an alternate way of returning data from multiple tables. Select, Insert, Update, Delete can be used with comparison operators (=, <, > etc)

20. Explain what is meant by 'data independence' and how relational database design addresses it.
---

Data independence refers to the separation of the data descriptions from the applications. In other words, a change to the structure of the data or how the data is stored on disk, does not affect the applications that use the data in such a way that it requires substantial alteration. A relational database provides data independence by decomposing data into entities and relationships. So when a value changes, it only changes in one place. 

There are two kinds of data independence: Physical Data Independence and Logical Data Independence. The former states that physical changes, e.g. data structures, will not affect applications that depend on the database. As an example, originally the database used Hash Index, but for performance reasons, the database is switched to using a B-Tree Index instead. The application depends on this database does not need to change. The only change the user might see will be performance change. On the other hand, Logical Data Independence requires that logical changes, e.g. adding columns and rows, will not adversely affect applications that depend on the database. 