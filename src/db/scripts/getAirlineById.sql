create
    definer = root@localhost procedure getAirlineById(IN code_in int)
begin
    select * from `airlines` where code = code_in;
end;


