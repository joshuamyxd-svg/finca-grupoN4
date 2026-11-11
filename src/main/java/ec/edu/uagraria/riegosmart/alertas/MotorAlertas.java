package ec.edu.uagraria.riegosmart.alertas;

import ec.edu.uagraria.riegosmart.dominio.Lectura;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class MotorAlertas {
    private final List<ReglaAlerta> reglas = new ArrayList<>();
    private final List<Consumer<Alerta>> observadores = new ArrayList<>();

    // Registra una regla de alerta
    public void agregarRegla(ReglaAlerta regla) {
        reglas.add(regla);
    }

    // Suscribe un observador (lambda o listener)
    public void suscribir(Consumer<Alerta> observador) {
        observadores.add(observador);
    }

    // Procesa una LECTURA a través de todas las reglas registradas
    public int procesar(Lectura lectura) {
        int contador = 0;
        for (ReglaAlerta regla : reglas) {
            Optional<Alerta> alertaOpt = regla.evaluar(lectura);
            if (alertaOpt.isPresent()) {
                Alerta alerta = alertaOpt.get();
                notificarObservadores(alerta);
                contador++;
            }
        }
        return contador;
    }

    // Notifica a todos los observadores suscritos
    private void notificarObservadores(Alerta alerta) {
        for (Consumer<Alerta> observador : observadores) {
            observador.accept(alerta);
        }
    }
}