package br.com.simulador.rendimento;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class RendimentoApplication {

	public static void main(String[] args) {
		SpringApplication.run(RendimentoApplication.class, args);

			Scanner scanner = new Scanner(System.in);

			//Taxa de rendimento diaria 0.0003887167
			// Por mes: 0.008163

			//Taxa de rendimento diaria 0.00036
			// Por mes: 0.00756

			var rendimentoPicPay = 0.00756;
			double rendimentoAcumulado = 0;

			System.out.print("Este programa calculará quanto de rendimento você terá no cofrinho"
					+ " do picpay, com base no seu saldo inicial, salário mensal e no tempo.\n");

			System.out.print("Digite o saldo inicial: ");
			double saldoInicial = scanner.nextDouble();

			System.out.print("Digite o salário mensal: ");
			double salario = scanner.nextDouble();

			System.out.print("Digite quantos meses você deseja ver o rendimento: ");
			int meses = scanner.nextInt();

			rendimentoAcumulado = saldoInicial;

			//for (int ano = 0; ano <= anos; ano++) {
			for (int mes = 1; mes <= meses; mes ++) {
					rendimentoAcumulado += salario;
					rendimentoAcumulado += (rendimentoAcumulado * rendimentoPicPay);
					System.out.println("SALARIO ADICIONADO - Mês: " + mes);
					System.out.println(rendimentoAcumulado);
				}
			// }

			System.out.println("-----------------------------------");
			System.out.printf("Saldo inicial: %.2f%n", saldoInicial);
			System.out.printf("Saldo final: %.2f%n", rendimentoAcumulado);
			System.out.printf("Quanto foi investido: %.2f%n", (saldoInicial + (salario * meses)));
			System.out.printf("Quanto rendeu: %.2f%n", (rendimentoAcumulado - (saldoInicial + (salario * meses))));

			scanner.close();

	}
}
