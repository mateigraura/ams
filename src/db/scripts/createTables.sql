create
    definer = root@localhost procedure createTables()
begin
    CREATE TABLE IF NOT EXISTS `Airlines`
    (
        `code`     INT          NOT NULL AUTO_INCREMENT,
        `name`     varchar(255) NOT NULL UNIQUE,
        `alliance` varchar(255) NOT NULL,
        `mainHub`  varchar(50)  NOT NULL,
        PRIMARY KEY (`code`)
    );

    CREATE TABLE IF NOT EXISTS `Flights`
    (
        `id`          INT          NOT NULL AUTO_INCREMENT,
        `source`      varchar(255) NOT NULL,
        `destination` varchar(255) NOT NULL,
        `status`      INT          NOT NULL,
        `callSign`    varchar(25)  NOT NULL,
        `passengers`  INT          NOT NULL,
        `delay`       TIME         NOT NULL,
        `airlineCode` INT          NOT NULL,
        `planeId`     INT          NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Planes`
    (
        `id`                INT          NOT NULL AUTO_INCREMENT,
        `model`             varchar(155) NOT NULL,
        `manufacturer`      varchar(155) NOT NULL,
        `fuelCapacity`      INT          NOT NULL,
        `passengerCapacity` INT          NOT NULL,
        `maxRange`          INT          NOT NULL,
        `manufactureDate`   DATE         NOT NULL,
        `lastMaintainance`  DATE         NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Inbound`
    (
        `id`            INT  NOT NULL AUTO_INCREMENT,
        `flightDate`    DATE NOT NULL,
        `departureTime` TIME NOT NULL,
        `arrivalTime`   TIME NOT NULL,
        `flightId`      INT  NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Outbound`
    (
        `id`            INT  NOT NULL AUTO_INCREMENT,
        `flightDate`    DATE NOT NULL,
        `departureTime` TIME NOT NULL,
        `arrivalTime`   TIME NOT NULL,
        `flightId`      INT  NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Users`
    (
        `id`           INT          NOT NULL AUTO_INCREMENT,
        `email`        varchar(155) NOT NULL,
        `passwordHash` varchar(155) NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Employees`
    (
        `id`           INT          NOT NULL AUTO_INCREMENT,
        `name`         varchar(255) NOT NULL,
        `email`        varchar(255) NOT NULL,
        `employeeCode` varchar(50)  NOT NULL,
        `userId`       INT          NOT NULL,
        `departmentId` INT          NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Admins`
    (
        `id`            INT          NOT NULL AUTO_INCREMENT,
        `email`         varchar(255) NOT NULL,
        `clearanceType` INT          NOT NULL,
        `userId`        INT          NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Departments`
    (
        `id`             INT          NOT NULL AUTO_INCREMENT,
        `departmentName` varchar(255) NOT NULL,
        `type`           INT          NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Runways`
    (
        `id`     INT         NOT NULL AUTO_INCREMENT,
        `code`   varchar(55) NOT NULL,
        `status` INT         NOT NULL,
        `type`   INT         NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `CheckIn`
    (
        `id`       INT NOT NULL AUTO_INCREMENT,
        `status`   INT NOT NULL,
        `flightId` INT NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `Issues`
    (
        `id`            INT          NOT NULL AUTO_INCREMENT,
        `category`      INT          NOT NULL,
        `status`        INT          NOT NULL,
        `passengerName` varchar(255) NOT NULL,
        `filedBy`       varchar(255) NOT NULL,
        `filedAt`       DATE         NOT NULL,
        `description`   varchar(550) NOT NULL,
        `flightRef`     INT          NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `IssuesLogs`
    (
        `id`   INT         NOT NULL AUTO_INCREMENT,
        `type` varchar(55) NOT NULL,
        `date` DATE        NOT NULL,
        PRIMARY KEY (`id`)
    );

    CREATE TABLE IF NOT EXISTS `AirlinesLogs`
    (
        `id`   INT         NOT NULL AUTO_INCREMENT,
        `type` varchar(55) NOT NULL,
        `date` DATE        NOT NULL,
        PRIMARY KEY (`id`)
    );

    ALTER TABLE `Flights`
        ADD CONSTRAINT `Flights_fk0` FOREIGN KEY (`airlineCode`) REFERENCES `Airlines` (`code`);

    ALTER TABLE `Flights`
        ADD CONSTRAINT `Flights_fk1` FOREIGN KEY (`planeId`) REFERENCES `Planes` (`id`);

    ALTER TABLE `Inbound`
        ADD CONSTRAINT `Inbound_fk0` FOREIGN KEY (`flightId`) REFERENCES `Flights` (`id`);

    ALTER TABLE `Outbound`
        ADD CONSTRAINT `Outbound_fk0` FOREIGN KEY (`flightId`) REFERENCES `Flights` (`id`);

    ALTER TABLE `Employees`
        ADD CONSTRAINT `Employees_fk0` FOREIGN KEY (`userId`) REFERENCES `Users` (`id`);

    ALTER TABLE `Employees`
        ADD CONSTRAINT `Employees_fk1` FOREIGN KEY (`departmentId`) REFERENCES `Departments` (`id`);

    ALTER TABLE `Admins`
        ADD CONSTRAINT `Admins_fk0` FOREIGN KEY (`userId`) REFERENCES `Users` (`id`);

    ALTER TABLE `CheckIn`
        ADD CONSTRAINT `CheckIn_fk0` FOREIGN KEY (`flightId`) REFERENCES `Flights` (`id`);

    ALTER TABLE `Issues`
        ADD CONSTRAINT `Issues_fk0` FOREIGN KEY (`flightRef`) REFERENCES `Flights` (`id`);

end;


