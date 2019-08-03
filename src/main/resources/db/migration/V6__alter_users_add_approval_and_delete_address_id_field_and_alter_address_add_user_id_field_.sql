ALTER TABLE users
  ADD COLUMN approval boolean CONSTRAINT approval_default DEFAULT false;
ALTER TABLE users
  DROP CONSTRAINT user_address_fk;
ALTER TABLE users
  DROP COLUMN address_id;

ALTER TABLE address
  ADD COLUMN user_id int8;
ALTER TABLE address
  ADD CONSTRAINT address_user_fk
foreign key (user_id) references users;
