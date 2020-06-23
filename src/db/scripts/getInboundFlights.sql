create
    definer = root@localhost procedure getInboundFlights()
begin
    select *
    from `inbound` i
             inner join flights f on i.flightId = f.id;
end;


