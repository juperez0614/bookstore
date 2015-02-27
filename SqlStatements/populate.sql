use bookstore;

insert into userauth (username, userpassword) 
values ("jeffrey98", "jeff9800");
insert into userauth (username, userpassword) 
values ("julio98", "perez0");
insert into userauth (username, userpassword) 
values ("linda98", "per0");
insert into userauth (username, userpassword) 
values ("brian98", "kliff0");
insert into userauth (username, userpassword) 
values ("clifford98", "bigg0");
insert into userauth (username, userpassword) 
values ("red98", "dogg0");
insert into userauth (username, userpassword) 
values ("ryu98", "karate0");
insert into userauth (username, userpassword) 
values ("ricky98", "ricard0");
insert into userauth (username, userpassword) 
values ("gob98", "magicman0");
insert into userauth (username, userpassword) 
values ("george98", "stefan0");

insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Jeff", "Asmus", "22567 NW 146th St", "Seattle", "WA", 98101, "jasmus08@uw.edu", "jeffrey98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Linda", "Perez", "27950 NE 147th Circle", "Duvall", "WA", 98019, "lper555@yahoo.com", "linda98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Brian", "kliff", "28550 SE 147th Pl", "Goldbar", "WA", 98032, "bkliff@microsoft.com", "brian98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Clifford", "Bigger", "814 NE 4th Pl", "Redmond", "WA", 98054, "cliff@uw.edu", "clifford98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Red", "Dog", "814 NE 4th Pl", "Redmond", "WA", 98054, "rdog@microsoft.com", "red98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Ryu", "Ken", "28550 SE 147th Pl", "Goldbar", "WA", 98032, "ryuken@uw.edu", "ryu98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Ricky", "Ricardo", "27950 NE 147th Circle", "Duvall", "WA", 98019, "rcardo@uw.edu", "ricky98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Gob", "Bluth", "1459 S Cocaine Rd", "Bogota", "CO", 00010, "magic@magicians4life.gov", "gob98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("George", "Michael", "000 bannanastand ln", "Hell", "WI", 44019, "terrorrist1@alibaba.cn", "george98");
insert into customer (firstname, lastname, address, city, state, zipcode, email, username)
values ("Julio", "Perez", "27950 NE 147th Circle", "Duvall", "WA", 98019, "jperez99@uw.edu", "julio98");


insert into userrole (username, role) 
values ("jeffrey98", "customer");
insert into userrole (username, role) 
values ("julio98", "customer");
insert into userrole (username, role) 
values ("linda98", "customer");
insert into userrole (username, role) 
values ("brian98", "customer");
insert into userrole (username, role) 
values ("clifford98", "customer");
insert into userrole (username, role) 
values ("red98", "customer");
insert into userrole (username, role) 
values ("ryu98", "customer");
insert into userrole (username, role) 
values ("ricky98", "customer");
insert into userrole (username, role) 
values ("gob98", "customer");
insert into userrole (username, role) 
values ("george98", "customer");


insert into author (firstname, lastname, biography)
values ("John", "Mclain", "The bio of john mclane");
insert into author (firstname, lastname, biography)
values ("Luis", "Mclittle", "The bio of lius mclittle");
insert into author (firstname, lastname, biography)
values ("Jake", "Master", "The bio of jake master");
insert into author (firstname, lastname, biography)
values ("gilbert", "joseph", "The bio of gilbert joseph");
insert into author (firstname, lastname, biography)
values ("jose", "alexis", "The bio of jose alexis");
insert into author (firstname, lastname, biography)
values ("ruby", "desmond", "The bio of ruby desmond");
insert into author (firstname, lastname, biography)
values ("juan", "perez", "The bio of juan perez");
insert into author (firstname, lastname, biography)
values ("master", "chief", "The bio of master chief");
insert into author (firstname, lastname, biography)
values ("John", "egoes", "The bio of john egoes");
insert into author (firstname, lastname, biography)
values ("nancy", "Mclain", "The bio of nancy mclane");
insert into author (firstname, lastname, biography)
values ("Anonymous", "", "The bio of ...");

insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("GoodBooks", "123 Candycane Ln", "Seattle", "WA", 98110, "808-719-3232", "Kaleb McGraw");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("BadBooks", "123 Candycane Ln", "Seattle", "WA", 98110, "426-736-3232", "John Outlaw");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("GreatBooks", "123 Candykane Ln", "Seattle", "WA", 98110, "405-789-3232", "Michael Phelps");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("BetterBooks", "444 kiddycorner st", "Seattle", "WA", 98110, "808-779-3232", "Jesus Martinez");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("BestBooks", "999 Champion Ave", "Seattle", "WA", 98110, "808-732-3232", "Chris Crater");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("GreaterBooks", "321 Candycorn Ln", "Nashville", "TN", 32101, "808-766-3232", "Gumbo Jenkins");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("ExtremeBooks", "123 Skyhigh Tr", "Seattle", "WA", 98110, "305-719-3223", "Leroy Hilliford");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("Awful Books", "333 Garbage St", "Philidelphia", "PA", 69808, "808-919-3232", "Joe Celeb");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("ReligiousBooks", "777 Heaven Rd", "Seattle", "WA", 98110, "808-319-3232", "Jack Frost");
insert into publisher (companyname, address, city, state, zipcode, phone, pointofcontact)
values ("SatanicBooks", "999 Upsidedown Ln", "Miami", "FL", 33014, "808-419-3232", "Abe Acerater");

