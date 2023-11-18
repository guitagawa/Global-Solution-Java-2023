import java.util.Scanner;

public class global {

	static Scanner teclado = new Scanner(System.in);

	// metodo A
	public static double[][] matrizMortalidade(int anos[], String indicadores[]) {
		double mortalidade[][] = new double[5][9];

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 9; j++) {
				System.out.println("Número de mortes em "+anos[i]+" para "+indicadores[j]);
				mortalidade[i][j]=teclado.nextDouble();
			}
		}
		return mortalidade;
	}
	
	//metodo b
	public static void totalDeMortos(double mortalidade[][], String indicadores[]) {
		double somas[] = new double[9];
		
		for (int i = 0; i <9; i++) {
			somas[i]=0;
			for (int j = 0; j < 5; j++) {
				somas[i]=somas[i] + mortalidade[j][i];
			}
		}
		
		for (int i = 0; i < somas.length; i++) {
			System.out.println(indicadores[i]+": "+somas[i]+" mortes");
		}
		
	}
	
	//metodo c
	public static void maisMortes(double mortalidade[][], int anos[]) {
		 int anoMaisMortesMasculino = anos[0];
	        int anoMenosMortes50Mais = anos[0];

	        double maisMortesMasculino = mortalidade[0][3]; 
	        double menosMortes50Mais = mortalidade[0][8]; 

	        for (int i = 1; i < 5; i++) {
	            if (mortalidade[i][3] > maisMortesMasculino) {
	                maisMortesMasculino = mortalidade[i][3];
	                anoMaisMortesMasculino = anos[i];
	            }

	            if (mortalidade[i][8] < menosMortes50Mais) {
	                menosMortes50Mais = mortalidade[i][8];
	                anoMenosMortes50Mais = anos[i];
	            }
	        }

	        System.out.println("Ano com mais mortes no indicador Masculino: " + anoMaisMortesMasculino);
	        System.out.println("Ano com menos mortes no indicador 50 anos ou mais: " + anoMenosMortes50Mais);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] anos = new int[] { 2022, 2021, 2020, 2019, 2018 };
		String[] indicadores = new String[] { "dengue", "zika virus", "chicungunha", "homens", "mulheres",
				"pessoas entre 0 e 9 anos", "pessoas entre 10 e 19 anos", "pessoas entre 20 e 49 anos",
				"pessoas com mais de 50 anos" };
		
		double[][] mortalidade = matrizMortalidade(anos, indicadores);
		
		totalDeMortos(mortalidade, indicadores);
		maisMortes(mortalidade, anos);
	}

}
