CREATE TABLE vehicle_order (
  ID             VARCHAR(64),
  vehicle        VARCHAR(50),
  price          INT,
  shop_id        VARCHAR(64),
  CREATED_AT     DATETIME,
  CONSTRAINT pk_order PRIMARY KEY (ID)
)
