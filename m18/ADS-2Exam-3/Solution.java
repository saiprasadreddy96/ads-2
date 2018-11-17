import java.util.Scanner;


public class Solution {

	// Don't modify this method.
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		String cases = scan.nextLine();

		switch (cases) {
		case "loadDictionary":
			// input000.txt and output000.txt
			BinarySearchST<String, Integer> hash = loadDictionary("/Files/t9.csv");
			while (scan.hasNextLine()) {
				String key = scan.nextLine();
				System.out.println(hash.get(key));
			}
			break;

		case "getAllPrefixes":
			// input001.txt and output001.txt
			T9 t9 = new T9(loadDictionary("/Files/t9.csv"));
			// while (scan.hasNextLine()) {
			// 	String prefix = scan.nextLine();
			// 	t9.getAllWords(prefix);
			// 	// for (String each : t9.getAllWords(prefix)) {
			// 	// 	System.out.println(each);
			// 	// }
			// }
			break;

		case "potentialWords":
			// input002.txt and output002.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			int count = 0;
			while (scan.hasNextLine()) {
				String t9Signature = scan.nextLine();
				for (String each : t9.potentialWords(t9Signature)) {
					count++;
					System.out.println(each);
				}
			}
			if (count == 0) {
				System.out.println("No valid words found.");
			}
			break;

		case "topK":
			// input003.txt and output003.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			Bag<String> bag = new Bag<String>();
			int k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				bag.add(line);
			}
			for (String each : t9.getSuggestions(bag, k)) {
				System.out.println(each);
			}

			break;

		case "t9Signature":
			// input004.txt and output004.txt
			t9 = new T9(loadDictionary("/Files/t9.csv"));
			bag = new Bag<String>();
			k = Integer.parseInt(scan.nextLine());
			while (scan.hasNextLine()) {
				String line = scan.nextLine();
				for (String each : t9.t9(line, k)) {
					System.out.println(each);
				}
			}
			break;

		default:
			break;

		}
	}

	// Don't modify this method.
	public static String[] toReadFile(String file) {
		In in = new In(file);
		return in.readAllStrings();
	}

	public static BinarySearchST<String, Integer> loadDictionary(String file) {
		BinarySearchST<String, Integer>  st = new BinarySearchST<String, Integer>();
		// your code goes here
		String[] words = toReadFile(file);
		for (String word1 : words) {
			String word = word1.toLowerCase();
			if (st.contains(word)) {
				int value = st.get(word);
				st.put(word, value + 1);
			} else {
				st.put(word, 1);
			}
			
		}
		return st;
	}

}

class T9 {

	public T9(BinarySearchST<String, Integer> st) {

		// your code goes here
		TST<Integer> tst = new TST<Integer>();

        for (String str : st.keys()) {
            SuffixArray sfax = new SuffixArray(str, tst);
        }
        Scanner scan = new Scanner(System.in);
        while (scan.hasNextLine()) {
				String prefix = scan.nextLine();
				for (String str : tst.keysWithPrefix(prefix)) {
            		System.out.println(str);
        		}
		}
	}

	// get all the prefixes that match with given prefix.
	// public void getAllWords(String prefix) {
	// 	// your code goes here
	// 	//String line = sc.nextLine();
 //        for (String str : tst.keysWithPrefix(prefix)) {
 //            System.out.println(str);
 //        }
	// 	return;
	// }

	public Iterable<String> potentialWords(String t9Signature) {
		// your code goes here
		return null;
	}

	// return all possibilities(words), find top k with highest frequency.
	public Iterable<String> getSuggestions(Iterable<String> words, int k) {
		// your code goes here
		return null;
	}

	// final output
	// Don't modify this method.
	public Iterable<String> t9(String t9Signature, int k) {
		return getSuggestions(potentialWords(t9Signature), k);
	}
}
