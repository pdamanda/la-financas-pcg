import java.util.Map;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
public class Relatorio {

	public static void gerarRelatorio() {
		Scanner sc = new Scanner(System.in);
		double totalRendas = Rendas.getTotalRendas();
		double totalDespesas = Despesas.getTotalDespesas();

		System.out.println("\nRELATÓRIO");
		System.out.println("Descrição             | Valor (R$)");

		if (Rendas.nomesRendas.isEmpty()) {
			System.out.println("Nenhuma renda     | 0.00");
		} else {
			for (int i = 0; i < Rendas.nomesRendas.size(); i++) {
				System.out.println(Rendas.nomesRendas.get(i) + " | " + Rendas.valoresRendas.get(i));
			}
		}

		System.out.println("TOTAL RENDAS     | " + totalRendas);
		System.out.println("\nDESPESAS");
		System.out.println("Descrição             | Valor (R$)");
		if (Despesas.despesasMap.isEmpty()) {
			System.out.println("Nenhuma despesa       | 0.00");
		} else {
			for (Map.Entry<String, Double> entry : Despesas.despesasMap.entrySet()) {
				System.out.println(entry.getKey() + " | " + entry.getValue());
			}
		}
		System.out.println("TOTAL DESPESAS        | " + totalDespesas);

		double saldoFinal = totalRendas - totalDespesas;

		System.out.println("\n SALDO FINAL ");
		System.out.println("Saldo disponível: R$ " + saldoFinal);

		// Verifica se a pessoa gastou mais do que ganha
		if (saldoFinal < 0) {
			System.out.println("Atenção: Você gastou mais do que ganha!");
		} else if (saldoFinal == 0) {
			System.out.println("Você gastou exatamente o que ganhou.");
		} else {
			System.out.println("Parabéns! Você conseguiu economizar R$ " + saldoFinal);
		}
		System.out.printf("\nDica: " + getDicaFinanceira(saldoFinal, totalRendas));
		
	}

	private static String getDicaFinanceira(double saldo, double totalRenda) {
		if (saldo < 0) {
			return "Considere reduzir despesas ou buscar fontes extras de renda.";
		} else if (saldo == 0) {
			return "Sugestão: reveja seus gastos e tente economizar pelo menos 10% da sua renda para imprevistos.";
		} else {
			double percentualEconomia = (saldo / totalRenda) * 100;
			return "Você está economizando " + percentualEconomia + "% da sua renda. Continue assim!";
		}

	}

}
