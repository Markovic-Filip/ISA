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
INSERT INTO address(id, number, street, city_id) VALUES (3, '56', 'Bazlakova', 1);
INSERT INTO address(id, number, street, city_id) VALUES (4, '25', 'Sekspirova', 1);


--center
INSERT INTO center(id, description, name, address_id) VALUES (1, 'Ovo je glavni centar za transfuziju', 'Glavni centar za transfuziju', 1);
INSERT INTO center(id, description, name, address_id) VALUES (2, 'Ovo je sporedni centar za transfuziju', 'Sporedni centar za transfuziju', 2);

--donator
INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('Donator',1, true, 'student', 'markovicfilip98@gmail.com', 1, '1111111111111', 'Filip', '123', true, '0645306855', 'student', 'Markovic','Filip123', 3);
INSERT INTO donator(penaltys, id) VALUES (0, 1);

--medical_stuff
INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('CenterAdministrator',2, true, 'ZTK', 'nikolicfilip98@gmail.com', 1, '1111111111110', 'Filip', '123', true, '0645306856', 'medicinski tehnicar', 'Nikolic','Filip124', 4);
INSERT INTO center_administrator(id,center) VALUES (2,1);

--appointment
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time, donator_id, medical_staff_id) VALUES (1,1,'2023-01-31 12:00:00', '2023-01-31 12:30:00',1,2);
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (17,0,'2023-02-01 12:00:00', '2023-02-01 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (2,0,'2023-02-02 12:00:00', '2023-02-02 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (3,0,'2023-02-03 12:00:00', '2023-02-03 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (4,0,'2023-02-04 12:00:00', '2023-02-04 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (5,0,'2023-02-05 12:00:00', '2023-02-05 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (6,0,'2023-02-06 12:00:00', '2023-02-06 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (7,0,'2023-02-07 12:00:00', '2023-02-07 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (8,0,'2023-02-08 12:00:00', '2023-02-08 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (9,0,'2023-02-09 12:00:00', '2023-02-09 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (10,0,'2023-02-10 12:00:00', '2023-02-10 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (11,0,'2023-02-11 12:00:00', '2023-02-11 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (12,0,'2023-02-12 12:00:00', '2023-02-12 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (13,0,'2023-02-13 12:00:00', '2023-02-13 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (14,0,'2023-02-14 12:00:00', '2023-02-14 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (15,0,'2023-02-15 12:00:00', '2023-02-15 12:30:00');
INSERT INTO appointment(id, appointment_state, appointment_end_time, appointment_start_time) VALUES (16,0,'2023-02-16 12:00:00', '2023-02-16 12:30:00');



