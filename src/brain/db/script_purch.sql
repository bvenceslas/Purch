create database db_purch

go
use db_purch

-- creation des tables



--access_setup
go 
create table t_access_setup
(
	id int not null,	
	access_setup varchar(255) not null, -- super admin, admin, vendeur, magasinier
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
	category varchar(255),
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
	id_user int not null,
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
	id_user int not null,
	primary key clustered
	(
		id asc
	)
)
