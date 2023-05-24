delete
from Cars;
insert into Cars(name, color, year, plate)
values ('Toyota Camry', 'серый', 2016, 'А862СМ 164 RUS'),
       ('Skoda Octavia', 'черный', 2018, 'A452ММ 164 RUS'),
       ('Lada Priora', 'серый', 2014, 'А777АА 777 RUS'),
       ('Hyundai Solaris', 'желтый', 2020, 'А862СМ 164 RUS'),
       ('Mercedes E', 'белый', 2017, 'П178ПМ 164 RUS');

delete
from Tariffs;
insert into Tariffs(name, rank, min_price, minute_price, kilometer_price, waiting_price, free_waiting, commission)
values ('Эконом', 1, 59, 6, 15, 6, 3, 18),
       ('Комфорт', 2, 89, 6, 20, 6, 3, 19),
       ('Бизнес', 3, 200, 10, 30, 10, 3, 21);

delete
from Roles;
insert into Roles(name)
values ('ROLE_ADMIN'),
       ('ROLE_DRIVER'),
       ('ROLE_CUSTOMER');


create table Tariffs_new
(
    id              bigint           not null,
    rank            bigint           not null,
    name            varchar(255)     not null,
    min_price       double precision not null,
    minute_price    double precision not null,
    kilometer_price double precision not null,
    waiting_price   double precision not null,
    free_waiting    integer          not null,
    commission      double precision not null,
    primary key (id)
);


insert into Tariffs_new(id, name, rank, min_price, minute_price, kilometer_price, waiting_price, free_waiting,
                        commission)
values (1, 'Эконом+', 1, 69, 6, 16, 6, 3, 18),
       (2, 'Комфорт', 2, 89, 7, 21, 7, 4, 19);

select *
from tariffs;
select *
from tariffs_new;

alter table tariffs
    add unique (name);
alter table tariffs_new
    add unique (name);

insert into tariffs(name, rank, min_price, minute_price, kilometer_price, waiting_price, free_waiting, commission)
select name,
       rank,
       min_price,
       minute_price,
       kilometer_price,
       waiting_price,
       free_waiting,
       commission
from tariffs_new
on conflict (name) do update set name            = excluded.name,
                                 rank            = excluded.rank,
                                 min_price       = excluded.min_price,
                                 minute_price    = excluded.minute_price,
                                 kilometer_price = excluded.kilometer_price,
                                 waiting_price   = excluded.waiting_price,
                                 free_waiting    = excluded.free_waiting,
                                 commission      = excluded.commission;


select drivers.id as driver_id, name as car
from drivers
         cross join cars;


alter table users
    add column inviter int references users (id);

select users.username as username, u.username as inviter
from users
         join users as u on u.id = users.inviter;

select username, inviter
from users;


WITH RECURSIVE tmp AS (SELECT id, inviter, username
                       FROM users
                       WHERE inviter is null
                       UNION
                       SELECT users.id, users.inviter, users.username
                       FROM users
                                JOIN tmp
                                     ON users.inviter = tmp.id)

SELECT *
FROM tmp
order by id;

with recursive tmp as
                   (select id, username, inviter, '' :: varchar as inviter_name
                    from users
                    where inviter is null
                    union all
                    select u.id,
                           u.username,
                           u.inviter,
                           t.username
                    from tmp t,
                         users u
                    where u.inviter = t.id)
select *
from tmp;


select d.id, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
where is_active = true
group by d.id
having count(*) < 3;

update users
set is_active = false
where id in (select d.id
             from drivers as d
                      join users u on d.id = u.id
                      join orders o on d.id = o.driver_id
             group by d.id
             having count(*) < 3);

select d.id, o.status, date_trunc('day', o.date) as date, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
group by rollup (d.id, o.status, date_trunc('day', o.date))
order by d.id;

select d.id, o.status, date_trunc('day', o.date) as date, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
group by cube (d.id, o.status, date_trunc('day', o.date))
order by d.id, o.status, date;

select d.id, o.status, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
group by cube (d.id, o.status)
order by d.id;

select d.id, o.status, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
group by grouping sets ((d.id, o.status), (d.id), ())
order by d.id;

select d.id, o.status, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
group by grouping sets ((d.id, o.status), (d.id), (o.status), ())
order by d.id;

select d.id, o.status, date_trunc('day', o.date) as date, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
group by grouping sets ((d.id, o.status, date_trunc('day', o.date)), (d.id, o.status), (d.id), ())
order by d.id;

select d.id, o.status, date_trunc('day', o.date) as date, count(*)
from drivers as d
         join users u on d.id = u.id
         join orders o on d.id = o.driver_id
group by grouping sets ( (d.id, o.status, date_trunc('day', o.date)),
                         (d.id, o.status),
                         (d.id, date_trunc('day', o.date)),
                         (o.status, date_trunc('day', o.date)),
                         (d.id),
                         (o.status),
                         (date_trunc('day', o.date)),
    ())
order by d.id, o.status, date;

select origin, destination, price,
       row_number() over (order by price),
       rank() over (order by price),
       dense_rank() over (order by price),
       ntile(5) over (order by price)
from orders;

select origin, destination, price, t.name,
       rank() over (partition by tariff_id order by price)
from orders
join tariffs t on orders.tariff_id = t.id;

select
       percentile_cont(0.5) within group ( order by price )
from orders
         join tariffs t on orders.tariff_id = t.id;