create
    definer = root@localhost procedure getAirlines()
begin
    select * from `airlines`;
end;


