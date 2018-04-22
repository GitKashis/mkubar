CREATE TABLE IF NOT EXISTS user_store (
  iid          SERIAL PRIMARY KEY,
  name         TEXT      NOT NULL,
  login        TEXT      NOT NULL UNIQUE,
  email        TEXT      NOT NULL UNIQUE,
  create_date  TIMESTAMP NOT NULL DEFAULT current_timestamp,
  user_password TEXT      NOT NULL
);

CREATE TABLE IF NOT EXISTS roles (
  iid       SERIAL PRIMARY KEY,
  name_role TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS user_role (
  iid       SERIAL PRIMARY KEY,
  iid_user  INTEGER REFERENCES user_store (iid) NOT NULL,
);
