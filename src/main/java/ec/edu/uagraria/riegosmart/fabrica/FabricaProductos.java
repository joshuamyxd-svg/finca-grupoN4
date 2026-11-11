package ec.edu.uagraria.riegosmart.fabrica;

import ec.edu.uagraria.riegosmart.dominio.Cultivo;
import ec.edu.uagraria.riegosmart.dominio.InsumoRiego;
import ec.edu.uagraria.riegosmart.dominio.TurnoRiego;

public class FabricaProductos {

    // Método centralizado usando un switch exhaustivo (sin default)
    public static Object crearProducto(TipoProducto tipo, String nombre, double valorExtra) {
        return switch (tipo) {
            case CULTIVO -> new Cultivo(nombre, valorExtra); // nombre y hectáreas
            case TURNO -> new TurnoRiego("TUR-" + nombre, "08:00", valorExtra); // código, horario, litros
            case INSUMO -> new InsumoRiego(nombre, (int) valorExtra, "Unidades", 10.0); // nombre, cantidad, unidad, costo
        };
    }

    // Métodos específicos de ayuda si los prefieres mantener limpios:
    public static Cultivo crearCultivo(String nombre, double hectareas) {
        return (Cultivo) crearProducto(TipoProducto.CULTIVO, nombre, hectareas);
    }

    public static TurnoRiego crearTurnoRiego(String codigoTurno, String horario, double litrosAsignados) {
        return new TurnoRiego(codigoTurno, horario, litrosAsignados);
    }

    public static InsumoRiego crearInsumoRiego(String nombre, int cantidad, String unidad, double costoUnitario) {
        return new InsumoRiego(nombre, cantidad, unidad, costoUnitario);
    }
}