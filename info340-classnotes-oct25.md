Oct 25 - Class Notes
====================

Stored Procedures vs user-defined function
---

__Stored Procedures__ - Explicit transaction  

```SQL
BEGIN Tran
(dozens... hundreds of the following):
INSERT 
UPDATE
DELETE
COMMIT Tran


S INSERT
F UPDATE
S DELETE

F INSERT  [x]
F UPDATE
S DELETE
```

More efficient:
- lives in memory  
- pre-compiled - saves time -> converted to machine language  
- has execution plan - collection of indexes (sorting) that we go through to get access to the data  
- has layer of security - needs permission to execute  
- reduce troubleshooting disasters  
- parameters and variables  
    
__User-defined function__ - a query, it "gets things"  

Example: UW  
- getID  
- getCapacity  
- getAvailability  
- getEligibility  

__I don't remember what the following list is for:__  

1. assembling transactions
2. validating data/error handling
3. "stick": CHECK constraints

ACID
====
__Atomicity__ In a transaction involving two or more discrete pieces of information, either all of the pieces are committed or none are. _All or nothing_

__Consistency__ A transaction either creates a new and valid state of data, or, if any failure occurs, returns all data to its state before the transaction was started. _Every transaction begins with DB in a consistent state_, otherwise the database is corrupt. Interrogation of business rules and constaints (Audit). One violation, stop checking.

__Isolation__ A transaction in process and not yet committed must remain isolated from any other transaction. _Assuming every transaction is two/three sides of ugly, doe snot make sense

Five isolation settings (NOT ON TEST)

- Default  READ-Committed
           READ-Uncommitted
  Many users - keep track of which transactions have changed
- Repeatable READ
- Snapshot Isolation
- SERIALIZABLE Single-User

__Durability__ Committed data is saved by the system such that, even in the event of a failure and system restart, the data is available in its correct state. _Write-ahead logging_ _Explicit transaction_ _Checkpoint brings data to disk_

UNIVERSITY database
===================

```SQL
CREATE DATABASE NewUW

USE NewUW

CREATE TABLE tblCOLLEGE
(CollegeID INT IDENTITY(1,1) primary key not null,
CollegeName varchar (50) not null,
CollegeDescr varchar (500) NULL
)

CREATE TABLE tblDEPARTMENT
(DeptID INT IDENTITY(1,1) primary key not null,
DeptName varchar(50) not null,
CollegeID INT FOREIGN KEY REFERENCES tblCOLLEGE(CollegeID) not null,
DeptDescr varchar(500)
)

CREATE TABLE tblCOURSE
(CourseID INT IDENTITY(1,1) primary key not null,
CourseName varchar(100) not null,
DeptID INT FOREIGN KEY REFERENCES tblDEPARTMENT (DeptID) not null,
CourseDescr varchar(500) null
)

CREATE TABLE tblQUARTER
(QuarterID INT IDENTITY(1,1) primary key not null,
QuarterName varchar(25) not null,
QuarterDescr varchar(1000)
)

CREATE TABLE tblCLASS
(ClassID INT IDENTITY(1,1) primary key not null
ClassName varchar()
CourseID varchar()
QuarterID varchar()
Year varchar()
)
```

BUSINESS RULES
--------------

```SQL
-- MEMORIZE THIS TEMPLATE
CREATE FUNCTION Fn_NOINFO340WINTER17 ()
RETURNS INT
AS
BEGIN
    DECLARE @RET INT=0
IF EXISTS(
    --find violation
)
SET @RET=1
RETURN @RET
END
```

```SQL
-- BUSINESS RULE: Information school cannot offer INFO340 in Winter 2017
CREATE FUNCTION Fn_NOINFO340WINTER17 ()
RETURNS INT
AS
BEGIN
    DECLARE @RET INT=0
IF EXISTS(
    SELECT *
    FROM tblCOLLEGE col
    JOIN tblDEPARTMENT dpt ON col.CollegeID = dpt.CollegeID
    JOIN tblCOURSE crs ON dpt.DeptID = crs.DeptID
    JOIN tblCLASS cls ON crs.CourseID = cls.CourseID
    JOIN tblQUARTER qtr ON cls.QuarterID = qtr.QuarterID
    WHERE col.CollegeName LIKE 'Information School'
    AND crs.CourseName LIKE 'INFO340'
    AND qtr.QuarterName LIKE 'Winter'
    AND cls.Year='2017'
)
SET @RET=1
RETURN @RET
END

ALTER TABLE tblCLASS
Add CONSTRAINT
CHECK (dbo.Fn_NOINFO340WINTER17()=0)
```

```SQL
-- BUSINESS RULE: Only classes from the business school can be held in PACCAR HALL
CREATE FUNCTION Fn_NOINFO340WINTER17 ()
RETURNS INT
AS
BEGIN
    DECLARE @RET INT=0
IF EXISTS(

SELECT *
FROM 
SELECT *
FROM tblCOLLEGE col
JOIN tblDEPARTMENT dpt ON col.CollegeID = dpt.CollegeID
JOIN tblCOURSE crs ON dpt.DeptID = crs.DeptID
JOIN tblCLASS cls ON crs.CourseID = cls.CourseID
JOIN tblCLASSROOM clsrm ON cls.ClassroomID = clsrm.ClassroomID
JOIN tblBUILDING bldg ON clsrm.BuildingID = bldg.BuildingID
WHERE col.CollegeName NOT LIKE 'Business School'
AND bldg.BuildingName LIKE 'Paccar Hall'

)
SET @RET=1
RETURN @RET
END
```