package sha;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class crackHash {

	public static List<String> allWords = new ArrayList<String>();
	public static Map<String, String> map = new HashMap<String, String>();
	
	public static List<String> readFile() {
		List<String> words = new ArrayList<String>();
		File file = new File("C:\\Users\\erian\\Downloads\\Networksecurity_Project (1)\\Networksecurity_Project\\dictionary.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(file));		
			String str;
			 while ((str = br.readLine()) != null) {
			        words.add(str);
			}
			 br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		return words;
	}
	
	public static boolean computeHashes(List<String> words) {

		String sha1 = null;
	    try {
	    	String one = "12345";
	    	String two = "123456";
	    	String three = "1234567";
	    	String four = "12345678";
	    	String five = "123456789";
	    	allWords.add(one);
	    	allWords.add(two);
	    	allWords.add(three);
	    	allWords.add(four);
	    	allWords.add(five);
	    	for(String st : words) {
	    		allWords.add(st);
	    		List<String> stringWithNumbers = addNumbers(st);
	    		for(String str : stringWithNumbers) {
	    			allWords.add(str);
	    		}
	    		String noVowels = removeVowels(st);
	    		List<String> noVowelNumbers = addNumbers(noVowels);
	    		allWords.add(noVowels);
	    		for(String s : noVowelNumbers) {
	    			allWords.add(s);
	    		}
	    		String reversed = backwards(st);
	    		List<String> backwardsNumbers = addNumbers(reversed);
	    		allWords.add(reversed);
	    		for(String stri : backwardsNumbers) {
	    			allWords.add(stri);
	    		}
	    		List<String> comboWords = makeCombos(st, words);
	    		for(String stuff : comboWords) {
	    			allWords.add(stuff);
	    			List<String> comboWithNumbers = addNumbers(stuff);
	    			for(String s : comboWithNumbers) {
		    			allWords.add(s);
		    		}
	    		}
	    	}
	    	//try combos and with numbers...
	    	//word with i replaced with 1
	    	//word with e replaced with 3
	    	File file = new File("C:\\Users\\erian\\Downloads\\Networksecurity_Project (1)\\Networksecurity_Project\\output.txt");
	    	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
	    	for(String word : allWords) {
	    		MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
		        msdDigest.update(word.getBytes("UTF-8"), 0, word.length());
		        byte[] hash = msdDigest.digest();
		        String hashstr = String.format("%040x", new BigInteger(1, hash));
		        //bw.write(hashstr);//or is it hex?
		        map.put(word, hashstr);
		        //bw.write("\n");
	    	}
	        bw.close();
	    } catch (NoSuchAlgorithmException | IOException e) {
	        System.out.println(e.getMessage());
	    }
	    return true;
	}
	
	
	public static List<String> makeCombos(String word, List<String> words) {
		List<String> list = new ArrayList<String>();
		for(String str : words) {
			list.add(word+str);
		}
		return list;
	}
	
	public static List<String> addNumbers(String str) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < 10 ; i++) {
			list.add(str+i);
		}
		list.add(str+00);
		for(int j = 0; j < 20; j++) {
			if(j < 10) {
				list.add(str+0+j);
			}
			else {
				list.add(str+j);
			}
		}
		list.add(str+"12");
		list.add(str+"123");
		list.add(str+"1234");
		list.add(str+"12345");
		list.add(str+"123456");
		list.add(str+"1234567");
		list.add(str+"12345678");
		list.add(str+"123456789");
		return list;
	}
	
	public static String removeVowels(String word) {
		return word.replaceAll("[aeiouAEIOU]", "");
	}
	
	public static String backwards(String word) {
		StringBuilder sb = new StringBuilder(word);
        String reversedString = sb.reverse().toString();
        return reversedString;
	}
	
	public static boolean checkHashes() {
		//File hashesFile = new File("C:\\\\Users\\\\erian\\\\Downloads\\\\Networksecurity_Project (1)\\\\Networksecurity_Project\\\\output.txt");
		File passwordFile = new File("C:\\Users\\erian\\Downloads\\Networksecurity_Project (1)\\Networksecurity_Project\\passwords.txt");
		File outputFile = new File("C:\\Users\\erian\\Downloads\\Networksecurity_Project (1)\\Networksecurity_Project\\output2.txt");
		//BufferedReader br;
		BufferedReader br2;
		BufferedWriter bw;
		try {
			//br = new BufferedReader(new FileReader(hashesFile));	
			br2 = new BufferedReader(new FileReader(passwordFile));
			bw = new BufferedWriter(new FileWriter(outputFile));
			
			List<String> passwords = new ArrayList<String>();
			//List<String> hashes = new ArrayList<String>();
			String str;
//			while ((str = br.readLine()) != null) {
//				 hashes.add(str);
//			}
			 while ((str = br2.readLine()) != null) {
				 String line = str;
				 String[] splitLine = line.split(" ");
				 passwords.add(splitLine[splitLine.length-1]);
			}
			 //br.close();
			 br2.close();
			 for(String s : passwords) {
				 if(map.containsValue(s)) {
					 for (Map.Entry<String, String> entry : map.entrySet()) {
						    String key = entry.getKey();
						    String value = entry.getValue();
						    if(value.equals(s)) {
						    	bw.write(key + " is " + value);
							 	bw.write("\n");
						    }
						}
					 	
				 }
			 }
			 bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return true;
	}
	
	public static void main(String[] args) {
		List<String> read = readFile();
		boolean compute = computeHashes(read);
		boolean check = checkHashes();
	}
}
