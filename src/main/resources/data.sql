INSERT INTO event(id,name,event_date,location,capacity) VALUES (1,'Test Concert','2023-02-14','Novi Sad',200);
INSERT INTO event(id,name,event_date,location,capacity) VALUES (2,'Test Festival','2023-03-15','Novi Sad',1000);
INSERT INTO event(id,name,event_date,location,capacity) VALUES (3,'Test Cafe Concert','2023-01-01','Belgrade',100);

INSERT INTO mailing_list(id,name,country,email) VALUES (1,'Pera Peric','Serbia','testmail@test.com');
INSERT INTO mailing_list(id,name,country,email) VALUES (2,'Mitar Mitar','Serbia','testmail2@test.com');
INSERT INTO mailing_list(id,name,country,email) VALUES (3,'Marko Markovic','Serbia','testmail3@test.com');

INSERT INTO music_record(id,name,release_year,artist,record_label) VALUES (1,'Test Name 1','2012','Test Band 1','Test Record Label');
INSERT INTO music_record(id,name,release_year,artist,record_label) VALUES (2,'Test Name 2','2014','Test Band 2','Test Record Label 2');
INSERT INTO music_record(id,name,release_year,artist,record_label) VALUES (3,'Test Name 3','2016','Test Band 3','Test Record Label 3');

INSERT INTO ticket(id,price,event_id) VALUES (1,300,2);
INSERT INTO ticket(id,price,event_id) VALUES (2,400,2);
INSERT INTO ticket(id,price,event_id) VALUES (3,200,3);






