/** 为User表初始化数据 **/
CREATE PROCEDURE init_data_for_juser()
BEGIN
	DECLARE i int;
	SET i=1;
	WHILE i<20 DO
		SET @email = CONCAT('xiaoli',i,'@163.com');
		SET @nameStr = CONCAT('xiaoli',i);
		INSERT INTO `jblog`.`juser` (`email`, `password`, `name`, `en_name`, `sex`, `website`, `position`, `isvalid`, `version`) VALUES (@email, '123456', @nameStr, @nameStr, '1', 'http://www.baidu.com', '北京', '1', '0');
    SET i=i+1;
	END WHILE;
END