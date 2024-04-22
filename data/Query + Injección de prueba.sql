SELECT tipo_movimiento,id,fecha.concepto,cantidad,id_categoria,dni_usuario
FROM movimientos
ORDER BY id desc LIMIT(1);

INSERT into movimientos(fecha,concepto,tipo_movimiento,cantidad,dni_usuario,id_categoria) values(?,?,?,?"DNIPORDEFECTO",?);