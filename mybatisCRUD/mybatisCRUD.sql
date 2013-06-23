CREATE TABLE USER(
    user_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    email_id VARCHAR(45) NOT NULL,
    password VARCHAR(45) NOT NULL,
    first_name VARCHAR(45) NOT NULL,
    last_name VARCHAR(45) DEFAULT NULL,
    PRIMARY KEY (user_id),
    UNIQUE KEY Index_2_email_uniq (email_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;


CREATE TABLE BLOG(
    blog_id INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
    blog_name VARCHAR(40) NOT NULL,
    created_on DATETIME NOT NULL,
    PRIMARY KEY (blog_id)
) ENGINE=InnoDB DEFAULT CHARSET=UTF8;