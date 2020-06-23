create
    definer = root@localhost procedure seed()
begin

    declare tableEmpty binary;

    set tableEmpty = (select count(*) = 0 from `departments`);
    if tableEmpty then
        INSERT INTO `departments` (departmentName, type)
        VALUES ('Financial dep.', 1),
               ('Check-in dep.', 2),
               ('Customs dep.', 3),
               ('Ground control dep.', 4);
    end if;

    set tableEmpty = (select count(*) = 0 from `users`);
    if tableEmpty then
        INSERT INTO `users` (email, passwordHash)
        VALUES ('admin1@ams.com', 'ap6MOYaHvdoPYZiyVabUow==,G7U='),
               ('admin2@ams.com', 'j955ArC9inhEpAnqrN7ZCA==,BkA='),
               ('emp1@ams.com', 'Erns/eJtkRlKXnPdSJwodQ==,5MI='),
               ('emp2@ams.com', '/HDm/6BpmK058G0QRMcMBw==,gAE='),
               ('emp3@ams.com', 'FiCJr5gOyDtcPObylaD9Dg==,1x0='),
               ('emp4@ams.com', 'agHqAU1OBwmEb/3afSI7aQ==,a0s='),
               ('emp5@ams.com', 'otcjG6JaKnrQ1bUrYrGnng==,HyU='),
               ('emp6@ams.com', '42O9pCUih0D/iWBEoIb0gw==,jGE='),
               ('emp7@ams.com', 'f94RsC9vPG7eSm+JceiGeQ==,ppg='),
               ('emp8@ams.com', 'WTBkUGw3PSyUsM9uHPCGOQ==,XGk=');
    end if;

    set tableEmpty = (select count(*) = 0 from `admins`);
    if tableEmpty then
        INSERT INTO `admins` (email, clearanceType, userId)
        VALUES ('admin1@ams.com', 1, 1),
               ('admin2@ams.com', 2, 2);
    end if;

    set tableEmpty = (select count(*) = 0 from `employees`);
    if tableEmpty then
        INSERT INTO `employees` (name, email, employeeCode, userId, departmentId)
        VALUES ('Employee 1', 'emp1@ams.com', 'FIN#1021', 3, 1),
               ('Employee 2', 'emp2@ams.com', 'FIN#2320', 4, 1),
               ('Employee 3', 'emp3@ams.com', 'CHKIN#2301', 5, 2),
               ('Employee 4', 'emp4@ams.com', 'CHKIN#3419', 6, 2),
               ('Employee 5', 'emp5@ams.com', 'CSTMS#2912', 7, 3),
               ('Employee 6', 'emp6@ams.com', 'CSTMS#2391', 8, 3),
               ('Employee 7', 'emp7@ams.com', 'GTC#0003', 9, 4),
               ('Employee 8', 'emp8@ams.com', 'GTC#0004', 10, 4);
    end if;

    set tableEmpty = (select count(*) = 0 from `runways`);
    if tableEmpty then
        INSERT INTO `runways` (code, status, type)
        VALUES ('MK-L-R90', 1, 2),
               ('MK-T-RL01', 1, 1),
               ('MK-T-RL02', 1, 1),
               ('MK-T-RL03', 2, 1),

               ('MZ-D-LD90', 1, 3),
               ('MZ-T-LD01', 1, 1),
               ('MZ-T-LD02', 1, 1),
               ('MZ-T-LD03', 3, 1);
    end if;

    set tableEmpty = (select count(*) = 0 from `airlines`);
    if tableEmpty then
        INSERT INTO `airlines` (name, alliance, mainHub)
        VALUES ('Delta Air Lines', 'SkyTeam Alliance', 'Atlanta'),
               ('American Airlines Group', 'One world Alliance', 'Chicago'),
               ('Lufthansa', 'Star Alliance', 'Frankfurt'),
               ('Air France-KLM', 'SkyTeam Alliance', 'Paris-Charles de Gaulle'),
               ('All Nippon Airways', 'Star Alliance', 'Tokyo'),
               ('United Airlines', 'Start Alliance', 'Los Angeles'),
               ('China Southern Airlines', 'SkyTeam Alliance', 'Beijing'),
               ('Alitalia', 'SkyTeam Alliance', 'Milan');
    end if;

    set tableEmpty = (select count(*) = 0 from `planes`);
    if tableEmpty then
        INSERT INTO `planes` (model, manufacturer, fuelCapacity, passengerCapacity,
                              maxRange, manufactureDate, lastMaintainance)
        VALUES ('A320', 'Airbus', 5000, 220, 6500, '1999-09-10', '2020-05-25'),
               ('A320', 'Airbus', 5000, 220, 6500, '2011-09-10', '2020-05-25'),
               ('A380', 'Airbus', 9000, 550, 11000, '2013-09-10', '2020-05-25'),
               ('A350', 'Airbus', 7800, 450, 9800, '2015-09-10', '2020-05-25'),

               ('747', 'Boeing', 9200, 470, 12000, '2003-09-10', '2020-05-25'),
               ('747', 'Boeing', 9200, 470, 12000, '1993-09-10', '2020-05-25'),
               ('737', 'Boeing', 4800, 237, 6490, '2001-09-10', '2020-05-25'),
               ('787', 'Boeing', 6700, 250, 7000, '2013-09-10', '2020-05-25');
    end if;

    set tableEmpty = (select count(*) = 0 from `flights`);
    if tableEmpty then
        INSERT INTO `flights` (source, destination, callSign, passengers, delay, airlineCode, planeId, status)
        VALUES ('LAX', 'AMS', 'SMTH', 194, 0, 1, 1, 5),
               ('LAX', 'CDG', 'CDGT', 211, 0, 2, 2, 5),
               ('LAX', 'OTP', 'OTPT', 491, 0, 3, 3, 5),
               ('LAX', 'LHR', 'CLSY', 443, 0, 4, 4, 5),

               ('AMS', 'LAX', 'AMLX', 421, 0, 5, 5, 5),
               ('LHR', 'LAX', 'LHTX', 432, 0, 6, 6, 5),
               ('CRL', 'LAX', 'SLTD', 201, 0, 7, 7, 5),
               ('SBZ', 'LAX', 'SLRW', 245, 0, 8, 8, 5);
    end if;

    set tableEmpty = (select count(*) = 0 from `inbound`);
    if tableEmpty then
        INSERT INTO `inbound` (flightDate, departureTime, arrivalTime, flightId)
        VALUES (curdate(), '10:00:00', '17:00:00', 5),
               (curdate(), '11:00:00', '18:00:00', 6),
               (curdate(), '12:00:00', '19:00:00', 7),
               (curdate(), '13:00:00', '20:00:00', 8);
    end if;

    set tableEmpty = (select count(*) = 0 from `outbound`);
    if tableEmpty then
        INSERT INTO `outbound` (flightDate, departureTime, arrivalTime, flightId)
        VALUES (curdate(), '10:00:00', '17:00:00', 1),
               (curdate(), '11:00:00', '18:00:00', 2),
               (curdate(), '12:00:00', '19:00:00', 3),
               (curdate(), '13:00:00', '20:00:00', 4);
    end if;

    set tableEmpty = (select count(*) = 0 from `checkin`);
    if tableEmpty then
        INSERT INTO `checkin` (status, flightId)
        VALUES (4, 1),
               (4, 2),
               (4, 3),
               (4, 4),
               (4, 5),
               (4, 6),
               (4, 7),
               (4, 8);
    end if;

    set tableEmpty = (select count(*) = 0 from `issues`);
    if tableEmpty then
        INSERT INTO `issues` (category, status, passengerName, filedBy, filedAt, description, flightRef)
        VALUES (1, 1, 'John Doe', 'Employee A', '2020-05-24',
                'Lost luggage, medium sized, red color, plastic casing, probably on connection flight at LAX',
                5),
               (1, 1, 'Jane Doe', 'Employee B', '2020-04-19',
                'No luggage at arrival, small size, animal print trolley, money, visa and passport inside. Urgent',
                3),

               (2, 3, 'Mike Doe', 'Employee C', '2020-05-14',
                'Expired passport upon arrival, left France by showing ID, needs immediate review regarding entry admission or return flight',
                4),
               (2, 2, 'Berlusconi Andrea', 'Employee D', '2020-05-24',
                'Passport not found, probably not left on plane. ID is not enough for admission.',
                5),

               (3, 3, 'Ramesh Andil', 'Employee D', '2020-05-12',
                'Here on a return flight from India, expired tourist Visa (9 months), came in resume university, says the embassy told him visa is renewed',
                7),
               (3, 3, 'Victor Banksy', 'Employee D', '2020-05-11',
                'Denied entry to the country. Aggressive behavior, needs further investigation, needs to be passed on to police',
                6);
    end if;

end;


