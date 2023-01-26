--country
INSERT INTO country(id, name) VALUES (1, 'Srbija');
INSERT INTO country(id, name) VALUES (2, 'Hrvatska');
INSERT INTO country(id, name) VALUES (3, 'Bugarska');
INSERT INTO country(id, name) VALUES (4, 'Rumunija');
INSERT INTO country(id, name) VALUES (5, 'Crna Gora');
INSERT INTO country(id, name) VALUES (6, 'Mađarska');
INSERT INTO country(id, name) VALUES (7, 'BIH');
INSERT INTO country(id, name) VALUES (8, 'Albanija');

--city
INSERT INTO city(id, name, zip_code, country_id) VALUES (1, 'Novi Sad', '21000', 1);
INSERT INTO city(id, name, zip_code, country_id) VALUES (2, 'Split', '31000', 2);
INSERT INTO city(id, name, zip_code, country_id) VALUES (3, 'Plovdiv', '41000', 3);
INSERT INTO city(id, name, zip_code, country_id) VALUES (4, 'Temisvar', '51000', 4);
INSERT INTO city(id, name, zip_code, country_id) VALUES (5, 'Niksic', '61000', 5);
INSERT INTO city(id, name, zip_code, country_id) VALUES (6, 'Segedin', '71000', 6);
INSERT INTO city(id, name, zip_code, country_id) VALUES (7, 'Tuzla', '81000', 7);
INSERT INTO city(id, name, zip_code, country_id) VALUES (8, 'Skadar', '91000', 8);


--address
INSERT INTO address(id, number, street, city_id) VALUES (1, '40', 'Narodnog fronta', 1);
INSERT INTO address(id, number, street, city_id) VALUES (2, '56', '1300 kaplara', 1);
INSERT INTO address(id, number, street, city_id) VALUES (3, '56', 'Bazlakova', 1);
INSERT INTO address(id, number, street, city_id) VALUES (4, '25', 'Sekspirova', 1);
INSERT INTO address(id, number, street, city_id) VALUES (5, '25', 'Temerinska', 1);
INSERT INTO address(id, number, street, city_id) VALUES (6, '25', 'Futoska', 1);
INSERT INTO address(id, number, street, city_id) VALUES (7, '25', 'Jevrejska', 1);
INSERT INTO address(id, number, street, city_id) VALUES (8, '25', 'Bate Brkica', 1);
INSERT INTO address(id, number, street, city_id) VALUES (9, '25', 'Bulvar oslobodjenja', 1);
INSERT INTO address(id, number, street, city_id) VALUES (10, '25', 'Nikolina', 2);
INSERT INTO address(id, number, street, city_id) VALUES (11, '25', 'Aleksina', 3);
INSERT INTO address(id, number, street, city_id) VALUES (12, '25', 'Kralja Petra', 4);
INSERT INTO address(id, number, street, city_id) VALUES (13, '25', 'Skadarska', 5);
INSERT INTO address(id, number, street, city_id) VALUES (14, '25', 'Novakova', 6);
INSERT INTO address(id, number, street, city_id) VALUES (15, '25', 'Milina', 7);
INSERT INTO address(id, number, street, city_id) VALUES (16, '25', 'Bulevar kralja', 8);
INSERT INTO address(id, number, street, city_id) VALUES (17, '25', 'Sikstinska', 8);
INSERT INTO address(id, number, street, city_id) VALUES (18, '25', 'Kikina', 8);


--center
INSERT INTO center(id, average_grade,description, name, address_id) VALUES (1, 8,'Ovo je glavni centar za transfuziju', 'Glavni centar za transfuziju', 1);
INSERT INTO center(id, average_grade,description, name, address_id) VALUES (2, 6,'Ovo je sporedni centar za transfuziju', 'Sporedni centar za transfuziju', 2);
INSERT INTO center(id, average_grade,description, name, address_id) VALUES (3, 3,'Ovo je glavni centar za transfuziju BIH', 'Glavni centar za transfuziju BIH', 15);
INSERT INTO center(id, average_grade,description, name, address_id) VALUES (4, 2,'Ovo je glavni centar za transfuziju Madjarske', 'Glavni centar za transfuziju Madjarske', 14);
INSERT INTO center(id, average_grade,description, name, address_id) VALUES (5, 7,'Ovo je glavni centar za transfuziju Albanije', 'Glavni centar za transfuziju Albanije', 16);

--donator
INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('Donator',100, true, 'student', 'markovicfilip98@gmail.com', 0, '1111111111111', 'Filip', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '0645306855', 'student', 'Markovic','Filip123', 3);
INSERT INTO donator(penaltys, id) VALUES (0, 100);
INSERT INTO questionnaire(id, donator_id,filled) VALUES (100,100,false);
UPDATE donator SET questionnaire_id = 100 WHERE id =100;

INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('Donator',101, true, 'student', 'goblinkofkv@gmail.com', 0, '1111111111112', 'Nikola', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '0645306854', 'student', 'Nikolic','Nikola123', 4);
INSERT INTO donator(penaltys, id) VALUES (4, 101);
INSERT INTO questionnaire(id, donator_id,filled) VALUES (101,101,false);
UPDATE donator SET questionnaire_id = 101 WHERE id =101;

