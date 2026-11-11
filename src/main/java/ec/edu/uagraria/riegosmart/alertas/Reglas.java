package ec.edu.uagraria.riegosmart.alertas;

import ec.edu.uagraria.riegosmart.dominio.Lectura;
import java.util.Optional;

/** Las tres reglas del tema, escritas como lambdas. */
public final class Reglas {
    private Reglas() { }

    /** HUMEDAD_SUELO_BAJA: humedad del suelo < humedadMinima. */
    public static ReglaAlerta humedadSueloBaja() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.humedadMinima();

            if (l.valor() < umbral) {
                String detalle = "Humedad del suelo = " + l.valor()
                        + " " + l.unidad() + " (umbral mínimo: " + umbral + ")";
                return Optional.of(new Alerta(TipoAlerta.HUMEDAD_SUELO_BAJA, l.codigoSensor(), detalle));
            }
            return Optional.empty();
        };
    }

    /** TURNO_VENCIDO: horas de retraso del turno programado > retrasoMaximoHoras. */
    public static ReglaAlerta turnoVencido() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.retrasoMaximoHoras();

            if (l.valor() > umbral) {
                String detalle = "Retraso en turno = " + l.valor()
                        + " " + l.unidad() + " (umbral máximo: " + umbral + ")";
                return Optional.of(new Alerta(TipoAlerta.TURNO_VENCIDO, l.codigoSensor(), detalle));
            }
            return Optional.empty();
        };
    }

    /** CUOTA_EXCEDIDA: agua consumida en la semana > cuotaSemanalM3. */
    public static ReglaAlerta cuotaExcedida() {
        return l -> {
            double umbral = Configuracion.INSTANCIA.cuotaSemanalM3();

            if (l.valor() > umbral) {
                String detalle = "Consumo de agua = " + l.valor()
                        + " " + l.unidad() + " (cuota semanal: " + umbral + ")";
                return Optional.of(new Alerta(TipoAlerta.CUOTA_EXCEDIDA, l.codigoSensor(), detalle));
            }
            return Optional.empty();
        };
    }
}
