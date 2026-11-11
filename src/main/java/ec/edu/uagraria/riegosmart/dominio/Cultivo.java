package ec.edu.uagraria.riegosmart.dominio;

public record Cultivo(String codigo, String nombre, double hectareas) implements Activo {

    // Constructor alternativo por si lo llamas con solo 2 datos
    public Cultivo(String nombre, double hectareas) {
        this("CUL-" + nombre.toUpperCase().replaceAll("\\s+", ""), nombre, hectareas);
    }
}