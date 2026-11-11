package ec.edu.uagraria.riegosmart.dominio;

public record Producto(String codigo, String nombre, double precioUnitario,
                       int unidades) implements Activo {
    public Producto {                               // constructor compacto
        if (precioUnitario < 0 || unidades < 0)
            throw new IllegalArgumentException("Valores negativos");
    }
}
