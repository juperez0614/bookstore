use bookstore; 

SELECT DISTINCT title from book
join lineItem on book.id = lineitem.BookId
order by lineItem.Quantity desc limit 5; 




select title FROM LineItem 
join book on book.id = lineItem.BookId
Group By bookid
order by sum(quantity) desc limit 5;

