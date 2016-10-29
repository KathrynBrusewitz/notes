Quiz 1
======
1. Cite the three major phases of database development and include high-level objectives of each.

The first phase, conceptual database design, is the creation of a conceptual model of the data, independent of all physical details such as programming languages, hardware platform and application programs. The data model is built using the information specified by the users' requirements.

The second phase, logical database design, is built off of the conceptual database design, and is derived knowing the underlying data model of the target DBMS, such as relational, network, or hierarchical. Any physical details, such as storage structures or indexes, are ignored. Normalization is used to test its correctness. 

The third phase, physical database design, identifies the target DBMS system and produces a description of the physical implementation on secondary storage, including the base relations, file organizations, indexes, and any integrity constraints and security measures. 


2. Explain the purpose of associative entities and provide an example.

Associative entities maps 2 or more tables together to resolve many-to-many relationships. For example, an actor can act in many films, and a film can have many actors. If this was illustrated, there would be an actor table with the primary key `actor_id` and perhaps a name attribute. Additionally, there would be a film table with the primary key `film_id` and perhaps a film name attribute. There would be a many-to-many relationship between these two relations. 

    Actor
    -----
    actor_id
    name

    Film
    ----
    film_id
    name

An associative entity to resolve this into a one-to-many relationship would reference the primary keys from both tables: `actor_id` and `film_id`. 

    ActorFilm
    ---------
    actor_id
    film_id

As an aside, an associative relationship attribute could be added to ActorFilm, like a `date_casted` timestamp, because it would not fit in the Actor table nor the Film table.

    ActorFilm
    ---------
    actor_id
    film_id
    date_casted


3. Explain the benefits of the Relational database design when compared to Hierarchical design.

Hierarchical are difficult to scale (inefficient with large data collection), difficult to account for complex relationships, and 5. prone to bad data and anomalies and redundancy, very expensive and required specialized skils to set up, modify, and maintain.

Relational databases solved nearly all thesei issues. They are able to scale and allow for large data collections, able to adapt and customize for complex relationships and optimize business processes, and guarantees accurate data and integrity of data. They are much less expensive and do not require specialized skills to set up, modify, and maintain because standards have allowed platform-independence, Relational databases also take up less physical space.


4. Discuss the purpose and benefits of following the normalization process during database design.

Normalization uses a series of tests (described as normal forms) to identify the optimal grouping for attributes. Ultimately, it will identify a set of suitable relations that support the data requirements of the enterprise. 

Normalization makes the database easier to access and maintin data and take up minimal storage space. It helps ensure that the relations derived from the data model do not display data redundancy, which can cause update anomalies. 


5. Explain what the instructor means by the phrase ‘organize or die’.

Over history, those that developed systems survived e.g. groups, cities. Farmers developed systems to grow more food and increase efficiency, societies developed systems of economies and markets and specialized roles and labor, cities developed systems of irrigation, sewage, roads, and so on. 

These systems help optimize society and organizations so that they can learn and innovate and gain a competitive advantage over those that do not. Organizations will be better able to adapt to a dynamic marketplace if they can track, control, manage, and obtain data.

Quiz 2
======
1. Explain differences between composite, multi-valued and derived attributes and provide examples of each.

A composite attribute has multiple components, or rather, multiple simple attributes. A complete name, such as "Kathryn Brusewitz", has composite attributes "Kathryn" and "Brusewitz". These composite attributes can be further divided into a tree like structure, so that each attribute has an independent existence on their own. Another example is an address. An address is a composite attribute, since it can be broken down into street, apartment or housing number, city, and state attributes.

A multi-valued attribute has more than one value for each occurence of an entity. Every occurence of a student can have multiple values for a phone number attribute, since a student could have more than one phone number; thus, phone number attribute in this case is multi-valued. Another example can be TA's leading different lab-sections. A lab-section is a multi-valued attribute, since a TA could be leading more than one lab-section. 

A derived attribute can be obtained from the value of a related attribute or a set of attributes. The radius of a sphere, for example, can be derived from another attribute, the circumference. As another example, the age of a person can be derived from finding the difference between the current date and their birthdate. A derived attribute can also be calculated from counting the number occurences of that entity. The number of staff can be derived from counting the total number of staff entity occurences.

2. Explain decisions designers make in regards to establishing each primary key; what is the preferred data type and configuration settings? Why?

Because it is possible for there to be more than one candidate key to be chosen to uniquely identify each occurence of an entity type, a decision has to be made in regards to choosing which to establish as the primary key. As a general guideline, the designer then chooses the candidate key with: 1. the most minimal set of attributes; 2. values least likely to change; 3. the fewest characters; 4. the smallest maximum value; and 5. easiest usage for the user.

A primary key with the most minimal set of attributes will have the most brief index entries. This is optimal, because the server can perform the lookups and comparisons much faster. The primary key should have values that do not change in the future, because if a primary key value is changed, then the associated foreign key values must be changed in many tables, otherwise the links built into the database will be lost. Additionally, the primary key should ideally have the fewest characters and smallest maximum value, as this makes it processing for the server easier and faster as well as makes joining tables and creating links easier for the user. Additionally, the ideal primary key has no embedded spaces, special characters, or differential capitalization, in order to ease difficulty and prevent user-errors. Finally, the designer should prefer fixed-length character over variable-length character data types because the server will need to use valuable processing power to decompress variable-length data before processing.

3. Explain what is meant by 'business rules' and provide an example.

Business rules are also known as the constraints on the data that is to be stored in the database, which can be determined by considering the views of the data (or rather, policies) held by the organization. A database for properties may have the following business rules: a staff member cannot manage more than 50 properties at one time, and a solicitor cannot work for both the buyer and seller. Another example, for any general business, could have a business rule that states a staff member's salary must not be greater than $80,000 and no less than $30,0000. Such business rules specify conditions and relationships that must always be true or false. These rules are enforced by constraints on the data, so that all data in the table conforms to the business rule.

In other words, business rules are essentially policies and conditions that the organization follows, and the constraints on the data reflect these business rules in order to keep the integrity of the data. Data integrity relies on the consistency of the data. If there are business rules that the database is not permitted to violate, data integrity stays intact and valid. 

4. Explain what is meant by 'data independence' and how relational database design addresses it.

Data independence referes to the separation of the data descriptions from the applications. In other words, a change to the structure of the data or how the data is stored on disk, does not affect the applications that use the data in such a way that it requires substantial alteration. A relational database provides data independence by decomposing data into entities and relationships. So when a value changes, it only changes in one place. 

There are two kinds of data independence: Physical Data Independence and Logical Data Independence. The former states that physical changes, e.g. data structures, will not affect applications that depend on the database. As an example, originally the database used Hash Index, but for performance reasons, the database is switched to using a B-Tree Index instead. The application depends on this database does not need to change. The only change the user might see will be performance change. On the other hand, Logical Data Independence requires that logical changes, e.g. adding columns and rows, will not adversely affect applications that depend on the database. 

5. Explain the use of a sub-query; which clauses/statements can a sub-query be used?

A sub-query is simply a complete SELECT statement inside a SELECT, INSERT, UPDATE, or DELETE statement, or inside another sub-query. More specifically, a sub-query can be inside the WHERE and HAVING clauses of a SELECT statement. The results of the sub-query is used in the outer SELECT statement, as a condition to further filter the data to be retrieved. 

There are three types of sub-queries: scalar, row, and table. A scalar sub-query returns a single value. A row sub-query returns a single row (with multiple columns). A table sub-query returns one or more columns and multiple rows. Sub-queries provide an alternate and more readable way to perform operations that might otherwise need complex joins and unions.