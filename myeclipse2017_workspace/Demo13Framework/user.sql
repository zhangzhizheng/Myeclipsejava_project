CREATE TABLE `user` (
  `username` varchar(10) NOT NULL COMMENT '�û�',
  `password` varchar(10) NOT NULL COMMENT '����',
  `verifycode` varchar(4) DEFAULT NULL COMMENT '��֤��',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

