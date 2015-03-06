use bookstore; 
select * from userrole;
SELECT DISTINCT title from book
join lineItem on book.id = lineitem.BookId
order by lineItem.Quantity desc limit 5; 

select * from userauth;

select * from book;


UPDATE LineItem SET BookId =  
				+ "quantity = ?, " + "InvoiceId = ?, "
						+ "WHERE id = ?";


Select * from invoice;

select * from userauth where Username = 'new use';

Select * from lineitem;

Select * from inventory;

SELECT  * from invoice;

select * from customer;

select book.title, lineItem.Quantity FROM book 
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

select (Sum(Book.price * lineItem.quantity) - sum(Book.cost * lineItem.quantity)) AS Profit 
 from lineItem inner join Book on book.Id = lineItem.BookId
 inner join Invoice on lineItem.InvoiceId = Invoice.Id
 where TransactionDate between '2015-01-01' and '2015-02-30'; 