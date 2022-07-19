insert into person
values (1, 'firstName1', 'lastName1', 25, 'male', now(), now()),
       (2, 'firstName2', 'lastName2', null, null, now(), now());

insert into child
values (1, 'child firstName1', 'child lastName1', 10, 30, 150, now(), now(), 1),
       (2, 'child firstName2', 'child lastName2', 1, null, null, now(), now(), 1)