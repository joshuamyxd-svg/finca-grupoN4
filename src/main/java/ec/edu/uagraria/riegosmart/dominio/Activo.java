package ec.edu.uagraria.riegosmart.dominio;

public sealed interface Activo permits Producto, Animal, Cultivo {
    String codigo();      // todo activo tiene un código
}