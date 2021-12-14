BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS invite;
DROP SEQUENCE IF EXISTS seq_invite_id;
DROP TABLE IF EXISTS invite_restaurant;
DROP SEQUENCE IF EXISTS seq_invite_restaurant_id;
DROP TABLE IF EXISTS invite_user;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP TABLE IF EXISTS invite_votes;
DROP SEQUENCE IF EXISTS seq_invite_votes_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;


CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	email varchar(200),
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE SEQUENCE seq_invite_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE invite (
  invite_id int DEFAULT nextval('seq_invite_id'::regclass) NOT NULL,
  host_id int NOT NULL,
  name varchar(200),
  continent_name varchar(200),
  constraint pk_invite primary key (invite_id),
  constraint fk_host foreign key (host_id) references users (user_id)
 );

CREATE SEQUENCE seq_invite_restaurant_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE invite_restaurant (
  invite_restaurant_id int DEFAULT nextval('seq_invite_restaurant_id'::regclass) NOT NULL,
  invite_id int NOT NULL,
  restaurant_id int,
  restaurant_name varchar(200),
  constraint pk_invite_restaurant primary key (invite_restaurant_id),
  constraint fk_invite foreign key (invite_id) references invite (invite_id)
);

CREATE SEQUENCE seq_invite_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE invite_user (
  invitee_id int DEFAULT nextval('seq_invite_user_id'::regclass) NOT NULL,
  invite_id int NOT NULL,
  constraint fk_invitee foreign key (invitee_id) references users (user_id),
  constraint fk_invite foreign key (invite_id) references invite (invite_id)
);

CREATE SEQUENCE seq_invite_votes_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;

CREATE TABLE invite_votes (
  vote_id int DEFAULT nextval('seq_invite_votes_id'::regclass) NOT NULL,
  restaurant_id int NOT NULL,
  voter_id int NOT NULL,
  vote boolean,
  constraint pk_vote primary key (vote_id),
  constraint fk_voter foreign key (voter_id) references users (user_id)
);

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
