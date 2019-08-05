-- 아스달연대기 DDL
DROP TABLE Arthdal cascade constraint;


CREATE TABLE Arthdal (
       name          	VARCHAR2(10 CHAR)  PRIMARY KEY,
       racial           VARCHAR2(10 CHAR) NOT NULL,
       tribe         	VARCHAR2(10 CHAR) NOT NULL,
       location         VARCHAR2(10 CHAR) NOT NULL,
       god              VARCHAR2(15 CHAR) NOT NULL
);

CREATE