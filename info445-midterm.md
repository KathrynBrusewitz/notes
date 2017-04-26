Part A
===
4 questions from the following:

__1. Explain the concept of error-handling (try and be complete: briefly explain what is it, when it happens, why it happens and how it happens). Touch on the benefits of error-handling as well.__

We want to handle errors when we anticipate failures. It is better to "fail early" than to "fail late". The concept of error-handling involves managing communication to the client. We need to communicate to the client what failed, where did it fail, and why did it fail. This most likely comes down to logging the event. A log will have: a Message number, Severity level, State, Procedure, Line, and Message.

Why do we want to anticipate errors? To improve performance. If we fail late, we affect other transactions. We don't want a cascading rollback of many transactions. If we send messages with the error, the client will know why it failed and troubleshoot.

__2. Normalization seeks to eliminate several different types of data anomalies; please identify what these data anomalies are and how normalization can eliminate them.__

Insertion anomaly: Example - Student Table has dorm information (DormName and RoomStyle); Can't insert dorm information without a student associated with a student. Solution is to create a separate table for dorms and an associative entity to keep history.

Deletion anomaly: Getting rid of data that will get rid of other data that we want to keep.

Update anomaly: Having to update RoomStyle would mean we have to update all students (could be hundreds) and would be a hassle. If it was a separate table, we don't have to update, we just have to insert into the table.

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
- Queries are often complex and may be thousands/millions of rows
- Effectiveness = response time
- Aggregated, historical data stored in a multi-dimensional schema (usually star schema)

__4. Explain the difference between synchronous and asynchronous data transfer; when are each preferred?__

Synchronous
- Communications are serial 
- In database terms, transactions wait for commit confirmation
- Care about data loss

Asynchronous
- Communications are parallel
- Transactions do not wait for commit confirmation
- Speed is more important than accuracy

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

Database Mirroring allows a database to mirror its data to another SQL Server thus providing redundancy. Best use of database mirroring is for databases that are considered mission-critical or otherwise cannot sustain significant downtime. Mirroring is synchronous; does not filter like replication.

Database Mirroring Pros:
- Mirroring can provide extremely High Availability
- Automatic failover in case primary server crashes = no downtime
- Flexibility in configuration
- Provides redundancy at the database level

Database Mirroring Cons:
- Synchronous transactions can impact system performance
- Have to create snapshots of the mirror database in order to get read access for reporting
- Only committed transactions are transferred.

