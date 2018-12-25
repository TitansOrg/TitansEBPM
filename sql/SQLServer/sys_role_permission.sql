CREATE TABLE  sys_role_permission  (
   id  varchar(36) NOT NULL,
   sys_role_id  varchar(32) NOT NULL,
   sys_permission_id  varchar(32) NOT NULL ,
  PRIMARY KEY ( id )
)  