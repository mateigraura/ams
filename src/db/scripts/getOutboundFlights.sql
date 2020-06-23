create
    definer = root@localhost procedure getOutboundFlights()
begin
    select *
    from `outbound` o
             inner join flights f on o.flightId = f.id;
end;


