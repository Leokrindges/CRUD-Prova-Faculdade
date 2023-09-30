
select * from Categoria;

select * from musica;

select * from usuario;

create table Categoria (
	id serial,
	descricao varchar not null	
);

create table musica (
	id serial,
	Categoria_id varchar not null,
	titulo varchar not null,
	data_lançamento date not null	
);

insert into usuario values(default,'admim', 'admim');
insert into usuario values(default,'juca', 'bala');

insert into Categoria values(default,'Rock');
insert into Categoria values(default, 'Reggae');
insert into Categoria values(default, 'Jazz');

--criando a tabela usuario
create table usuario(
	id serial,
	usuario varchar(150),
	senha varchar(200)
);