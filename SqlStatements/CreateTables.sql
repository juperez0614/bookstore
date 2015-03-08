Create DATABASE bookstore;
use bookstore;



CREATE Table UserAuth (
    Username nVarChar(50) NOT NULL, 
    UserPassword nVarChar(50) NOT NULL, 
    
    PRIMARY KEY (Username)

);

CREATE Table UserRole (
    Role nVarChar(50), 
    Username nVarChar(50) NOT NULL, 
     
    FOREIGN KEY (Username) REFERENCES UserAuth(Username)
);

CREATE Table  Author (
	Id INT NOT NULL auto_increment, 
    FirstName nVarchar(50) NULL, 
    LastName nVarChar(50) NULL, 
    Biography nVarChar(250) NULL, 
    PRIMARY KEY (Id)
);

CREATE Table Publisher (
	Id INT NOT NULL auto_increment, 
	CompanyName nVarChar(50) NULL, 
    Address nVarChar(50) NULL, 
    Address2 nVarChar(50) NULL, 
    City nVarChar(50) NULL, 
    ZipCode INT NULL, 
    State nVarChar(2) NULL, 
    Phone nVarChar(12) NULL, 
    PointOfContact nVarChar(50) NULL, 

    Primary Key(Id)
);


CREATE TABLE Customer(
	Id INT NOT NULL auto_increment, 
    FirstName nVarChar(50) NULL, 
    LastName nVarChar(50) NULL, 
    Address nVarChar(50) NULL, 
    Address2 nVarChar(50) NULL, 
    City nVarChar(50) NULL, 
    State nVarChar(2) NULL, 
	ZipCode INT NULL, 
    Username nVarChar(50) NOT NULL, 
    Email nVarChar(50) NULL, 
    
    Primary KEY (Id), 
    FOREIGN KEY (Username) REFERENCES UserAuth(Username)
);

CREATE Table Genre (
	Id INT NOT NULL auto_increment, 
    Genre nVarChar(100) NOT NULL, 
    Primary Key (Id)
);

CREATE table Book (
	Id INT NOT NULL auto_increment, 
    ISBN INT NULL, 
    Price double NOT NULL, 
    Summary nVarChar(250),
    Title nVarChar(100),
    GenreId INT NOT NULL,
    PublisherId INT NOT NULL,
    Cost double NOT NULL, 
    PRIMARY KEY (Id), 
    FOREIGN KEY (GenreId) REFERENCES Genre(Id),
    FOREIGN KEY (PublisherId) REFERENCES Publisher(Id)
);

CREATE Table BookAuthor (
	BookId INT NOT NULL, 
    AuthorId INT NOT NULL, 
    
    FOREIGN KEY (BookId) REFERENCES Book(Id), 
    FOREIGN KEY (AuthorId) REFERENCES Author(Id)

);

CREATE Table Rating (
	Id INT NOT NULL auto_increment, 
    Rating INT NULL, 
    Review nVarChar(250) NULL, 
    BookId INT NOT NULL, 
    CustomerId INT NOT NULL, 
    RatingDate DATE NOT NULL, 
    
    PRIMARY KEY (Id), 
    CHECK (Rating > 0 AND Rating <= 5), 
    FOREIGN KEY (CustomerId) REFERENCES Customer(Id), 
    FOREIGN KEY (BookId) REFERENCES Book(Id)

);


CREATE Table Invoice (
	Id INT NOT NULL auto_increment, 
    CustomerId INT NOT NULL, 
    PaymentType nVarChar(50) NULL, 
    TransactionDate DATE NULL, 
    TotalAmount Double NULL, 
    IsProcessed BOOLEAN NULL, 
    
    PRIMARY KEY(Id),
    FOREIGN KEY (CustomerId) REFERENCES customer(Id)

); 

CREATE Table LineItem (
	Id INT NOT NULL auto_increment, 
    BookId INT NOT NULL, 
    Quantity INT NULL, 
    InvoiceId INT NOT NULL,
    
    PRIMARY KEY (Id), 
    FOREIGN KEY (BookId) REFERENCES Book(Id), 
    FOREIGN KEY (InvoiceId) REFERENCES Invoice(Id)
);

CREATE Table WeeklyProfits(
	WeekId INT NOT NULL auto_increment, 
    TotalProfit double NOT NULL, 
    PRIMARY KEY (WeekId)

);

Create Table MonthlyProfits(
	MonthId INT NOT NULL auto_increment, 
    TotalProfit double NOT NULL, 
    PRIMARY KEY (MonthId)
);

Create Table Inventory (
	BookId INT NOT NULL, 
    Quantity INT NOT NULL, 
    
    Foreign key (BookId) REFERENCES Book(Id)
);



