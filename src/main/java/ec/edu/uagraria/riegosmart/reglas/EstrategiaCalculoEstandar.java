package ec.edu.uagraria.riegosmart.reglas;

import ec.edu.uagraria.riegosmart.dominio.Cultivo;

public class EstrategiaCalculoEstandar implements EstrategiaCalculo {
    @Override
    public double calcular(Cultivo cultivo) {
        // Ejemplo de cálculo usando las hectáreas del cultivo
        return cultivo.hectareas() * 50.0;
    }
}