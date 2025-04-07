INSERT INTO medico(id, crm, cpf, nome, telefone) VALUES(1, '1253', '32426849', 'Dr. Anderson', '984780584')
INSERT INTO medico(id, crm, cpf, nome, telefone) VALUES(2, '1253', '32426849', 'Dr. Paulo', '984780584')

INSERT INTO paciente(id, cpf, nome, telefone) VALUES(3, '06241688106', 'Joao Vitor', '984780584')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(4, '06551688306', 'Fagno', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(5, '06351644306', 'Emmerson', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(6, '06351644306', 'Renato', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(7, '06351644306', 'Hugo', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(8, '06351644306', 'Matheus', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(9, '06351644306', 'Lucas', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(10, '06351644306', 'Tenorio', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(11, '06351644306', 'William', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(12, '06351644306', 'Lalyet', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(13, '06351644306', 'Samuel', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(14, '06351644306', 'Daniel', '984720554')
INSERT INTO paciente(id, cpf,  nome, telefone) VALUES(15, '06351644306', 'Anderson', '984720554')

INSERT INTO consulta(id, data, valor, id_medico, id_paciente, observacao) values (1, '20230921', 100.0, 2, 3, 'teste')
INSERT INTO consulta(id, data, valor, id_medico, id_paciente, observacao) values (2, '20230921', 70.0, 2, 4, 'teste')
INSERT INTO consulta(id, data, valor, id_medico, id_paciente, observacao) values (3, '20230921', 60.0, 2, 5, 'teste')

INSERT INTO perfil(id, nome) values (1, 'ROLE_ADMIN')
INSERT INTO perfil(id, nome) values (2, 'ROLE_ATENDENTE')
INSERT INTO perfil(id, nome) values (3, 'ROLE_MEDICO')

INSERT INTO usuario(id, pessoaID, login, senha) values (1, 1, 'admin', '$2a$10$MzBPcGHwyBgjNp2BjyAtbespp4q5Z9Ns/XKUjaYtdSjEhn8Q21B4i') --admin do sistema
INSERT INTO usuario(id, pessoaID, login, senha) values (2, 3, 'joao', '$2a$10$MzBPcGHwyBgjNp2BjyAtbespp4q5Z9Ns/XKUjaYtdSjEhn8Q21B4i') -- atendente
INSERT INTO usuario(id, pessoaID, login, senha) values (3, 2, 'dr.paulo', '$2a$10$MzBPcGHwyBgjNp2BjyAtbespp4q5Z9Ns/XKUjaYtdSjEhn8Q21B4i') --médico

INSERT INTO usuario_perfis(perfis_id, usuario_id) values (1, 1)
INSERT INTO usuario_perfis(perfis_id, usuario_id) values (2, 2)
INSERT INTO usuario_perfis(perfis_id, usuario_id) values (3, 3)

INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 08:00', 1,'false');
INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 09:00', 1,'true');
INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 10:00', 1,'true');
INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 11:00', 1,'true');
INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 14:00', 1,'true');
INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 15:00', 1,'true');
INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 16:00', 1,'true');
INSERT INTO agenda (horario_inicio, pessoa_Id, disponivel) VALUES ('2023-04-17 17:00', 1,'true');

INSERT INTO agendamento (data_nascimento, agenda_id, nome, observacoes, telefone) VALUES ('1990-01-01', 1, 'João Silva', 'Consulta de rotina', '(11) 1234-5678');




