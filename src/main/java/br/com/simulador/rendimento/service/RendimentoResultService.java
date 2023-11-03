package br.com.simulador.rendimento.service;

import java.util.List;

public class RendimentoResultService {

    public void exibirResultadosGerais(double saldoInicial, double saldoAcumulado, List<Double> rendimentosMensais) {

        var rendimentoTotal = rendimentosMensais.stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.print("""
            --------------------------------------------------------------------------
            Saldo inicial: %.2f
            Saldo final: %.2f
            Quanto foi investido: %.2f
            Quanto rendeu: %.2f
            """.formatted(saldoInicial, saldoAcumulado, saldoAcumulado - rendimentoTotal, rendimentoTotal));
    }

    public void exibirEstatiscasMensais(int meses, List<Double> saldosMensais, List<Double> rendimentosMensais) {
        System.out.println("""
            --------------------------------------------------------------------------
            ESTATÍSTICAS""");

        for (int mes = 0; mes < meses; mes ++) {
            System.out.print("""
                MÊS: %d
                Saldo: %.2f
                Rendimento: %.2f
                ---------------------
                """.formatted(mes + 1, saldosMensais.get(mes), rendimentosMensais.get(mes)));
        }
    }
}
