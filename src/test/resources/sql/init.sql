CREATE TABLE IF NOT EXISTS example.book
(
    id           bigint auto_increment
        primary key,
    name         varchar(30) not null
) default character set utf8 collate utf8_general_ci;

INSERT INTO example.author(name)
VALUES
    ('찰스'),
    ('1박2일 편집부'),
    ('생로병사 편집부'),
    ('EBS'),
    ('내셔널지오그래픽');


CREATE TABLE IF NOT EXISTS example.book
(
    id           bigint auto_increment
        primary key,
    name         varchar(30) not null,
    price        bigint      null,
    published_at datetime    null,
    sale_status  varchar(11) not null,
    author_id    bigint      not null
) default character set utf8 collate utf8_general_ci;

INSERT INTO example.book(
    name, price, published_at, sale_status, author_id
) VALUES
('바람과 함께 사라지다', 11000, '1950-01-01 00:00:00', 'HOLD', 1),
('바람과 함께 사라지다', 12000, '1950-01-02 00:00:00', 'HOLD', 2),
('바람과 함께 사라지다', 13000, '1950-01-03 00:00:00', 'FOR_SALE', 3),
('바람과 함께 사라지다', 14000, '1950-01-04 00:00:00', 'FOR_SALE', 4),
('바람과 함께 사라지다', 15000, '1950-01-05 00:00:00', 'FOR_SALE', 5)
;

