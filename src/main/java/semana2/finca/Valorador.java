package semana2.finca; // O el paquete donde lo tengas ubicado

import ec.edu.uagraria.riegosmart.dominio.Cultivo;
import ec.edu.uagraria.riegosmart.dominio.InsumoRiego;
import ec.edu.uagraria.riegosmart.dominio.TurnoRiego;

public class Valorador {

    // Ejemplo de método que calcula o procesa información usando el Cultivo
    public double calcularValorCultivo(Cultivo cultivo, double costoPorHectarea) {
        // Usa el método hectareas() que definimos en el record Cultivo
        return cultivo.hectareas() * costoPorHectarea;
    }

    public void mostrarDetalleCultivo(Cultivo cultivo) {
        System.out.println("Código: " + cultivo.codigo());
        System.out.println("Nombre: " + cultivo.nombre());
        System.out.println("Hectáreas: " + cultivo.hectareas());
    }
}