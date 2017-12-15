CREATE TABLE vehicle (
  ID             VARCHAR(64),
  NAME           VARCHAR(50),
  PRICE          INT,
  CREATED_AT     DATETIME,
  CONSTRAINT pk_vehicle PRIMARY KEY (ID)
)