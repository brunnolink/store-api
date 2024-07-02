INSERT INTO restaurant (id, cep, complement, name) VALUES
(1L, '50870750', 'B1', 'Lanchonete seu Ze'),
(2L, '50421460', 'B2', 'Rei do pastel');

INSERT INTO client (id, cep, complement, name) VALUES
(1L, '50870750', 'B1', 'Brunno Assuncao');

INSERT INTO product (id, available, name, unitary_value, restaurant_id) VALUES
(1L, true, 'coca em lata', 5.5, 1L),
(2L, true, 'Coxinha do rei', 8.0, 1L),
(3L, true, 'Pastel 8 sabores', 10.5, 2L);

INSERT INTO bag (id, payment_form, close, total_value, client_id) VALUES
(1L, 0, false, 0.0, 1L);


