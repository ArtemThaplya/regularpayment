SET MODE PostgreSQL;
CREATE TYPE STATUS AS ENUM ('Active', 'Reversed');

CREATE TABLE IF NOT EXISTS payments (
  id                         SERIAL PRIMARY KEY,
  fullName                   VARCHAR(45) NOT NULL,
  INN                        INT         NOT NULL,
  cardNumber                 INT         NOT NULL,
  beneficiarysCurrentAccount VARCHAR(45) NOT NULL,
  MFO                        INT         NOT NULL,
  OKPO                       INT         NOT NULL,
  recipientsName             VARCHAR(45) NOT NULL,
  retirementPeriod           TIMESTAMP   NOT NULL,
  amountOfPayment            DECIMAL     NOT NULL
);

CREATE TABLE IF NOT EXISTS entries (
  id                          SERIAL PRIMARY KEY,
  idInstructionRegularPayment INT       NOT NULL,
  dateAndTime                 TIMESTAMP NOT NULL,
  amountOfPayment             DECIMAL   NOT NULL,
  status                      STATUS    NOT NULL
);
