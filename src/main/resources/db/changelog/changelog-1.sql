--liquibase formatted sql

--changeset igi:1
create table some_data(
    id int primary key,
    value_1 varchar(254)
);

--rollback drop table some_data;

--changeset igi:2
CREATE SEQUENCE some_data_sequence
    INCREMENT BY 100
    START WITH 1
    NOMAXVALUE
      NOCYCLE
      CACHE 10;

--rollback drop sequence some_data_sequence;
