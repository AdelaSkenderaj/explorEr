CREATE TABLE [COUNTRY] (
    [id] bigint IDENTITY(1,1) not null,
    [name] varchar(255),
    primary key(id)
);


CREATE TABLE [CITY] (
    [id] bigint IDENTITY(1,1) not null,
    [name] varchar(255),
    [country_id] bigint not null,
    primary key(id),
    constraint FK_CITY_COUNTRY foreign key (country_id) references COUNTRY(id)
);


CREATE TABLE [ADDRESS] (
    [id] bigint IDENTITY(1,1) not null,
    [country_id] bigint not null,
    [city_id] bigint not null,
    [street] varchar(255),
    [zip_number] varchar(255),
    primary key(id),
    constraint FK_ADDRESS_COUNTRY foreign key  (country_id) references COUNTRY(id),
    constraint FK_ADDRESS_CITY foreign key (city_id) references CITY(id)
);

CREATE TABLE [PERSON] (
    [id] bigint IDENTITY(1,1) not null,
    [firstname] varchar(255),
    [lastname] varchar(255),
    [email] varchar(255) unique,
    [password] varchar(255),
    [username] varchar(255) unique,
    [address_id] bigint not null,
    primary key(id),
    constraint FK_USER_ADDRESS foreign key (address_id) references ADDRESS(id)
);


CREATE TABLE [UNIVERSITY](
    [id] bigint IDENTITY(1,1) not null,
    [name] varchar(255) not null,
    [address_id] bigint not null,
    [password] varchar(255),
    [email] varchar(255) unique,
    [funded] date,
    [imgSrc] varchar(255),
    [description] varchar(max),
    primary key(id),
    constraint FK_UNIVERSITY_ADDRESS foreign key (address_id) references ADDRESS(id)
);

CREATE TABLE [FACULTY](
    [id] bigint IDENTITY(1,1) not null,
    [name] varchar(255) not null,
    [university_id] bigint not null,
    primary key (id),
    constraint FK_FACULTY_UNIVERSITY foreign key (university_id) references UNIVERSITY(id)
);

CREATE TABLE [PROGRAM](
    [id] bigint IDENTITY(1,1) not null,
    [name] varchar(255) not null,
    [description] varchar(255),
    [university_id] bigint not null,
    [faculty_id] bigint,
    primary key(id),
    constraint FK_PROGRAM_UNIVERSITY foreign key (university_id) references UNIVERSITY(id),
    constraint FK_PROGRAM_FACULTY foreign key (faculty_id) references FACULTY(id)
);

CREATE TABLE [REGISTERED](
    [user_id] bigint not null,
    [university_id] bigint not null,
    [start_date] date,
    [end_date] date,
    [faculty_id] bigint,
    [program_id] bigint not null,
    constraint PK_REGISTERED primary key (user_id, university_id),
    constraint FK_REGISTERED_USER foreign key (user_id) references PERSON(id),
    constraint FK_REGISTERED_UNIVERSITY foreign key (university_id) references UNIVERSITY(id),
    constraint FK_REGISTERED_FACULTY foreign key (faculty_id) references FACULTY(id),
    constraint FK_REGISTERED_PROGRAM foreign key (program_id) references PROGRAM(id)
);

CREATE TABLE [EXCHANGE_PROGRAM](
    [id] bigint IDENTITY(1,1) not null,
    [host_university_id] bigint not null,
    [available_places] int,
    [start_date] date not null,
    [end_date] date not null,
    [application_deadline] date not null,
    [subject] varchar(255),
    [description] varchar(max),
    primary key (id),
    constraint FK_EXCHANGE_PROGRAM_UNIVERSITY foreign key (host_university_id) references UNIVERSITY(id),
);

CREATE TABLE [OPEN_TO](
    [exchange_program_id] bigint not null,
    [university_id] bigint not null,
    constraint PK_OPEN_TO primary key (exchange_program_id, university_id),
    constraint FK_OPEN_TO_PROGRAM foreign key (exchange_program_id) references EXCHANGE_PROGRAM(id),
    constraint FK_OPEN_TO_UNIVERSITY foreign key (university_id) references UNIVERSITY(id)
);

CREATE TABLE [EXCHANGE_STUDENT](
    [user_id] bigint NOT NULL,
    [exchange_program_id] bigint not null,
    constraint PK_EXCHANGE_STUDENT primary key (user_id, exchange_program_id),
    constraint FK_EXCHANGE_STUDENT_STUDENT foreign key (user_id) references PERSON(id),
    constraint FK_EXCHANGE_STUDENT_PROGRAM foreign key (exchange_program_id) references EXCHANGE_PROGRAM(id)
);

CREATE TABLE [MESSAGE](
    [id] bigint IDENTITY(1,1) not null,
    [from_user_id] bigint not null,
    [to_user_id] bigint not null,
    [date] date,
    [text] varchar(255),
    primary key (id),
    constraint FK_MESSAGE_USER_1 foreign key (from_user_id) references PERSON(id),
    constraint FK_MESSAGE_USER_2 foreign key (to_user_id) references PERSON(id)
);

CREATE TABLE [REVIEW](
    [id] bigint IDENTITY(1,1) not null,
    [user_id] bigint not null,
    [university_id] bigint not null,
    [comment] varchar(500),
    [date_posted] date,
    [rate] integer NOT NULL CHECK (rate >= 1 AND rate <= 5),
    primary key (id),
    constraint FK_REVIEW_USER foreign key (user_id) references PERSON(id),
    constraint FK_REVIEW_UNIVERSITY foreign key (university_id) references UNIVERSITY(id)
);

CREATE TABLE [BLOG](
    [id] bigint IDENTITY(1,1) not null,
    [user_id] bigint not null,
    [subject] varchar(255) not null,
    [description] varchar(max) not null,
    [content] varchar(max) not null,
    [date_posted] date,
    primary key (id),
    constraint BLOG_USER foreign key (user_id) references PERSON(id)
);

CREATE TABLE [TAG](
    [id] bigint IDENTITY(1,1) not null,
    tag varchar(255),
    primary key (id)
);

CREATE TABLE BLOG_TAG(
    [blog_id] bigint NOT NULL,
    [tag_id] bigint NOT NULL,
    constraint PK_BLOG_TAG primary key (blog_id, tag_id),
    constraint FK_BLOG_TAG_BLOG foreign key (blog_id) references BLOG(id),
    constraint FK_BLOG_TAG_TAG foreign key (tag_id) references TAG(id)
);

CREATE TABLE BLOG_COMMENT(
    [blog_id] bigint not null,
    [user_id] bigint not null,
    constraint PK_BLOG_COMMENT primary key (blog_id, user_id),
    constraint FK_BLOG_COMMENT_BLOG foreign key (blog_id) references BLOG(id),
    constraint FK_BLOG_COMMENT_USER foreign key (user_id) references PERSON(id),
)