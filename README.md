# libraryManager
This repository manages the Library operations.

#Technologies
Java
JPA
Maven
H2 database

#Appproach

I have used H2 in memory database to create sample data for book, user and borrowed entities. I implemented Soft-Delete approach to remove books from borrowed list and book entity which mean whenever book is borrowed its availability will be marked as false instead of deleting the record.

