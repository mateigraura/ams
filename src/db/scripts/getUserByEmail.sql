create
    definer = root@localhost procedure getUserByEmail(IN email_in varchar(155))
begin
    select * from users where `email` = email_in;
end;


