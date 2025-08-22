import java.util.ArrayList;
import java.util.Scanner;

public class Rendas {

	public static ArrayList<String> nomesRendas = new ArrayList<>();
	public static ArrayList<Double> valoresRendas = new ArrayList<>();

	public static void cadastrarRendas() {
		Scanner sc = new Scanner(System.in); // Cria o objeto "sc" para ler entradas do usuário

		System.out.print("Quantas rendas você possui (salário, pensão, freela, etc.)? ");
		int qtdRendas = sc.nextInt();
		sc.nextLine(); // tira quebra de linha para evitar erros - IMPORTANTE

		for (int i = 1; i <= qtdRendas; i++) {
			System.out.print("Digite o nome do rendimento " + i + ": ");
			String nome = sc.nextLine(); // lê o nome do rendimento
			System.out.print("Digite o valor de " + nome + ": R$ ");
			double valor = sc.nextDouble(); // lê o valor em dinheiro
			sc.nextLine();

			nomesRendas.add(nome);
			valoresRendas.add(valor);
		}
		
	}

	public static double getTotalRendas() {
		double total = 0;
		for (double valor : valoresRendas) {
			total += valor;
		}
		return total;
	}
}