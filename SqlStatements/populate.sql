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

insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456789, 19.99, "summary-book1", "book1", 1, 1, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456788, 18.88, "summary-book2", "book2", 2, 2, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456787, 17.77, "summary-book3", "book3", 3, 3, 3.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456786, 16.66, "summary-book4", "book4", 4, 4, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456785, 15.55, "summary-book5", "book5", 5, 5, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456784, 14.44, "summary-book6", "book6", 6, 6, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456783, 13.33, "summary-book7", "book7", 7, 7, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456782, 12.22, "summary-book8", "book8", 8, 8, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456781, 11.11, "summary-book9", "book9", 9, 9, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (123456780, 10.00, "summary-book10", "book10", 10, 10, 1.00);

insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456789, 19.99, "summary-book21", "2book1", 1, 1, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456788, 18.88, "summary-book22", "2book2", 2, 2, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456787, 17.77, "summary-book23", "2book3", 3, 3, 3.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456786, 16.66, "summary-book24", "2book4", 4, 4, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456785, 15.55, "summary-book25", "2book5", 5, 5, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456784, 14.44, "summary-book26", "2book6", 6, 6, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456783, 13.33, "summary-book27", "2book7", 7, 7, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456782, 12.22, "summary-book28", "2book8", 8, 8, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456781, 11.11, "summary-book29", "2book9", 9, 9, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (223456780, 10.00, "summary-book210", "2book10", 10, 10, 1.00);

insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456789, 19.99, "summary-book31", "3book1", 1, 1, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456788, 18.88, "summary-book32", "3book2", 2, 2, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456787, 17.77, "summary-book33", "3book3", 3, 3, 3.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456786, 16.66, "summary-book34", "3book4", 4, 4, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456785, 15.55, "summary-book35", "3book5", 5, 5, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456784, 14.44, "summary-book36", "3book6", 6, 6, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456783, 13.33, "summary-book37", "3book7", 7, 7, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456782, 12.22, "summary-book38", "3book8", 8, 8, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456781, 11.11, "summary-book39", "3book9", 9, 9, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (323456780, 10.00, "summary-book310", "3book10", 10, 10, 1.00);

insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456789, 19.99, "summary-book41", "4book1", 1, 1, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456788, 18.88, "summary-book42", "4book2", 2, 2, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456787, 17.77, "summary-book43", "4book3", 3, 3, 3.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456786, 16.66, "summary-book44", "4book4", 4, 4, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456785, 15.55, "summary-book45", "4book5", 5, 5, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456784, 14.44, "summary-4", "4book6", 6, 6, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456783, 13.33, "summary-book47", "4book7", 7, 7, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456782, 12.22, "summary-book48", "4book8", 8, 8, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456781, 11.11, "summary-book49", "4book9", 9, 9, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (423456780, 10.00, "summary-book410", "4book10", 10, 10, 1.00);

insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456789, 19.99, "summary-book51", "5book1", 1, 1, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456788, 18.88, "summary-book52", "5book2", 2, 2, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456787, 17.77, "summary-book53", "5book3", 3, 3, 3.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456786, 16.66, "summary-book54", "5book4", 4, 4, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456785, 15.55, "summary-book55", "5book5", 5, 5, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456784, 14.44, "summary-book56", "5book6", 6, 6, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456783, 13.33, "summary-book57", "5book7", 7, 7, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456782, 12.22, "summary-book58", "5book8", 8, 8, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456781, 11.11, "summary-book59", "5book9", 9, 9, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (523456780, 10.00, "summary-book510", "5book10", 10, 10, 1.00);

insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456789, 19.99, "summary-book61", "6book1", 1, 1, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456788, 18.88, "summary-book62", "6book2", 2, 2, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456787, 17.77, "summary-book63", "6book3", 3, 3, 3.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456786, 16.66, "summary-book64", "6book4", 4, 4, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456785, 15.55, "summary-book65", "6book5", 5, 5, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456784, 14.44, "summary-book66", "6book6", 6, 6, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456783, 13.33, "summary-book67", "6book7", 7, 7, 4.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456782, 12.22, "summary-book68", "6book8", 8, 8, 2.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456781, 11.11, "summary-book69", "6book9", 9, 9, 5.00);
insert into book (isbn, price, summary, title, genreid, publisherid, cost)
values (623456780, 10.00, "summary-book10", "6book10", 10, 10, 1.00);

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

