create table M_Nikkei_average(Month varchar(100) primary key,end_price varchar(100),start_price varchar(100),high_price varchar(100),low_price varchar(100),Volum varchar(100),The_day_before_ratio varchar(100));

create table Y_Nikkei_average(Year varchar(100) primary key,end_price varchar(100),start_price varchar(100),high_price varchar(100),low_price varchar(100),Volum varchar(100),The_day_before_ratio varchar(100));

create table D_Nikkei_average(number int auto_increment  primary key,Daily varchar(100),end_price varchar(100),start_price varchar(100),high_price varchar(100),low_price varchar(100),Volum varchar(100),The_day_before_ratio varchar(100));

create table companydata(code int primary key,company_name varchar(100),market_name varchar(100),Classification varchar(100),unit_shares varchar(100));

create table companystock(number int auto_increment primary key,code int,Daily varchar(100),end_price varchar(100),start_price varchar(100),high_price varchar(100),low_price varchar(100),Volum varchar(100),adjust varchar(100));