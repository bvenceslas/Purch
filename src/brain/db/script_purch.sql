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

--produit
go
create table t_produit
(
	id int not null,
	produit varchar(255),
	quantification text, 
	prix float,
	stock float default 0,
	id_categoy int not null,
	primary key clustered
	(
		id
	)
)

--fournisseur
go
create table t_fournisseur
(
	id int not null,
	nom varchar(50), 
	prenom varchar(50), 
	contact varchar(13),
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
	primary key clustered
	(
		id
	)
)


--provision
go
create table t_provision 
(
	id int not null,
	id_fournisseur int not null,
	date_provision date,
	primary key clustered
	(
		id asc
	)
)

--line providing
go
create table t_ligne_provision 
(
	id_provision int not null,
	id_produit int not null,
	qty float,
	price float,
	primary key clustered
	(
		id_provision,
		id_produit
	)
)

-- achat
go
create table t_achat
(
	id int not null,
	id_client int not null,
	username varchar(255) not null,
	date_achat date,
	primary key clustered
	(
		id asc
	)
)

-- line achat
go
create table t_line_achat
(
	id_achat int not null,
	id_produit int not null,
	qty float,
	reduction float,
	primary key clustered
	(
		id_achat,
		id_produit
	)
)

--payment
go
create table t_payment
(
	id int not null,
	id_achat int not null,
	montant float,
	date_payment date,
	username varchar(255) not null,
	primary key clustered
	(
		id asc
	)
)


-- Creation of constraints

alter table t_category with check add constraint fk_gamme_category foreign key(id_gamme) references t_gamme(id)

alter table t_produit with check add constraint fk_category_produit foreign key(id_categoy) references t_category(id)

alter table t_provision with check add constraint fk_fournisseur_provision foreign key(id_fournisseur) 
references t_fournisseur(id)

alter table t_ligne_provision with check add constraint fk_provision_ligne_provision foreign key(id_provision) 
references t_provision(id)
alter table t_ligne_provision with check add constraint fk_produit_ligne_provision foreign key(id_produit) 
references t_produit(id)

alter table t_achat with check add constraint fk_client_achat foreign key(id_client) 
references t_client(id)
alter table t_achat with check add constraint fk_user_achat foreign key(username) 
references t_login(username)

alter table t_line_achat with check add constraint fk_achat_line_achat foreign key(id_achat) 
references t_achat(id)
alter table t_line_achat with check add constraint fk_produit_line_achat foreign key(id_produit) 
references t_produit(id)

alter table t_payment with check add constraint fk_achat_payment foreign key(id_achat) 
references t_achat(id)
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


--produit
go
create procedure sp_update_produit
(
	@id int,
	@produit varchar(255),
	@quantification text, 
	@price float,
	@stock float,
	@categoy varchar(255)
)
as
begin
	declare @id_category int = (select id from t_category where category = @categoy)
	if not exists(select * from t_produit where id = @id)
		insert into t_produit values(@id, @produit, @quantification, @price, @stock, @id_category)
	else
		update t_produit set produit = @produit, quantification = @quantification, price = @price, stock = @stock, id_categoy = @id_category where id = @id
end

--fournisseur
go
create procedure sp_update_fournisseur
(
	@id int,
	@nom varchar(50), 
	@prenom varchar(50), 
	@contact varchar(13), 
	@addresse varchar(255)
)
as
begin
	if not exists(select * from t_fournisseur where id = @id)
		insert into t_fournisseur values(@id, @nom, @prenom, @contact, @addresse)
	else
		update t_fournisseur set nom = @nom, prenom = @prenom, contact = @contact, addresse = @addresse where id = @id
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


--line providing and provision
go
create procedure sp_update_ligne_provision 
(
	@id int,
	@fournisseur varchar(255),
	@date_provision date,
	@produit  varchar(255),
	@qty float,
	@price float
)
as
begin
	-- get fournisseur id
	declare @id_fournisseur int = (select id  from t_fournisseur where concat(nom, ' ', prenom) = @fournisseur)
	-- get produit id
	declare @id_produit int = (select id  from t_produit where produit = @produit)

	-- first the provision table
	if not exists(select * from t_provision where id = @id)
		insert into t_provision values (@id, @id_fournisseur, @date_provision)
	else
		update t_provision set id_fournisseur = @id_fournisseur, date_provision = @date_provision where id = @id

	-- now the ligne_provision
	if not exists (select * from t_ligne_provision where id_provision = @id and id_produit = @id_produit)
		begin
			insert into t_ligne_provision values(@id, @id_produit, @qty, @price)
			update t_produit set stock = (stock + @qty) where id = @id_produit
		end
	else
		begin
			update t_ligne_provision set qty = @qty, price = @price where id_provision = @id and id_produit = @id_produit
			-- decrease the last value of the quantity
			declare @qty_init float = (select qty from t_ligne_provision where id_provision = @id and id_produit = @id_produit)
			update t_produit set stock = (stock - @qty_init) + @qty where id = @id_produit
		end
end


-- line achat and achat
go
create procedure sp_update_line_achat
(
	@id int,
	@client varchar(255),
	@username varchar(255),
	@date_achat date,
	@produit varchar(255),
	@qty float,
	@reduction float
)
as
begin
	-- get client id
	declare @id_client int = (select id  from t_client where concat(nom, ' ', prenom) = @client)
	-- get produit id
	declare @id_produit int = (select id  from t_produit where produit = @produit)
	-- get the stock of the produit
	declare @actual_stock float = (select stock from t_produit where id = @id_produit)
		if @qty <= @actual_stock
			begin
				-- first the achat table
				if not exists(select * from t_achat where id = @id)
					insert into t_achat values (@id, @id_client, @date_achat, @username)
				else
					update t_achat set id_client = @id_client, date_achat = @date_achat, username = @username where id = @id

				-- now the line_achat
				if not exists (select * from t_line_achat where id_achat = @id and id_produit = @id_produit)
					begin
						insert into t_line_achat values(@id, @id_produit, @qty, @reduction)
						update t_produit set stock = (stock - @qty) where id = @id_produit
					end
				else
					begin
						update t_line_achat set qty = @qty, reduction = @reduction where id_achat = @id and id_produit = @id_produit
						-- increase the value of the quantity
						declare @qty_init float = (select qty from t_line_achat where id_achat = @id and id_produit = @id_produit)
						update t_produit set stock = (stock + @qty_init) - @qty where id = @id_produit
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
	@id_achat int,
	@amount float,
	@date_payment date,
	@username varchar(255)
)
as
begin
	if not exists(select * from t_payment where id = @id)
		insert into t_payment values(@id, @id_achat, @amount, @date_payment, @username)
	else
		update t_payment set id_achat = @id_achat, amount = @amount, date_payment = @date_payment, username = @username where id = @id
end