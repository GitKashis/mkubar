CREATE TABLE IF NOT EXISTS sql_ru_parse (
  iid SERIAL PRIMARY KEY,
  name_topic text NOT NULL,
  url_topic text NOT NULL UNIQUE ,
  body_topic text NOT NULL,
  time_topic TIMESTAMP NOT NULL
);