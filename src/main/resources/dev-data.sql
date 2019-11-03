insert into FLIGHT (ID, NUMBER, AIRLINE_CODE, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT, DEPART_TIME, ARRIVAL_TIME) values (FLIGHT_ID_SEQ.NEXTVAL, 'WN101','WN', '10/20/2019','DAL', 'HOU', '10:00', '23:00');
insert into FLIGHT (ID, NUMBER, AIRLINE_CODE, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT, DEPART_TIME, ARRIVAL_TIME) values (FLIGHT_ID_SEQ.NEXTVAL, 'AA102','AA', '10/20/2019','HOU', 'DAL', '10:00', '23:00');
insert into FLIGHT (ID, NUMBER, AIRLINE_CODE, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT, DEPART_TIME, ARRIVAL_TIME) values (FLIGHT_ID_SEQ.NEXTVAL, 'DL103','DL', '10/20/2019','DAL', 'SAN', '10:00', '23:00');
insert into FLIGHT (ID, NUMBER, AIRLINE_CODE, FLIGHT_DATE, FROM_AIRPORT, TO_AIRPORT, DEPART_TIME, ARRIVAL_TIME) values (FLIGHT_ID_SEQ.NEXTVAL, 'WS104','WS', '10/20/2019','SAN', 'HOU', '10:00', '23:00');
commit;

insert into USER (ID, NAME, EMAIL) values (user_id_seq.NEXTVAL, 'Praveen', 'praveenkumar_s@yahoo.com');
insert into USER (ID, NAME, EMAIL) values (user_id_seq.NEXTVAL, 'Tester', 'tester@yahoo.com');
commit;