--medical_stuff
INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('CenterAdministrator',200, true, 'ZTK', 'nikolicfilip98@gmail.com', 1, '1111111111113', 'Filip', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '0645306856', 'medicinski tehnicar', 'Nikolic','Filip124', 5);
INSERT INTO center_administrator(id,center) VALUES (200,1);

INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('CenterAdministrator',201, true, 'ZTK', 'nikolicfilisp98@gmail.com', 1, '1111111111114', 'Marija', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '0645306856', 'medicinski tehnicar', 'Petrovic','Filip1241', 6);
INSERT INTO center_administrator(id,center) VALUES (201,2);

INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('CenterAdministrator',202, true, 'ZTK', 'nikolicfilipa98@gmail.com', 2, '1111111111115', 'Eko', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '0645306856', 'medicinski tehnicar', 'Sestroivc','Filip1242', 7);
INSERT INTO center_administrator(id,center) VALUES (202,3);

INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('CenterAdministrator',203, true, 'ZTK', 'nikolicfilip9g8@gmail.com', 0, '1111111111116', 'Miki', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '0645306856', 'medicinski tehnicar', 'Maric','Filip1243', 8);
INSERT INTO center_administrator(id,center) VALUES (203,4);

INSERT INTO users(role ,id, activated, company, email, gender, jmbg, name, password,password_changed, phone_number, profession, surname, username, address) VALUES ('CenterAdministrator',204, true, 'ZTK', 'nikolicfilip98e@gmail.com', 2, '1111111111117', 'Mali', '$2a$04$Vbug2lwwJGrvUXTj6z7ff.97IzVBkrJ1XfApfGNl.Z695zqcnPYra', true, '0645306856', 'medicinski tehnicar', 'Vucic','Filip1244', 9);
INSERT INTO center_administrator(id,center) VALUES (204,5);

--appointment
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, donator_id, medical_staff_id) VALUES (1,1,'2023-01-31 12:00:00', '2023-01-31 12:30:00',100,200);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (17,0,'2023-02-01 12:00:00', '2023-02-01 12:30:00',200);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (2,0,'2023-02-02 12:00:00', '2023-02-02 12:30:00',200);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (3,0,'2023-02-03 12:00:00', '2023-02-03 12:30:00',200);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (4,0,'2023-02-04 12:00:00', '2023-02-04 12:30:00',200);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (5,0,'2023-02-05 12:00:00', '2023-02-05 12:30:00',200);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (6,0,'2023-02-06 12:00:00', '2023-02-06 12:30:00',201);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (7,0,'2023-02-07 12:00:00', '2023-02-07 12:30:00',201);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (8,0,'2023-02-08 12:00:00', '2023-02-08 12:30:00',202);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (9,0,'2023-02-09 12:00:00', '2023-02-09 12:30:00',202);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (10,0,'2023-02-10 12:00:00', '2023-02-10 12:30:00',203);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (11,0,'2023-02-11 12:00:00', '2023-02-11 12:30:00',203);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (12,0,'2023-02-12 12:00:00', '2023-02-12 12:30:00',204);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (13,0,'2023-02-13 12:00:00', '2023-02-13 12:30:00',200);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (14,3,'2023-02-14 12:00:00', '2023-02-14 12:30:00',201);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (15,3,'2023-02-15 12:00:00', '2023-02-15 12:30:00',202);
INSERT INTO appointment(id, appointment_state, appointment_start_time, appointment_end_time, medical_staff_id) VALUES (16,3,'2022-01-16 12:00:00', '2022-01-16 12:30:00',200);

--warehouse
INSERT INTO warehouse(id,center_id) VALUES (1,1);
INSERT INTO warehouse(id,center_id) VALUES (2,2);

--equipment
INSERT INTO equipment(equipment_id, name, quantity, warehouse_id)  VALUES (1, 'igla',10,1);
--blood
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (1,true,20,0,1);
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (2,true,20,1,1);
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (3,true,20,2,1);
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (4,true,20,3,1);
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (5,false,20,0,1);
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (6,false,20,1,1);
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (7,false,20,2,1);
INSERT INTO blood(id, positive, quantity, type, warehouse_id) VALUES (8,false,20,3,1);

--history of appointments
INSERT INTO history_of_appointments(id, donator_id) VALUES (100,100);
INSERT INTO report(report_id,appointment_id, blood_id, history_id) VALUES (100,16,1,100);
INSERT INTO report_equipment(report_id, equipment_id) VALUES (100,1);

INSERT INTO report(report_id,appointment_id, blood_id, history_id) VALUES (102,14,1,100);
INSERT INTO report_equipment(report_id, equipment_id) VALUES (100,1);

INSERT INTO history_of_appointments(id, donator_id) VALUES (101,101);
INSERT INTO report(report_id,appointment_id, blood_id, history_id) VALUES (101,15,2,101);
INSERT INTO report_equipment(report_id, equipment_id) VALUES (101,1);

--roles
INSERT INTO ROLE (name) VALUES ('ROLE_USER');
INSERT INTO ROLE (name) VALUES ('ROLE_CENTER_ADMIN');
INSERT INTO ROLE (name) VALUES ('ROLE_ADMIN');

INSERT INTO USER_ROLE (user_id, role_id) VALUES (100, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (101, 1); -- user-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (200, 2); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (201, 2); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (202, 2); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (203, 2); -- admin-u dodeljujemo rolu USER
INSERT INTO USER_ROLE (user_id, role_id) VALUES (204, 2); -- admin-u dodeljujemo rolu USER





