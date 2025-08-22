import java.util.Scanner;

public class ControleFinanceiroCSV {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); // Cria o objeto "sc" para ler entradas do usuário
		int menu = 0;
		

		do {	
			System.out.println("MENU");
			System.out.println("1 - Rendas");
			System.out.println("2 - Despesas");
			System.out.println("3 - Relatório");
			System.out.println("4 - Sair");
			System.out.println("Digite o número desejado:");
			menu = sc.nextInt();

			switch (menu) {
			case 1:
				System.out.println("Você escolheu: Rendas");
				Rendas.cadastrarRendas();
				break;
			case 2:
				System.out.println("Você escolheu: Despesas");
				Despesas.menuDespesas();
				break;
			case 3:
				System.out.println("Você escolheu: Relatório");
			    Relatorio.gerarRelatorio();
				break;
			case 4:
				System.out.println("Saindo do programa");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}

		} while (menu != 4);
		 sc.close();
	}
}