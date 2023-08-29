-- seed data into departments schema
INSERT INTO `departments`(name, value)
VALUES ("Biochemistry", "biochemistry");
INSERT INTO `departments`(name, value)
VALUES ("Hematology", "hematology");
INSERT INTO `departments`(name, value)
VALUES ("Molecular Diagnostics", "molecular-diagnostics");
INSERT INTO `departments`(name, value)
VALUES ("Serology & Immunology", "serology-and-immunology");
INSERT INTO `departments`(name, value)
VALUES ("Microbiology", "microbiology");


-- seed data into type_of_units schema
INSERT INTO `units`(name) VALUES ("Collection");
INSERT INTO `units`(name) VALUES ("Processing");
INSERT INTO `units`(name) VALUES ("Both");