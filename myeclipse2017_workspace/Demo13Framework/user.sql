CREATE TABLE `user` (
  `username` varchar(10) NOT NULL COMMENT '用户',
  `password` varchar(10) NOT NULL COMMENT '密码',
  `verifycode` varchar(4) DEFAULT NULL COMMENT '验证码',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

