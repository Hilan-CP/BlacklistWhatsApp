package application;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Blacklist para WhatsApp");
		System.out.print("Arquivo contendo números WhatsApp: ");
		String path = scan.nextLine();
		
		scan.close();
		
		Blacklist blacklist = new Blacklist(path);
		blacklist.importNumbers();
		blacklist.readBlacklist();
		blacklist.filterMobile();
		blacklist.exportNumbers();
		
		System.out.println("Finalizado");
	}

}
