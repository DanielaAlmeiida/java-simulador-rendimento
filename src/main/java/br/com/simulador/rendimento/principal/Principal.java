package br.com.simulador.rendimento.principal;

import br.com.simulador.rendimento.domain.DadosCalculo;
import br.com.simulador.rendimento.service.Calculadora;
import br.com.simulador.rendimento.service.MensagemInicialService;
import br.com.simulador.rendimento.service.RendimentoResultService;

import java.util.List;
import java.util.Scanner;

public class Principal {
    RendimentoResultService resultService;
    MensagemInicialService mensagemInicialService;
    Scanner scanner;

    public Principal(RendimentoResultService resultService, MensagemInicialService mensagemInicialService, Scanner scanner) {
        this.resultService = resultService;
        this.mensagemInicialService = mensagemInicialService;
        this.scanner = scanner;
    }

    public void iniciarPrograma() {
        mensagemInicialService.exibirMensagemInicial();

        System.out.print("Digite o saldo inicial: ");
        double saldoInicial = scanner.nextDouble();

        System.out.print("Digite o valor do investimento mensal: ");
        double valorInvestimentoMensal = scanner.nextDouble();

        System.out.print("Digite quantos meses você deseja ver o rendimento: ");
        int meses = scanner.nextInt();


        Calculadora calculadora = new Calculadora();
        DadosCalculo resultadosCalculos = calculadora.calcularResultados(saldoInicial, meses, valorInvestimentoMensal);


        double saldoAcumulado = resultadosCalculos.saldoAcumulado();
        List<Double> rendimentosMensais = resultadosCalculos.rendimentosMensais();
        List<Double> saldosMensais = resultadosCalculos.saldosMensais();

        resultService.exibirResultadosGerais(saldoInicial, saldoAcumulado, rendimentosMensais);
        resultService.exibirEstatiscasMensais(meses, saldosMensais, rendimentosMensais);

        scanner.close();
    }

}
