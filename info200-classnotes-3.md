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

Authorization = rules whether a given user should be given permission to do something  
Authentication = process of verifying identity

Usable Security
---------------
Applying UX principles to security features, so that users desire and comprehend

How to Store Passwords
----------------------
Never store passwords in plain text.  
Instead, _salt and hash_ user passwords using an adaptive cryptographic hashing algorithm (bcrypt, scrypt, argon2, dont use sha-1)  
Even weak passwords take weeks or months to break if they are salted and hashed - gives time to change passwords

Password Hashing: `input + salt value -> hash function -> fixed-length hash (aka digest)`

`hash(password + salt)` then compare hashes

* one way, irreversible process
* unique
* unpredictable
* adaptive

`store hash` and `salt` for username
`generate new salt` values everytime a user creates an account

Encryption and Decryption
-------------------------
__Symmetric encryption:__ encrypt and decrypt with same key (currently 2048 bits)  
__Asymmetric encryption:__ private and public key (mathematically related); encrypt with one key but decrypt only with the other  
__RSA Algorithm:__ There is no known algorithm and enough computing power to factor the product of two large prime numbers

Digital Signatures and Certificates
-----------------------------------
Digital signatures combine hashing and asymmetric encryption to create a digital file that you know:  
was signed by the agent in control of a particular private key, and  
was not modified since it was signed

Certificates: combines digital signatures with trusted third parties (Certificate Authorities) to create a trustworthy digital file that: identifies the holder and contains correct public keys for the holder and trusted third parties - a legal identity is attached

HTTPS (TLS)
-----------
TLS - transport layer security  
digital cert: has public key  
asymmetric used to encrypt seed, in order to share a symmetric key (seed value is what generates the symmetric key)  
then can deliver symmetrically-encrypted data back and forth (saves on time)