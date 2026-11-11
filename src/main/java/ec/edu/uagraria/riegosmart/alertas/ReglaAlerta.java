package ec.edu.uagraria.riegosmart.alertas;

import ec.edu.uagraria.riegosmart.dominio.Lectura;
import java.util.Optional;

@FunctionalInterface
public interface ReglaAlerta {
    Optional<Alerta> evaluar(Lectura lectura);
}