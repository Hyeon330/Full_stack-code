create database miniproject default character set UTF8;
drop database miniproject;
show databases;

use miniproject;
show tables;
desc member;
insert into member(userid, userpwd, username, tel, email)
values ("admin", "1234", "admin", "010-0000-0000", "admin");
insert into member(userid, userpwd, username, tel, email)
values ("hyeon330", "0330", "hyeon", "010-1111-1111", "hyeon330@gmail.com");
select * from member;
delete from member where not userid="admin" and not userid="hyeon330";

select count(*) cnt
from member
where userid="hyeon330";


drop table schedule;

desc schedule;
select * from schedule;
delete from schedule;
update schedule set color = "778899" where title="test3";
insert into schedule (userid, title, start, end, repeats, color, place, text, public)
values ("hyeon330", "가족여행", "2022-03-16", "2022-03-19", "N/", "87CEEB", "제주도", "개꿀잼~", "Y");

insert into schedule (userid, title, start, end, repeats, color, place, text, public)
values ("hyeon330" ,"test6", "2022-03-22", "2022-03-24", "D/10/6", "0f0", "test6", "test6", null);

select * from schedule;

select title, start, end, repeats, color, place, text
from schedule
where userid='hyeon330' and ((start like '2022-03%' or end like '2022-03%') or not repeats like 'N%');

update schedule
set repeats='N/0' where title='휴가';
