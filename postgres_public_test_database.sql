create table test_database
(
    one   serial       not null
        constraint test_database_pkey
            primary key,
    two   varchar(128) not null,
    three varchar(128) not null
);

alter table test_database
    owner to postgres;

INSERT INTO public.test_database (one, two, three) VALUES (1, '2', '3');
INSERT INTO public.test_database (one, two, three) VALUES (4, '5', '6');
INSERT INTO public.test_database (one, two, three) VALUES (7, '8', '9');