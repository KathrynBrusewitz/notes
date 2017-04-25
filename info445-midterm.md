Part A
===
4 questions from the following:

__1. Explain the concept of error-handling (try and be complete: briefly explain what is it, when it happens, why it happens and how it happens). Touch on the benefits of error-handling as well.__

We want to handle errors when we anticipate failures. It is better to "fail early" than to "fail late". The concept of error-handling involves managing communication to the client. We need to communicate to the client what failed, where did it fail, and why did it fail. This most likely comes down to logging the event. A log will have: a Message number, Severity level, State, Procedure, Line, and Message.

__2. Normalization seeks to eliminate several different types of data anomalies; please identify what these data anomalies are and how normalization can eliminate them.__

Normalization makes the database easier to access and maintain data and take up minimal storage space. It helps ensure that the relations derived from the data model do not have redundant data, which can cause update anomalies. Normalization is a process for determining which attributes belong in specific entities. Identifies optimal grouping for attributes. Normalization is essentially an exercise where we look for nouns that are misplaced. If we look for attributes that are dependents of columns other than the primary key, we eliminate redundant data, therefore eliminating update anomalies.

__3. Describe the differences between Online Transaction Processing (OLTP) databases and those that are supporting Data Warehousing or Online Analytical Processing (OLAP).__

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

__4. Explain the difference between synchronous and asynchronous data transfer; when are each preferred?__

Synchronous
- Communications are serial 
- In database terms, transactions wait for commit confirmation

Asynchronous
- Communications are parallel
- Transactions do not wait for commit confirmation

__5. Describe 5 different SQL commands that are considered ‘control of flow’ language.__

BEGIN...END
- BEGIN and END define a series of statements that execute together.

BREAK
- Exits the innermost loop in a WHILE statement or an IF...ELSE statement inside a WHILE loop. 

GOTO label
- The statements after GOTO are skipped and processing continues at the label. 

CONTINUE
- Restarts a WHILE loop. Any statements after the CONTINUE keyword are ignored. 

IF...ELSE
- Imposes conditions on the execution of a statement block. If the condition is true, statements following IF... will be executed. If the condition is false, statements following the ELSE will be executed.

WHILE
- Sets a condition for the repeated execution of a statement block. The statements are executed repeatedly as long as the condition is true.

RETURN
- Exits unconditionally from a query or procedure. RETURN is immediate and can be used at any point to exit from a procedure, batch, or statement block. Statements that follow RETURN are not executed.

WAITFOR
- Blocks the execution of a batch, stored procedure, or transaction until a specified time or time interval is reached, or a specified statement modifies or returns at least one row.

THROW
- Raises an exception.

TRY...CATCH
- Implements error handling similar to C# and C++. If an error occurs in the TRY block, control is passed to another group of statements that is enclosed in a CATCH block.

__6. Compare database mirroring, log shipping and replication; when is each the preferred tool of use?__

Database Mirroring allows a database to mirror its data to another SQL Server thus providing redundancy. Best use of database mirroring is for databases that are considered mission-critical or otherwise cannot sustain significant downtime. 

Database Mirroring Pros:
- Mirroring can provide extremely High Availability
- Automatic failover in case primary server crashes
- Easy to set up
- Flexibility in configuration
- Provides redundancy at the database level

Database Mirroring Cons:
- Operating modes with synchronous transactions can impact system performance
- Have to create snapshots of the mirror database in order to get read access for reporting
- Only committed transactions are transferred.

Log Shipping allows a database to automatically send transaction log backups from a primary database on a primary server instance to one or more secondary databases on separate secondary server instances. 

Log Shipping Pros:
- Provides a disaster-recovery solution for a single primary database and one or more secondary databases
- Provides additional redundancy to your backup strategy
- Can use the secondary database for reporting purposes
- Easy to set up and maintain
- Data can be copied on more than one location
- All committed and un-committed transactions are transferred

Log Shipping Cons:
- Does not automatically failover from the primary server to the secondary server
- Secondary database must be brought online manually
- Need to manage all the databases separately
- Secondary database isn't fully readable while the restore process is running

Replication is a set of technologies for copying and distributing data and database objects from one database to another and then synchronizing between databases to maintain consistency. Tracks and detects changes and ships the changes.

