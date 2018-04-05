CREATE TABLE IF NOT EXISTS items (
  iid serial primary key,
  fname text UNIQUE
);
CREATE TABLE IF NOT EXISTS tracker (
  id serial primary key,
  item_id int NOT NULL,
  rid_items INT REFERENCES items(iid),
  fname text NOT NULL,
  fdesc text NOT NULL,
  fcommit text,
  fdate TIMESTAMP DEFAULT now()
);
INSERT INTO items (fname) VALUES ('Bug') ON CONFLICT DO NOTHING;
INSERT INTO items (fname) VALUES ('Task') ON CONFLICT DO NOTHING;