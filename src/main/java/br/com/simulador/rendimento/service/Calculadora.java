package br.com.simulador.rendimento.service;

import br.com.simulador.rendimento.domain.DadosCalculo;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {
    public DadosCalculo calcularResultados(double saldoInicial, int meses, double valorInvestimentoMensal) {
        final double PORCENTAGEM_RENDIMENTO_MENSAL = 0.00756;
        List<Double> rendimentosMensais = new ArrayList<>();
        List<Double> saldosMensais = new ArrayList<>();
        double saldoAcumulado = saldoInicial;

        for (int mes = 0; mes < meses; mes ++) {
            saldoAcumulado += valorInvestimentoMensal;

            double rendimentoMensal = saldoAcumulado * PORCENTAGEM_RENDIMENTO_MENSAL;
            rendimentosMensais.add(rendimentoMensal);

            saldoAcumulado += rendimentoMensal;
            saldosMensais.add(saldoAcumulado);
        }

        return new DadosCalculo(saldoAcumulado, rendimentosMensais, saldosMensais);
    }
}
