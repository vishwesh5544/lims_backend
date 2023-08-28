DROP TABLE IF EXISTS `departments`;

CREATE TABLE departments
(
    id    int(11) AUTO_INCREMENT NOT NULL,
    name  varchar(255)           NOT NULL,
    value varchar(255)           NOT NULL,
    primary key (id),
    unique (id)
);