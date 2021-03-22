package gerson;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import gerson.throwable.exception.DomainException;
import gerson1.Carga;
import gerson1.Passeio;

public class Program {

	public static void main(String[] args) throws ParseException  {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		try {
			System.out.print("Digite a data de in�cio: ");
			Date inicio = sdf.parse(sc.nextLine());

			System.out.print("Digite a data final: ");
			Date fim = sdf.parse(sc.nextLine());

			Veiculo v = new Veiculo(inicio, fim);

			System.out.print("Digite o pre�o por dia: ");
			double precoPorDia = sc.nextDouble();

			System.out.print("Digite o pre�o por Mes: ");
			double precoPorMes = sc.nextDouble();

			System.out.print("Ve�culo de Passeio ou Carga (p, c)? ");
			Character tipo = sc.next().charAt(0);
			tipo = Character.toLowerCase(tipo);
			
			if (tipo == 'p') {
				ContaEstacionamento ce = new ContaEstacionamento(precoPorDia, precoPorMes, new Passeio());
				ce.CalcularValor(v);
			}
			else {
				ContaEstacionamento ce = new ContaEstacionamento(precoPorDia, precoPorMes, new Carga());
				ce.CalcularValor(v);
			}

			System.out.printf("O valor a pagar �: " + String.format("%.2f", v.valorTotal()));

		} 
		catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		sc.close();
	}
}