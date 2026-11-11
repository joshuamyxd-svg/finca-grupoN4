package ec.edu.uagraria.riegosmart.alertas;

/** Las magnitudes que vigila el motor de RiegoSmart. */
public enum Magnitud {
    HUMEDAD_DEL_SUELO("humedad del suelo", "%"),
    HORAS_DE_RETRASO_DEL_TURNO_PROGRAMADO("horas de retraso del turno programado", "h"),
    AGUA_CONSUMIDA_EN_LA_SEMANA("agua consumida en la semana", "m³");

    private final String nombre;
    private final String unidad;

    Magnitud(String nombre, String unidad) { this.nombre = nombre; this.unidad = unidad; }

    public String nombre() { return nombre; }

    public String unidad() { return unidad; }
}
