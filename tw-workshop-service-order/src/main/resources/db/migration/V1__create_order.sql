CREATE TABLE shop (
  ID        VARCHAR(64),
  code      VARCHAR(64),
  name      VARCHAR(50),
  f1        VARCHAR(64),
  f2        VARCHAR(64),
  f3        VARCHAR(64),
  f4        VARCHAR(64),
  f5        VARCHAR(64),
  f6        VARCHAR(64),
  f7        VARCHAR(64),
  f8        VARCHAR(64),
  f9        VARCHAR(64),
  f10        VARCHAR(64),
  CONSTRAINT pk_shop PRIMARY KEY (ID)
);

CREATE TABLE vehicle_order (
  ID             VARCHAR(64),
  vehicle        VARCHAR(50),
  price          INT,
  shop_id        VARCHAR(64),
  shop_code        VARCHAR(64),
  CREATED_AT     DATETIME,
  CONSTRAINT pk_order PRIMARY KEY (ID)
);
