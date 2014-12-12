CREATE TABLE IF NOT EXISTS Users (
  id INTEGER PRIMARY KEY,
  login VARCHAR(25) UNIQUE NOT NULL,
  password VARCHAR(25) NOT NULL DEFAULT '',
  firstName VARCHAR(50),
  secondName VARCHAR(50),
  email VARCHAR(255),
  comment VARCHAR(500),
  tmLastLogin TIMESTAMP,
  tmRegistered TIMESTAMP
)