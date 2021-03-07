CREATE TABLE IF NOT EXISTS USERS_NL
(
    login  VARCHAR(64) PRIMARY KEY,
    passwd VARCHAR(64)
);
CREATE TABLE IF NOT EXISTS USER_ROLES_NL
(
    login VARCHAR(64),
    role  VARCHAR(32)
);
DELETE
from USER_ROLES_NL;
DELETE
from USERS_NL;
INSERT into USERS_NL
values ('admin', 'admin');
INSERT into USERS_NL
values ('admin2', 'admin');
INSERT into USERS_NL
values ('WillemI', 'admin');
INSERT into USER_ROLES_NL
values ('admin', 'Manager');
INSERT into USER_ROLES_NL
values ('admin2', 'Civilian');
INSERT into USER_ROLES_NL
values ('WillemI', 'OranjeNassau');
