package br.com.simulador.rendimento;

import br.com.simulador.rendimento.principal.Principal;
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
		RendimentoResultService rendimentoResultService = new RendimentoResultService();
		MensagemInicialService mensagemInicialService = new MensagemInicialService();
		Scanner scanner = new Scanner(System.in);

		Principal principal = new Principal(rendimentoResultService, mensagemInicialService, scanner);
		principal.iniciarPrograma();
	}
}
