package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Blacklist {
	private Set<String> numbers;
	private File file;
	
	public Blacklist(String path) {
		numbers = new HashSet<>();
		file = new File(path);
	}
	
	public void importNumbers() {
		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String line = br.readLine();
			while(line != null) {
				numbers.add(line);
				line = br.readLine();
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void exportNumbers() {
		String outFile = file.getParent() + "\\saida.csv";
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(outFile))) {
			for(String n : numbers) {
				bw.write(n);
				bw.newLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void readBlacklist() {
		String[] path = new String[2];
		path[0] = "C:\\Users\\HP\\Desktop\\Blacklist\\Blacklist_Total.txt";
		path[1] = "C:\\Users\\HP\\Desktop\\Blacklist\\blacklist_extra.txt";

		for(int i = 0; i < 2; ++i) {
			try (BufferedReader br = new BufferedReader(new FileReader(path[i]))) {
				br.lines().forEach(line -> {
					if(numbers.contains(line)) {
						numbers.remove(line);
					}
				});
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void filterMobile() {
		numbers.removeIf(n -> n.length() != 11);
	}
}
