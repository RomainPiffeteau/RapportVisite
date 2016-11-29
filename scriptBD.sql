create table RV_visitor(
id int not null,
name char(32) not null,
firstName char(32) not null,
CONSTRAINT pk_rv_visitor PRIMARY KEY (id)
)

create table RV_practitioner(
id int not null,
name char(32) not null,
firstName char(32) not null,
sector char(32) null,
activity char null,
activityPrecisions char(128) null,
CONSTRAINT pk_rv_practitioner PRIMARY KEY (id)
)

create table RV_product(
id int not null,
name char(32) not null,
CONSTRAINT pk_rv_product PRIMARY KEY (id)
)

create table RV_labo(
id int not null,
name char(32) not null,
address char(128) null,
tel longint null,
fax longint null,
CONSTRAINT pk_rv_labo PRIMARY KEY (id)
)

create table RV_visit(
idVisitor int not null,
idPractitioner int not null,
date datetime not null,
dateLast datetime null,
comment char(128) null,
CONSTRAINT fk_rv_visitor_visit FOREIGN KEY (idVisitor) REFERENCES rv_visitor(id),
CONSTRAINT fk_rv_practitioner_visit FOREIGN KEY (idPractitioner) REFERENCES rv_practitioner(id),
CONSTRAINT pk_rv_visit PRIMARY KEY (idVisitor, idPractitioner, date)
)

create table RV_visit_products(
idVisitor int not null,
idPractitioner int not null,
dateVisit datetime not null,
idProduct int not null,
CONSTRAINT fk_rv_visitor_visit_visitproducts FOREIGN KEY (idVisitor,idPractitioner,dateVisit) REFERENCES rv_visit(idVisitor, idPractitioner, date),
CONSTRAINT fk_rv_product_visitproducts FOREIGN KEY (idProduct) REFERENCES rv_product(id),
CONSTRAINT pk_rv_visit PRIMARY KEY (idVisitor, idPractitioner, dateVisit, idProduct)
)

create table RV_knowing(
idPractitioner int not null,
idProduct int not null,
presc int null,
presc25 char(128) null,
presc75 char(128) null,
instructions char(128) null,
instructComment char(128) null,
productComment char(128) null
CONSTRAINT fk_rv_practitioner_knowing FOREIGN KEY (idPractitioner) REFERENCES rv_practitioner(id),
CONSTRAINT fk_rv_product_knowing FOREIGN KEY (idProduct) REFERENCES rv_product(id),
CONSTRAINT pk_rv_knowing PRIMARY KEY (idPractitioner, idProduct)
)

create table RV_opinion(
idPractitioner int not null,
idLabo int not null,
opinion int not null,
comment char(128) null,
participComment char(128) null,
CONSTRAINT pk_rv_opinion PRIMARY KEY (idPractitioner, idLabo)
)

GRANT SELECT,INSERT,UPDATE ON RV_visitor TO JeanMedicament
GRANT SELECT,INSERT,UPDATE ON RV_practitioner TO JeanMedicament
GRANT SELECT,INSERT,UPDATE ON RV_product TO JeanMedicament
GRANT SELECT,INSERT,UPDATE ON RV_labo TO JeanMedicament
GRANT SELECT,INSERT,UPDATE ON RV_visit TO JeanMedicament
GRANT SELECT,INSERT,UPDATE ON RV_visit_products TO JeanMedicament
GRANT SELECT,INSERT,UPDATE ON RV_knowing TO JeanMedicament
GRANT SELECT,INSERT,UPDATE ON RV_opinion TO JeanMedicament