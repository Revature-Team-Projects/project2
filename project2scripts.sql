create table companies(
	email text,
	company_name text primary key,
	pass text,
	access_code text,
	rating int4
	access_level text,
	link text
);

create table users(
	email text,
	password text,
	first_name text,
	lastname text,
	phone text,
	company text,
	bio text,
	resume text,
	post_id integer,
	rating int4,
	access_level text,
	work_type text,
	primary key(email)
);



ALTER TABLE users 
ADD CONSTRAINT constraint_fkey FOREIGN KEY (post_id) REFERENCES posts(post_id);

foreign key (post_id) references posts(post_id)

create table posts(
	post_id serial primary key,
	status text,
	posting_email text,
	accepting_email text unique,
	referenced_company text,
	posted_time timestamp,
	start_time timestamp,
	end_time timestamp,
	foreign key (posting_email) references users(email),
	foreign key (affiliated_company) references companies(company_name)
);

alter table posts drop constraint posts_accepting_email_key;
              
create table company_user(
company_name text,
email text,
foreign key (company_name) references companies(company_name),
foreign key (email) references users(email)
);



alter table posts add column post_content text;

insert into posts(post_content) values('this is my first post') where post_id = 1; 

select * from posts where post_id = 1;

truncate posts cascade;

alter table users
alter column "rating" type int4;

alter table companies
alter column "rating" type int4;

drop table companies, posts, users;
drop table posts;
drop table users;
drop table company_user;

insert into companies(email, company_name, pass, access_code, rating)
values('company1@email.com', 'company name1', 'password1', '213415', 5);

insert into companies(email, company_name, pass, access_code, rating)
values('company2@email.com', 'company name2', 'password2', '213415', 5);

insert into companies(email, company_name, pass, access_code, rating)
values('company3@email.com', 'company name3', 'password3', '213415', 5);

insert into companies(email, company_name, pass, access_code, rating)
values('company4@email.com', 'company name4', 'password4', '213415', 5);

insert into companies(email, company_name, pass, access_code, rating)
values('company5@email.com', 'company name5', 'password5', '213415', 5);

insert into users (email, password, first_name, last_name, phone, company, bio,resume, rating, access_level, work_type) 
values('test1@test.com', 'password1', 'testfirst', 'testlast', '123-456-7890','testcompany', 'testbio', 'testresume', 2, 'OPEN','FRONTHOUSE');

insert into users (email, password, first_name, last_name, phone, company, bio,resume, rating, access_level, work_type) 
values('test2@test.com', 'password2', 'testfirst', 'testlast', '123-456-7890','testcompany', 'testbio', 'testresume', 2, 'OPEN','FRONTHOUSE');

insert into users (email, password, first_name, last_name, phone, company, bio,resume, rating, access_level, work_type) 
values('test3@test.com', 'password3', 'testfirst', 'testlast', '123-456-7890','testcompany', 'testbio', 'testresume', 2, 'OPEN','FRONTHOUSE');

insert into users (email, password, first_name, last_name, phone, company, bio,resume, rating, access_level, work_type) 
values('test4@test.com', 'password4', 'testfirst', 'testlast', '123-456-7890','testcompany', 'testbio', 'testresume', 2, 'OPEN','FRONTHOUSE');

insert into users (email, password, first_name, last_name, phone, company, bio,resume, rating, access_level, work_type) 
values('test5@test.com', 'password5', 'testfirst', 'testlast', '123-456-7890','testcompany', 'testbio', 'testresume', 2, 'OPEN','FRONTHOUSE');


insert into posts (status,	posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values ('PENDING', 'test1@test.com', 'test2@test.com', 'company name1', '2019-06-22 19:10:25-07', '2019-06-23 19:10:25-07', '2019-06-24 19:10:25-07', 'really insghtful content1');

insert into posts (status,	posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values ('PENDING', 'test1@test.com', 'test3@test.com', 'company name1', '2019-06-25 19:10:25-07', '2019-06-26 19:10:25-07', '2019-06-27 19:10:25-07', 'really insghtful content2');

insert into posts (status,	posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values ('PENDING', 'test1@test.com', 'test4@test.com', 'company name1', '2019-06-28 19:10:25-07', '2019-06-29 19:10:25-07', '2019-06-30 19:10:25-07', 'really insghtful content3');

insert into posts (status,	posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values ('PENDING', 'test1@test.com', 'test5@test.com', 'company name1', '2019-07-01 19:10:25-07', '2019-07-02 19:10:25-07', '2019-07-03 19:10:25-07', 'really insghtful content4');

insert into posts (status,	posting_email, accepting_email, referenced_company, posted_time, start_time, end_time, post_content)
values ('PENDING', 'test1@test.com', 'test6@test.com', 'company name1', '2019-07-01 19:10:25-07', '2019-07-02 19:10:25-07', '2019-07-03 19:10:25-07', 'really insghtful content5');