import java.util.*;
import java.io.*;

public class Anagrams {
	private HashMap<String, TreeSet> map = new HashMap<>();

	private static void processDictionary(ArrayList<String> original)  {
		String[] sorted = (String[]) original.toArray();
		for (int i = 0; i < sorted.length; i++) {
			sorted[i] = sortString(sorted[i]);
		}
	}

	private static String sortString(String str) {
		char[] temp = str.toCharArray();
		Arrays.sort(temp);
		return new String(temp);
	}

	public static void main(String[] args) {
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
			processDictionary(original);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Scanner scan = new Scanner(System.in); 
		String input = scan.nextLine();
		while (!(input.equals(""))) {
			System.out.println(input);
			input = scan.nextLine();
		}
	}
}