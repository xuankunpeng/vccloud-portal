CREATE TABLE t_portal_info (
  id bigint(12) NOT NULL auto_increment,
  portal_url varchar(1024) collate utf8_bin default NULL,
  logo_url varchar(1024) collate utf8_bin default NULL,
  welcome_word varchar(1024) collate utf8_bin default NULL,
  admin_name varchar(1024) collate utf8_bin default NULL,
  admin_password varchar(1024) collate utf8_bin default NULL,
  display_name varchar(1024) collate utf8_bin default NULL,
  admin_only bit(1) default b'0';
  create_time datetime default NULL,
  update_time datetime default NULL,
  PRIMARY KEY  (id),
  KEY idx_portal_info_1 (portal_url)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

CREATE TABLE t_legacy (
  id bigint(12) NOT NULL auto_increment,
  url varchar(1024) collate utf8_bin default NULL,
  legacy_name varchar(1024) collate utf8_bin default NULL,
  legacy_extension varchar(1024) collate utf8_bin default NULL,
  room_id varchar(1024) collate utf8_bin default NULL,
  create_time datetime default NULL,
  update_time datetime default NULL,
  PRIMARY KEY  (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
