CREATE TABLE IF NOT EXISTS USERS_PRIDE
(
    login  VARCHAR(64) PRIMARY KEY,
    passwd VARCHAR(64)
);
CREATE TABLE IF NOT EXISTS USER_ROLES_PRIDE
(
    login VARCHAR(64),
    role  VARCHAR(32)
);
DELETE
from USER_ROLES_PRIDE;
DELETE
from USERS_PRIDE;
INSERT into USERS_PRIDE
values ('admin', 'admin');
INSERT into USERS_PRIDE
values ('admin2', 'admin');
INSERT into USER_ROLES_PRIDE
values ('admin', 'Manager');
INSERT into USER_ROLES_PRIDE
values ('admin2', 'Organizer');
