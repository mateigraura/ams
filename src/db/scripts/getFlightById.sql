create
    definer = root@localhost procedure getFlightById(IN id_in int)
begin
    select * from `flights` where id = id_in;
end;