insert into genre (genre)
values ("Suspense");
insert into genre (genre)
values ("Action");
insert into genre (genre)
values ("romance");
insert into genre (genre)
values ("mystery");
insert into genre (genre)
values ("politics");
insert into genre (genre)
values ("history");
insert into genre (genre)
values ("biography");
insert into genre (genre)
values ("autobiography");
insert into genre (genre)
values ("childrens");
insert into genre (genre)
values ("science fiction");

insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456789, 19.99, "summary-book1", "book1", 1, 1);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456788, 18.88, "summary-book2", "book2", 2, 2);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456787, 17.77, "summary-book3", "book3", 3, 3);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456786, 16.66, "summary-book4", "book4", 4, 4);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456785, 15.55, "summary-book5", "book5", 5, 5);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456784, 14.44, "summary-book6", "book6", 6, 6);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456783, 13.33, "summary-book7", "book7", 7, 7);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456782, 12.22, "summary-book8", "book8", 8, 8);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456781, 11.11, "summary-book9", "book9", 9, 9);
insert into book (isbn, price, summary, title, genreid, publisherid)
values (123456780, 10.00, "summary-book10", "book10", 10, 10);

insert into bookauthor (bookid, authorid)
values (1,1);
insert into bookauthor (bookid, authorid)
values (2,2);
insert into bookauthor (bookid, authorid)
values (3,3);
insert into bookauthor (bookid, authorid)
values (4,4);
insert into bookauthor (bookid, authorid)
values (5,5);
insert into bookauthor (bookid, authorid)
values (6,6);
insert into bookauthor (bookid, authorid)
values (7,7);
insert into bookauthor (bookid, authorid)
values (8,8);
insert into bookauthor (bookid, authorid)
values (9,9);
insert into bookauthor (bookid, authorid)
values (10,10);

insert into rating (rating, review, bookid, customerid)
values (1, "reveiwb1", 1, 1 );
insert into rating (rating, review, bookid, customerid)
values (2, "reveiwb2", 2, 2 );
insert into rating (rating, review, bookid, customerid)
values (3, "reveiwb3", 3, 3 );
insert into rating (rating, review, bookid, customerid)
values (4, "reveiwb4", 4, 4 );
insert into rating (rating, review, bookid, customerid)
values (5, "reveiwb5", 5, 5 );
insert into rating (rating, review, bookid, customerid)
values (5, "reveiwb6", 6, 6 );
insert into rating (rating, review, bookid, customerid)
values (4, "reveiwb7", 7, 7 );
insert into rating (rating, review, bookid, customerid)
values (3, "reveiwb8", 8, 8 );
insert into rating (rating, review, bookid, customerid)
values (2, "reveiwb9", 9, 9 );
insert into rating (rating, review, bookid, customerid)
values (1, "reveiwb10", 10, 10 );

insert into invoice (customerid, isprocessed)
values (1,false);
insert into invoice (customerid, isprocessed)
values (2,false);
insert into invoice (customerid, isprocessed)
values (3,false);
insert into invoice (customerid, isprocessed)
values (4,false);
insert into invoice (customerid, isprocessed)
values (5,false);
insert into invoice (customerid, isprocessed)
values (6,false);
insert into invoice (customerid, isprocessed)
values (7,false);
insert into invoice (customerid, isprocessed)
values (8,false);
insert into invoice (customerid, isprocessed)
values (9,false);
insert into invoice (customerid, isprocessed)
values (10,false);

insert into lineitem (bookid, quantity, invoiceid)
values(1, 1, 1);
insert into lineitem (bookid, quantity, invoiceid)
values(2, 2, 2);
insert into lineitem (bookid, quantity, invoiceid)
values(3, 3, 3);
insert into lineitem (bookid, quantity, invoiceid)
values(4, 1, 4);
insert into lineitem (bookid, quantity, invoiceid)
values(5, 1, 5);
insert into lineitem (bookid, quantity, invoiceid)
values(6, 1, 6);
insert into lineitem (bookid, quantity, invoiceid)
values(7, 1, 7);
insert into lineitem (bookid, quantity, invoiceid)
values(8, 1, 8);
insert into lineitem (bookid, quantity, invoiceid)
values(9, 1, 9);
insert into lineitem (bookid, quantity, invoiceid)
values(10, 1, 10);

