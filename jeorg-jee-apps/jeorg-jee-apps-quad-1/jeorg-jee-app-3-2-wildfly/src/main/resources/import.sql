CREATE TABLE IF NOT EXISTS USERS
(
    login  VARCHAR(64) PRIMARY KEY,
    passwd VARCHAR(64)
);
CREATE TABLE IF NOT EXISTS USER_ROLES
(
    login VARCHAR(64),
    role  VARCHAR(32)
);
DELETE
from USER_ROLES;
DELETE
from USERS;
INSERT into USERS
values ('admin', 'admin');
INSERT into USERS
values ('IsabelI', 'admin');
INSERT into USERS
values ('FernandoII', 'admin');
INSERT into USERS
values ('FernandoV', 'admin');
INSERT into USERS
values ('JuanaI', 'admin');
INSERT into USERS
values ('FelipeI', 'admin');
INSERT into USER_ROLES
values ('admin', 'Manager');
INSERT into USER_ROLES
values ('IsabelI', 'Trastamara');
INSERT into USER_ROLES
values ('FernandoII', 'Trastamara');
INSERT into USER_ROLES
values ('FernandoV', 'Trastamara');
INSERT into USER_ROLES
values ('JuanaI', 'Trastamara');
INSERT into USER_ROLES
values ('FelipeI', 'Trastamara');
