INSERT INTO TIPO_BIEN ( ESTADO , NOMBRE, ICONO ) VALUES (1, 'VEHICULO', 'CAR_RENTAL');
INSERT INTO TIPO_BIEN ( ESTADO , NOMBRE, ICONO ) VALUES (1, 'VIVIENDA', 'HOME');
INSERT INTO TIPO_BIEN ( ESTADO , NOMBRE, ICONO ) VALUES (1, 'COMERCIO', 'BUSINESS');

/*CONTRIBUYENTES */

INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347504','LÓPEZ','HERNÁNDEZ','JOHN','ALBERTO', 'john.lopez@gmail.com','CALLE JUAN PORCELL 8','3002967452');
INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347505','CAMARGO','HERNÁNDEZ','SERGIO','ALEJANDRO', 'sergio.camargo@gmail.com','CALLE REINA VICTORIA','3002569874');
INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347506','VASQUEZ','FERNÁNDEZ','ANA','SILVIA', 'ana.vasquez@gmail.com','CALLE JOAN PORTA 8','3113697852');
INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347507','ROJAS','ORDOÑEZ','VIVIANA','ANDREA', 'viviana.ordonez@gmail.com','CALLE 76 78 43','32145678214');
INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347508','PALACIOS','HERNÁNDEZ','CLAUDIA','ANDREA', 'andrea.palacios@gmail.com','CALLE 78G 45SUR 34','3153609872');
INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347509','GOMEZ','HERNÁNDEZ','ALEJANDRO','', 'alejandro.gomez@gmail.com','CALLE 98 72 45','3503197538');
INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347510','VARGAS','FERNÁNDEZ','MARIA','JOSÉ', 'maria.vargas@gmail.com','CALLE 151 78 45','3002843597');
INSERT INTO CONTRIBUYENTE ( TIPO_IDENTIFICACION, NUMERO_IDENTIFICACION, PRIMER_APELLIDO, SEGUNDO_APELLIDO, PRIMER_NOMBRE, SEGUNDO_NOMBRE, CORREO_ELECTRONICO, DIRECCION_NOTIFICACION, TELEFONO_PRINCIPAL ) VALUES ('CC', '1022347511','MEDINA','ORDOÑEZ','LAURA','MARCELA', 'laura.medina@hotmail.com','CALLE 78G 54','3002563654');

/* BIEN */
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (2, '1022347507', 160000000);
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (3, '1022347507', 650000000);
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (1, '1022347508', 100000000);
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (2, '1022347508', 250000000);
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (2, '1022347509', 350000000);
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (1, '1022347510', 50000000);
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (2, '1022347510', 120000000);
INSERT INTO BIEN ( TIPO_BIEN_ID , CONTRIBUYENTE_ID, VALOR_AVALUO ) VALUES (3, '1022347510', 200000000);

/* MI BASE DE DATOS */
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (160000000,'1022347504',2);
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (650000000,'1022347504',3);
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (100000000,'1022347508',1);
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (250000000,'1022347508',2);
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (350000000,'1022347509',2);
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (50000000,'1022347510',1);
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (120000000,'1022347510',2);
INSERT INTO BIEN(VALOR_AVALUO, CONTRIBUYENTE_ID, TIPO_BIEN_ID) VALUES (200000000,'1022347510',3);



/* VEHÍCULOS */
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('HSQ786', 'RENAULT', 'SANDERO', 2012, 1991, 'PARTICULAR', 2);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('UYT703', 'VOLKSWAGEN', 'VOYAGE', 2020, 1591, 'PARTICULAR', 3);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('LOD987', 'HYUNDAI', 'ACCENT GL', 2022, 1591, 'PARTICULAR', 4);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('QWE567', 'KIA', 'CERATO', 2021, 1191, 'PARTICULAR', 5);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('NCV000', 'VOLKSWAGEN', 'GOLF', 2008, 1591, 'PARTICULAR', 6);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('HDY567', 'RENAULT', 'CLIO', 2009, 1591, 'PARTICULAR', 7);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('AWQ987', 'MAZDA', '3', 2014, 1991, 'PARTICULAR', 8);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('QQK111', 'HYUNDAI', 'ACCENT GL', 2016, 1591, 'PARTICULAR', 9);
INSERT INTO VEHICULO ( PLACA , MARCA , LINEA , MODELO , CAPACIDAD , USO , BIEN_ID ) VALUES ('AAT567', 'VOLKSWAGEN', 'GOL', 2013, 1191, 'PARTICULAR', 10);

/* COMERCIOS */
INSERT INTO COMERCIO (NIT, BASE_GRAVABLE_ACTIVIDAD, CODIGO_ACTIVIDAD, NOMBRE_ESTABLECIMIENTO_COMERCIAL, BIEN_ID ) VALUES (900648159, 1500000, 101, 'GOON ',11);
INSERT INTO COMERCIO (NIT, BASE_GRAVABLE_ACTIVIDAD, CODIGO_ACTIVIDAD, NOMBRE_ESTABLECIMIENTO_COMERCIAL, BIEN_ID ) VALUES (923647834, 5000000, 160, 'D1 ', 12);
INSERT INTO COMERCIO (NIT, BASE_GRAVABLE_ACTIVIDAD, CODIGO_ACTIVIDAD, NOMBRE_ESTABLECIMIENTO_COMERCIAL, BIEN_ID ) VALUES (934754481, 7300000, 120, 'PAPELERIA CASA ', 13);

/* VIVIENDA */

