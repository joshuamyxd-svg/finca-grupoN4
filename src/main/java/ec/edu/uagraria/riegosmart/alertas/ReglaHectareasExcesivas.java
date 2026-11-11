package ec.edu.uagraria.riegosmart.alertas;

import ec.edu.uagraria.riegosmart.dominio.Lectura;
import java.util.Optional;

public class ReglaHectareasExcesivas implements ReglaAlerta {
    @Override
    public Optional<Alerta> evaluar(Lectura lectura) {
        double max = Configuracion.INSTANCIA.getUmbralMaximoHectareas();

        if (lectura.valor() > max) {
            return Optional.of(new Alerta(
                    TipoAlerta.CUOTA_EXCEDIDA, // Usando un tipo válido de tu enum
                    lectura.codigoSensor(),    // Código de origen (sensor)
                    "Alerta Crítica: El sensor " + lectura.codigoSensor() + " excede el límite máximo permitido con " + lectura.valor() + " " + lectura.unidad() + " (máximo: " + max + ")."
            ));
        }
        return Optional.empty();
    }
}