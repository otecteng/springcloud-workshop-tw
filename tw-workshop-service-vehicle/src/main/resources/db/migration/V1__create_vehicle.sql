CREATE TABLE vehicle (
  ID             VARCHAR(64),
  NAME           VARCHAR(50),
  PRICE          INT,
  shop_id        VARCHAR(64),
  CREATED_AT     DATETIME,
  CONSTRAINT pk_vehicle PRIMARY KEY (ID)
)
