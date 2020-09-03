INSERT INTO usuarios(activo, apellidos, email, fecha_nacimiento, nombre, username, password, foto) VALUES (true, 'DA SILVA LOPEZ', 'jdasilva1980@gmail.com', NOW(), 'JOSE MANUEL', 'jdasilva1980', '$2a$10$YMROzpPbWViO88QOMikmKuhc2.YVEP54AfKj4AfRYfSf8y5S3PkC6', 'jose.jpg');
INSERT INTO usuarios(activo, apellidos, email, fecha_nacimiento, nombre, username, password, foto) VALUES (true, 'DA SILVA LOPEZ', 'rosam1980@gmail.com',  NOW(), 'ROSA MARIA', 'rosamaria67', '$2a$10$qPOb9Yi/VDJVcI9ji/huhO.cChgPXf64.l3cheMweffizDr99b8yO', 'rosa.jpg');
INSERT INTO usuarios(activo, apellidos, email, fecha_nacimiento, nombre, username, password, foto) VALUES (true, 'DA SILVA LOPEZ', 'rosam1980@gmail.com',  NOW(), 'LUA', 'lua2012', '$2a$10$qPOb9Yi/VDJVcI9ji/huhO.cChgPXf64.l3cheMweffizDr99b8yO', 'lua.jpg');

INSERT INTO authorities(role, descripcion) VALUES ('ROLE_ADMIN', 'ADMINISTRADOR');
INSERT INTO authorities(role, descripcion) VALUES ('ROLE_USER', 'USER');

INSERT INTO usuarios_authorities(usuario_id, authority_id) VALUES (1, 1);
INSERT INTO usuarios_authorities(usuario_id, authority_id) VALUES (1, 2);
INSERT INTO usuarios_authorities(usuario_id, authority_id) VALUES (2, 1);
INSERT INTO usuarios_authorities(usuario_id, authority_id) VALUES (2, 2);
INSERT INTO usuarios_authorities(usuario_id, authority_id) VALUES (3, 1);
INSERT INTO usuarios_authorities(usuario_id, authority_id) VALUES (3, 2);

INSERT INTO contactos(usuario_id, contacto_usuario_id) VALUES (1, 2);
INSERT INTO contactos(usuario_id, contacto_usuario_id) VALUES (1, 1);
INSERT INTO contactos(usuario_id, contacto_usuario_id) VALUES (1, 3);
INSERT INTO contactos(usuario_id, contacto_usuario_id) VALUES (2, 1);
INSERT INTO contactos(usuario_id, contacto_usuario_id) VALUES (2, 2);
INSERT INTO contactos(usuario_id, contacto_usuario_id) VALUES (3, 2);
INSERT INTO contactos(usuario_id, contacto_usuario_id) VALUES (3, 3);