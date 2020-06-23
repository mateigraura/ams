create
    definer = root@localhost procedure getIssueById(IN id_in int)
begin
    select * from `issues` where id = id_in;
end;


