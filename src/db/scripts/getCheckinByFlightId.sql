create
    definer = root@localhost procedure getCheckinByFlightId(IN flightId_in int)
begin
    select * from `checkin` where flightId = flightId_in;
end;


