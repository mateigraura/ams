create
    definer = root@localhost procedure addIssue(IN category_in int, IN status_in int, IN passengerName_in varchar(255),
                                                IN filedBy_in varchar(255), IN filedAt_in date,
                                                IN description_in varchar(550),
                                                IN flightRef_in int)
begin
    insert into `issues` (category, status, passengerName, filedBy, filedAt, description, flightRef)
    values (category_in, status_in, passengerName_in, filedBy_in, filedAt_in, description_in, flightRef_in);

    select last_insert_id();
end;

