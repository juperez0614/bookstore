use bookstore;

CREATE Table  Author (
	Id INT NOT NULL, 
    FirstName nVarchar(50) NULL, 
    LastName nVarChar(50) NULL, 
    Biography nVarChar(250) NULL, 
    PRIMARY KEY (Id)
);

CREATE table Book (
	Id INT NOT NULL, 
    ISBN INT NULL, 
    Price double NULL, 
    Summary nVarChar(250), 
    PRIMARY KEY (Id)
);

CREATE Table BookAuthor (
	BookId INT NOT NULL, 
    AuthorId INT NOT NULL, 
    
    FOREIGN KEY (BookId) REFERENCES Book(Id), 
    FOREIGN KEY (AuthorId) REFERENCES Author(Id)

);

CREATE Table Rating (
	Id INT NOT NULL, 
    Rating INT NULL, 
    Review nVarChar(250) NULL, 
    
    PRIMARY KEY (Id), 
    CHECK (Rating > 0 AND Rating <= 5)

);

CREATE Table Publisher (
	Id INT NOT NULL, 
	CompanyName nVarChar(50) NULL, 
    Address nVarChar(50) NULL, 
    Address2 nVarChar(50) NULL, 
    City nVarChar(50) NULL, 
    ZipCode INT NULL, 
    State nVarChar(2) NULL, 
    Phone nVarChar(12) NULL, 
    PointOfContact nVarChar(50) NULL, 
    BookId INT NOT NULL, 
    
    FOREIGN KEY (BookId) REFERENCES Book(Id)

);
CREATE Table UserTbl (
	Id INT NOT NULL, 
    UserPassword nVarChar(50) NOT NULL, 
    
    PRIMARY KEY (Id)

);

CREATE Table UserRole (
	Id INT NOT NULL, 
    Role nVarChar(50), 
    UserId INT NOT NULL, 
    
    PRIMARY KEY (Id), 
    FOREIGN KEY (UserId) REFERENCES UserTbl(Id)

);
CREATE TABLE Customer(
	Id INT NOT NULL, 
    FirstName nVarChar(50) NULL, 
    LastName nVarChar(50) NULL, 
    Address nVarChar(50) NULL, 
    Address2 nVarChar(50) NULL, 
    City nVarChar(50) NULL, 
    State nVarChar(2) NULL, 
	ZipCode INT NULL, 
    UserId INT NOT NULL, 
    Email nVarChar(50) NULL, 
    
    Primary KEY (Id), 
    FOREIGN KEY (UserId) REFERENCES UserTbl(Id)
);


CREATE Table Invoice (
	Id INT NOT NULL, 
    BookId INT NOT NULL, 
    CustomerId INT NOT NULL, 
    PaymentType nVarChar(50) NULL, 
    TransactionDate DATE NULL, 
    TotalAmount Double NULL, 
    IsProcessed BOOLEAN NULL, 
    
    PRIMARY KEY(Id),
     FOREIGN KEY (BookId) REFERENCES Book(Id), 
    FOREIGN KEY (CustomerId) REFERENCES customer(Id)

); 

CREATE Table LineItem (
	Id INT NOT NULL, 
    BookId INT NOT NULL, 
    InvoiceId INT NOT NULL, 
    Quantity INT NULL, 
    
    PRIMARY KEY (Id), 
    FOREIGN KEY (BookId) REFERENCES Book(Id), 
    FOREIGN KEY (InvoiceId) REFERENCES Invoice(Id)

);
