package ec.edu.uagraria.riegosmart.reglas;

import ec.edu.uagraria.riegosmart.dominio.Cultivo;

public class Calculadora {
    private EstrategiaCalculo estrategia;

    public Calculadora(EstrategiaCalculo estrategia) {
        this.estrategia = estrategia;
    }

    public double ejecutarCalculo(Cultivo cultivo) {
        return estrategia.calcular(cultivo);
    }
}