import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Despesas {
	public static HashMap<String, Double> despesasMap = new HashMap<>();
	static Scanner sc = new Scanner(System.in);

	public static void menuDespesas() {
		int opcao;

		do {
			System.out.println("\nMENU DE DESPESAS");
			System.out.println("1 - Cadastrar Nova Despesa");
			System.out.println("2 - Mostrar Todas as Despesas");
			System.out.println("3 - Limpar Todas as Despesas");
			System.out.println("4 - Voltar ao Menu Principal");
			System.out.print("Escolha uma opção: ");

			// Validação para entrada numérica
			while (!sc.hasNextInt()) {
				System.out.println("Erro: Por favor, digite um número (1-4)!");
				sc.next(); // Limpa o valor inválido
				System.out.print("Escolha uma opção: ");
			}
			
			opcao = sc.nextInt();
			sc.nextLine();

			switch (opcao) {
			case 1:
				cadastrarDespesas();
				break;
			case 2:
				mostrarDespesas();
				break;
			case 3:
				limparDespesas();
				break;
			case 4:
				System.out.println("Voltando ao menu principal...");
				break;
			default:
				System.out.println("Opção inválida! Tente novamente.");
			}

		} while (opcao != 4);
	}

	private static void limparDespesas() {
		System.out.print("Tem certeza que deseja limpar TODAS as despesas? (s/n): ");
		char confirmacao = sc.next().charAt(0);

		if (confirmacao == 's' || confirmacao == 'S') {
			despesasMap.clear();
			System.out.println("Todas as despesas foram removidas.");
		} else {
			System.out.println("Operação cancelada.");
		}
	}

	public static void cadastrarDespesas() {
		char continuar;

		System.out.println("\nCADASTRO DE DESPESAS");
		do {

			System.out.print("Digite o nome da despesa: ");
			String nome = sc.nextLine(); // lê o nome da despesa

			System.out.print("Digite o valor de " + nome + ": R$ ");
			double valorMensal = sc.nextDouble();
			sc.nextLine();

			despesasMap.put(nome, valorMensal); // Guarda os nomes e valores ligados

			System.out.println("Despesa " + nome + " de R$ " + valorMensal + " cadastrada!");
			System.out.print("\nDeseja cadastrar outra despesa? (s/n): ");
			continuar = sc.next().charAt(0);
			sc.nextLine();
			System.out.println();
		} while (continuar == 's' || continuar == 'S');
		System.out.println("Total de despesas cadastradas: " + despesasMap.size());
		System.out.println("Gasto mensal total: R$ " + getTotalDespesas());
	}

	public static double getTotalDespesas() {
		double total = 0;
		for (double valor : despesasMap.values()) {
			total += valor;
		}
		return total;
	}

	public static void mostrarDespesas() {
		if (despesasMap.isEmpty()) {
			System.out.println("Nenhuma despesa cadastrada.");
		} else {
			System.out.println("\nLISTA DE DESPESAS");
			int i = 1;
			for (Map.Entry<String, Double> entry : despesasMap.entrySet()) {
				// Map.Entry: Representa um par chave-valor dentro do Map.
				// entrada.getKey(): Obtém a chave do par, no caso o nome da despesa.
				// entrada.getValue(): Obtém o valor do par, no caso o valor da despesa.
				System.out.println(i + ". " + entry.getKey() + ": R$ " + entry.getValue());
				i++;
			}
			System.out.println("Total: R$ " + getTotalDespesas());
		}
	}
}