# --- !Ups
create table "AMNESTY_REPORT" ("AR_ID" INT NOT NULL, "IS_PUBLIC" INT NOT NULL, "TEXT" VARCHAR(1024) NOT NULL);

# --- !Downs
drop table "AMNESTY_REPORT";
