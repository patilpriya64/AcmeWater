# AcmeWater
Name :- Priya Patil
Mock project for Acme Water

Description : 
1. Read CSV file.
2.Connect to SQL Server Database and update customer information 
3.Generate bill for the customer and send email to customers who have not been billed for the given month and year


1.CSV parser  will read CSV file which wil have customer information . This information is passed 
to database through JDBC connection to database. 
2. Store procedure will update customer record if already exist in table else insert new record.
3. SQL SQL server will return list of customer which are not nilled for a given month and year.
4. amount_due for the these customers will be retrieved from URL provided.
5. Email will be sent to customer.
6. Once only email is sent SQL server will update billing table with information of month and year billed.