insert into bookauthor (bookid, authorid)
values (11,1);
insert into bookauthor (bookid, authorid)
values (12,2);
insert into bookauthor (bookid, authorid)
values (13,3);
insert into bookauthor (bookid, authorid)
values (14,4);
insert into bookauthor (bookid, authorid)
values (15,5);
insert into bookauthor (bookid, authorid)
values (16,6);
insert into bookauthor (bookid, authorid)
values (17,7);
insert into bookauthor (bookid, authorid)
values (18,8);
insert into bookauthor (bookid, authorid)
values (19,9);
insert into bookauthor (bookid, authorid)
values (20,10);

insert into bookauthor (bookid, authorid)
values (21,1);
insert into bookauthor (bookid, authorid)
values (22,2);
insert into bookauthor (bookid, authorid)
values (23,3);
insert into bookauthor (bookid, authorid)
values (24,4);
insert into bookauthor (bookid, authorid)
values (25,5);
insert into bookauthor (bookid, authorid)
values (26,6);
insert into bookauthor (bookid, authorid)
values (27,7);
insert into bookauthor (bookid, authorid)
values (28,8);
insert into bookauthor (bookid, authorid)
values (29,9);
insert into bookauthor (bookid, authorid)
values (30,10);

insert into bookauthor (bookid, authorid)
values (31,1);
insert into bookauthor (bookid, authorid)
values (32,2);
insert into bookauthor (bookid, authorid)
values (33,3);
insert into bookauthor (bookid, authorid)
values (34,4);
insert into bookauthor (bookid, authorid)
values (35,5);
insert into bookauthor (bookid, authorid)
values (36,6);
insert into bookauthor (bookid, authorid)
values (37,7);
insert into bookauthor (bookid, authorid)
values (38,8);
insert into bookauthor (bookid, authorid)
values (39,9);
insert into bookauthor (bookid, authorid)
values (40,10);

insert into bookauthor (bookid, authorid)
values (41,1);
insert into bookauthor (bookid, authorid)
values (42,2);
insert into bookauthor (bookid, authorid)
values (43,3);
insert into bookauthor (bookid, authorid)
values (44,4);
insert into bookauthor (bookid, authorid)
values (45,5);
insert into bookauthor (bookid, authorid)
values (46,6);
insert into bookauthor (bookid, authorid)
values (47,7);
insert into bookauthor (bookid, authorid)
values (48,8);
insert into bookauthor (bookid, authorid)
values (49,9);
insert into bookauthor (bookid, authorid)
values (50,10);

insert into bookauthor (bookid, authorid)
values (51,1);
insert into bookauthor (bookid, authorid)
values (52,2);
insert into bookauthor (bookid, authorid)
values (53,3);
insert into bookauthor (bookid, authorid)
values (54,4);
insert into bookauthor (bookid, authorid)
values (55,5);
insert into bookauthor (bookid, authorid)
values (56,6);
insert into bookauthor (bookid, authorid)
values (57,7);
insert into bookauthor (bookid, authorid)
values (58,8);
insert into bookauthor (bookid, authorid)
values (59,9);
insert into bookauthor (bookid, authorid)
values (60,10);