Log Shipping allows a database to automatically send transaction log backups from a primary database on a primary server instance to one or more secondary databases on separate secondary server instances. Not filtered; exact copy of data. Read activity = shared lock. Write activity = exclusive lock (this will prevent all read activity. Use log shipping to create a copy so read activity could occur while write activity occurs on the other database.

Log Shipping Pros:
- Provides a disaster-recovery solution for a single primary database and one or more secondary databases
- Provides additional redundancy to your backup strategy
- Can use the secondary database for reporting purposes
- Data can be copied on more than one location
- All committed and un-committed transactions are transferred

Log Shipping Cons:
- Not used for high availability
- Does not automatically failover from the primary server to the secondary server
- Secondary database must be brought online manually
- Need to manage all the databases separately
- Secondary database isn't fully readable while the restore process is running

Replication tracks and detects changes and ships the changes. Use replication to filter data on geographic data (send only data relevant to your location). Or, certain locations receive specific information based on their job function.

Replication Pros:
- Limit specific objects that are replicated to the subscriber. This can be useful if only a subset of tables is needed.
- Gives ability to scale up.

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

__11. Discuss the mechanisms employed by database management systems to ensure recoverability for all transactions that may be interrupted during processing.__

Transaction processing links multiple individual operations into a single transaction and ensures that either all operations in a transaction are completed without error, or none of them are. If some of the operations are completed but errors occur when the others are attempted, the transaction-processing system "rolls back" ALL of the operations in the transaction (including the successful ones). This restores the system to the consistent state that it was in before processing of the transaction began.

Transaction processing guards against hardware and software errors that might leave a transaction partially completed. If the computer system crashes in the middle of a transaction, the system guarantees that all operations in any uncommitted transactions are cancelled. 

Part B
===
Husky Gym is an athletics facility in the University District that offers monthly memberships for weight-training to students, staff and faculty. The following are facts established in a preliminary phone interview with the owners:

- There are 11 certified Nutrition and Athletic Well-Being Advisors on staff. 
- In addition to a full-size basketball court and an Olympic-grade lap pool, there are 57 independent exercise machines as well as over 85,000 pounds in free-weights. 
- There is a gender-neutral sauna and free towel service after 3:00 PM on week days
- The facility has 4 racquetball courts that can be converted to pickle ball if reservations are made a day prior
- The 25-bike spin room and yoga floor has a side-entrance to Brooklyn Avenue. 
- Anyone registering for the 3-month Yoga for Life and Beauty class is eligible for complimentary child-care at ‘Teeny-Toddlers’ across the street.

The owners of Husky Gym would like a database designed to keep track of staff, members, their visits, exercise equipment, all maintenance and any incidents arising during operating hours. One of their primary goals is to lower the occurrence of injuries related to faulty equipment. Design a database ERD in 3NF that will allow them to better operate the business. __Do not include payroll or accounting.__

Part C
===
__Create at least one stored procedure that takes in several parameters of friendly names and INSERTs into multiple tables in an explicit transaction with proper error-handling__
```sql
CREATE PROCEDURE uspNewSpecialNeedPerson
@Fname VARCHAR (30)
@Lname VARCHAR (30)
@GenderName VARCHAR (30)
@AreaCode INT
@PhoneNum INT
@EthnicityName VARCHAR (30)
@SpecialNeedName VARCHAR (60)

-- Declare and initiate IDs for transaction(s)
AS
DECLARE @PersonID INT
DECLARE @GenderID INT
DECLARE @PhoneID INT
DECLARE @EthnicityID INT
DECLARE @SpecialNeedID INT

SET @GenderID = (SELECT GenderID FROM GENDER WHERE GenderName = @GenderName)
SET @EthnicityID = (SELECT EthnicityID FROM ETHNICITY WHERE EthnicityName = @EthnicityName)
SET @SpecialNeedID = SELECT SpecialNeedID FROM SPECIAL_NEED WHERE SpecialNeedName = @SpecialNeedName)

BEGIN Transaction
  -- Insert a new row into PHONE 
  INSERT INTO PHONE (AreaCode, PhoneNum)
  VALUES (@AreaCode, @PhoneNum)

  SET @PhoneID = (SELECT SCOPE_IDENTITY())

  -- Insert a new row into PERSON
  INSERT INTO PERSON (Fname, Lname, EthnicityID, GenderID, PhoneID)
  VALUES (@Fname, @Lname, @EthnicityID, @GenderID, @PhoneID)

  SET @PersonID = (SELECT SCOPE_IDENTITY())

  -- Insert a new row into STUDENT_SPECIAL_NEED
  INSERT INTO STUDENT_SPECIAL_NEED (PersonID, SpecialNeedID)
  VALUES (@PersonID, @SpecialNeedID)

IF @@ERROR <> 0
  ROLLBACK Transaction
ELSE
  COMMIT Transaction
```

__Create at least one business rule or computed column leveraging a function__
```sql
-- Creates a computed column in DEPARTMENT that
-- tracks number of Classes in each Department

CREATE FUNCTION fnTotalClasses(@Department VARCHAR (40))
RETURNS INT
AS
BEGIN
DECLARE @numOfClasses INT

SELECT @numOfClasses = COUNT(C.ClassID)
FROM CLASS C
JOIN COURSE CRS ON C.CourseID = CRS.CourseID
JOIN DEPARTMENT D ON CRS.DeptID = D.DeptID
WHERE D.DeptName = @Department

RETURN @numOfClasses
END

ALTER TABLE DEPARTMENT
ADD TotalClasses INT
AS (dbo.fnTotalClasses(DepartmentName))
```

```sql
-- Creates a business rule that only classes from the "Information School"
-- are allowed to be in the building "Mary Gates Hall"

CREATE FUNCTION ckOnlyInfoClassesInMGH()
RETURNS INT
AS
BEGIN

DECLARE @RET INT = 0
IF EXISTS (
  SELECT * 
  FROM COLLEGE CLLG
  JOIN DEPARTMENT D ON CLLG.CollegeID = D.CollegeID
  JOIN COURSE CRS ON D.DeptID = CRS.DeptID
  JOIN CLASS C ON CRS.CourseID = C.CourseID
  JOIN ROOM R ON C.RoomID = R.RoomID
  JOIN BUILDING B ON R.BuildingID = B.BuildingID
  WHERE CLLG.CollegeName != "Information School"
  AND B.BuildingName = "Mary Gates Hall"
)
SET @RET = 1
RETURN @RET
END

ALTER TABLE BUILDING
ADD CONSTRAINT ckOnlyInfoClassesInMGH
CHECK (dbo.ckOnlyInfoClassesInMGH() = 0)
```

__Create at least one stored procedure that calls additional stored procedures (‘nested’ stored procedures) leveraging OUTPUT parameters__
```sql
-- not yet done...
```

__Create at least one complex view (multiple JOINs, GROUP BY, HAVING, CASE)__
```sql
-- not yet done...
```

![Part C ERD](http://i.imgur.com/hyyGK53.jpg)
