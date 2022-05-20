DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_AgregarPersona`(in Dni varchar(20),in Nombre varchar(45), in Apellido varchar(45))
BEGIN
insert into personas(Dni,Nombre,Apellido) values (Dni,Nombre,Apellido);
END$$
DELIMITER ;

DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_EliminarPersona`(in p_Dni varchar(20))
BEGIN
delete from personas where Dni = p_Dni;
END$$
DELIMITER ;
DELIMITER $$
CREATE DEFINER=`root`@`localhost` PROCEDURE `sp_ModificarPersona`(in p_Dni varchar(20),in p_Nombre varchar(45), in p_Apellido varchar(45))
BEGIN
update personas
set
Nombre = p_Nombre,
Apellido = p_Apellido
where Dni = p_Dni; 
END$$
DELIMITER ;
