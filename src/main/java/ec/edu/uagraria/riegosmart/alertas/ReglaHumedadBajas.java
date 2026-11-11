package ec.edu.uagraria.riegosmart.alertas;

import ec.edu.uagraria.riegosmart.dominio.Lectura;
import java.util.Optional;

public class ReglaHumedadBajas implements ReglaAlerta {
    @Override
    public Optional<Alerta> evaluar(Lectura lectura) {
        double umbralMinimo = 30.0; // Umbral de prueba

        if (lectura.valor() < umbralMinimo) {
            return Optional.of(new Alerta(
                    TipoAlerta.HUMEDAD_SUELO_BAJA,              // 1. tipo
                    lectura.codigoSensor(),                     // 2. codigoOrigen (el sensor que generó el valor)
                    TipoAlerta.HUMEDAD_SUELO_BAJA.descripcion() // 3. detalle
            ));
        }
        return Optional.empty();
    }
}