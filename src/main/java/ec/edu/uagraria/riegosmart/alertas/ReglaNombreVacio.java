package ec.edu.uagraria.riegosmart.alertas;

import ec.edu.uagraria.riegosmart.dominio.Lectura;
import java.util.Optional;

public class ReglaNombreVacio implements ReglaAlerta {
    @Override
    public Optional<Alerta> evaluar(Lectura lectura) {
        // Valida si el código del sensor de la lectura está vacío o nulo
        if (lectura.codigoSensor() == null || lectura.codigoSensor().trim().isEmpty()) {
            return Optional.of(new Alerta(
                    TipoAlerta.TURNO_VENCIDO, // O puedes usar el tipo de alerta que mejor se adapte
                    "SISTEMA",
                    "Alerta: Se detectó una lectura con un código de sensor vacío o inválido."
            ));
        }
        return Optional.empty();
    }
}