insert into rating (rating, review, bookid, customerid, ratingdate)
values (1, "reveiwb1", 1, 1, '2015-01-06');
insert into rating (rating, review, bookid, customerid, ratingdate)
values (2, "reveiwb2", 2, 2, '2015-01-14' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (3, "reveiwb3", 3, 3, '2015-01-28' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (4, "reveiwb4", 4, 4, '2015-02-13' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (5, "reveiwb5", 5, 5, '2015-02-18' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (5, "reveiwb6", 6, 6, '2015-02-23' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (4, "reveiwb7", 7, 7, '2015-03-02' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (3, "reveiwb8", 8, 8, '2015-03-02' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (2, "reveiwb9", 9, 9, '2015-03-03' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (1, "reveiwb10", 10, 10, '2015-03-04');

insert into rating (rating, review, bookid, customerid, ratingdate)
values (3, "reveiwb1", 4, 1, '2015-01-08');
insert into rating (rating, review, bookid, customerid, ratingdate)
values (3, "reveiwb2", 5, 2, '2015-01-18' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (5, "reveiwb3", 8, 3, '2015-01-24' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (4, "reveiwb4", 9, 4, '2015-02-14' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (5, "reveiwb5", 10, 5, '2015-02-18' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (5, "reveiwb6", 4, 6, '2015-02-25' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (3, "reveiwb7", 8, 7, '2015-03-03' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (3, "reveiwb8", 7, 8, '2015-03-04' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (1, "reveiwb9", 10, 9, '2015-03-04' );
insert into rating (rating, review, bookid, customerid, ratingdate)
values (4, "reveiwb10", 9, 10, '2015-03-05');

insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (1,true, '20150101', 30.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (2,true, '2015-01-02', 50.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (3,true, '2015-01-08', 40.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (4,true, '2015-01-09', 20.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (5,true, '2015-01-15', 10.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (6,true, '2015-01-16', 90.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (7,true, '2015-01-22', 80.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (8,true, '2015-01-23', 70.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (9,true, '2015-01-29', 60.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (10,true, '2015-01-30', 30.00);

insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (1,true, '2015-02-01', 50.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (2,true, '2015-02-02', 30.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (3,true, '2015-02-08', 80.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (4,true, '2015-02-09', 20.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (5,true, '2015-02-15', 90.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (6,true, '2015-02-16', 20.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (7,true, '2015-02-22', 30.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (8,true, '2015-02-23', 10.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (9,true, '2015-02-27', 40.00);
insert into invoice (customerid, isprocessed, transactiondate, totalamount)
values (10,true, '2015-02-28', 80.00);

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

insert into inventory (bookid, quantity)
values (1, 20);
insert into inventory (bookid, quantity)
values (2, 20);
insert into inventory (bookid, quantity)
values (3, 20);
insert into inventory (bookid, quantity)
values (4, 20);
insert into inventory (bookid, quantity)
values (5, 20);
insert into inventory (bookid, quantity)
values (6, 20);
insert into inventory (bookid, quantity)
values (7, 20);
insert into inventory (bookid, quantity)
values (8, 20);
insert into inventory (bookid, quantity)
values (9, 20);
insert into inventory (bookid, quantity)
values (10, 20);

insert into inventory (bookid, quantity)
values (11, 20);
insert into inventory (bookid, quantity)
values (12, 20);
insert into inventory (bookid, quantity)
values (13, 20);
insert into inventory (bookid, quantity)
values (14, 20);
insert into inventory (bookid, quantity)
values (15, 20);
insert into inventory (bookid, quantity)
values (16, 20);
insert into inventory (bookid, quantity)
values (17, 20);
insert into inventory (bookid, quantity)
values (18, 20);
insert into inventory (bookid, quantity)
values (19, 20);
insert into inventory (bookid, quantity)
values (20, 20);


insert into inventory (bookid, quantity)
values (21, 20);
insert into inventory (bookid, quantity)
values (22, 20);
insert into inventory (bookid, quantity)
values (23, 20);
insert into inventory (bookid, quantity)
values (24, 20);
insert into inventory (bookid, quantity)
values (25, 20);
insert into inventory (bookid, quantity)
values (26, 20);
insert into inventory (bookid, quantity)
values (27, 20);
insert into inventory (bookid, quantity)
values (28, 20);
insert into inventory (bookid, quantity)
values (29, 20);
insert into inventory (bookid, quantity)
values (30, 20);

insert into inventory (bookid, quantity)
values (31, 20);
insert into inventory (bookid, quantity)
values (32, 20);
insert into inventory (bookid, quantity)
values (33, 20);
insert into inventory (bookid, quantity)
values (34, 20);
insert into inventory (bookid, quantity)
values (35, 20);
insert into inventory (bookid, quantity)
values (36, 20);
insert into inventory (bookid, quantity)
values (37, 20);
insert into inventory (bookid, quantity)
values (38, 20);
insert into inventory (bookid, quantity)
values (39, 20);
insert into inventory (bookid, quantity)
values (40, 20);

insert into inventory (bookid, quantity)
values (41, 20);
insert into inventory (bookid, quantity)
values (42, 20);
insert into inventory (bookid, quantity)
values (43, 20);
insert into inventory (bookid, quantity)
values (44, 20);
insert into inventory (bookid, quantity)
values (45, 20);
insert into inventory (bookid, quantity)
values (46, 20);
insert into inventory (bookid, quantity)
values (47, 20);
insert into inventory (bookid, quantity)
values (48, 20);
insert into inventory (bookid, quantity)
values (49, 20);
insert into inventory (bookid, quantity)
values (50, 20);

insert into inventory (bookid, quantity)
values (51, 20);
insert into inventory (bookid, quantity)
values (52, 20);
insert into inventory (bookid, quantity)
values (53, 20);
insert into inventory (bookid, quantity)
values (54, 20);
insert into inventory (bookid, quantity)
values (55, 20);
insert into inventory (bookid, quantity)
values (56, 20);
insert into inventory (bookid, quantity)
values (57, 20);
insert into inventory (bookid, quantity)
values (58, 20);
insert into inventory (bookid, quantity)
values (59, 20);
insert into inventory (bookid, quantity)
values (60, 20);