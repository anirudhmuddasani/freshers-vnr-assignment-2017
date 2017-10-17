---- creating an database for the order to cook


USE  DATABASE havemore;

CREATE TABLE order(
	order id int UNIQUE ,
	itemname        varchar(15),
	quantity int,
	
	
	primary key (order.id)

);
	