Replication Pros:
- Limit specific objects that are replicated to the subscriber. This can be useful if only a subset of tables is needed.
- Can support distributed processing by spreading the workload of an application across several servers.

Replication Cons: 
- Replication is bound to database objects, so if you create a new object on the database it is not automatically added.

__7. Describe the use and benefits of an output parameter.__

A stored procedure could return one or more output parameters. These are parameters that the stored procedure uses to return data back to the calling application so that it can save the value and use it. The benefit is being able to nest stored procedures within another stored procedure. 

__8. Define the different data warehouse design structures:  star schema, snowflake schema, ‘star flake’ schema, fact table, dimension table in addition to a ‘measure’.__

Star Schema: A central table (Fact Table) contains fact data. Multiple tables (Dimension Tables) radiate out from it. They are connected by the primary and foreign keys of the database.

![Star Schema](https://www.tutorialspoint.com/dwh/images/start_schema.jpg)

Snowflake Schema: Like the star schema, but is further normalized into sub-dimension tables. 

![Snowflake Schema](https://www.tutorialspoint.com/dwh/images/snowflake.jpg)

Star Flake Schema: Like the snowflake schema, but only some dimension tables have been denormalized.

Fact Table: Contains fact data, which are measurable, quantitative data. Contains foreign keys of its dimensions.

Dimension table: Contains a set of attributes, which are descriptive attributes related to fact data. Connects with the Fact Table through its primary key. 

Measure: Fact tables record measurements for a specific event. A measure is something that can be used in calculations and analysis.

__9. Explain the differences between a Data Warehouse, ETL and a Data Mart.__

Data Warehouse:
- Holds multiple subject areas
- Holds very detailed information
- Works to integrate all data sources
- Does not necessarily use a dimensional model but feeds dimensional models

Data Mart:
- Often holds only one subject area - for example, finance or sales
- May hold more summarised data
- Concentrates on integrating information from a given subject area or set of source systems
- Is built focused on a dimensional model using a star schema

ETL (Extract, Transform, Load) is the process of getting data from one data storage method into another. ETL usually depends on data pipelines provided by third parties. Data Warehouse/Data Mart is the place where data is stored for analysis/reporting. 

__10. Explain the difference between the concepts of ‘high-availability’ and ‘scalability’ in regards to relational database systems: What are the terms and tools are used? How do we measure their effectiveness?__

Clustering for scalability versus clustering for high availability (HA). HA means that the application will be available without interruption.

Scalability: 
- ability of a system to provide throughput limited only by available hardware resources. 
- a scalable system is one that can handle increasing numbers of requests without adversely affecting response time and throughput
- vertical scaling: increasing cpu within one operating environment; adding hardware to a single node; upgrading to a larger node
- horizontal scaling: leveraging multiple systems to work together in parallel; adding more nodes; spreading workload among nodes
- "Throughput": Transactions per second

High Availability:
- availability is defined as the percentage of time that it works normally
- Unfortunately, measuring availability is not as simple as selecting one of the availability percentages. You must first decide what metric you want to use to qualify downtime. For example, one organization may consider downtime to occur when one database is not mounted. Another organization may consider downtime to occur only when more than half of its users are affected by an outage.
- Goal is to provide continuous use of mission-critical data
- There are degrees of availability (it's NOT all or nothing)
  - 99.9% = 8.7 hours of downtime/year
- Tool: Database Snapshots - Quick and efficient; only modified data gets moved

__11. Describe the differences between the various types of indexes presented during lecture.__

???

__12. Discuss the mechanisms employed by database management systems to ensure recoverability for all transactions that may be interrupted during processing.__

Transaction processing links multiple individual operations into a single transaction and ensures that either all operations in a transaction are completed without error, or none of them are. If some of the operations are completed but errors occur when the others are attempted, the transaction-processing system "rolls back" ALL of the operations in the transaction (including the successful ones). This restores the system to the consistent state that it was in before processing of the transaction began.

Transaction processing guards against hardware and software errors that might leave a transaction partially completed. If the computer system crashes in the middle of a transaction, the system guarantees that all operations in any uncommitted transactions are cancelled. 

