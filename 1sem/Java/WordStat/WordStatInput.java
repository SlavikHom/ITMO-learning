import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;
import java.nio.charset.StandardCharsets;

public class WordStatInput {
	public static void main(String[] args) {
		String inputFileName = args[0];
        String outputFileName = args[1];
		LinkedHashMap<String, Integer> words = new LinkedHashMap<>();
		StringBuilder word = new StringBuilder();
		try {
			Reader in = new FileReader(inputFileName, StandardCharsets.UTF_8);
			try {
				char[] buffer = new char[1024];
				while(true) {
					int read = in.read(buffer);
					if (read < 0) {
						break;
					}
					String block = new String(buffer, 0, read);
					for (int i = 0; i < block.length(); i++) {
						char letter = block.charAt(i);
						if (Character.isLetter(letter) || Character.getType(letter) == Character.DASH_PUNCTUATION
								|| letter == '\'') {
							word.append(letter);
						} else {
							addWordToWords(words, word);
						}
					}
				}
				addWordToWords(words, word);
			} finally {
				in.close();
			}
		} catch (IOException e) {
			System.err.println("Error reading file:" + e.getMessage());
		}
        try {
			Writer out = new BufferedWriter(
				new OutputStreamWriter(
					new FileOutputStream(outputFileName),
					"utf8"
				),
				1024
			);
			try {
				for (Map.Entry<String, Integer> entry : words.entrySet()) {
					out.write(entry.getKey() + " " + entry.getValue() + "\n");
				}
			} finally{
				out.close();
			}
		} catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
	}
	
	private static void addWordToWords(LinkedHashMap<String, Integer> words, StringBuilder word) {
        if (!word.isEmpty()) {
			String realWord = word.toString().toLowerCase();
			words.put(realWord, words.getOrDefault(realWord, 0) + 1);
			word.setLength(0);
		}
    }
}