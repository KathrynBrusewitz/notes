Nov 9 - [Quiz 3](https://canvas.uw.edu/courses/1066596/quizzes/915789)

User Research this weekend, then prototyping (using prototyping/appsketching tools) next week (nov 1 - nov 5)  
Prototyping tools introduced in lab (Wednesday)

Oct 27 - Designing Secure Systems
=================================

Multi-Factor Authentication
---------------------------
Something you know (pin, password)  
Something you have (fob)  
Something you are (biometrics)

Escalate authentication checks relative to importance of data.

Authorization
:  Rules whether a given user should be given permission to do something  

Authentication
:  Process of verifying identity

Usable Security
:  Applying UX principles to security features, so that users desire and comprehend

How to Store Passwords
----------------------
Never store passwords in plain text. Instead, _salt and hash_ user passwords using an adaptive cryptographic hashing algorithm (bcrypt, scrypt, argon2, dont use sha-1). Even weak passwords take weeks or months to break if they are salted and hashed - gives time to change passwords

Password Hashing
:  `input + salt value -> hash function -> fixed-length hash (aka digest)`

`hash(password + salt)` then compare hashes

Password hashing is one way, irreversible process, unique, unpredictable, and adaptive.

`store hash` and `salt` for username
`generate new salt` values everytime a user creates an account

Encryption and Decryption
-------------------------
Symmetric encryption
:  Encrypt and decrypt with same key (currently 2048 bits)  

Asymmetric encryption
:  Private and public key (mathematically related); encrypt with one key but decrypt only with the other  

RSA Algorithm
:  There is no known algorithm and enough computing power to factor the product of two large prime numbers

Digital Signatures and Certificates
-----------------------------------
Digital signatures 
:  Combine hashing and asymmetric encryption to create a digital file that you know was signed by the agent in control of a particular private key, and was not modified since it was signed

Certificates
:  Combine digital signatures with trusted third parties (Certificate Authorities) to create a trustworthy digital file that: identifies the holder and contains correct public keys for the holder and trusted third parties - a legal identity is attached

HTTPS (TLS)
-----------
TLS = transport layer security.  

Digital Certificate has public key.  

Asymmetric used to encrypt seed, in order to share a symmetric key (seed value is what generates the symmetric key)  
then can deliver symmetrically-encrypted data back and forth (saves on time)

Nov 1 - Data Modeling and Encoding
==================================
Accounting Tokens and Envelopes (Encoding/Decoding) <--> Analogous to digital signatures

Early 19th century had punchcards; used for surveys/census

Character Sets
:  Defined mapping between patterns of bit and characters. Multiple character sets cause serious problems, if we don't know what character set was used to represent the data

ASCII
:  English  

Unicode
:  Universal, 16 bits per-character = 65,536 possible code points  

Multiplane Unicode
:  32 bits per-character = 4.2 billion possible code points: _UTF-32_ (UNIX), _UTF-16_ (Java, .Net), _UTF-8_ (web, Go)  

Higher numbered characters have different bit sequences depending on the character set used.

Raster Image Encoding
:  3 numbers per pixel, each 0-255, 24 bits per pixel, e.g. `Red: 233`, `Green: 157`, `Blue: 144`

Databases and Data Modeling
---------------------------
Data modeling is about modeling the salient characteristics of that object.  
Want to maintain integrity, and control and authorize accessibility.  

Database Management System (DBMS)
:  A software process that allows clients to define a data structure; add data to that structure; navigate, tabulate, update, and delete those data; maintain data security and integrity; and automatically recover from failure.

Relational (SQL)
:  Tables  

No-SQL Distributed
:  Complex documents, invented specifically for social media, not good with sets of data, good with singular items, data spread over different machines, can store tons of information  

Multidimensional
:  Microsoft pivot tables, hypercube matrix of data  

Hierarchical
:  Strict hierarchical; parent/child relationships, file system on computer  

Simple Tables
:  Excel, singular tables of data, duplicated data  

Schema
:  structure for holding data, accounts for attributes  

Data Modeling
:  the process of designing a structure capable of holding the data the system needs to track, while avoiding redundancy and ensuring data integrity; resulting structure is called a schema. Visually designed and represented in an Entity-Relationship Diagram (ERD)  

Entity
:  a person place, thing, or concept tracked by the system

Nov 3 - Information Architecture
================================
How does your grocery store organize its products? Does it makes sense to you, or do you have trouble finding things like salsa, pickles, or marshmallows?

How do we describe the information that our systems track? Base decisions on the way our target users think how it would be organized in order to be able to find the information they need.

Why did Netflix create their micro-genre feature, what makes it work, and which ones do they keep suggesting for you?

Classification
:  Grouping things together based on their shared qualities. These groups form a taxonomy, which is often hierachical.

Taxonomy
:  Structure (often hierarchical) 

Faceted Classification
:  Organizing by multiple, parallel taxonomies. Each taxonomy considers a different quality (facet) and acts as an independent filter. `Movies: genre, length, rating, directors, actors, distributor`. Allows for rich searching/navigation UI. `Clothing: gender, type, color, size`

Physical Schema
:  Each item may exist in one categoy

Folksonomy
:  Allowing end-users to tag items with various categories or descriptive words. Pros: Gives the users power; participatory design. Cons: too little tagging; irrelevant tags; redundancy/synonyms; trolling or ironic tags; plural forms of word

Controlled Vocabulary
:  Organized set of words and phrases that help people organize

Synonym Ring
:  Words related to each other

Authority File

	food processor (canonical form)
	-------------------------------
	foodprocessor (variants)
	cuisinart
	cuizinart
	kitchen aid
	kitchenaid
	blender
	obliterator

Disambiguation List
	pitch
	-----
	pitch (throw)
	pitch (propose)
	pitch (assemble)
	pitch (playing field)
	pitch (frequency)
	pitch (angle)
	pitch (distance)

Nov 8 - Introduction to Data Science
====================================
Next week: Discuss "Right to be Forgotten" - Should U.S. consider adopting this policy?

![Drew Conway's Data Science Venn Diagram](http://bit.ly/2eSUY4L)

Data Science Workflow
1. Preparing to run a model - Gathering, cleaning, integrating, restructuring, combining, etc.
2. Running the Model
3. Interpreting the results

Data Management
- Relational Algebra
- Scheme-Later and NoSQL
Stats
- Permutation Methods
- Multiple Hypothesis 
Communication
- Visualization
- Data Privacy and Ethics

Responsibility, Ethics
----------------------
Properties of "Weapons of Math Destruction":
- Opacity
- Scale
- Damage

What can we do with massive, noisy, heterogeneous datasets?  
What should we do with massive, noisy, heterogeneous datasets?  
Decisions are based on two sources of information:
1. Past examples
2. Societal constraints

How do we apply societal constraints to algorithmic decision-making?  
Option 1: Keep a human in the loop  
Option 2: Build them into the algorithms themselves

On transparency vs. accountability: As we shift decisions to algorithms, we lose both transparency and accountability.

Privacy, Fairness, Transparency, Reproducibility, Ethics

Fairness
--------
Any background signal in the data of institutional racism is amplified and reinforced by the algorithm

Knack
-----
- Not very transparent. How did Knack come to the conclusions that they did? 
- Does not consider soft skills; can only measure attention to the game. How is that a useful measurement for real-life and real skills?


