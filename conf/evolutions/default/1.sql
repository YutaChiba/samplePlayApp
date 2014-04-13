# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table account (
  id                        bigint auto_increment not null,
  login_id                  varchar(255),
  password                  varchar(255),
  constraint pk_account primary key (id))
;

create table parent (
  id                        bigint auto_increment not null,
  name                      varchar(255),
  create_date               datetime not null,
  update_date               datetime not null,
  constraint pk_parent primary key (id))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table account;

drop table parent;

SET FOREIGN_KEY_CHECKS=1;

