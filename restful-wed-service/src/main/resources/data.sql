insert into user_details(id,birth_date,name)
values(1001, current_date(), 'sai');

insert into user_details(id,birth_date,name)
values(1002, current_date(), 'uj');

insert into user_details(id,birth_date,name)
values(1003, current_date(), 'pb');

insert into post(id,description,user_id)
values(2001, 'learn core java', 1001);

insert into post(id,description,user_id)
values(2002, 'learn AWS', 1001);

insert into post(id,description,user_id)
values(2003, 'learn Javascript', 1002);

insert into post(id,description,user_id)
values(2004, 'learn React', 1002);