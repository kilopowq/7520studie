ALTER TABLE users
  ADD COLUMN login varchar(255) not null,
  ADD COLUMN password varchar(255) not null,
  ADD COLUMN role varchar(255) not null;

alter table users
  add constraint user_login_un unique (login);