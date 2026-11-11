package ec.edu.uagraria.riegosmart.alertas;

public enum TipoAlerta {
    HUMEDAD_SUELO_BAJA("Humedad del suelo por debajo del umbral de riego"),
    TURNO_VENCIDO("Turno programado que no se ejecutó a tiempo"),
    CUOTA_EXCEDIDA("Consumo de agua que supera la cuota asignada");

    private final String descripcion;

    TipoAlerta(String descripcion) { this.descripcion = descripcion; }

    public String descripcion() { return descripcion; }
}
