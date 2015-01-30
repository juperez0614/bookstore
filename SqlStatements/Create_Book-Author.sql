
Use bookStore;

Create Table Books (
	Id INT primary key auto_increment, 
    Title varchar(50) NULL, 
    PublicationDate Date NULL,
    Publisher varchar(50) NULL, 
    Edition varchar(50) NULL, 
    ISBN varchar(50) NULL
);

Create Table Author (
	Id INT primary key auto_increment, 
    FirstName varchar(50),
    LastName varchar(50)
);

Create Table BookAuthor (
	Id INT primary key auto_increment, 
    BookId INT, 
    AuthorId INT, 
    FOREIGN KEY (BookId) REFERENCES Books(Id),
    FOREIGN KEY (AuthorId) REFERENCES Author(Id)
);