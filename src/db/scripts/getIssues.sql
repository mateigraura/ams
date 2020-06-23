create
    definer = root@localhost procedure getIssues()
begin
    select * from `issues`;
end;


