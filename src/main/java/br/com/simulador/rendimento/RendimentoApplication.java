package br.com.simulador.rendimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class RendimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RendimentoApplication.class, args);

		Scanner scanner = new Scanner(System.in);

		double rendimentoPicPay = 0.00756;
		double rendimentoAcumulado = 0;

		List<Double> rendimentosMensais = new ArrayList<>();
		List<Double> saldosMensais = new ArrayList<>();


		System.out.println("***************************************************************************");
		System.out.print("Este programa calculará quanto de rendimento você terá no cofrinho do\n"
				+ "PicPay, com base no seu saldo inicial, salário mensal e no tempo em meses.\n" +
				"Bem como o valor do rendimento e saldo de cada mês.\n");
		System.out.println("***************************************************************************");


		System.out.print("Digite o saldo inicial: ");
		double saldoInicial = scanner.nextDouble();

		System.out.print("Digite o valor do investimento mensal: ");
		double valorInvestimentoMensal = scanner.nextDouble();

		System.out.print("Digite quantos meses você deseja ver o rendimento: ");
		int meses = scanner.nextInt();


		rendimentoAcumulado = saldoInicial;

		for (int mes = 0; mes < meses; mes ++) {
			rendimentoAcumulado += valorInvestimentoMensal;

			double rendimentoMensal = rendimentoAcumulado * rendimentoPicPay;
			rendimentosMensais.add(rendimentoMensal);

			rendimentoAcumulado += rendimentoMensal;
			saldosMensais.add(rendimentoAcumulado);

		}


		System.out.println("--------------------------------------------------------------------------");
		System.out.printf("Saldo inicial: %.2f%n", saldoInicial);
		System.out.printf("Saldo final: %.2f%n", rendimentoAcumulado);
		System.out.printf("Quanto foi investido: %.2f%n", (saldoInicial + (valorInvestimentoMensal * meses)));
		System.out.printf("Quanto rendeu: %.2f%n", (rendimentoAcumulado - (saldoInicial + (valorInvestimentoMensal * meses))));

		System.out.println("--------------------------------------------------------------------------");
		System.out.println("ESTATÍSTICAS");

		for (int mes = 0; mes < meses; mes ++) {
			System.out.println("MÊS: " + (mes + 1));
			System.out.printf("Saldo: %.2f%n", saldosMensais.get(mes));
			System.out.printf("Rendimento: %.2f%n", rendimentosMensais.get(mes));
			System.out.println("---------------------");
		}

		scanner.close();

	}
}
