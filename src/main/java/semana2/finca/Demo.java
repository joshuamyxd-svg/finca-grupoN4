package ec.edu.uagraria.riegosmart;

import ec.edu.uagraria.riegosmart.alertas.*;
import ec.edu.uagraria.riegosmart.dominio.Lectura;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        // 1. Inicializar el motor de alertas
        MotorAlertas motor = new MotorAlertas();

        // 2. Registrar las reglas de negocio (Estrategias)
        motor.agregarRegla(Reglas.humedadSueloBaja());
        motor.agregarRegla(Reglas.turnoVencido());
        motor.agregarRegla(Reglas.cuotaExcedida());

        // 3. Crear la bitácora en memoria para el segundo observador
        List<Alerta> bitacoraMemoria = new ArrayList<>();

        // 4. Suscribir observadores usando la Fábrica
        motor.suscribir(ObservadorFactory.crearObservadorConsola());
        motor.suscribir(ObservadorFactory.crearObservadorBitacora(bitacoraMemoria));
        motor.suscribir(ObservadorFactory.crearObservadorSmsSimulado("+593999999999"));

        // 5. Simular lecturas de sensores (algunas dispararán alertas y otras pasarán normal)
        System.out.println("--- INICIANDO PROCESAMIENTO DE SENSORES ---");

        motor.procesar(new Lectura("SENSOR_HUM_01", 15.0, "PORCENTAJE")); // Debe disparar Humedad Baja
        motor.procesar(new Lectura("SENSOR_TUR_02", 48.0, "HORAS"));     // Debe disparar Turno Vencido
        motor.procesar(new Lectura("SENSOR_AGUA_03", 120.0, "M3"));      // Debe disparar Cuota Excedida
        motor.procesar(new Lectura("SENSOR_HUM_04", 45.0, "PORCENTAJE")); // Normal (sin alerta)

        // 6. Verificar la bitácora en memoria
        System.out.println("\n--- REVISANDO BITÁCORA EN MEMORIA ---");
        System.out.println("Total de alertas registradas en bitácora: " + bitacoraMemoria.size());
        for (Alerta a : bitacoraMemoria) {
            System.out.println("-> Guardada en bitácora: " + a.tipo() + " | " + a.detalle());
        }
    }
}