create
    definer = root@localhost procedure addAirline(IN name_in varchar(255),  IN alliance_in varchar(255),
                                                  IN mainHub_in varchar(50))
begin
    insert into `airlines` (name, alliance, mainHub)
    values (name_in, alliance_in, mainHub_in);

    select last_insert_id();
end;

