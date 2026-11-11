package ec.edu.uagraria.riegosmart.alertas;

import ec.edu.uagraria.riegosmart.dominio.Lectura;
import java.util.Optional;

public class ReglaHectareasBajas implements ReglaAlerta {
    @Override
    public Optional<Alerta> evaluar(Lectura lectura) {
        double umbralMinimo = 10.0; // Umbral mínimo de referencia para la lectura

        if (lectura.valor() < umbralMinimo) {
            return Optional.of(new Alerta(
                    TipoAlerta.CUOTA_EXCEDIDA, // O el tipo de alerta que prefieras del enum
                    lectura.codigoSensor(),
                    "Alerta: El valor registrado (" + lectura.valor() + " " + lectura.unidad() + ") está por debajo del mínimo permitido."
            ));
        }
        return Optional.empty();
    }
}