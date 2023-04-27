CREATE TABLE COUNTRY (
    id bigint IDENTITY(1,1) not null,
    name varchar(255),
    primary key(id)
);


CREATE TABLE CITY (
    id bigint IDENTITY(1,1) not null,
    name varchar(255),
    country_id bigint not null,
    primary key(id),
    constraint FK_CITY_COUNTRY foreign key (country_id) references COUNTRY(id)
);


CREATE TABLE ADDRESS (
    id bigint IDENTITY(1,1) not null,
    country_id bigint not null,
    city_id bigint not null,
    street varchar(255),
    zip_number varchar(255),
    primary key(id),
    constraint FK_ADDRESS_COUNTRY foreign key  (country_id) references COUNTRY(id),
    constraint FK_ADDRESS_CITY foreign key (city_id) references CITY(id)
);

CREATE TABLE PERSON (
    id bigint IDENTITY(1,1) not null,
    firstname varchar(255),
    lastname varchar(255),
    email varchar(255) unique,
    password varchar(255),
    username varchar(255) unique,
    address_id bigint not null,
    primary key(id),
    constraint FK_USER_ADDRESS foreign key (address_id) references ADDRESS(id)
);


CREATE TABLE UNIVERSITY(
    id bigint IDENTITY(1,1) not null,
    name varchar(255) not null,
    address_id bigint not null,
    password varchar(255),
    username varchar(255) unique,
    primary key(id),
    constraint FK_UNIVERSITY_ADDRESS foreign key (address_id) references ADDRESS(id)
);

CREATE TABLE FACULTY(
    id bigint IDENTITY(1,1) not null,
    name varchar(255) not null,
    university_id bigint not null,
    primary key (id),
    constraint FK_FACULTY_UNIVERSITY foreign key (university_id) references UNIVERSITY(id)
);

CREATE TABLE PROGRAM(
    id bigint IDENTITY(1,1) not null,
    name varchar(255) not null,
    description varchar(255),
    university_id bigint not null,
    faculty_id bigint,
    primary key(id),
    constraint FK_PROGRAM_UNIVERSITY foreign key (university_id) references UNIVERSITY(id),
    constraint FK_PROGRAM_FACULTY foreign key (faculty_id) references FACULTY(id)
);

CREATE TABLE REGISTERED(
    user_id bigint not null,
    university_id bigint not null,
    start_date date,
    end_date date,
    faculty_id bigint,
    program_id bigint not null,
    constraint PK_REGISTERED primary key (user_id, university_id),
    constraint FK_REGISTERED_USER foreign key (user_id) references PERSON(id),
    constraint FK_REGISTERED_UNIVERSITY foreign key (university_id) references UNIVERSITY(id),
    constraint FK_REGISTERED_FACULTY foreign key (faculty_id) references FACULTY(id),
    constraint FK_REGISTERED_PROGRAM foreign key (program_id) references PROGRAM(id)
);

CREATE TABLE EXCHANGE(
    id bigint IDENTITY(1,1) not null,
    user_id bigint not null,
    university_id bigint not null,
    start_date date,
    end_date date,
    faculty_id bigint,
    program_id bigint not null,
    primary key (id),
    constraint FK_EXCHANGE_USER foreign key (user_id) references PERSON(id),
    constraint FK_EXCHANGE_UNIVERSITY foreign key (university_id) references UNIVERSITY(id),
    constraint FK_EXCHANGE_FACULTY foreign key (faculty_id) references FACULTY(id),
    constraint FK_EXCHANGE_PROGRAM foreign key (program_id) references PROGRAM(id)
);

CREATE TABLE MESSAGE(
    id bigint IDENTITY(1,1) not null,
    from_user_id bigint not null,
    to_user_id bigint not null,
    date date,
    text varchar(255),
    primary key (id),
    constraint FK_MESSAGE_USER_1 foreign key (from_user_id) references PERSON(id),
    constraint FK_MESSAGE_USER_2 foreign key (to_user_id) references PERSON(id)
);

CREATE TABLE REVIEW(
    id bigint IDENTITY(1,1) not null,
    user_id bigint not null,
    university_id bigint not null,
    comment varchar,
    date_posted date,
    primary key (id),
    constraint FK_REVIEW_USER foreign key (user_id) references PERSON(id),
    constraint FK_REVIEW_UNIVERSITY foreign key (university_id) references UNIVERSITY(id)
);