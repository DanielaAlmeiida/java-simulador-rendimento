package br.com.simulador.rendimento.domain;

import java.util.List;

public record DadosCalculo(double saldoAcumulado, List<Double> rendimentosMensais, List<Double> saldosMensais) {
}

