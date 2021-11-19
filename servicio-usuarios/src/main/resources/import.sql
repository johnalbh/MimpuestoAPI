INSERT INTO roles(nombre) VALUES('ROLE_ADMIN');
INSERT INTO roles(nombre) VALUES('ROLE_USER');

INSERT INTO usuarios(username,password,enabled,email,NUMERO_IDENTIFICACION) VALUES('john.lopez', '1234',1,'john.lopez@gmail.com','1022347504');
INSERT INTO usuarios(username,password,enabled,email,NUMERO_IDENTIFICACION) VALUES('admin_sergio', '5678',1,'sergio.camargo@gmail.com','1022347505');
INSERT INTO USUARIOS(USERNAME,PASSWORD,ENABLED,EMAIL,NUMERO_IDENTIFICACION) VALUES('ana.vasquez', '1234',1,'ana.vasquez@gmail.com','1022347506');
INSERT INTO USUARIOS(USERNAME,PASSWORD,ENABLED,EMAIL,NUMERO_IDENTIFICACION) VALUES('viviana.ordonez', '2580',1,'viviana.ordonez@gmail.com','1022347507');
INSERT INTO USUARIOS(USERNAME,PASSWORD,ENABLED,EMAIL,NUMERO_IDENTIFICACION) VALUES('andrea.palacios', '2790',1,'andrea.palacios@gmail.com','1022347508');
INSERT INTO USUARIOS(USERNAME,PASSWORD,ENABLED,EMAIL,NUMERO_IDENTIFICACION) VALUES('alejandro.gomez', '1350',1,'alejandro.gomez@gmail.com','1022347509');
INSERT INTO USUARIOS(USERNAME,PASSWORD,ENABLED,EMAIL,NUMERO_IDENTIFICACION) VALUES('maria.vargas', '2790',1,'maria.vargas@gmail.com','1022347510');
INSERT INTO USUARIOS(USERNAME,PASSWORD,ENABLED,EMAIL,NUMERO_IDENTIFICACION) VALUES('laura.medina', '1350',1,'laura.medina@hotmail.com','1022347511');

INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(1,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(2,1);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(3,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(4,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(5,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(6,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(7,2);
INSERT INTO usuario_roles(usuario_id,roles_id) VALUES(8,2);



