CREATE TABLE ACCOUNT_USER
(
    ID                    BIGSERIAL    NOT NULL PRIMARY KEY,
    username              VARCHAR(255) NOT NULL,
    password              VARCHAR(255) NOT NULL,
    firstname             VARCHAR(255) NOT NULL,
    lastname              VARCHAR(255) NOT NULL,
    account_non_expired     BOOLEAN      NOT NULL,
    account_non_locked      BOOLEAN      NOT NULL,
    credentials_non_expired BOOLEAN      NOT NULL,
    enabled               BOOLEAN      NOT NULL
);

CREATE TABLE AUTHORITY
(
    ID   BIGSERIAL    NOT NULL PRIMARY KEY,
    ROLE VARCHAR(255) NOT NULL
);

CREATE TABLE USER_AUTHORITY
(
    USER_ID BIGINT NOT NULL,
    AUTHORITY_ID BIGINT NOT NULL,


    PRIMARY KEY (USER_ID, AUTHORITY_ID),

    CONSTRAINT fk_user_authority_account_user
        FOREIGN KEY (USER_ID)
            REFERENCES ACCOUNT_USER (ID),

    CONSTRAINT fk_user_authority_authority
        FOREIGN KEY (AUTHORITY_ID)
            REFERENCES AUTHORITY (ID)
);



insert into account_user(username, password, firstname, lastname, account_non_expired, account_non_locked, credentials_non_expired, enabled)
values ('user', '$2a$10$bm/sjSmHmELwoW.IPupxPu1E3bPCj3pLN9pqjZEuC1e9PIjTAOmK6', 'Иван', 'Петров', true, true, true,
        true),
       ('admin', '$2a$10$ubbs7jUU0vDMPAUBF/APxOq/99PzC94cq0dsABKvETMGRnuH2Pfey', 'Владимир', 'Иванов', true, true, true,
        true);


insert into authority (role)
values ('USER'),
       ('ADMIN');

insert into user_authority (user_id, authority_id)
values (1, 1),
       (2, 2);