Kathryn Brusewitz  
INFO 200 BC  
Dr. David Stearns  
27 October 2016  

Response to _Security_
======================
_What were the critical system design and operational flaws that allowed hackers to gain control over Mat Honan's accounts? What lessons should we learn from this about designing secure systems?_

Two-factor authentication was optional on his Google account, and possibly not even offered at the time on other popular services, such as Amazon, AppleID, and Twitter. Without two-factor authentication, there is nothing to double check whether your identity is legitimate. Once the first verification layer, such as a password entry, is passed, a second verification layer should be required to reduce the chances of account breaches. Honan had failed to turn on two-factor authentication on as many of his accounts as possible, which, I would argue, isn't entirely his fault, as the system design of all these services should have considered the security of users as a primary concern, and design with the fact in mind that the average will disregard steps to secure their credentials and accounts, if made optional, in favor of simple, quick, ease of use. 

Honan regrets not regularly backing up his data. However, it is possible that it is not entirely his fault for either forgetting or completely disregarding backing up his data. It might be better to design the systems and applications he used to manage his photos to have a backup system in place to the cloud, and is only turned off by choice. Or choosing what things to backup should be made easier, so that users do not find it too much work. Applications should encourage and remind (to an extent that it does not become annoying) to regularly backup important files. Otherwise, the system fails to fully consider all of the user experience, which encomposses not only their experience with using the app, but also the collateral effects of when things unintentionally happen in the application.

Probably most vital to point out is the most glaring operational problem this hack exposes: the customer service systems. 
Amazon tech support gave hackers the last four digits of Honan's credit card. Apple tech support had then deemed this information, paired with a billing address, as enough to give access to Honan's iCloud account. This form of identity verification is severely lacking, as it has obviously failed to protect Honan's accounts. This ease of being able to obtain information from one application and use it to gain access to another application exposes how flawed the current technology industry's data management and attempt at security is. Internal policies set by Apple were ignored or not followed completely by its very own tech support - policies which were specifically designed to protect users and their information. Verification of one's identity should not rely on small and impartial bits of information that are easily found, physically or on the web.

_Why do Whitten and Tygar think that end-user email encryption software is so difficult to use? What is their suggestion for a better design strategy?_




References
----------
Honan, M. (2012, August 6). _How Apple and Amazon Security Flaws Led to My Epic Hacking_. Retrieved from https://www.wired.com/2012/08/apple-amazon-mat-honan-hacking/

Whitten, A., & Tygar J.D. (1999, August 23). _Why Johnny Can't Encrypt: A Usability Evaluation of PGP 5.0_. Retrieved from https://faculty.washington.edu/dlsinfo/info200/readings/why-johnny-cant-encrypt.pdf