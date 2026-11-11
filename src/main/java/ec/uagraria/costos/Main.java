package ec.uagraria.costos;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA 1: LOTE DE BANANO ===");
        Lote loteBanano = new Lote("L-01", new Banano("Cavendish"), 4.0, List.of(
                new Insumo("Urea 50 kg", 12, "saco", 32.50),
                new Insumo("Fungicida", 8, "litro", 21.75),
                new Insumo("Semilla certificada", 1, "lote", 180.00)));

        CalculadoraCostos calc = new CalculadoraCostos();

        // 1. Sin estrategia configurada -> Optional.empty
        System.out.println("Sin estrategia: " + calc.calcular(loteBanano));

        // 2. Costo directo (solo insumos) -> Esperado: 744,00
        calc.setEstrategia(Estrategias.costoDirecto());
        System.out.println("Costo Directo: USD " + CalculadoraCostos.redondear(calc.calcular(loteBanano).orElseThrow()));

        // 3. Insumos + mano de obra -> Esperado: 2 076,00
        calc.setEstrategia(Estrategias.costoConManoDeObra());
        System.out.println("Costo con Mano de Obra: USD " + CalculadoraCostos.redondear(calc.calcular(loteBanano).orElseThrow()));

        // 4. Costo por hectárea -> Esperado: 519,00
        calc.setEstrategia(Estrategias.costoPorHectarea());
        System.out.println("Costo por Hectárea: USD " + CalculadoraCostos.redondear(calc.calcular(loteBanano).orElseThrow()));

        // 5. Con subsidio del 20% a la urea -> Esperado: 1 998,00
        calc.setEstrategia(Estrategias.costoConSubsidioFertilizante(0.20));
        System.out.println("Costo con Subsidio (20% Urea): USD " + CalculadoraCostos.redondear(calc.calcular(loteBanano).orElseThrow()));

        // 6. Con IVA del 15% (sobre mano de obra) -> Esperado: 2 387,40
        calc.setEstrategia(Estrategias.conIva(Estrategias.costoConManoDeObra()));
        System.out.println("Costo con IVA (15%): USD " + CalculadoraCostos.redondear(calc.calcular(loteBanano).orElseThrow()));


        System.out.println("\n=== PRUEBA 2: LOTE DE CACAO ORGÁNICO ===");
        Lote loteCacao = new Lote("L-CACAO", new Cacao("Nacional", true), 2.5, List.of(
                new Insumo("Urea 50 kg", 5, "saco", 32.50),
                new Insumo("Abono organico", 30, "saco", 9.80)));

        // Verificando jornales por hectárea (Esperado: 25)
        System.out.println("Jornales por hectárea (Cacao orgánico): " + loteCacao.jornalesPorHectarea());

        // Insumos + mano de obra para cacao orgánico -> Esperado: 1 612,75
        calc.setEstrategia(Estrategias.costoConManoDeObra());
        System.out.println("Costo Insumos + MO (Cacao orgánico): USD " + CalculadoraCostos.redondear(calc.calcular(loteCacao).orElseThrow()));
    }
}