import java.util.Scanner;

import net.bytebuddy.build.Plugin.Engine.Source.Empty;

public class test {
	public static void main(String [] args) {
		final int taille=10;
		String [] tableauAdresse=new String[taille];
		double [][] tab=new double[taille][2];//taibleau prix and superficie
		Scanner sc=new Scanner(System.in);
		System.out.println("----Saisie des terrain");
		char choix='n';
		int i=0;
		do {
			System.out.println("saisie terrain "+i+1);
			System.out.print("\t superficie:");
			tab[i][0]=sc.nextDouble();
			System.out.print("\t prix:");
			tab[i][1]=sc.nextDouble();
			sc.nextLine();
			System.out.println("\t adresse:");
			tableauAdresse[i]=sc.nextLine();
			
			System.out.println("voulez vous continuer(o/n)");
			String choixString=sc.nextLine();
			if(choixString!=null && !choixString.isEmpty())
				choix=choixString.charAt(0);
			i++;
		} while (choix=='o');
		System.out.println("-----affichage des terrain");
		for (int j = 0; j < i ; j++) {
			System.out.print("terrain "+i+1);
			System.out.print("	superfice:"+tab[j][0]);
			System.out.print("	prix:"+tab[j][1]);
			System.out.print("	prix:"+tableauAdresse[j]);
			System.out.println();
		}
		
		
	}
}
