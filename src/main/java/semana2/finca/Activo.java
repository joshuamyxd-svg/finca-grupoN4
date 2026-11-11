package semana2.finca;

public sealed interface Activo permits Producto, Cultivo, Animal {
    String codigo();      // todo activo tiene un código
}
