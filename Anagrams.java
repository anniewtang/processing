import java.util.*;
import java.io.*;

public class Anagrams {
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
			System.out.println("Contents of file:");
			System.out.println(origina.toArray());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}