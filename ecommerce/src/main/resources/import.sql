insert into categoria (nome, descricao) values ('Livros', 'Livros Técnicos');
insert into categoria (nome, descricao) values ('Eletrônicos', 'Equipamentos Eletrônicos');
insert into categoria (nome, descricao) values ('Escritório', 'Material de Escritório');
insert into categoria (nome, descricao) values ('Veículos' , 'Veículos de Trabalho');
insert into categoria (nome, descricao) values ('Ferramentas', 'Chave de fenda, Escadas e Afins');

insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Código Limpo', 'Livro do Autor Robert Martin', 73.44, 20, 1);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Computador', 'Positivo Sim+', 150.66, 3, 2);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Grampeador', 'JocarOffice', 15.00, 10, 3);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Carro', 'Savuno 1996', 75000.00, 1, 4);
insert into produto (nome, descricao, preco, estoque, categoria_id) values ('Furadeira', 'Makita', 510.00, 8, 5);

insert into cliente (nome, email, telefone) values ('Mike','mikeBaguncinha@hotmail.com','43996905193');
insert into cliente (nome, email, telefone) values ('José Luis','blackRiverAndOnlyLemons@Yahoo.com','43940028922');
insert into cliente (nome, email, telefone) values ('Chico','sadatoshiHamadan34@outlook.com','11998272706');
insert into cliente (nome, email, telefone) values ('Nanda','gabiestrelinha22@gmail.com','43988342714');
insert into cliente (nome, email, telefone) values ('Janga','jangasilmoeshumanski@gmail.com','11991423639');

insert into pedido (`data`, `status`, valor_total, cliente_id) values ('2026-06-14 14:36:25', 'inativo', 73.44, 2);
insert into pedido (`data`, `status`, valor_total, cliente_id) values ('2026-06-24 17:46:35', 'inativo', 510.00, 4);
insert into pedido (`data`, `status`, valor_total, cliente_id) values ('2026-06-22 22:39:26', 'inativo', 146.88, 3);
insert into pedido (`data`, `status`, valor_total, cliente_id) values ('2026-07-26 09:25:33', 'inativo', 75000.00, 1);
insert into pedido (`data`, `status`, valor_total, cliente_id) values ('2026-06-07 13:37:49', 'inativo', 73.44, 5);

insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 73.44, 1, 1);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 510.00, 2, 5);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (2, 73.44, 3, 1);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 75000.00, 4, 4);
insert into item_pedido (quantidade, valor_unitario, pedido_id, produto_id) values (1, 73.44, 5, 1);

insert into pagamento (valor, `data`, `status`, tipo, pedido_id) values (73.44, '2026-07-29 13:48:44', 'pago', 'pix', 1);
insert into pagamento (valor, `data`, `status`, tipo, pedido_id) values (510.00, '2026-07-30 11:56:49', 'pago', 'dinheiro',2);
insert into pagamento (valor, `data`, `status`, tipo, pedido_id) values (146.88, '2026-08-09 13:33:54', 'pago', 'cartao de credito', 3);
insert into pagamento (valor, `data`, `status`, tipo, pedido_id) values (75000.00, '2026-08-22 14:21:35', 'pago', 'cartao de debito', 4);
insert into pagamento (valor, `data`, `status`, tipo, pedido_id) values (73.44, '2026-09-03 10:42:42', 'pago', 'vale afucar', 5);