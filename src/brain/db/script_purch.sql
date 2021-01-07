create database db_purch

go
use db_purch

-- Creation of tables



--access_setup
go 
create table t_access_setup
(
	id int not null,	
	access_level varchar(255) not null, -- super admin, admin, vendeur, magasinier
	primary key clustered
	(
		id
	)
)

--login
go
create table t_login
(
	username varchar(255) not null,
	pwd varchar(255) not null,
	access_level varchar(50), 
	primary key clustered
	(
		username
	)
)

--soft
go 
create table t_soft
(
	id int not null,
	soft varchar(255) not null, -- keep up the history of names of the software, but only select the last
	primary key clustered
	(
		id
	)
)

--gamme
go 
create table t_gamme
(
	id int not null,
	gamme varchar(255) not null, -- genre of producs
	primary key clustered
	(
		id
	)
)

--category
go 
create table t_category
(
	id int not null,
	category varchar(255) not null,
	id_gamme int not null,
	primary key clustered
	(
		id
	)
)


--quantification
go 
create table t_quantification
(
	id int not null,
	quantification varchar(255) not null, -- boite, ampoule, carton, piece, etc..
	primary key clustered
	(
		id
	)
)

--product
go
create table t_product
(
	id int not null,
	product varchar(255),
	quantification text, 
	price float,
	stock float default 0,
	id_categoy int not null,
	primary key clustered
	(
		id
	)
)

--provider
go
create table t_provider
(
	id int not null,
	nom varchar(50), 
	prenom varchar(50), 
	contact varchar(13), 
	addresse varchar(255),
	primary key clustered
	(
		id
	)
)

--client
go
create table t_client
(
	id int not null,
	nom varchar(50), 
	prenom varchar(50), 
	contact varchar(13), 
	addresse varchar(255),
	primary key clustered
	(
		id
	)
)


--providding
go
create table t_providding 
(
	id int not null,
	id_provider int not null,
	date_providding date,
	primary key clustered
	(
		id asc
	)
)

--line providing
go
create table t_line_providding 
(
	id_providding int not null,
	id_product int not null,
	qty float,
	price float,
	primary key clustered
	(
		id_providding,
		id_product
	)
)

-- purchase
go
create table t_purchase
(
	id int not null,
	id_client int not null,
	username varchar(255) not null,
	date_purchase date,
	primary key clustered
	(
		id asc
	)
)

-- line purchase
go
create table t_line_purchase
(
	id_purchase int not null,
	id_product int not null,
	qty float,
	reduction float,
	primary key clustered
	(
		id_purchase,
		id_product
	)
)

--payment
go
create table t_payment
(
	id int not null,
	id_purchase int not null,
	amount float,
	date_payment date,
	username varchar(255) not null,
	primary key clustered
	(
		id asc
	)
)


-- Creation of constraints

alter table t_category with check add constraint fk_gamme_category foreign key(id_gamme) references t_gamme(id)

alter table t_product with check add constraint fk_category_product foreign key(id_categoy) references t_category(id)

alter table t_providding with check add constraint fk_provider_providding foreign key(id_provider) 
references t_provider(id)

alter table t_line_providding with check add constraint fk_providding_line_providding foreign key(id_providding) 
references t_providding(id)
alter table t_line_providding with check add constraint fk_product_line_providding foreign key(id_product) 
references t_product(id)

alter table t_purchase with check add constraint fk_client_purchase foreign key(id_client) 
references t_client(id)
alter table t_purchase with check add constraint fk_user_purchase foreign key(username) 
references t_login(username)

alter table t_line_purchase with check add constraint fk_purchase_line_purchase foreign key(id_purchase) 
references t_purchase(id)
alter table t_line_purchase with check add constraint fk_product_line_purchase foreign key(id_product) 
references t_product(id)

alter table t_payment with check add constraint fk_purchase_payment foreign key(id_purchase) 
references t_purchase(id)
alter table t_payment with check add constraint fk_user_payment foreign key(username) 
references t_login(username)


-- Creation of Stored procedures

--access_setup
go
create procedure sp_update_access_setup
(	
	@id int,
	@access_level varchar(255)
)
as 
begin
	if not exists(select * from t_access_setup where id = @id)
		insert into t_access_setup values(@id, @access_level)
	else
		update t_access_setup set access_level = @access_level where id = @id
end

--login
go
create procedure sp_update_login
(
	@username varchar(255),
	@pwd varchar(255),
	@access_level varchar(50)
)
as
begin
	if not exists(select * from t_login where username = @username)
		insert into t_login values (@username, @pwd, @access_level)
	else
		update t_login set pwd = @pwd, access_level = @access_level where username = @username
end


--soft
go 
create procedure sp_update_soft
(
	@id int,
	@soft varchar(255)
)
as
begin
	if not exists(select * from t_soft where id = @id)
		insert into t_soft values(@id, @soft)
	else
		update t_soft set soft = @soft where id = @id
end

--gamme
go 
create procedure sp_update_gamme
(
	@id int,
	@gamme varchar(255)
)
as
begin
	if not exists(select * from t_gamme where id = @id)
		insert into t_gamme values(@id, @gamme)
	else
		update t_gamme set gamme = @gamme where id = @id
end

