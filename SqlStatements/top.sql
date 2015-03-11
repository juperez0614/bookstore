use bookstore; 
select * from userrole;
SELECT DISTINCT title from book
join lineItem on book.id = lineitem.BookId
order by lineItem.Quantity desc limit 5; 

delete from rating where id = 32; 

Select sum(totalamount) from invoice where Transactiondate between '2015-01-01' and '2015-03-07'; 




Select sum(totalamount), transactiondate, week(transactiondate, 1) from invoice group by week(transactiondate, 1);

Select sum(totalamount), transactiondate, month(transactiondate) from invoice group by month(transactiondate);


select DATEFIRST 6; 
SELECT      DATEPART(wk, Transactiondate)     weekno
        ,   SUM(totalamount)           totalvalue
FROM        invoice
GROUP BY    DATEPART(wk, datevalue);

select * from userauth;
select * from book where id = 57;
Insert into BookAuthor (BookId, AuthorId)
Values (1, 3);
select * from bookauthor where bookid = 1;

SELECT * FROM Rating WHERE bookId = 4 order by RatingDate DESC;
select * from inventory;
delete from rating where bookid = 60;
select * from customer;

UPDATE inventory SET Quantity = 20 where bookid > 0; 


select book.id, book.title, lineItem.Quantity from book
join genre on genre.id = book.genreid
left join lineitem on lineitem.bookid = book.id
where genre.genre = "action"
group by book.id
order by sum(lineitem.quantity) desc;


select book.id, book.title, sum(lineitem.quantity), genre.genre from book
inner join genre on genre.id = book.genreid
join lineitem on lineitem.bookid = book.id
where genre.id = 3
group by book.Id
order by (CASE WHEN sum(lineitem.quantity) IS NOT NULL Then sum(lineitem.quantity)
				ELSE book.title end) desc;

select book.id as id, book.title, genre.genre from book
inner join genre on genre.id = book.genreid 
where genre.id = 3;

select book.id, lineitem.quantity, lineitem.invoiceid from book 
 join lineitem on book.Id = lineitem.bookid;

SELECT book.id, sum(lineitem.quantity), genre.genre FROM book 
join genre on book.genreid = genre.id
Left JOIN lineItem ON book.id = lineitem.bookid 
where genre.id = 4
group by book.id
order by sum(lineitem.quantity) desc;

select book.isbn, book.title from book;

delete from inventory where bookid <= 10;
select * from bookauthor 
join author on author.id = bookauthor.AuthorId
where author.firstname = "john" and author.lastname = "Mclain";

select * from book 
join publisher on book.publisherid = publisher.id;

select * from Book where title Like "%book%";

select * from author;

Select * from invoice;

select * from userauth where Username = 'new use';

Select * from lineitem;

Select * from inventory;

SELECT  * from invoice;

select * from customer;

select book.id, book.title, lineItem.Quantity FROM book 
join lineItem on book.id = lineItem.BookId
join invoice on lineItem.InvoiceId = invoice.Id
Where invoice.transactionDate between DATE_SUB(CURDATE(), INTERVAL 7 DAY) and CURDATE()
Group By LineItem.bookid
order by sum(quantity) desc limit 10;

select book.title, rating.rating FROM book 
join rating on book.id = rating.BookId
join invoice on b
Group By book.id
order by rating.rating desc limit 10;

select * from invoice; 


select * from invoice Where transactionDate = DATE_SUB(CURDATE(), INTERVAL 6 DAY);

select sum(book.price * lineItem.quantity) as bTotal FROM LineItem 
join book on book.id = lineItem.BookId
join invoice on invoice.id = lineitem.InvoiceId
where invoice.id = 37;

select * from lineitem where invoiceid =37;

select * from book 
inner Join genre on book.GenreId = genre.Id
where genre.genre LIKE  '%suSpense%';

select * from book 
inner Join genre on book.GenreId = genre.Id
where genre.genre = 'SuSpense';

select * from author 
inner join bookauthor on author.Id = bookauthor.AuthorId
where bookauthor.BookId = 1;

select SUM(totalamount) as weeklysales from invoice 
where TransactionDate  between '2015-01-01' and '2015-01-07' and totalamount is not null;

select SUM(totalamount) as monthlysales from invoice 
where TransactionDate  between '2015-01-01' and '2015-01-30' and totalamount is not null;

select sum(totalProfit) as Weeklysales from weeklyprofits 
where Weekid = 1 AND weekId = 2;

select inventory.quantity, lineitem.quantity, (inventory.quantity - lineitem.quantity) from lineitem 
inner join inventory on lineitem.bookid = inventory.bookid 
where lineItem.invoiceid = 37;

select * from userauth;

select * from weeklyprofits;



SELECT a.emp_id AS "Emp_ID",a.emp_name AS "Employee Name",  
b.emp_id AS "Supervisor ID",b.emp_name AS "Supervisor Name"  
FROM employee a, employee b  
WHERE a.emp_supv = b.emp_id; 

select * from invoice;

select sum(totalamount) from invoice where isprocessed = true and transactiondate >'2015-01-01';

select Sum(Book.price * lineItem.quantity) as cost, sum(TotalAmount) as sales, (sum(TotalAmount) - Sum(Book.price * lineItem.quantity)) as profit, week(transactiondate, 1) 
 from lineItem inner join Book on book.Id = lineItem.BookId
 inner join Invoice on lineItem.InvoiceId = Invoice.Id
 where IsProcessed = True
 group by week(TransactionDate); 

select Sum(Book.price * lineItem.quantity) as cost, sum(TotalAmount) as sales, (sum(TotalAmount) - Sum(Book.price * lineItem.quantity)) as profit, month(transactiondate) 
 from lineItem inner join Book on book.Id = lineItem.BookId
 inner join Invoice on lineItem.InvoiceId = Invoice.Id
 where TransactionDate > '2015-01-01' group by extract(YEAR_MONTH from TransactionDate); 