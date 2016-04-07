import java.io.*;
import java.util.*;

public class CountingFileContents {

	public static void main(String[] args) throws Exception {
		Scanner in = new Scanner(System.in);
		// ucitavanje file-a od usera
		System.out.print("Ime filea: ");
		String filename = in.nextLine();
		File file = new File(filename);
		// prikaz rezultat brojanja ukoliko file postoji
		if (file.exists()) {
			System.out.println("Broj rijeci u file-u = " + countWords(file));
			System.out.println("Broj unikatnih rijeci u file-u = " + countUniqueWords(file));
			System.out.println("Broj recenica u file-u = " + countSentences(file));
			System.out.println("Broj slova u file-u = " + countLetters(file));
			System.out.println("Broj karaktera u file-u = " + countCharacters(file));
			System.out.println("Letters occurrence:");
			countLettersOccurrence(file);
		} else {
			System.out.println("File " + filename + " ne postoji");
		}
		in.close();
	}
	// brojanje rijeci u file-u
	public static int countWords(File file) throws Exception {
		Scanner input = new Scanner(new FileInputStream(file));
		int count = 0;
		while (input.hasNext()) {
			input.next();
			count++;
		}
		input.close();
		return count;
	}
	// brojanje unikatnih rijeci u file-u
	public static int countUniqueWords(File file) throws Exception {
		Scanner input = new Scanner(new FileInputStream(file));
		Set<String> uniqueWords = new HashSet<String>();
		while (input.hasNext()) {
			uniqueWords.add(input.next());
		}
		input.close();
		return uniqueWords.size();
	}
	// brojanje recenica u file-u
	public static int countSentences(File file) throws Exception {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		int count = 0;
		String line;
		String delimiters = "?!.";
		while ((line = reader.readLine()) != null) { // broj dok ne dodjemo do
														// kraja file-a
			for (int i = 0; i < line.length(); i++) {
				if (delimiters.indexOf(line.charAt(i)) != -1) {
					count++;
				}
			}
		}
		reader.close();
		return count;
	}
	// brojanje slova u file-u
	public static int countLetters(File file) throws Exception {
		Scanner input = new Scanner(file);
		int count = 0;
		while (input.hasNext()) {
			char[] chars = input.nextLine().toLowerCase().toCharArray();
			for (Character c : chars) {
				if (Character.isLetter(c)) count++;
			}
		}
		input.close();
		return count;
	}
	// brojanje karaktera u file-u
	public static int countCharacters(File file) throws Exception {
		Scanner input = new Scanner(file);
		int count = 0;
		while (input.hasNext()) {
			char[] chars = input.nextLine().toLowerCase().toCharArray();
			count += chars.length;
		}
		input.close();
		return count;
	}
	// brojanje pojavljivanja pojedinih slova u file-u
	public static void countLettersOccurrence(File file) throws Exception {
		TreeMap<Character, Integer> hashMap = new TreeMap<Character, Integer>();
		Scanner input = new Scanner(file);
		while (input.hasNext()) {
			char[] chars = input.nextLine().toLowerCase().toCharArray();
			for (Character c : chars) {
				if (!Character.isLetter(c)) {
					continue;
				} else if (hashMap.containsKey(c)) {
					hashMap.put(c, hashMap.get(c) + 1);
				} else {
					hashMap.put(c, 1);
				}
			}
		}
		for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
			System.out.println(entry.getKey() + ": " + entry.getValue());
		}
		input.close();
	}

}
