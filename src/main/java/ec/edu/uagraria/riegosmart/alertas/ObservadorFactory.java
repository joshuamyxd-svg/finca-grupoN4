package ec.edu.uagraria.riegosmart.alertas;

import java.util.List;
import java.util.function.Consumer;

public class ObservadorFactory {

    /**
     * Canal 1: Imprime las alertas formateadas directamente en la consola.
     */
    public static Consumer<Alerta> crearObservadorConsola() {
        return alerta -> System.out.println("📢 [CONSOLA] 🚨 Alerta detectada -> " +
                "Tipo: " + alerta.tipo() +
                " | Sensor: " + alerta.codigoOrigen() +
                " | Detalle: " + alerta.detalle());
    }

    /**
     * Canal 2: Guarda las alertas en una bitácora en memoria (List<Alerta>) usando method reference.
     */
    public static Consumer<Alerta> crearObservadorBitacora(List<Alerta> bitacora) {
        // Utiliza la referencia al método add de la lista: bitacora::add
        return bitacora::add;
    }

    /**
     * Canal 3 (Opcional/Simulado): Simula el envío de un SMS o Correo Electrónico.
     */
    public static Consumer<Alerta> crearObservadorSmsSimulado(String numeroDestino) {
        return alerta -> System.out.println("📱 [SMS a " + numeroDestino + "] Enviando notificación urgente: " + alerta.detalle());
    }
}
