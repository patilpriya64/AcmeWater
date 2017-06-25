USE [acmewater]
GO


/*** This is customer table***/
CREATE TABLE [dbo].[Customer](
	[CustomerId] [varchar](255) NOT NULL,
	[LastName] [varchar](255) NULL,
	[FirstName] [varchar](255) NULL,
	[Email] [varchar](50) NULL,
	[Address] [varchar](255) NULL,
	[City] [varchar](255) NULL,
	[Zip] [varchar](255) NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerId] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)


/*** This is billing table ***/

CREATE TABLE [dbo].[Billing](
	[CustomerId] [varchar](255) NOT NULL,
	[LastBillingDate] [date] NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[CustomerId] ASC,
	[LastBillingDate] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON)
)




/** this procedure will get customer data . If the customer record already exist in customer 
table then update existing record else insert new record
**/

GO
Create procedure [dbo].[InsertorUpdateCustomer]
as
  SET NOCOUNT ON

BEGIN
DECLARE   @CustomerID VARCHAR
DECLARE   @LastName VARCHAR(255)
DECLARE   @FirstName VARCHAR(255)
DECLARE   @Email VARCHAR(50)
DECLARE   @Address VARCHAR(255)
DECLARE   @City VARCHAR(255)
DECLARE   @Zip VARCHAR(255)

;
with
base as ( select *
from customer
where CustomerId = @CustomerId
)
 
MERGE customer as target
 USING base as source
  ON target.CustomerId = source.CustomerId
WHEN matched
  THEN Update
  SET target.LastName = source.LastName,
    target.FirstName = source.FirstName,
    target.Email = source.Email,
    target.Address = source.Address,
    target.City = source.City,
    target.zip = source.zip
WHEN not matched THEN INSERT
VALUES (source.CustomerID, source.LastName, source.FirstName,             
source.Email, source.Address, source.City, source.zip)



/*** This store procedure will return record of customer that have not billed yet 
for the give mon and year****/

Create procedure [dbo].[NotBilledCustomer]( @BillingMonth int ,
@BillingYear int )

as
  SET NOCOUNT ON

/** this sent results back to java code where customer is not billed for given month and year**/

BEGIN

SELECT * FROM Customer C
WHERE CustomerId NOT IN (
	SELECT B.CustomerId FROM Billing B
	WHERE month = @BillingMonth
		AND year = @BillingYear
)


End



/** This store procedure will insert new record in billing table for the customer whom email is been sent **/



Create procedure [dbo].[UpdateBillingAfterEmail_Sent]( @customerID,@BillingMonth int ,
@BillingYear int )

/**Once the Letter is sen we can update billing information***/
as
  SET NOCOUNT ON

BEGIN
 
INSERT into billing(CustomerID, Month, year)
VALUES (@customerID, @BillingMonth, @BillingYear)


End 
