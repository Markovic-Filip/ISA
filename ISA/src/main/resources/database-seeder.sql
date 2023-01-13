--country
INSERT INTO country(id, name) VALUES (1, 'Srbija');
INSERT INTO country(id, name) VALUES (2, 'Hrvatska');
INSERT INTO country(id, name) VALUES (3, 'Bugarska');
INSERT INTO country(id, name) VALUES (4, 'Rumunija');
INSERT INTO country(id, name) VALUES (5, 'Crna Gora');
INSERT INTO country(id, name) VALUES (6, 'Mađarska');
INSERT INTO country(id, name) VALUES (7, 'BIH');
INSERT INTO country(id, name) VALUES (8, 'Albanija');
INSERT INTO country(id, name) VALUES (9, 'Severna Makedonija');

--city
INSERT INTO city(id, name, zip_code, country_id) VALUES (1, 'Novi Sad', '21000', 1);

--address
INSERT INTO address(id, number, street, city_id) VALUES (1, '40', 'Narodnog fronta', 1);
INSERT INTO address(id, number, street, city_id) VALUES (2, '56', '1300 kaplara', 1);

--center
INSERT INTO center(id, description, name, address_id) VALUES (1, 'Ovo je glavni centar za transfuziju', 'Glavni centar za transfuziju', 1);
INSERT INTO center(id, description, name, address_id) VALUES (2, 'Ovo je sporedni centar za transfuziju', 'Sporedni centar za transfuziju', 2);




