ALTER TABLE cgg_isla ADD COLUMN regitro_tct numeric;
UPDATE sii.cgg_isla SET regitro_tct=0;
UPDATE sii.cgg_isla SET regitro_tct=1 where cisla_codigo in ('CISLA1','CISLA2','CISLA3','CISLA4');
ALTER TABLE cgg_isla ALTER COLUMN regitro_tct SET NOT NULL;


-- Table: cgg_catalogos

-- DROP TABLE cgg_catalgos;

CREATE TABLE sii.cgg_catalogo ( 
	cdcata_codigo       	varchar(20) NOT NULL,
	cdcata_identificador	varchar(20) NULL,
	cdcata_descripcion  	varchar(50) NULL,
        CONSTRAINT pk_cgg_catalogos PRIMARY KEY (cdcata_codigo) 
	);
COMMENT ON COLUMN sii.cgg_catalogo.cdcata_codigo IS 'IDENTIFICATIVO UNICO DE LOS CATALOGOS';
COMMENT ON COLUMN sii.cgg_catalogo.cdcata_identificador IS 'IDENTIFICADOR DEL GRUPO DE CATALOGOS';
COMMENT ON COLUMN sii.cgg_catalogo.cdcata_descripcion IS 'DESCRIPCION DEL CATALOGO';

INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('15', '4', 'En grupo');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('1', '1', 'Soltero/a');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('2', '1', 'Casado/a');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('3', '1', 'Divorsiado/a');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('4', '1', 'Viudo/a');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('5', '1', 'Union Libre');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('6', '1', 'Se ignora');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('7', '2', 'Masculino');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('8', '2', 'Femenino');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('9', '3', 'Primaria');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('10', '3', 'Secuandaria');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('11', '3', 'Superior');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('12', '3', 'Otros');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('13', '4', 'Solo');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('14', '4', 'En pareja');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('16', '4', 'En familia');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('17', '5', 'Turismo');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('18', '5', 'Negocios');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('19', '5', 'Eventos organizados');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('20', '5', 'Servicios religiosos');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('21', '5', 'Visita familiar o amigos');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('22', '5', 'Investgación');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('23', '6', 'Página web');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('24', '6', 'Agencia de viajes');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('25', '6', 'Revistas especializadas');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('26', '6', 'Otro');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('27', '7', 'Si');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('28', '7', 'No');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('29', '8', 'Aida Maria');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('30', '8', 'Anahí');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('31', '8', 'Angelito I');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('32', '8', 'Archipell');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('33', '8', 'Archipell II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('34', '8', 'Athala II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('35', '8', 'Beluga');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('36', '8', 'Cachalote');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('37', '8', 'Carina');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('38', '8', 'Coral I');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('39', '8', 'Coral II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('40', '8', 'Cormorant');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('41', '8', 'Cruceros Humboldt');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('42', '8', 'Daphne');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('43', '8', 'Darwin');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('44', '8', 'Deep Blue');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('45', '8', 'Domenica');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('46', '8', 'Eclipse');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('47', '8', 'Edén');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('48', '8', 'Encantada');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('49', '8', 'Eric');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('50', '8', 'Estrella Del Mar');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('51', '8', 'Evolution');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('52', '8', 'Flamingo');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('53', '8', 'Flamingo I');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('54', '8', 'Floreana');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('55', '8', 'Fragata');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('56', '8', 'Galápagos Adventure');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('57', '8', 'Galápagos Legend');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('58', '8', 'Galápagos Majestic');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('59', '8', 'Galápagos Sky');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('60', '8', 'Galaxy');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('61', '8', 'Galaxy II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('62', '8', 'Golondrina I');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('63', '8', 'Grace');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('64', '8', 'Gran Natalia');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('65', '8', 'Guantanamera');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('66', '8', 'Integrity');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('67', '8', 'Isabela II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('68', '8', 'Jesus Del Gran Poder');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('69', '8', 'King Of The Sea');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('70', '8', 'La Pinta');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('71', '8', 'Letty');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('72', '8', 'Mary Anne');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('73', '8', 'Merak');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('74', '8', 'Millenium');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('75', '8', 'Monserrat');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('76', '8', 'National Geographic Endeavour');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('77', '8', 'National Geographic Islander');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('78', '8', 'Nemo II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('79', '8', 'Nemo III');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('80', '8', 'Nemo Martinica');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('81', '8', 'Nortada');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('82', '8', 'Ocean Spray');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('83', '8', 'Passion');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('84', '8', 'Pingüino Explorer');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('85', '8', 'Queen Beatriz');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('86', '8', 'Queen Of Galapagos');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('87', '8', 'Reina Silvia');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('88', '8', 'Samba');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('89', '8', 'San José');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('90', '8', 'Santa Cruz');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('91', '8', 'Sea Man II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('92', '8', 'Silver Galápagos');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('93', '8', 'Solitario George');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('94', '8', 'Stella Maris');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('95', '8', 'The Beagle');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('96', '8', 'Tip Top III');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('97', '8', 'Tip Top IV');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('98', '8', 'Treasure Of Galápagos');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('99', '8', 'Xavier III');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('100', '8', 'Xpedition');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('101', '8', 'Yolita II');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('102', '9', 'Abordo De Crucero');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('103', '9', 'Domicilio Amigo/Familiar');
INSERT INTO sii.cgg_catalogo(cdcata_codigo, cdcata_identificador, cdcata_descripcion)
  VALUES('104', '9', 'Hotel');

-- Table: cgg_catalogos

-- DROP TABLE cgg_catalgos;

CREATE TABLE sii.cgg_isla_hotel
(
  cdisho_codigo character varying(20) NOT NULL,
  cdisho_isla_codigo character varying(20), 
  cdisho_nombre character varying(50), 
  CONSTRAINT pk_cdisho_codigo PRIMARY KEY (cdisho_codigo),
  CONSTRAINT fk_cdisho_isla_codigo FOREIGN KEY (cdisho_isla_codigo)
      REFERENCES sii.cgg_isla (cisla_codigo) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);
COMMENT ON COLUMN sii.cgg_isla_hotel.cdisho_codigo IS 'IDENTIFICADOR UNICO DE LOS HOTELES PO ISLA';
COMMENT ON COLUMN sii.cgg_isla_hotel.cdisho_isla_codigo IS 'IDENTICADOR DE LA ISLA';
COMMENT ON COLUMN sii.cgg_isla_hotel.cdisho_nombre IS 'NOMBRE DEL HOTEL';

INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('1', 'CISLA4', 'Black Beach House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('2', 'CISLA4', 'Casa De Huéspedes Emperatriz');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('3', 'CISLA4', 'El Pajas');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('4', 'CISLA4', 'Floreana Lava Lodge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('5', 'CISLA4', 'Hildita');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('6', 'CISLA4', 'Lecocarpus');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('7', 'CISLA4', 'Los Cactus');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('8', 'CISLA4', 'Santa María');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('9', 'CISLA4', 'Wittmer');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('10', 'CISLA3', 'Albemarle');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('11', 'CISLA3', 'Brisas Del Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('12', 'CISLA3', 'Caleta Iguana');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('13', 'CISLA3', 'Cally');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('14', 'CISLA3', 'Campo Duro Ecolodge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('15', 'CISLA3', 'Cartago Bay');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('16', 'CISLA3', 'Casa Baronesa');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('17', 'CISLA3', 'Casa Los Delfines');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('18', 'CISLA3', 'Casa Sol');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('19', 'CISLA3', 'Cerro Azul');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('20', 'CISLA3', 'Chez Manany');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('21', 'CISLA3', 'Coral Blanco');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('22', 'CISLA3', 'Cormorant');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('23', 'CISLA3', 'Drake Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('24', 'CISLA3', 'El Delfin Azul');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('25', 'CISLA3', 'El Peregrino');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('26', 'CISLA3', 'Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('27', 'CISLA3', 'Galapagos Bay Suits');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('28', 'CISLA3', 'Gladismar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('29', 'CISLA3', 'Iguana');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('30', 'CISLA3', 'Iguana Crossing');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('31', 'CISLA3', 'Iguana Rosada');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('32', 'CISLA3', 'Insular');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('33', 'CISLA3', 'Isabela Del Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('34', 'CISLA3', 'Janeth');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('35', 'CISLA3', 'Jeniffer');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('36', 'CISLA3', 'La Casa De Joel');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('37', 'CISLA3', 'La Casa De Marita');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('38', 'CISLA3', 'La Casita');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('39', 'CISLA3', 'La Casita De La Playa');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('40', 'CISLA3', 'La Gran Tortuga');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('41', 'CISLA3', 'La Isla Del Descanso');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('42', 'CISLA3', 'La Jungla');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('43', 'CISLA3', 'La Laguna');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('44', 'CISLA3', 'Las Fragatas');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('45', 'CISLA3', 'Las Gardenias');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('46', 'CISLA3', 'La Tintorera');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('47', 'CISLA3', 'Lava Lizard');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('48', 'CISLA3', 'Loja');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('49', 'CISLA3', 'Los Cactus');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('50', 'CISLA3', 'Los Flamencos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('51', 'CISLA3', 'Los Túneles');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('52', 'CISLA3', 'Mother Fanny');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('53', 'CISLA3', 'Muro De Lágrimas');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('54', 'CISLA3', 'Neptuno');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('55', 'CISLA3', 'Paraíso De Isabela');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('56', 'CISLA3', 'Posada Del Caminante');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('57', 'CISLA3', 'Posada Del Caminante II');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('58', 'CISLA3', 'Punta Arena');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('59', 'CISLA3', 'Rincón De George');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('60', 'CISLA3', 'Sandrita');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('61', 'CISLA3', 'San Vicente');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('62', 'CISLA3', 'Sea Lion');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('63', 'CISLA3', 'Serenety Beach House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('64', 'CISLA3', 'Sierra Negra');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('65', 'CISLA3', 'Star Fish');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('66', 'CISLA3', 'Sula Sula');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('67', 'CISLA3', 'Sun Island');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('68', 'CISLA3', 'Tero Real');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('69', 'CISLA3', 'The Wooden House Lodge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('70', 'CISLA3', 'Villamil');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('71', 'CISLA3', 'Volcano');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('72', 'CISLA1', 'Albatros, San Cristobal');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('73', 'CISLA1', 'Algarrobos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('74', 'CISLA1', 'Arena Blanca');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('75', 'CISLA1', 'Blue Marlin');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('76', 'CISLA1', 'Cabañas Don Jorge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('77', 'CISLA1', 'Cabañas Pimampiro');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('78', 'CISLA1', 'Cabañas Vista Al Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('79', 'CISLA1', 'Cactus');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('80', 'CISLA1', 'Casa Blanca');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('81', 'CISLA1', 'Casa D´ Celeste');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('82', 'CISLA1', 'Casa De Cristhi');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('83', 'CISLA1', 'Casa De Laura');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('84', 'CISLA1', 'Casa De Milton');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('85', 'CISLA1', 'Casa De Nelly');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('86', 'CISLA1', 'Casa Iguana Mar Y Sol');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('87', 'CISLA1', 'Casa Mabell');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('88', 'CISLA1', 'Casa Opuntia');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('89', 'CISLA1', 'Casa Pimampiro');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('90', 'CISLA1', 'Casa Playa Mann');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('91', 'CISLA1', 'Cattleya');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('92', 'CISLA1', 'Chatam');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('93', 'CISLA1', 'Cisne House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('94', 'CISLA1', 'Cucuve Ecolodge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('95', 'CISLA1', 'Deep Blue');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('96', 'CISLA1', 'D Korales');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('97', 'CISLA1', 'Dlewis');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('98', 'CISLA1', 'Dolphin House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('99', 'CISLA1', 'Dorys House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('100', 'CISLA1', 'El Matazarno');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('101', 'CISLA1', 'Emanuel');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('102', 'CISLA1', 'Estancia El Progreso');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('103', 'CISLA1', 'Estrellita');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('104', 'CISLA1', 'Finca Ecoturística Guadalupe');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('105', 'CISLA1', 'Fragatas Home');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('106', 'CISLA1', 'Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('107', 'CISLA1', 'Galapagos Bay Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('108', 'CISLA1', 'Galápagos Eco Lodge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('109', 'CISLA1', 'Galápagos Planet');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('110', 'CISLA1', 'Golden Bay Hotel & Spa');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('111', 'CISLA1', 'Gosén Guest House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('112', 'CISLA1', 'Hacienda La Esperanza');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('113', 'CISLA1', 'Hospedaje Alegría');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('114', 'CISLA1', 'Hospedaje Amaro');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('115', 'CISLA1', 'Hospedaje Andry');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('116', 'CISLA1', 'Hospedaje Darling');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('117', 'CISLA1', 'Hospedaje De Luis');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('118', 'CISLA1', 'Hospedaje Luz Amalia');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('119', 'CISLA1', 'Hospedaje Milena');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('120', 'CISLA1', 'Hospedaje Nathaly');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('121', 'CISLA1', 'Hospedaje Rommy');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('122', 'CISLA1', 'House Arena Y Sol');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('123', 'CISLA1', 'Islas Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('124', 'CISLA1', 'Jardín De Helena');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('125', 'CISLA1', 'Jeimy');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('126', 'CISLA1', 'Katarma Galápagos Artistic & Green Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('127', 'CISLA1', 'La Aldea D´ Lorien');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('128', 'CISLA1', 'La Cañada');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('129', 'CISLA1', 'La Casa De Mi Sub');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('130', 'CISLA1', 'La Casa De Vidrio');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('131', 'CISLA1', 'La Casita De La Isla');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('132', 'CISLA1', 'La Zayapa');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('133', 'CISLA1', 'Leon Dormido');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('134', 'CISLA1', 'Mar Azul');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('135', 'CISLA1', 'Mare Mío');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('136', 'CISLA1', 'Marpico Home');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('137', 'CISLA1', 'Mi Caleta');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('138', 'CISLA1', 'Miconia San Cristobal');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('139', 'CISLA1', 'Morys House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('140', 'CISLA1', 'Northia');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('141', 'CISLA1', 'Paraiso Insular I');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('142', 'CISLA1', 'Paraiso Insular II');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('143', 'CISLA1', 'Pensión Suiza');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('144', 'CISLA1', 'Posada De Jose Carlos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('145', 'CISLA1', 'Residencial Erick');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('146', 'CISLA1', 'Rokas Y Kactus');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('147', 'CISLA1', 'Royal Bambú');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('148', 'CISLA1', 'Salamanca II');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('149', 'CISLA1', 'San Francisco');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('150', 'CISLA1', 'Sea Side Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('151', 'CISLA1', 'Sofía');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('152', 'CISLA1', 'Stefany Lodging House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('153', 'CISLA1', 'Suite Bellavista');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('154', 'CISLA1', 'Terito');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('155', 'CISLA1', 'Tongo Reef');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('156', 'CISLA1', 'Twin Suits Galápagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('157', 'CISLA1', 'Zerimar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('158', 'CISLA2', 'Albatros');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('159', 'CISLA2', 'Altair');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('160', 'CISLA2', 'Angermeyer Water Front Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('161', 'CISLA2', 'Aquamarine');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('162', 'CISLA2', 'Ariana´S Galapagos Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('163', 'CISLA2', 'Bay House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('164', 'CISLA2', 'Bay House Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('165', 'CISLA2', 'Bay View House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('166', 'CISLA2', 'Blue Heron');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('167', 'CISLA2', 'Blue House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('168', 'CISLA2', 'Blue Shark');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('169', 'CISLA2', 'Bratle');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('170', 'CISLA2', 'Brisas Del Pacifico');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('171', 'CISLA2', 'Cactus Pad Y Orchidea');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('172', 'CISLA2', 'Camping El Eden');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('173', 'CISLA2', 'Capitan Max');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('174', 'CISLA2', 'Carliza');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('175', 'CISLA2', 'Carliza II');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('176', 'CISLA2', 'Carpao');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('177', 'CISLA2', 'Casa Cascada');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('178', 'CISLA2', 'Casa Del Lago');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('179', 'CISLA2', 'Casa De Mathias');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('180', 'CISLA2', 'Casa De Pablo');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('181', 'CISLA2', 'Casa De Patty´S');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('182', 'CISLA2', 'Casa Eden');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('183', 'CISLA2', 'Casa Kubler');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('184', 'CISLA2', 'Casa La Iguana');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('185', 'CISLA2', 'Casa Opuntia');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('186', 'CISLA2', 'Casa Tortuga Y Casita Muyuyo');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('187', 'CISLA2', 'Castro');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('188', 'CISLA2', 'Chalet Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('189', 'CISLA2', 'Cormorant Lodging House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('190', 'CISLA2', 'Costa Del Pacifico');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('191', 'CISLA2', 'Costa Del Sol');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('192', 'CISLA2', 'Cozy Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('193', 'CISLA2', 'Crossman');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('194', 'CISLA2', 'Cucuve Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('195', 'CISLA2', 'Darwin');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('196', 'CISLA2', 'Dejavu');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('197', 'CISLA2', 'Divines Bay');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('198', 'CISLA2', 'Duncan Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('199', 'CISLA2', 'Eco Lodge Galapagos Walker');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('200', 'CISLA2', 'El Bambu Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('201', 'CISLA2', 'El Castillo');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('202', 'CISLA2', 'El Descanso Del Guia');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('203', 'CISLA2', 'El Descanso Del Petrel');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('204', 'CISLA2', 'Elizabeth');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('205', 'CISLA2', 'El Paraiso');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('206', 'CISLA2', 'El Pinzon');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('207', 'CISLA2', 'Encantadas');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('208', 'CISLA2', 'Escalesia');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('209', 'CISLA2', 'España');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('210', 'CISLA2', 'Estrella De Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('211', 'CISLA2', 'Fernandina');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('212', 'CISLA2', 'Fiesta');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('213', 'CISLA2', 'Finca Jack');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('214', 'CISLA2', 'Finch Bay');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('215', 'CISLA2', 'Flamingo');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('216', 'CISLA2', 'Fragata');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('217', 'CISLA2', 'Gala House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('218', 'CISLA2', 'Galapagos Apart And Suite');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('219', 'CISLA2', 'Galapagos Best Hostel');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('220', 'CISLA2', 'Galapagos Coral Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('221', 'CISLA2', 'Galapagos Cottage');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('222', 'CISLA2', 'Galapagos Dove');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('223', 'CISLA2', 'Galapagos Dreams');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('224', 'CISLA2', 'Galapagos Hostelling');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('225', 'CISLA2', 'Galapagos House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('226', 'CISLA2', 'Galapagos Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('227', 'CISLA2', 'Galapagos Island');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('228', 'CISLA2', 'Galapagos Magic');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('229', 'CISLA2', 'Galapagos Morning Glory');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('230', 'CISLA2', 'Galapagos Native');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('231', 'CISLA2', 'Galapagos Paradise');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('232', 'CISLA2', 'Galapagos People Lodge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('233', 'CISLA2', 'Galapagos Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('234', 'CISLA2', 'Galasuite Coloma');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('235', 'CISLA2', 'Gardner');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('236', 'CISLA2', 'Gecko Guest House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('237', 'CISLA2', 'Germania');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('238', 'CISLA2', 'Gloria Galapagos Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('239', 'CISLA2', 'Isla Del Pirata');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('240', 'CISLA2', 'Jean´S Home');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('241', 'CISLA2', 'La Casa Del Pinzon');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('242', 'CISLA2', 'La Casa De Norma');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('243', 'CISLA2', 'La Casa Redonda');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('244', 'CISLA2', 'La Fortaleza De Haro');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('245', 'CISLA2', 'La Isla');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('246', 'CISLA2', 'La Kleta De Doña Yoly');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('247', 'CISLA2', 'La Mirada Del Solitario George');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('248', 'CISLA2', 'La Perla De Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('249', 'CISLA2', 'Las Ninfas');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('250', 'CISLA2', 'Lava House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('251', 'CISLA2', 'Lirio Del Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('252', 'CISLA2', 'Lobo De Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('253', 'CISLA2', 'Lonesome George');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('254', 'CISLA2', 'Los Amigos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('255', 'CISLA2', 'Los Cibeles');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('256', 'CISLA2', 'Los Piqueros');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('257', 'CISLA2', 'Maidith Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('258', 'CISLA2', 'Mainao');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('259', 'CISLA2', 'Mar Y Sol');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('260', 'CISLA2', 'Mi Caleta Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('261', 'CISLA2', 'Miconia');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('262', 'CISLA2', 'Mimosa');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('263', 'CISLA2', 'Monte Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('264', 'CISLA2', 'Muyuyo');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('265', 'CISLA2', 'Nelyza');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('266', 'CISLA2', 'North Seymour');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('267', 'CISLA2', 'Ocean Dreams');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('268', 'CISLA2', 'Palmeras');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('269', 'CISLA2', 'Palo Santo');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('270', 'CISLA2', 'Pelican Bay Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('271', 'CISLA2', 'Penguin Guest House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('272', 'CISLA2', 'Peregrina');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('273', 'CISLA2', 'Petrel');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('274', 'CISLA2', 'Pikaia Lodge');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('275', 'CISLA2', 'Planet House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('276', 'CISLA2', 'Posada Del Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('277', 'CISLA2', 'Quinta Margarita');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('278', 'CISLA2', 'Rancho Don Solo');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('279', 'CISLA2', 'Rancho Piedras Blancas');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('280', 'CISLA2', 'Red Booby');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('281', 'CISLA2', 'Red Mangrove');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('282', 'CISLA2', 'Royal Palm');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('283', 'CISLA2', 'Safari Camp');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('284', 'CISLA2', 'Salinas');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('285', 'CISLA2', 'Santa Cruz');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('286', 'CISLA2', 'Scalesia Guest House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('287', 'CISLA2', 'Semilla Verde');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('288', 'CISLA2', 'Seta Inn');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('289', 'CISLA2', 'Shangri-La');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('290', 'CISLA2', 'Silberstein');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('291', 'CISLA2', 'Sir Francis Drake');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('292', 'CISLA2', 'Sol Marina');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('293', 'CISLA2', 'Sol Y Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('294', 'CISLA2', 'Stefany');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('295', 'CISLA2', 'Suite De Los Sueños Silvestres');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('296', 'CISLA2', 'Suite Palace');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('297', 'CISLA2', 'Suites Del Sol');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('298', 'CISLA2', 'Suites Matazarnos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('299', 'CISLA2', 'Suites Santa Fe');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('300', 'CISLA2', 'Suymar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('301', 'CISLA2', 'The Blue Booby House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('302', 'CISLA2', 'The Marlin House');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('303', 'CISLA2', 'Tintorera Suites');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('304', 'CISLA2', 'Torre Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('305', 'CISLA2', 'Tortuga Bay');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('306', 'CISLA2', 'Twin Suites Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('307', 'CISLA2', 'Twin Suites Galapagos 2');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('308', 'CISLA2', 'Verde Azul');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('309', 'CISLA2', 'Villa Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('310', 'CISLA2', 'Villa Laguna');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('311', 'CISLA2', 'Vista Al Mar');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('312', 'CISLA2', 'White House Galapagos');
INSERT INTO sii.cgg_isla_hotel(cdisho_codigo, cdisho_isla_codigo, cdisho_nombre)
  VALUES('313', 'CISLA2', 'Zurisadai');


-- Function: f_cgg_catalogo_select_as(character varying)

-- DROP FUNCTION f_cgg_catalogo_select_as(character varying);

CREATE OR REPLACE FUNCTION f_cgg_catalogo_select_as(in_identificador character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CDCATA_CODIGO, 
		CDCATA_DESCRIPCION	
	FROM SII.CGG_CATALOGO
	WHERE CDCATA_IDENTIFICADOR = IN_IDENTIFICADOR;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION f_cgg_catalogo_select_as(character varying)
  OWNER TO postgres;


-- Function: f_cgg_isla_hotel_select_as(character varying)

-- DROP FUNCTION f_cgg_isla_hotel_select_as(character varying);

CREATE OR REPLACE FUNCTION f_cgg_isla_hotel_select_as(in_isla_codigo character varying)
  RETURNS SETOF refcursor AS
$BODY$
DECLARE
	TMP_REF REFCURSOR;
BEGIN
	OPEN TMP_REF FOR
	SELECT
		CDISHO_CODIGO, 
		CDISHO_NOMBRE	
	FROM SII.CGG_ISLA_HOTEL
	WHERE CDISHO_ISLA_CODIGO = IN_ISLA_CODIGO ORDER BY CDISHO_CODIGO ASC;
	RETURN NEXT TMP_REF;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100
  ROWS 1000;
ALTER FUNCTION f_cgg_isla_hotel_select_as(character varying)
  OWNER TO postgres;

ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_categoria character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_tipo_registro character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_numero_vuelo character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_tipo_hospedaje character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_isla_hospedaje character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_nombre_hospedaje_crucero character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_nombre_hospedaje_hotel character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_lugar_hospedaje character varying(200);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_viaje_acompanante character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_viaje_motivo character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_viaje_actividades character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_viaje_num_miembros character varying(10);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_viaje_tour character varying(20);
ALTER TABLE sii.cgg_tct_registro ADD COLUMN ctreg_viaje_cual character varying(200);

COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_categoria IS 'IDENTIFICATIVO UNICO DE LA CATEGORIA';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_tipo_registro IS 'IDENTIFICATIVO UNICO DEL TIPO DE REGISTRO ';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_numero_vuelo IS 'NUMERO DE VUELO DEL REGISTRO';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_tipo_hospedaje IS 'IDENTIFICATIVO UNICO DE TIPO DE HOSPEDDAJE ';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_isla_hospedaje IS 'IDENTIFICATIVO UNICO DE LA ISLA DE HOSPEDAJE ';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_nombre_hospedaje_crucero IS 'IDENTIFICATIVO UNICO DEL NOMBRE DEL CRUCERO EN CASO DE QUE HAYA SELECCIONADO EL TIPO CRUCERO U HOTEL';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_nombre_hospedaje_hotel IS 'IDENTIFICATIVO UNICO DEL NOMBRE DEL HOTEL EN CASO DE QUE HAYA SELECCIONADO HOTEL';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_lugar_hospedaje IS 'IDENTIFICATIVO UNICO DE LUGAR DEL HOSPEDAJE EN EL CASO DE QUE HAYA SELECCIONADO EL TIPO DOMICILIO AMIGO/FAMILIAR';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_viaje_acompanante IS 'IDENTIFICATIVO UNICO DE LA INFORMACION DEL VIAJE ACOMPAÑANTE';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_viaje_motivo IS 'IDENTIFICATIVO UNICO DE DE LA INFORMACION DEL VIAJE MOTIVO';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_viaje_actividades IS 'IDENTIFICATIVO UNICO DE DE LA INFORMACION DEL VIAJE INFORMACION DE LAS ACTIVIDADES';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_viaje_tour IS 'IDENTIFICATIVO UNICO DE DE LA INFORMACION DEL VIAJE TOUR FUERA O DENTRO DE GALAPAGOS';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_viaje_cual IS 'IDENTIFICATIVO UNICO DE DE LA INFORMACION DEL VIAJE CUAL';
COMMENT ON COLUMN sii.cgg_tct_registro.ctreg_viaje_num_miembros IS 'NUMERO DE MIEMBROS DEL REGISTRO';


ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_categoria FOREIGN KEY (ctreg_categoria)
      REFERENCES sii.cgg_tct_categoria (tctcat_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_tipo_registro FOREIGN KEY (ctreg_tipo_registro)
      REFERENCES sii.cgg_tct_tipo_registro (tcttr_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_tipo_hospedaje FOREIGN KEY (ctreg_tipo_hospedaje)
      REFERENCES sii.cgg_catalogo (cdcata_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_isla_hospedaje FOREIGN KEY (ctreg_isla_hospedaje)
      REFERENCES sii.cgg_isla (cisla_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_nombre_hospedaje_crucero FOREIGN KEY (ctreg_nombre_hospedaje_crucero)
     REFERENCES sii.cgg_catalogo (cdcata_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_nombre_hospedaje_hotel FOREIGN KEY (ctreg_nombre_hospedaje_hotel)
     REFERENCES sii.cgg_isla_hotel (cdisho_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_viaje_acompanante FOREIGN KEY (ctreg_viaje_acompanante)
      REFERENCES sii.cgg_catalogo (cdcata_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_viaje_motivo FOREIGN KEY (ctreg_viaje_motivo)
      REFERENCES sii.cgg_catalogo (cdcata_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_viaje_actividades FOREIGN KEY (ctreg_viaje_actividades)
      REFERENCES sii.cgg_catalogo (cdcata_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;

ALTER TABLE sii.cgg_tct_registro
  ADD CONSTRAINT fk_ctreg_viaje_tour FOREIGN KEY (ctreg_viaje_tour)
      REFERENCES sii.cgg_catalogo (cdcata_codigo) MATCH SIMPLE
      ON UPDATE CASCADE ON DELETE CASCADE;


-- Table: cgg_tct_grupo_turista

-- DROP TABLE cgg_tct_grupo_turista;

CREATE TABLE sii.cgg_tct_atractivos_actividades
(
  ctata_codigo character varying(20) NOT NULL, 
  ctgtr_codigo character varying(20), 
  ctata_vida_marina character varying(2),
  ctata_sol_playa character varying(2),
  ctata_vida_terrestre character varying(2),
  ctata_paisaje character varying(2),
  ctata_crucero character varying(2),
  ctata_buceo character varying(2),
  ctata_snorkel character varying(2),
  ctata_kayak character varying(2),
  ctata_surf character varying(2),
  ctata_senderismo character varying(2),
  ctata_observacion character varying(2),
  ctata_fotografia character varying(2),
  ctata_pesca_vivencial character varying(2),
  CONSTRAINT pk_cgg_tct_atractivos_actividades PRIMARY KEY (ctata_codigo),
  CONSTRAINT fk_cgg_tct_grupo_turista FOREIGN KEY (ctgtr_codigo)
      REFERENCES sii.cgg_tct_grupo_turista (ctgtr_codigo) MATCH SIMPLE
      ON UPDATE RESTRICT ON DELETE RESTRICT
);


COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_codigo IS 'IDENTIFICATIVO UNICO DE LA TABLA';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctgtr_codigo IS 'IDENTIFICATIVO UNICO DEL GRUPO TURISTA';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_vida_marina IS 'PUNTUACION PARA EL ATRACTIVO VIDA MARINA';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_sol_playa IS 'PUNTUACION PARA EL ATRACTIVO SOL Y PLAYA';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_vida_terrestre IS 'PUNTUACION PARA EL ATRACTIVO VIDA TERRESTRE';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_paisaje IS 'PUNTUACION PARA EL ATRACTIVO PAISAJE';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_crucero IS 'PUNTUACION PARA LA ACTIVDAD CRUCERO';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_buceo IS 'PUNTUACION PARA LA ACTIVDAD BUCEO';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_snorkel IS 'PUNTUACION PARA LA ACTIVDAD SNORKEL';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_kayak IS 'PUNTUACION PARA LA ACTIVDAD KAYAK';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_surf IS 'PUNTUACION PARA LA ACTIVDAD SURF';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_senderismo IS 'PUNTUACION PARA LA ACTIVDAD SENDERISMO';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_observacion IS 'PUNTUACION PARA LA ACTIVDAD OBSERVACION';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_fotografia IS 'PUNTUACION PARA LA ACTIVDAD FOTOGRAFIA';
COMMENT ON COLUMN sii.cgg_tct_atractivos_actividades.ctata_pesca_vivencial IS 'PUNTUACION PARA LA ACTIVDAD PESCA VIVENCIAL';


-- Function: f_cgg_tct_registro_insert(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, bigint, timestamp with time zone, timestamp with time zone, character varying, timestamp with time zone, timestamp with time zone, smallint, character varying, boolean, character varying)

-- DROP FUNCTION f_cgg_tct_registro_insert(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, bigint, timestamp with time zone, timestamp with time zone, character varying, timestamp with time zone, timestamp with time zone, smallint, character varying, boolean, character varying);

CREATE OR REPLACE FUNCTION f_cgg_tct_registro_insert(in_ctreg_codigo character varying, in_crper_codigo character varying, in_ctgtr_codigo character varying, in_cusu_codigo character varying, in_cgg_cusu_codigo character varying, in_carpt_codigo character varying, in_cgg_carpt_codigo character varying, in_craln_codigo character varying, in_crtra_codigo character varying, in_ctreg_numero bigint, in_ctreg_fecha_preregistro timestamp with time zone, in_ctreg_fecha_ingreso timestamp with time zone, in_ctreg_codigo_barras character varying, in_ctreg_fecha_salida timestamp with time zone, in_ctreg_impresion_especie timestamp with time zone, in_ctreg_estado_registro smallint, in_ctreg_observacion character varying, in_ctreg_estado boolean, in_ctreg_usuario_insert character varying, in_ctreg_categoria character varying, in_ctreg_tipo_registro character varying, in_ctreg_numero_vuelo character varying, in_ctreg_tipo_hospedaje character varying,  in_ctreg_isla_hospedaje character varying, in_ctreg_nombre_hospedaje_crucero character varying, in_ctreg_nombre_hospedaje_hotel character varying, in_ctreg_lugar_hospedaje character varying, in_ctreg_viaje_acompanante character varying,  in_ctreg_viaje_motivo character varying, in_ctreg_viaje_actividades character varying, in_ctreg_viaje_num_miembros character varying, in_ctreg_viaje_tour character varying, in_ctreg_viaje_cual character varying)
  RETURNS character varying AS
$BODY$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CTREG_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_TCT_REGISTRO','CTREG_CODIGO','CTREG') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CTREG_CODIGO;
	END IF;
	INSERT INTO SII.CGG_TCT_REGISTRO(
		CTREG_CODIGO, 
		CRPER_CODIGO, 
		CTGTR_CODIGO, 		
		CUSU_CODIGO, 
		CGG_CUSU_CODIGO, 
		CARPT_CODIGO, 
		CGG_CARPT_CODIGO, 
		CRALN_CODIGO, 
		CRTRA_CODIGO, 
		CTREG_NUMERO, 
		CTREG_FECHA_PREREGISTRO, 
		CTREG_FECHA_INGRESO, 
		CTREG_CODIGO_BARRAS, 
		CTREG_FECHA_SALIDA, 
		CTREG_IMPRESION_ESPECIE, 
		CTREG_ESTADO_REGISTRO, 
		CTREG_OBSERVACION, 
		CTREG_ESTADO, 
		CTREG_FECHA_INSERT, 
		CTREG_USUARIO_INSERT, 
		CTREG_FECHA_UPDATE, 
		CTREG_USUARIO_UPDATE,
		CTREG_CATEGORIA, 
		CTREG_TIPO_REGISTRO, 
		CTREG_NUMERO_VUELO, 
		CTREG_TIPO_HOSPEDAJE,
		CTREG_ISLA_HOSPEDAJE, 
		CTREG_NOMBRE_HOSPEDAJE_CRUCERO, 
		CTREG_NOMBRE_HOSPEDAJE_HOTEL, 
		CTREG_LUGAR_HOSPEDAJE,
		CTREG_VIAJE_ACOMPANANTE, 
		CTREG_VIAJE_MOTIVO, 
		CTREG_VIAJE_ACTIVIDADES, 
		CTREG_VIAJE_NUM_MIEMBROS,
		CTREG_VIAJE_TOUR, 
		CTREG_VIAJE_CUAL
	) VALUES (
		OUT_KEY, 
		IN_CRPER_CODIGO, 
		IN_CTGTR_CODIGO, 		
		IN_CUSU_CODIGO, 
		IN_CGG_CUSU_CODIGO, 
		IN_CARPT_CODIGO, 
		IN_CGG_CARPT_CODIGO, 
		IN_CRALN_CODIGO, 
		IN_CRTRA_CODIGO, 
		IN_CTREG_NUMERO, 
		IN_CTREG_FECHA_PREREGISTRO, 
		IN_CTREG_FECHA_INGRESO, 
		IN_CTREG_CODIGO_BARRAS, 
		IN_CTREG_FECHA_SALIDA, 
		IN_CTREG_IMPRESION_ESPECIE, 
		IN_CTREG_ESTADO_REGISTRO, 
		IN_CTREG_OBSERVACION, 
		IN_CTREG_ESTADO, 
		CURRENT_TIMESTAMP, 
		IN_CTREG_USUARIO_INSERT, 
		CURRENT_TIMESTAMP, 
		IN_CTREG_USUARIO_INSERT,
		IN_CTREG_CATEGORIA, 
		IN_CTREG_TIPO_REGISTRO, 
		IN_CTREG_NUMERO_VUELO,
		IN_CTREG_TIPO_HOSPEDAJE, 
		IN_CTREG_ISLA_HOSPEDAJE, 
		IN_CTREG_NOMBRE_HOSPEDAJE_CRUCERO, 
		IN_CTREG_NOMBRE_HOSPEDAJE_HOTEL, 
		IN_CTREG_LUGAR_HOSPEDAJE,
		IN_CTREG_VIAJE_ACOMPANANTE, 
		IN_CTREG_VIAJE_MOTIVO, 
		IN_CTREG_VIAJE_ACTIVIDADES, 
		IN_CTREG_VIAJE_NUM_MIEMBROS,
		IN_CTREG_VIAJE_TOUR, 
		IN_CTREG_VIAJE_CUAL
	);
	RETURN OUT_KEY;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_cgg_tct_registro_insert(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, bigint, timestamp with time zone, timestamp with time zone, character varying, timestamp with time zone, timestamp with time zone, smallint, character varying, boolean, character varying)
  OWNER TO postgres;



CREATE OR REPLACE FUNCTION f_cgg_tct_atractivos_insert(in_ctata_codigo character varying, in_ctgtr_codigo character varying, in_ctata_vida_marina character varying, in_ctata_sol_playa  character varying, in_ctata_vida_terrestre character varying, in_ctata_paisaje character varying, in_ctata_crucero character varying, in_ctata_buceo character varying, in_ctata_snorkel character varying, in_ctata_kayak character varying, in_ctata_surf character varying, in_ctata_senderismo character varying, in_ctata_observacion character varying, in_ctata_fotografia character varying, in_ctata_pesca_vivencial character varying)
  RETURNS character varying AS
$BODY$
DECLARE
OUT_KEY VARCHAR;
BEGIN
	IF (UPPER(IN_CTATA_CODIGO) = 'KEYGEN') THEN
		SELECT SII.F_KEYGEN('CGG_TCT_ATRACTIVOS_ACTIVIDADES','CTATA_CODIGO','CTATA') INTO OUT_KEY;
	ELSE
		OUT_KEY := IN_CTATA_CODIGO;
	END IF;
	INSERT INTO SII.CGG_TCT_ATRACTIVOS_ACTIVIDADES(
	CTATA_CODIGO,
	CTGTR_CODIGO,
	CTATA_VIDA_MARINA,
	CTATA_SOL_PLAYA,
	CTATA_VIDA_TERRESTRE,
	CTATA_PAISAJE,
	CTATA_CRUCERO, 
	CTATA_BUCEO,
	CTATA_SNORKEL,
	CTATA_KAYAK,
	CTATA_SURF,
	CTATA_SENDERISMO,
	CTATA_OBSERVACION,
	CTATA_FOTOGRAFIA,
	CTATA_PESCA_VIVENCIAL

	) VALUES (
		OUT_KEY, 
		IN_CTGTR_CODIGO,
		IN_CTATA_VIDA_MARINA, 
		IN_CTATA_SOL_PLAYA, 
		IN_CTATA_VIDA_TERRESTRE,
		IN_CTATA_PAISAJE,
		IN_CTATA_CRUCERO, 
		IN_CTATA_BUCEO,
		IN_CTATA_SNORKEL,
		IN_CTATA_KAYAK,
		IN_CTATA_SURF,
		IN_CTATA_SENDERISMO,
		IN_CTATA_OBSERVACION,
		IN_CTATA_FOTOGRAFIA,
		IN_CTATA_PESCA_VIVENCIAL
		);
	RETURN OUT_KEY;
END
$BODY$
  LANGUAGE plpgsql VOLATILE
  COST 100;
ALTER FUNCTION f_cgg_tct_atractivos_insert(character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying, character varying)
  OWNER TO sii;



--> MIGRATION SCRIPT CONTROLLER <--
INSERT INTO sii.cgg_migrationscript (mrgsp_codigo,mrgsp_fecha,mrgsp_usuario_insert,mrgsp_fecha_insert,mrgsp_usuario_update,mrgsp_fecha_update,
	mrgsp_estado,mrgsp_developer,mrgsp_name,mrgsp_description,
	mrgsp_releaseno,mrgsp_filename,mrgsp_isapply)
VALUES(SII.F_KEYGEN('CGG_MIGRATIONSCRIPT','MRGSP_CODIGO','MRGSP'), current_timestamp,'ADMIN', current_timestamp,'ADMIN', current_timestamp,
	true,'xsilva','CATALOGOS TCT','Todos los catalogos necesarios para la nueva funcionalidad TCT',
	'2.0','2016_08_22_script_catalogos_tct.sql',true);