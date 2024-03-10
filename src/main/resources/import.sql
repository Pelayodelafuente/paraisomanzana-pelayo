INSERT INTO `u676938568_paraisomanzana`.`fincas` (`idfinca`, `denominacion`,`direccion`,`referenciacatastral`,`superficie`,`localizacion`) VALUES ('1', 'La Pumarada','C/ Gijón 20','AA3300',350,'58.7491, -55.2833');
INSERT INTO `u676938568_paraisomanzana`.`fincas` (`idfinca`, `denominacion`,`direccion`,`referenciacatastral`,`superficie`,`localizacion`) VALUES ('2', 'Manzanera del Sol','C/ Menendez 56','BB5562',400,'-87.2646, -137.4658');
INSERT INTO `u676938568_paraisomanzana`.`fincas` (`idfinca`, `denominacion`,`direccion`,`referenciacatastral`,`superficie`,`localizacion`) VALUES ('3', 'El Jardín de las Delicias','C/ Julio César 33','CC0097',650,'-33.9338, -149.2849');
INSERT INTO `u676938568_paraisomanzana`.`fincas` (`idfinca`, `denominacion`,`direccion`,`referenciacatastral`,`superficie`,`localizacion`) VALUES ('4', 'El Vergel','C/ Asturias 56','DD4532',600,'-62.6469, 148.0294');




INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('1', 'Raxao');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('2', 'Regona');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('3', 'Perico');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('4', 'Verde Doncella');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('5', 'De la Riega');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('6', 'Blanquina');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('7', 'Carrio');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('8', 'Colorada de Tineo');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('9', 'Durona de Tresali');
INSERT INTO `u676938568_paraisomanzana`.`variedades` (`idvariedad`, `nombre`) VALUES ('10', 'Xuanina');




INSERT INTO `u676938568_paraisomanzana`.`arboles` (`idarbol`, `fila`,`columna`,`ubicacion`,`idfinca`,`idvariedad`,`estado`) VALUES ('1','1','1','-86.7637, 30.6638','1','1','SANO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (`idarbol`, `fila`,`columna`,`ubicacion`,`idfinca`,`idvariedad`,`estado`) VALUES ('2','1','2','-11.7540, 39.3274','1','2','SANO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (`idarbol`, `fila`,`columna`,`ubicacion`,`idfinca`,`idvariedad`,`estado`) VALUES ('3','1','3','16.3769, -40.9007','1','4','MUERTO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (`idarbol`, `fila`,`columna`,`ubicacion`,`idfinca`,`idvariedad`,`estado`) VALUES ('4','2','1','25.1477, -132.6629','1','6','SANO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (idarbol, fila, columna, ubicacion, idfinca, idvariedad, estado)VALUES ('5', '2', '2', '-55.1122, -77.6530', '1', '1', 'ENFERMO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (idarbol, fila, columna, ubicacion, idfinca, idvariedad, estado)VALUES ('6', '2', '3', '72.0630, -150.2514', '1', '3', 'SANO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (idarbol, fila, columna, ubicacion, idfinca, idvariedad, estado)VALUES ('7', '3', '1', '-2.9444, 85.5521', '1', '9', 'MUERTO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (idarbol, fila, columna, ubicacion, idfinca, idvariedad, estado)VALUES ('8', '3', '2', '7.9260, 76.5820', '1', '4', 'SANO');
INSERT INTO `u676938568_paraisomanzana`.`arboles` (idarbol, fila, columna, ubicacion, idfinca, idvariedad, estado)VALUES ('9', '3', '3', '31.4076, -45.3509', '1','5','SANO');




INSERT INTO `u676938568_paraisomanzana`.`fotos` (`idfoto`,`alias`,`url`,`idarbol`) VALUES ('1','Primera foto','https://i.imgur.com/CJiDuH1.jpg','1');




INSERT INTO `u676938568_paraisomanzana`.`tratamientos` (`idtratamiento`,`denominacion`,`dosisrecomendada`,`tipo`,`idarbol`) VALUES ('1','Primer tratamiento','100','Insecticida','1');
INSERT INTO `u676938568_paraisomanzana`.`recolecciones` (`idrecoleccion`,`cantidad`,`fecharecoleccion`,`temporada`,`idfinca`,`idvariedad`) VALUES ('1','200','1996/05/06','Primavera','1','1');




INSERT INTO `u676938568_paraisomanzana`.`usuarios` (idusuario, password, username) VALUES ('1','$2a$12$M5iDJ1ROO7XaRz/C5vOMP.pmKucUItgVn88UUqYv9.uGZM.dQVExG','admin');
INSERT INTO `u676938568_paraisomanzana`.`usuarios` (idusuario, password, username) VALUES ('2','$2a$12$M5iDJ1ROO7XaRz/C5vOMP.pmKucUItgVn88UUqYv9.uGZM.dQVExG','user');




INSERT INTO `u676938568_paraisomanzana`.`roles` (idrol,nombre)VALUES ('1','ROLE_ADMIN');
INSERT INTO `u676938568_paraisomanzana`.`roles` (idrol,nombre)VALUES ('2','ROLE_USER');




INSERT INTO `u676938568_paraisomanzana`.`usuariorol` (idusuariorol,idrol,idusuario)VALUES ('1','1','1');
INSERT INTO `u676938568_paraisomanzana`.`usuariorol` (idusuariorol,idrol,idusuario)VALUES ('2','2','2');