--category
go 
create procedure sp_update_tcategory
(
	@id int,
	@category varchar(255),
	@gamme int 
)
as
begin
	declare @id_gamme int = (select id from t_gamme where gamme = @gamme)
	if not exists(select * from t_category where id = @id)
		insert into t_category values(@id, @category, @id_gamme)
	else
		update t_category set category = @category, id_gamme = @id_gamme where id = @id
end


--quantification
go 
create procedure sp_update_quantification
(
	@id int,
	@quantification varchar(255)
)
as
begin
	if not exists(select * from t_quantification where id = @id)
		insert into t_quantification values(@id, @quantification)
	else
		update t_quantification set quantification = @quantification where id = @id
end


--product
go
create procedure sp_update_product
(
	@id int,
	@product varchar(255),
	@quantification text, 
	@price float,
	@stock float,
	@categoy varchar(255)
)
as
begin
	declare @id_category int = (select id from t_category where category = @categoy)
	if not exists(select * from t_product where id = @id)
		insert into t_product values(@id, @product, @quantification, @price, @stock, @id_category)
	else
		update t_product set product = @product, quantification = @quantification, price = @price, stock = @stock, id_categoy = @id_category where id = @id
end

--provider
go
create procedure sp_update_provider
(
	@id int,
	@nom varchar(50), 
	@prenom varchar(50), 
	@contact varchar(13), 
	@addresse varchar(255)
)
as
begin
	if not exists(select * from t_provider where id = @id)
		insert into t_provider values(@id, @nom, @prenom, @contact, @addresse)
	else
		update t_provider set nom = @nom, prenom = @prenom, contact = @contact, addresse = @addresse where id = @id
end


--client
go
create procedure sp_update_client
(
	@id int,
	@nom varchar(50), 
	@prenom varchar(50), 
	@contact varchar(13), 
	@addresse varchar(255)
)
as
begin
	if not exists(select * from t_client where id = @id)
		insert into t_client values(@id, @nom, @prenom, @contact, @addresse)
	else
		update t_client set nom = @nom, prenom = @prenom, contact = @contact, addresse = @addresse where id = @id
end


--line providing and providding
go
create procedure sp_update_line_providding 
(
	@id int,
	@provider varchar(255),
	@date_providding date,
	@product  varchar(255),
	@qty float,
	@price float
)
as
begin
	-- get provider id
	declare @id_provider int = (select id  from t_provider where concat(nom, ' ', prenom) = @provider)
	-- get product id
	declare @id_product int = (select id  from t_product where product = @product)

	-- first the providding table
	if not exists(select * from t_providding where id = @id)
		insert into t_providding values (@id, @id_provider, @date_providding)
	else
		update t_providding set id_provider = @id_provider, date_providding = @date_providding where id = @id

	-- now the line_providding
	if not exists (select * from t_line_providding where id_providding = @id and id_product = @id_product)
		begin
			insert into t_line_providding values(@id, @id_product, @qty, @price)
			update t_product set stock = (stock + @qty) where id = @id_product
		end
	else
		begin
			update t_line_providding set qty = @qty, price = @price where id_providding = @id and id_product = @id_product
			-- decrease the last value of the quantity
			declare @qty_init float = (select qty from t_line_providding where id_providding = @id and id_product = @id_product)
			update t_product set stock = (stock - @qty_init) + @qty where id = @id_product
		end
end


-- line purchase and purchase
go
create procedure sp_update_line_purchase
(
	@id int,
	@client varchar(255),
	@username varchar(255),
	@date_purchase date,
	@id_purchase int,
	@product varchar(255),
	@qty float,
	@reduction float
)
as
begin
	-- get client id
	declare @id_client int = (select id  from t_client where concat(nom, ' ', prenom) = @client)
	-- get product id
	declare @id_product int = (select id  from t_product where product = @product)
	-- get the stock of the product
	declare @actual_stock float = (select stock from t_product where id = @id_product)
		if @qty <= @actual_stock
			begin
				-- first the purchase table
				if not exists(select * from t_purchase where id = @id)
					insert into t_purchase values (@id, @id_client, @date_purchase, @username)
				else
					update t_purchase set id_client = @id_client, date_purchase = @date_purchase, username = @username where id = @id

				-- now the line_purchase
				if not exists (select * from t_line_purchase where id_purchase = @id and id_product = @id_product)
					begin
						insert into t_line_purchase values(@id, @id_product, @qty, @reduction)
						update t_product set stock = (stock - @qty) where id = @id_product
					end
				else
					begin
						update t_line_purchase set qty = @qty, reduction = @reduction where id_purchase = @id and id_product = @id_product
						-- increase the value of the quantity
						declare @qty_init float = (select qty from t_line_purchase where id_purchase = @id and id_product = @id_product)
						update t_product set stock = (stock + @qty_init) - @qty where id = @id_product
					end
			end
		else
			print 'STOCK INSUFFISANT'
end


--payment
go
create procedure sp_update_payment
(
	@id int,
	@id_purchase int,
	@amount float,
	@date_payment date,
	@username varchar(255)
)
as
begin
	if not exists(select * from t_payment where id = @id)
		insert into t_payment values(@id, @id_purchase, @amount, @date_payment, @username)
	else
		update t_payment set id_purchase = @id_purchase, amount = @amount, date_payment = @date_payment, username = @username where id = @id
end