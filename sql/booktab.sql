SELECT * FROM bootdemo.booktab;

select * from booktab where bauthor is not null;

select * from booktab where bname like 'A%';
select * from booktab where bname like '%S';
select * from booktab where bname like '___';
select * from booktab where bname like '%R%';
select * from booktab where bname not like '___';
select * from booktab where bauthor not like 'Shiva';


select * from booktab where btype="FrontEnd" and bcost < 600;