insert into AIRPORTS (select * from CSVREAD('C:\SpringIDE\workspace\com.foxtel.spring.demo\src\main\resources\airports.dat'));

insert into ROUTES (select * from CSVREAD('C:\SpringIDE\workspace\com.foxtel.spring.demo\src\main\resources\routes.dat'));

insert into AIRLINES(select * from CSVREAD('C:\SpringIDE\workspace\com.foxtel.spring.demo\src\main\resources\airlines.dat'));