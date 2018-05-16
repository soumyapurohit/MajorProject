create database pocketdesk;
use pocketdesk;

create table member(
member_id int auto_increment primary key,
fname varchar(100) not null,
lname varchar(100) not null,
phone varchar(20) unique not null,
email varchar(50) unique not null,
profile_pic varchar(100),
gender varchar(10),
city varchar(100),
dob date,
is_active bool not null default true);

create table user(
user_id int auto_increment primary key,
user_type varchar(20) not null,
login_id varchar(50) unique not null,
password varchar(50) not null,
user_active bool not null default false,
otp int not null,
member_id int);

create table member_qualification(
qualification_id int auto_increment primary key,
title varchar(30) not null,
type varchar(20) not null,
stream varchar(20) not null,
year int  not null,
college varchar(100) not null,
percentage float(5) not null,
member_id int not null, 
foreign key(member_id) references member(member_id) );

create table member_profession(
profession_id int auto_increment primary key,
title varchar(30) not null,
company_name varchar(50) not null,
designation varchar(30) not null,
package varchar(20),
join_date date not null,
end_date date,
city varchar(30) not null,
member_id int not null,
foreign key(member_id) references member(member_id) );

create table network(
network_id int auto_increment primary key,
member_id int not null,
create_date date not null,
network_type varchar(20) not null,
title varchar(50) not null,
profile_pic varchar(100),
network_active bool not null default true,
network_deleted bool not null default false,
foreign key(member_id) references member(member_id));

create table invitation(
invite_id int auto_increment primary key,
network_id int not null,
member_id int not null,
sent_by int not null,
sent_date date not null,
invite_status varchar(10) not null default 'pending',
foreign key(network_id) references network(network_id),
foreign key(member_id) references member(member_id),
foreign key(sent_by) references member(member_id));

create table network_member(
network_member_id int auto_increment primary key,
network_id int not null,
member_id int not null,
join_date date not null,
is_active bool not null default true,
network_member_type varchar(15) not null,
foreign key(network_id) references network(network_id),
foreign key(member_id) references member(member_id));

create table post(
post_id int auto_increment primary key,
network_id int not null,
post_by int not null,
post_date date not null,
post_active bool not null,
post_type varchar(100) not null,
text_data varchar(100) not null,
media_path varchar(100) not null,
foreign key(network_id) references network(network_id),
foreign key(post_by) references network_member(network_member_id));

create table network_chat(
chat_id int auto_increment primary key,
network_id int not null,
chat_date date not null,
chat_msg varchar(100) not null,
sent_by int not null,
chat_active bool not null default true,
foreign key(network_id) references network(network_id),
foreign key(sent_by) references member(member_id));

create table network_drive(
drive_id int auto_increment primary key,
post_id int not null,
post_size float not null,
post_type varchar(50) not null,
post_path varchar(100) not null,
foreign key(post_id)references post(post_id));

create table network_calender(
network_calender_id int  auto_increment primary key,
network_id int not null,
post_by int not null,
post_date date not null,
calender_date date not null,
message varchar(100) not null,
reminder_active bool not null default true,
foreign key(network_id) references network(network_id),
foreign key(post_by) references member(member_id));
