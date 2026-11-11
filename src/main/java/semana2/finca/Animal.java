package semana2.finca;

public record Animal(String codigo, String especie, double pesoKg, double precioPorKg) implements Activo {
    public Animal {
        // Validación del reto: peso y precio no pueden ser negativos ni cero
        if (pesoKg <= 0 || precioPorKg < 0) {
            throw new IllegalArgumentException("El peso debe ser mayor a cero y el precio no puede ser negativo");
        }
    }
}