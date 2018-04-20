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
  iid_roles INTEGER REFERENCES roles (iid)      NOT NULL
);

INSERT INTO roles (name_role) VALUES ('admin')
ON CONFLICT DO NOTHING;
INSERT INTO roles (name_role) VALUES ('user')
ON CONFLICT DO NOTHING;
INSERT INTO roles (name_role) VALUES ('hr')
ON CONFLICT DO NOTHING;

CREATE VIEW users_view AS
  SELECT
    us.iid,
    us.name,
    us.login,
    us.email,
    us.create_date,
    us.user_password,
    rol.name_role
  FROM user_store AS us
    LEFT JOIN user_role AS ur ON us.iid = ur.iid_user
    LEFT JOIN roles AS rol ON ur.iid_roles = rol.iid;