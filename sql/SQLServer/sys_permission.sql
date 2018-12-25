CREATE TABLE  sys_permission  (
   id  numeric(20) NOT NULL, --COMMENT '主键',
   name  varchar(128) NOT NULL, --COMMENT '资源名称',
   type  varchar(32) NOT NULL, --COMMENT '资源类型：menu,button,model',
   url  varchar(128) DEFAULT NULL, --COMMENT '访问url地址',
   percode  varchar(128) DEFAULT NULL, --COMMENT '权限代码字符串',
   parentid  numeric(20) DEFAULT NULL, --COMMENT '父结点id',
   parentids  varchar(128) DEFAULT NULL, --COMMENT '父结点id列表串',
   sortstring  varchar(128) DEFAULT NULL, --COMMENT '排序号',
   available  char(1) DEFAULT NULL --COMMENT '是否可用,1：可用，0不可用',
  PRIMARY KEY ( id )
)