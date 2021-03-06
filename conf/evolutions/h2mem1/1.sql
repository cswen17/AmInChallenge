# --- !Ups
create table AMNESTY_REPORT (AR_ID INT NOT NULL, IS_PUBLIC INT NOT NULL, TEXT VARCHAR(1024) NOT NULL);
create table OUTPUT_CORPUS (OC_ID INT NOT NULL);
create table INPUT_RULE (IR_ID INT NOT NULL,TYPE VARCHAR NOT NULL,REGEX VARCHAR(128),WORD_DISTANCE INT,RULE_NAME VARCHAR NOT NULL,IRR_FK_ID INT, PRIMARY KEY (IR_ID));
create table INPUT_RULE_RELATION (IRR_ID INT NOT NULL,IR_FK_ID_LEFT INT NOT NULL, IR_FK_ID_RIGHT INT NOT NULL, OC_FK_ID INT, FOREIGN KEY (IR_FK_ID_LEFT) REFERENCES INPUT_RULE(IR_ID), FOREIGN KEY (IR_FK_ID_RIGHT) REFERENCES INPUT_RULE(IR_ID), FOREIGN KEY (OC_FK_ID) REFERENCES OUTPUT_CORPUS(OC_ID), PRIMARY KEY(IRR_ID));

# --- !Downs
drop table AMNESTY_REPORT;
drop table INPUT_RULE;
drop table INPUT_RULE_RELATION;
drop table OUTPUT_CORPUS;

