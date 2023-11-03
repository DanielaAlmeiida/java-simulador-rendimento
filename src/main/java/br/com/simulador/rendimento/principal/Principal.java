package br.com.simulador.rendimento.principal;

import br.com.simulador.rendimento.domain.DadosCalculo;
import br.com.simulador.rendimento.service.Calculadora;
import br.com.simulador.rendimento.service.MensagemInicialService;
import br.com.simulador.rendimento.service.RendimentoResultService;

import java.util.Scanner;

public class Principal {
    private final Scanner scanner;
    private final MensagemInicialService mensagemInicialService;
    private final RendimentoResultService resultService;
    private final Calculadora calculadora;

    public Principal(Scanner scanner, MensagemInicialService mensagemInicialService, Calculadora calculadora, RendimentoResultService resultService) {
        this.scanner = scanner;
        this.mensagemInicialService = mensagemInicialService;
        this.calculadora = calculadora;
        this.resultService = resultService;
    }

    public void iniciarPrograma() {
        mensagemInicialService.exibirMensagemInicial();

        double saldoInicial = lerDouble("Digite o saldo inicial: ");
        double valorInvestimentoMensal = lerDouble("Digite o valor do investimento mensal: ");
        int meses = lerInt("Digite quantos meses você deseja ver o rendimento: ");

        DadosCalculo resultadosCalculos = calculadora.calcularResultados(saldoInicial, meses, valorInvestimentoMensal);

        resultService.exibirResultadosGerais(saldoInicial, resultadosCalculos.saldoAcumulado(), resultadosCalculos.rendimentosMensais());
        resultService.exibirEstatiscasMensais(meses, resultadosCalculos.saldosMensais(), resultadosCalculos.rendimentosMensais());

        scanner.close();
    }

    public double lerDouble(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextDouble();
    }

    public int lerInt(String mensagem) {
        System.out.println(mensagem);
        return scanner.nextInt();
    }

}
