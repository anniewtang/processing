import java.util.*;
import java.io.*;

public class Anagrams {
	/* HashMap has the following mapping:
	KEY: Sorted word (universal key for all anagrams) 
	VALUE: TreeSet for all dictionary words that are anagrams */
	private HashMap<String, TreeSet<String>> map = new HashMap<>();

	/* private method to process provided dictionary file & update map 
	PARAMS: arraylist<string> of read in words from txt file
	RETURN: (void) */
	private static void processDictionary(ArrayList<String> originalDict)  {
		for (int i = 0; i < originalDict.size(); i++) {
			String originalWord = originalDict.get(i);

			// sorts original word to obtain "universal" anagramKey
			String anagramKey = sortString(originalWord);

			// adds the original word into hashmap's treeset, under anagramKey
			if (map.contains(anagramKey)) {
				TreeSet<String> wordsList = map.get(anagramKey);
			} else {
				TreeSet<String> wordsList = new TreeSet<>();
			}
			wordsList.add(originalWord);
		}
	}

	/* private helper method to sort Strings
	PARAMS: String (original word from dictionary)
	RETURN: String (sorted word) */
	private static String sortString(String str) {
		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}

	private static void displayAnagrams(String w) {
		String anagramKey = sortString(w);
		TreeSet<String> anagrams = map.get(anagramKey);
		if (anagrams) {
			int count = 0;
			int size = anagrams.size() - 1;
			StringBuilder output = new StringBuilder();
			for (String s : anagrams.iterator()) {
				output.append(s);
				if (count != size) {
					output.append(" ");
				} else {
					output.append("\n");
				}
			}
			System.out.println(output.toString());
		} else {
			System.out.println('-');
		}
	}

	public static void main(String[] args) {

		// read in provided file path parameter to dictionary
		try {
			File file = new File(args[0]);
			FileReader fileReader = new FileReader(file);
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String word;
			ArrayList<String> original = new ArrayList<>();
			while ((word = bufferedReader.readLine()) != null) {
				original.add(word);
			}
			fileReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// process dictionary and update HashMap map
		processDictionary(original);

		// read in input from command line & process outputs
		Scanner scan = new Scanner(System.in); 
		String input = scan.nextLine();
		while (!(input.equals(""))) {
			displayAnagrams(input);
			input = scan.nextLine();
		}
	}
}