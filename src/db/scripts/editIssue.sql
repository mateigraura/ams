create
    definer = root@localhost procedure editIssue(IN id_in int, IN category_in int, IN status_in int,
                                                 IN description_in varchar(550))
begin
    update `issues`
    set `category`    = category_in,
        `status`      = status_in,
        `description` = description_in
    where `id` = id_in;

    select * from `issues` where `id` = id_in;
end;

