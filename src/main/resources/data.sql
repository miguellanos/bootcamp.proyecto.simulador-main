
DROP TABLE IF EXISTS cliente;

CREATE TABLE cliente (
      id INT AUTO_INCREMENT PRIMARY KEY,
      dni VARCHAR(8) NOT NULL,
      nombre VARCHAR(250) NOT NULL,
      nroTarjeta VARCHAR(16) NOT NULL,
      tipoTarjeta VARCHAR(250) DEFAULT NULL
  );


  insert into cliente (dni, nombre, nroTarjeta, tipoTarjeta)
  values('70438135','Juan', '4444444444', 'Clasica');

  insert into cliente (dni, nombre, nroTarjeta, tipoTarjeta)
  values('12345678','Pedro', '5555555555', 'Oro');

  insert into cliente (dni, nombre, nroTarjeta, tipoTarjeta)
  values('87654321','Maria', '6666666666', 'Plata');


DROP TABLE IF EXISTS formulario;

CREATE TABLE formulario (
      id INT AUTO_INCREMENT PRIMARY KEY,
      dni VARCHAR(8) NOT NULL,
      tipoTarjeta VARCHAR(15) NOT NULL,
      moneda INT NOT NULL,
      monto INT NOT NULL,
      cuotas INT NOT NULL,
      tea DOUBLE NOT NULL,
      diaPago INT NOT NULL
  );

insert into formulario (dni,tipoTarjeta,moneda, monto, cuotas, tea, diaPago)
  values('12345678','Clasica',0,6500, 10, 10.5,15);


insert into formulario (dni,tipoTarjeta,moneda, monto, cuotas, tea, diaPago)
  values('87654321','Platinum',1,10500, 10, 10.5,1);
