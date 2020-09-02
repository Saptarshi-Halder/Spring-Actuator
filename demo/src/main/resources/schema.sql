DROP TABLE CS_Topic IF EXISTS;;

CREATE TABLE CS_Topic (
	ObjId bigint PRIMARY KEY NOT NULL,
	TopicName varchar(2500) NOT NULL,
	Description varchar(254) NOT NULL,
	
) ;;