INSERT INTO VIVIENDA ( CEDULA_CATRASTAL , DIRECCION_PREDIO , TERRENO , CONSTRUCCION, ESTRATO , BIEN_ID ) VALUES ('ABD1256TOTO', 'CALLE 6C 78G 32', 100, 95.5 , 3, 14);
INSERT INTO VIVIENDA ( CEDULA_CATRASTAL , DIRECCION_PREDIO , TERRENO , CONSTRUCCION, ESTRATO , BIEN_ID ) VALUES ('RTH4534UYTR', 'CALLE 58 12 34', 77, 65.5 , 4, 15);
INSERT INTO VIVIENDA ( CEDULA_CATRASTAL , DIRECCION_PREDIO , TERRENO , CONSTRUCCION, ESTRATO , BIEN_ID ) VALUES ('LOPS1256OOO', 'CALLE 132BIS 78 32', 80, 79.5 , 5, 16);
INSERT INTO VIVIENDA ( CEDULA_CATRASTAL , DIRECCION_PREDIO , TERRENO , CONSTRUCCION, ESTRATO , BIEN_ID ) VALUES ('AB3435TOTO4', 'CALLE 48G3 78G 32', 99, 97.5 , 3, 17);
INSERT INTO VIVIENDA ( CEDULA_CATRASTAL , DIRECCION_PREDIO , TERRENO , CONSTRUCCION, ESTRATO , BIEN_ID ) VALUES ('RTZ3434UYTR', 'CALLE 34 12 34', 120, 98.5 , 4, 18);
INSERT INTO VIVIENDA ( CEDULA_CATRASTAL , DIRECCION_PREDIO , TERRENO , CONSTRUCCION, ESTRATO , BIEN_ID ) VALUES ('ZERT5555OOO', 'CALLE 132BIS 78 32', 100, 97.5 , 5, 19);

/* ACCESO */
INSERT INTO IMPUESTO(OBLIGATORIO, BASE_PAGO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, BASE_PAGO_EXTRAORDINARIO, BASE_PAGO_ORDINARIO, BASE_PAGO_ORDINARIO_CON_PAGO_VOLUNTARIO, ESTADO, FECHA_LIMITE_PAGO_EXTRA_ORDINARIO, FECHA_LIMITE_PAGO_ORDINARIO, PERIODICIDAD, VALOR_PAGO_MINIMO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_ORDINARIO, TIPO_BIEN_ID) VALUES (1,50000,70000,60000,75000,0,'2021-09-11','2021-10-11','ANUAL',80000,78000,84000,55000,1);
INSERT INTO IMPUESTO(OBLIGATORIO, BASE_PAGO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, BASE_PAGO_EXTRAORDINARIO, BASE_PAGO_ORDINARIO, BASE_PAGO_ORDINARIO_CON_PAGO_VOLUNTARIO, ESTADO, FECHA_LIMITE_PAGO_EXTRA_ORDINARIO, FECHA_LIMITE_PAGO_ORDINARIO, PERIODICIDAD, VALOR_PAGO_MINIMO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_ORDINARIO, TIPO_BIEN_ID) VALUES (1,50000,70000,60000,75000,0,'2021-09-11','2021-10-11','ANUAL',80000,78000,84000,55000,1);
INSERT INTO IMPUESTO(OBLIGATORIO, BASE_PAGO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, BASE_PAGO_EXTRAORDINARIO, BASE_PAGO_ORDINARIO, BASE_PAGO_ORDINARIO_CON_PAGO_VOLUNTARIO, ESTADO, FECHA_LIMITE_PAGO_EXTRA_ORDINARIO, FECHA_LIMITE_PAGO_ORDINARIO, PERIODICIDAD, VALOR_PAGO_MINIMO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_ORDINARIO, TIPO_BIEN_ID) VALUES (1, 55000,80000, 60000, 85000, 0,'2021-08-18','2021-09-20', 'ANUAL' , 90000, 100000, 110000, 40000,2);
INSERT INTO IMPUESTO(OBLIGATORIO, BASE_PAGO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, BASE_PAGO_EXTRAORDINARIO, BASE_PAGO_ORDINARIO, BASE_PAGO_ORDINARIO_CON_PAGO_VOLUNTARIO, ESTADO, FECHA_LIMITE_PAGO_EXTRA_ORDINARIO, FECHA_LIMITE_PAGO_ORDINARIO, PERIODICIDAD, VALOR_PAGO_MINIMO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_ORDINARIO, TIPO_BIEN_ID) VALUES (1,60000,90000,65000,95000,0,'2021-11-11','2021-12-11','ANUAL',100000,120000,90000,45000,3);
INSERT INTO IMPUESTO(OBLIGATORIO, BASE_PAGO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, BASE_PAGO_EXTRAORDINARIO, BASE_PAGO_ORDINARIO, BASE_PAGO_ORDINARIO_CON_PAGO_VOLUNTARIO, ESTADO, FECHA_LIMITE_PAGO_EXTRA_ORDINARIO, FECHA_LIMITE_PAGO_ORDINARIO, PERIODICIDAD, VALOR_PAGO_MINIMO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO, VALOR_PAGO_MINIMO_EXTRA_ORDINARIO_CON_PAGO_VOLUNTARIO, VALOR_PAGO_MINIMO_ORDINARIO, TIPO_BIEN_ID) VALUES (1,70000,100000,74000,130000,0,'2021-07-21','2021-08-22','ANUAL',120000,80000,95000,50000,2);


