insert into tb_role(role_name) values ('ADMIN');
insert into tb_role(role_name) values ('TECHNICIAN');
insert into tb_role(role_name) values ('CLIENT');

insert into tb_user(username, password) values ('admin', '$2y$10$sO9GDKfV.2asQ4mwT4awBuH/0JQINu4qIvIJwkdurO2J.Vm30C8C2');
insert into tb_user_has_role (id_user, id_role) values (1, 1);

insert into tb_address(street, number, cep, neighborhood, city, complement) values ('rua 1', '83', '58400448', 'são josé', 'campina grande', 'proximo ao posto maia');

insert into tb_technician(name, cpf, phone_number, email, id_address) values ('Lucas de Lucena Siqueira', '10891726489', '83986907270', 'lucas.lucenak@gmail.com', 1);

insert into tb_client(name, cpf, phone_number, email, id_address) values ('Cliente', '10891726489', '83986907270', 'client@email.com', 1);

insert into tb_user(username, password) values ('10891726489', '$2y$10$xElf0FqRi80b.6OrtUXfUedB4Rl02hGKCjQyZovcEcoJGCjqsmasy');
insert into tb_user_has_role (id_user, id_role) values (2, 3);

insert into tb_os(id_client, id_technician, equipment, estimated_value, payment_method, installments, payed_installments, observation) values (1, 1, 'Computador', 1250.30, 'PIX', 1, 1, 'Formatação completa');

select * from tb_address;
select * from tb_client tc ;
select * from tb_os to2 ;
select * from tb_role tr ;
select * from tb_technician tt ;
select * from tb_user tu ;
select * from tb_user_has_role tuhr ;