insert into FLIGHT (ID, NUMBER, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT) values (FLIGHT_ID_SEQ.NEXTVAL, 'A101','10/20/2019','DAL', 'HOU');
insert into FLIGHT (ID, NUMBER, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT) values (FLIGHT_ID_SEQ.NEXTVAL, 'A102','10/20/2019','HOU', 'DAL');
insert into FLIGHT (ID, NUMBER, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT) values (FLIGHT_ID_SEQ.NEXTVAL, 'A103','10/20/2019','DAL', 'SAN');
insert into FLIGHT (ID, NUMBER, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT) values (FLIGHT_ID_SEQ.NEXTVAL, 'A104','10/20/2019','SAN', 'HOU');
commit;

insert into USER (ID, NAME, EMAIL) values (user_id_seq.NEXTVAL, 'Praveen', 'praveenkumar_s@yahoo.com');
insert into USER (ID, NAME, EMAIL) values (user_id_seq.NEXTVAL, 'Kumar', 'praveenkumar_s@yahoo.com');
insert into USER (ID, NAME, EMAIL) values (user_id_seq.NEXTVAL, 'Tester', 'tester@yahoo.com');
commit;
