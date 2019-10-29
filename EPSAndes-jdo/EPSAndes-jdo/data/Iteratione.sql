
CREATE TABLE "Administrador"
(
	"contraseña" VARCHAR(50) NOT NULL,
	"correo" VARCHAR(50) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"tipoDocumento" VARCHAR(50) NOT NULL,
	"administradorID" NUMBER(8,2) NOT NULL,
	"epsID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Organizador"
(
	"contraseña" VARCHAR(50) NOT NULL,
	"correo" VARCHAR(50) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"tipoDocumento" VARCHAR(50) NOT NULL,
	"organizadorID" NUMBER(8,2) NOT NULL,
	"epsID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Afiliado"
(
	"correo" VARCHAR(50) NOT NULL,
	"fechaNacimiento" VARCHAR(50) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"tipoDocumento" VARCHAR(50) NOT NULL,
	"afiliadoID" NUMBER(8,2) NOT NULL,
	"epsID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "CitaMedica"
(
	"horario" VARCHAR(50) NOT NULL,
	"llego" NUMBER(8,2) NOT NULL,
	"sesiones" NUMBER(8,2) NOT NULL,
	"citaMedicaID" NUMBER(8,2) NOT NULL,
	"afiliadoID" NUMBER(8,2) NOT NULL,
    "servicioSaludID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Eps"
(
	"nombre" VARCHAR(50) NOT NULL,
	"epsID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Gerente"
(
	"correo" VARCHAR(50) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"tipoDocumento" VARCHAR(50) NOT NULL,
	"gerenteID" NUMBER(8,2) NOT NULL,
	"epsID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "IPS"
(
	"localizacion" VARCHAR(50) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"iPSID" NUMBER(8,2) NOT NULL,
	"epsID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Medicos"
(
	"Especialidad" VARCHAR(50) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"numeroRegistroMedico" NUMBER(8,2) NOT NULL,
	"tipoDocumento" VARCHAR(50) NOT NULL,
	"medicosID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Ordenes"
(
	"ordenesID" NUMBER(8,2) NOT NULL,
	"afiliadoID" NUMBER(8,2) NOT NULL,
    "servicioID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Recepcionista"
(
	"correo" VARCHAR(50) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"tipoDocumento" VARCHAR(50) NOT NULL,
	"recepcionistaID" NUMBER(8,2) NOT NULL,
	"iPSID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "ServicioSalud"
(
	"horario" VARCHAR(80) NOT NULL,
	"medicosDisponibles" NUMBER(8,2) NOT NULL,
	"nombre" VARCHAR(50) NOT NULL,
	"servicioSaludID" NUMBER(8,2) NOT NULL,
    "iPSID" NUMBER(8,2) NOT NULL
)
;

CREATE TABLE "Trabajan"
(
	"iPSID" NUMBER(8,2),
	"medicosID" NUMBER(8,2)
)
;

ALTER TABLE "Administrador" 
 ADD CONSTRAINT "PK_Administrador"
	PRIMARY KEY ("administradorID") USING INDEX
;

ALTER TABLE "Organizador" 
 ADD CONSTRAINT "PK_Organizador"
	PRIMARY KEY ("organizadorID") USING INDEX
;

ALTER TABLE "Afiliado" 
 ADD CONSTRAINT "PK_Afiliado"
	PRIMARY KEY ("afiliadoID") USING INDEX
;

ALTER TABLE "CitaMedica" 
 ADD CONSTRAINT "PK_CitaMedica"
	PRIMARY KEY ("citaMedicaID") USING INDEX
;

ALTER TABLE "Eps" 
 ADD CONSTRAINT "PK_Eps"
	PRIMARY KEY ("epsID") USING INDEX
;

ALTER TABLE "Gerente" 
 ADD CONSTRAINT "PK_Gerente"
	PRIMARY KEY ("gerenteID") USING INDEX
;

ALTER TABLE "IPS" 
 ADD CONSTRAINT "PK_IPS"
	PRIMARY KEY ("iPSID") USING INDEX
;

ALTER TABLE "Medicos" 
 ADD CONSTRAINT "PK_Medicos"
	PRIMARY KEY ("medicosID") USING INDEX
;

ALTER TABLE "Ordenes" 
 ADD CONSTRAINT "PK_Ordenes"
	PRIMARY KEY ("ordenesID") USING INDEX
;

ALTER TABLE "Recepcionista" 
 ADD CONSTRAINT "PK_Recepcionista"
	PRIMARY KEY ("recepcionistaID") USING INDEX
;

ALTER TABLE "ServicioSalud" 
 ADD CONSTRAINT "PK_ServicioSalud"
	PRIMARY KEY ("servicioSaludID") USING INDEX
;

ALTER TABLE "Administrador" 
 ADD CONSTRAINT "FK_Administrador_Eps"
	FOREIGN KEY ("epsID") REFERENCES "Eps" ("epsID")
;

ALTER TABLE "Organizador" 
 ADD CONSTRAINT "FK_Organizador_Eps"
	FOREIGN KEY ("epsID") REFERENCES "Eps" ("epsID")
;

ALTER TABLE "Afiliado" 
 ADD CONSTRAINT "FK_Afiliado_Eps"
	FOREIGN KEY ("epsID") REFERENCES "Eps" ("epsID")
;

ALTER TABLE "CitaMedica" 
 ADD CONSTRAINT "FK_Servicio"
	FOREIGN KEY ("servicioSaludID") REFERENCES "ServicioSalud" ("servicioSaludID")
;

ALTER TABLE "CitaMedica" 
 ADD CONSTRAINT "FK_CitaMedica_Afiliado"
	FOREIGN KEY ("afiliadoID") REFERENCES "Afiliado" ("afiliadoID")
;

ALTER TABLE "Gerente" 
 ADD CONSTRAINT "FK_Gerente_Eps"
	FOREIGN KEY ("epsID") REFERENCES "Eps" ("epsID")
;

ALTER TABLE "IPS" 
 ADD CONSTRAINT "FK_IPS_Eps"
	FOREIGN KEY ("epsID") REFERENCES "Eps" ("epsID")
;

ALTER TABLE "Ordenes" 
 ADD CONSTRAINT "FK_Ordenes_Afiliado"
	FOREIGN KEY ("afiliadoID") REFERENCES "Afiliado" ("afiliadoID")
;

ALTER TABLE "Ordenes" 
 ADD CONSTRAINT "FK_Ordenes_Servicio"
	FOREIGN KEY ("servicioID") REFERENCES "ServicioSalud" ("servicioSaludID")
;

ALTER TABLE "ServicioSalud" 
 ADD CONSTRAINT "FK_Prestaciones_IPS"
	FOREIGN KEY ("iPSID") REFERENCES "IPS" ("iPSID")
;

ALTER TABLE "Recepcionista" 
 ADD CONSTRAINT "FK_Recepcionista_IPS"
	FOREIGN KEY ("iPSID") REFERENCES "IPS" ("iPSID")
;

ALTER TABLE "Trabajan" 
 ADD CONSTRAINT "FK_Trabajan_IPS"
	FOREIGN KEY ("iPSID") REFERENCES "IPS" ("iPSID")
;

ALTER TABLE "Trabajan" 
 ADD CONSTRAINT "FK_Trabajan_Medicos"
	FOREIGN KEY ("medicosID") REFERENCES "Medicos" ("medicosID")
;

ALTER TABLE "CitaMedica"
ADD CONSTRAINT "CK_llego" CHECK ("llego" < 2) ENABLE;
