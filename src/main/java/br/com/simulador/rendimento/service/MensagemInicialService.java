package br.com.simulador.rendimento.service;

public class MensagemInicialService {

    public void exibirMensagemInicial() {
        System.out.print("""
        ***************************************************************************
        Este programa calculará quanto de rendimento você terá no cofrinho do
        PicPay, com base no seu saldo inicial, salário mensal e no tempo em meses.
        Bem como o valor do rendimento e saldo de cada mês.
        ***************************************************************************
         """);
    }

}
