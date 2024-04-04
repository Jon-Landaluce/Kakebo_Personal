CREATE TABLE  "tipos_movimiento" (
	"id"	TEXT,
	"descripcion"	TEXT NOT NULL,
	PRIMARY KEY("id")
);

CREATE TABLE "categorias" (
	"tipo_movimiento"	TEXT,
	"id"	INTEGER,
	"descripcion"	TEXT NOT NULL,
	FOREIGN KEY("tipo_movimiento") REFERENCES "tipos_movimiento"("id"),
	PRIMARY KEY("id","tipo_movimiento")
);

CREATE TABLE "usuarios" (
	"dni"	TEXT,
	"nombre"	TEXT NOT NULL,
	PRIMARY KEY("dni")
);

CREATE TABLE "movimientos" (
	"id"	INTEGER,
	"fecha"	TEXT NOT NULL,
	"concepto"	TEXT NOT NULL,
	"cantidad"	REAL NOT NULL,
	"dni_usuario"	TEXT NOT NULL,
	"tipo_movimiento"	TEXT NOT NULL,
	"id_categoria"	INTEGER NOT NULL,
	PRIMARY KEY("id" AUTOINCREMENT),
	FOREIGN KEY("dni_usuario") REFERENCES "usuarios"("dni"),
	FOREIGN KEY("tipo_movimiento", "id_categoria") REFERENCES "categorias"("tipo_movimiento", "id")
);

insert into tipos_movimiento (id, descripcion) values ("I", "INGRESOS");
INSERT INTO tipos_movimiento (id, descripcion) VALUES("G", "GASTOS");

INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 1, "EMPLEO");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 2, "PASIVO");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 3, "NEGOCIOS");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 4, "PENSIONES");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("I", 5, "OTROS");

INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 1, "NECESIDAD");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 2, "OCIO");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 3, "CULTURA");
INSERT INTO categorias (tipo_movimiento, id, descripcion) VALUES ("G", 4, "EXTRA");

INSERT INTO usuarios (dni, nombre) VALUES ("DNIPORDEFECTO", "USUARIOPORDEFECTO");

COMMIT;