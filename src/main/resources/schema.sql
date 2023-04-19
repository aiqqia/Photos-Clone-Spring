create table if not exists PHOTOZ (
    id bigint auto_increment primary key,
    file_name varchar(255),
    content_type varchar(255),
    data varbinary(1000000000)
);