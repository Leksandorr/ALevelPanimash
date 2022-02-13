create table if not exists subscribers
(
    subscriber_id bigserial
        primary key,
    city varchar(255),
    first_name varchar(255),
    last_name varchar(255),
    patronymic varchar(255),
    phone_number bigint,
    current_tariff_id bigint

);

create table if not exists tariffs
(
    tariff_id bigserial
        primary key,
    is_available_for_all boolean,
    package_internet numeric(19,2),
    package_minutes integer,
    package_sms integer,
    price numeric(19,2)
);

create table if not exists equipments
(
    equipment_id bigserial
        primary key,
    model varchar(255)
);

create table if not exists activities
(
    dtype varchar(31) not null,
    activity_id bigserial
        primary key,
    content_sms varchar(255),
    ip varchar(255),
    traffic numeric(19,2),
    equipment_id bigint,
    sender_id bigint,
    receiver_id bigint

);

create table if not exists subscribers_equipments
(
    subscriber_id bigint not null,
    equipment_id bigint not null
);