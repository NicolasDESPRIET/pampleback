CREATE DATABASE IF NOT EXISTS myQCMPLUS;
use myQCMPLUS;

-- create table
create table hibernate_sequence (next_val bigint);
insert into hibernate_sequence values ( 1 );

create table p_parcours_question_link (
    parcours_id bigint not null,
    q_id bigint not null
);
create table parcours (
    parcours_id bigint not null auto_increment,
    parcours_date date,
    parcours_nb_failed integer,
    parcours_nb_succes integer,
    parcours_note varchar(255),
    parcours_time double precision,
    parcours_qcm_id bigint,
    parcours_stagiaire_id bigint,
    primary key (parcours_id)
);
create table qcm (
    qcm_id bigint not null auto_increment,
    qcm_author varchar(255),
    qcm_description varchar(255),
    qcm_name varchar(255),
    primary key (qcm_id)
);
create table qcm_qcm_question (
    qcm_qcm_id bigint not null,
    qcm_question_q_id bigint not null
);
create table question_responses (
    question_q_id bigint not null,
    response_value integer,
    response_text varchar(255) not null,
    primary key (question_q_id, response_text)
);
create table questions (
    q_id bigint not null auto_increment,
    q_enonce varchar(255),
    primary key (q_id)
);
create table types (
    type_id bigint not null,
    type_name varchar(255),
    primary key (type_id)
);
create table users (
    user_id bigint not null auto_increment,
    user_name varchar(255),
    user_password varchar(255),
    user_societe varchar(255),
    user_type_id bigint,
    primary key (user_id)
);

-- alter table
alter table p_parcours_question_link add constraint FKgjv4wr6nlib3l2no83f0ytnv1 foreign key (q_id) references questions (q_id);
alter table p_parcours_question_link add constraint FKs3qec0ktqevjw9ebcs0tmke0h foreign key (parcours_id) references parcours (parcours_id);
alter table parcours add constraint FKnb4mig0y2j10qhhh1d8d8sgcv foreign key (parcours_qcm_id) references qcm (qcm_id);
alter table parcours add constraint FK4kxppfbvys63upkw0kcw9xj1e foreign key (parcours_stagiaire_id) references users (user_id);
alter table qcm_qcm_question add constraint FK8iele2t2svu3os6t1dyi8uekl foreign key (qcm_question_q_id) references questions (q_id);
alter table qcm_qcm_question add constraint FKo1ufy565aseos23qrs8wa7vnt foreign key (qcm_qcm_id) references qcm (qcm_id);
alter table question_responses add constraint FKijqoat21w3yb3wmcnhjxcbm8v foreign key (question_q_id) references questions (q_id);
alter table users add constraint FKt62lb79pp2bxxncjkj1kajkrf foreign key (user_type_id) references types (type_id);