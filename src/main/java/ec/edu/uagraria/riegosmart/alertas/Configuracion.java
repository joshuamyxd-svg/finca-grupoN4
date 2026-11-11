package ec.edu.uagraria.riegosmart.alertas;

/** SINGLETON: los umbrales del tema, en un solo lugar y configurables. */
public enum Configuracion {
    INSTANCIA;

    private double humedadMinima = 25.0;
    private double retrasoMaximoHoras = 2.0;
    private double cuotaSemanalM3 = 500.0;

    public double humedadMinima() { return humedadMinima; }

    public void cambiarHumedadMinima(double nuevo) { humedadMinima = nuevo; }

    public double retrasoMaximoHoras() { return retrasoMaximoHoras; }

    public void cambiarRetrasoMaximoHoras(double nuevo) { retrasoMaximoHoras = nuevo; }

    public double cuotaSemanalM3() { return cuotaSemanalM3; }

    public void cambiarCuotaSemanalM3(double nuevo) { cuotaSemanalM3 = nuevo; }
    // Dentro de tu clase Configuracion:
    public double getUmbralMaximoHectareas() {
        return 100.0; // O el valor numérico que corresponda a tu umbral
    }
}
