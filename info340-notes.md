Data Warehousing
===
Ability to analyze massive amounts of data

Pre-1975
---
- Data storage of horrificly expensive (50 mb)
- Used reel-to-reel tapes 
	- needed sequential access (slow performance)
	- 8-bits
	- limited in speed
	- limited in capacity
- Redundant data
	- hierarchical design
	- bloated databases
- Deletes operationally obsolete data

1980s
---
Conditions that made saving data popular:  
- better hardware
- disk media (no longer sequential access) (faster performance)
	- 16-bits
- bigger capacity 5-10 GB
- understood value of archived data
	- can project behavior by consumers
	- predict
	- observe/discover trends and patterns

Who does well with data warehousing? Large corporations:  
Google, Microsoft, Amazon, Starbucks

Online Transactional Processing (OLTP):  
- Supply Chain DB
- HR DB
- Product Sales DB
- Customer DB
- Partnership DB

Online Analytical Processing (OLAP) => ROLAP, MOLAP, HOLAP (Relational, Multidimensional, Hybrid)  
Relational: boxes linked by lines
Dimensional: in a star schema, a FACT surrounded by Dimensions, each linked back to FACT
- Dimensions: WHO, WHAT, WHEN, WHERE
- Example: Customer, Product, Time, Store, Employee

More specifically:  



Star Schema:  
- de-normalized, got normalized then became strategically organized

Internal vs External
---
Internal:  
- Supply Chain DB
- HR DB
- Product Sales DB
- Customer DB
- Partnership DB
External:  
Demographics

OLTP:  
- Live data
- Write-centric

OLAP:
- Dead-data/Read-only
- Read-centric
- Few large transactions 40-million+ rows
- Many small transactions (30 million 1 row each)
- A subject-oritned, integrated, time-variant, and non-volatile collection of data in support of management's decision-making process (Inmon)


Bill Inmon
: "Go big"

Ralph Kimball
: "Start small"

Benefits of Data warehousing:
potential high returns on investment
competitive advantage
increased productivity of corporate decision-makers

current vs historic
supports operational processing vs analytical processing

Problems of Data Warehousing
- Underestimation of resources for data loading
Hidden problems with source systems  
Required data not captured  
Increased end-user demands   
Data homogenization  
High demand for resources  
Data ownership  
High maintenance  
Long duration projects  
Complexity of integration

Data Warehouse Tools - ETL Processes
- Extraction: Google "SSIS" to extract data
- Transformation: Applies a series of rules/functions to the extracted data and transforms it via data encoding, merging, splitting, calculations
- Loading: As data loads additional constraints defined in the database schema can be activated (such as uniqueness, referential integrity, and mandatory fields), which contribute to the overall data quality performance of the ETL process.

1970's-1990: Followed Inmon's philosophy "Go big"

Data Mart
: Database that contains subset of corporate data to support the analytical requirements of a particular business unit. A subset of datawarehouses. Smaller in scope, less data
- Give users access to data they need to analyze most
- Improve end-user response time due to less data

Ralph Kimball - "Start-small"