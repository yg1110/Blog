CREATE SCHEMA `blog` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin ;

INSERT INTO `blog`.`user` (`email`, `pwd`) VALUES ('aaa', 'aaa');
INSERT INTO `blog`.`user` (`email`, `pwd`) VALUES ('bbb', 'bbb');

use blog;
select * from user;

