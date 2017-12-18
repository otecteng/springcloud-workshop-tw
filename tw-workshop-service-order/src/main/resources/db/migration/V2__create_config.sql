CREATE TABLE system_config (
  ID           VARCHAR(64),
  config_name  VARCHAR(64),
  config_value VARCHAR(64),
  CREATED_AT   DATETIME,
  CONSTRAINT pk_system_config PRIMARY KEY (ID)
)


