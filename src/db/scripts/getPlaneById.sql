create
    definer = root@localhost procedure getPlaneById(IN planeId_in int)
begin
    select * from `planes` where id = planeId_in;
end;


