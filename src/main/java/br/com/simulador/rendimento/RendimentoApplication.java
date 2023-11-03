package br.com.simulador.rendimento;

import br.com.simulador.rendimento.principal.Principal;
import br.com.simulador.rendimento.service.Calculadora;
import br.com.simulador.rendimento.service.MensagemInicialService;
import br.com.simulador.rendimento.service.RendimentoResultService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;


@SpringBootApplication
public class RendimentoApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(RendimentoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Scanner scanner = new Scanner(System.in);
		MensagemInicialService mensagemInicialService = new MensagemInicialService();
		RendimentoResultService rendimentoResultService = new RendimentoResultService();
		Calculadora calculadora = new Calculadora();

		Principal principal = new Principal(scanner, mensagemInicialService, calculadora, rendimentoResultService);
		principal.iniciarPrograma();
	}
}
