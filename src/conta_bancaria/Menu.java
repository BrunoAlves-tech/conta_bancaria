package conta_bancaria;

import java.io.IOException;

import java.util.Scanner;

import conta_bancaria.model.ContaCorrente;
import conta_bancaria.model.ContaPoupanca;
import conta_bancaria.util.Cores;
import conta_bancaria.controller.ContaController;

public class Menu {
	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);
ContaController contas = new ContaController();
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		double saldo, limite;
		
		
		
		ContaCorrente cc1 = new ContaCorrente(2, 456, 1, "Bruno Alves", 600000,600000 );
		cc1.visualizar();
		
		cc1.sacar(659000);
		cc1.visualizar();
		
		cc1.depositar(590000);
		cc1.visualizar();
		
		ContaPoupanca cp1 = new ContaPoupanca(2, 456, 2, "Bruno Alves", 600000, 5, 7);
		cp1.visualizar();
		
		cp1.sacar(659000);
		cp1.visualizar();
		
		cp1.depositar(590000);
		cp1.visualizar();
		
		while (true) {

			System.out.println(Cores.TEXT_YELLOW + Cores.ANSI_BLACK_BACKGROUND
					+ "*****************************************************");
			System.out.println("                                                     ");
			System.out.println("                BANCO DO BRAZIL COM Z                ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("                                                     ");
			System.out.println("            1 - Criar Conta                          ");
			System.out.println("            2 - Listar todas as Contas               ");
			System.out.println("            3 - Buscar Conta por Numero              ");
			System.out.println("            4 - Atualizar Dados da Conta             ");
			System.out.println("            5 - Apagar Conta                         ");
			System.out.println("            6 - Sacar                                ");
			System.out.println("            7 - Depositar                            ");
			System.out.println("            8 - Transferir valores entre Contas      ");
			System.out.println("            9 - Sair                                 ");
			System.out.println("                                                     ");
			System.out.println("*****************************************************");
			System.out.println("Entre com a opção desejada:                          ");
			System.out.println("                                                     " + Cores.TEXT_RESET);

			opcao = leia.nextInt();

			if (opcao == 9) {
				System.out.println(Cores.TEXT_WHITE_BOLD + "\nBanco do Brazil com Z - O seu Futuro começa aqui!");
				sobre();
				leia.close();
				System.exit(0);
			}

			switch (opcao) {
			case 1:
 				System.out.println("CRIAR CONTA");
 				
 				System.out.println("Digite o numero da agencia: ");
 				agencia = leia.nextInt();
 				
 				System.out.println("Digite o nome do titular: ");
 				leia.skip("\\R");
 				titular = leia.nextLine();
 				
 				System.out.println("Digite o tipo da conta (1 - CC | 2 - CP): ");
 				tipo = leia.nextInt();
 				
 				System.out.println("Digite o saldo inicial da conta");
 				saldo = leia.nextFloat();
 				
 				
 				switch(tipo) {
 				case 1 ->{
 						System.out.println("Digite o limite da conta: ");
 						limite = leia.nextFloat();
 						contas.cadastrar(new ContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
 					}
 				case 2->{
 						System.out.println("Digite o dia de aniversário da conta: ");
 						aniversario = leia.nextInt();
 						System.out.println("Digite a taxa de juros:");
 						float juros = leia.nextFloat();
 						contas.cadastrar(new ContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario, juros));
 				}
 				}
			
 				
 				
 				keyPress();
 				break;
 			
 			case 2:
 				System.out.println("LISTAR CONTAS");
 				contas.listarTodas();
 				
 				
 				keyPress();
 				break;
 				
 				
 			case 3:
 				System.out.println("BUSCAR CONTA");
 				System.out.println("Digite o numero da conta que deseja buscar: ");
 				numero = leia.nextInt();
 				
 				contas.procurarPorNumero(numero);
 				
 				keyPress();
 				break;
			case 4:
				System.out.println(Cores.TEXT_WHITE + "Atualizar dados da Conta\n\n");

				keyPress();
				break;
			case 5:
				System.out.println(Cores.TEXT_WHITE + "Apagar a Conta\n\n");

				keyPress();
				break;
			case 6:
				System.out.println(Cores.TEXT_WHITE + "Saque\n\n");

				keyPress();
				break;
			case 7:
				System.out.println(Cores.TEXT_WHITE + "Depósito\n\n");

				keyPress();
				break;
			case 8:
				System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

				keyPress();
				break;
			default:
				System.out.println(Cores.TEXT_RED_BOLD + "\nOpção Inválida!\n" + Cores.TEXT_RESET);
				keyPress();
				break;
			}
		}
	}

	public static void sobre() {
		System.out.println("\n*********************************************************");
		System.out.println("Projeto Desenvolvido por: ");
		System.out.println("Generation Brasil - generation@generation.org");
		System.out.println("github.com/conteudoGeneration");
		System.out.println("*********************************************************");
	}

	public static void keyPress() {

		try {

			System.out.println(Cores.TEXT_RESET + "\n\nPressione Enter para Continuar...");
			System.in.read();

		} catch (IOException e) {

			System.out.println("Você pressionou uma tecla diferente de enter!");

		}
	}

}
