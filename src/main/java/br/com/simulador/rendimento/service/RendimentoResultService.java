package br.com.simulador.rendimento.service;

import java.util.List;

public class RendimentoResultService {

    public void exibirResultadosGerais(double saldoInicial, double saldoAcumulado, List<Double> rendimentosMensais) {

        var rendimentoTotal = rendimentosMensais.stream()
                .mapToDouble(Double::doubleValue)
                .sum();

        System.out.println("--------------------------------------------------------------------------");
        System.out.printf("Saldo inicial: %.2f%n", saldoInicial);
        System.out.printf("Saldo final: %.2f%n", saldoAcumulado);
        System.out.printf("Quanto rendeu: %.2f%n", + rendimentoTotal);
        System.out.printf("Quanto foi investido: %.2f%n", saldoAcumulado - rendimentoTotal);
    }

    public void exibirEstatiscasMensais(int meses, List<Double> saldosMensais, List<Double> rendimentosMensais) {
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("ESTATÍSTICAS");

        for (int mes = 0; mes < meses; mes ++) {
            System.out.println("MÊS: " + (mes + 1));
            System.out.printf("Saldo: %.2f%n", saldosMensais.get(mes));
            System.out.printf("Rendimento: %.2f%n", rendimentosMensais.get(mes));
            System.out.println("---------------------");
        }
    }
}
