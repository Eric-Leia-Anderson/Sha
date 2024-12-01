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
		File file = new File("E:\\sha-1\\dictionary.txt");
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

		File file = new File("E:\\sha-1\\output.txt");
		String sha1 = null;
	    try {
	    	BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//	    	String one = "12345";
//	    	String two = "123456";
//	    	String three = "1234567";
//	    	String four = "12345678";
//	    	String five = "123456789";
	    	
	    	MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
	        
	    	//allWords.add(one);
//	    	msdDigest.update(one.getBytes("UTF-8"), 0, one.length());
//	        byte[] hash = msdDigest.digest();
//	        String hashstr = String.format("%040x", new BigInteger(1, hash));
//	        bw.write(one+",");
//	        bw.write(hashstr);//or is it hex?
//	        bw.write("\n");
//	    	//allWords.add(two);
//	    	msdDigest.update(two.getBytes("UTF-8"), 0, two.length());
//	        hash = msdDigest.digest();
//	        hashstr = String.format("%040x", new BigInteger(1, hash));
//	        bw.write(two+",");
//	        bw.write(hashstr);//or is it hex?
//	        bw.write("\n");
//	    	//allWords.add(three);
//	    	msdDigest.update(three.getBytes("UTF-8"), 0, three.length());
//	        hash = msdDigest.digest();
//	        hashstr = String.format("%040x", new BigInteger(1, hash));
//	        bw.write(three+",");
//	        bw.write(hashstr);//or is it hex?
//	        bw.write("\n");
//	    	//allWords.add(four);
//	    	msdDigest.update(four.getBytes("UTF-8"), 0, four.length());
//	        hash = msdDigest.digest();
//	        hashstr = String.format("%040x", new BigInteger(1, hash));
//	        bw.write(four+",");
//	        bw.write(hashstr);//or is it hex?
//	        bw.write("\n");
//	    	//allWords.add(five);
//	    	msdDigest.update(five.getBytes("UTF-8"), 0, five.length());
//	        hash = msdDigest.digest();
//	        hashstr = String.format("%040x", new BigInteger(1, hash));
//	        bw.write(five+",");
//	        bw.write(hashstr);//or is it hex?
//	        bw.write("\n");
	    	for(String st : words) {
	    		//allWords.add(st);
	    		msdDigest.update(st.getBytes("UTF-8"), 0, st.length());
	    		byte[] hash = msdDigest.digest();
		        String hashstr = String.format("%040x", new BigInteger(1, hash));
		        bw.write(st+",");
		        bw.write(hashstr);//or is it hex?
		        bw.write("\n");
	    		List<String> stringWithNumbers = addNumbers(st);
	    		for(String str : stringWithNumbers) {
	    			msdDigest.update(str.getBytes("UTF-8"), 0, str.length());
	    			hash = msdDigest.digest();
			        hashstr = String.format("%040x", new BigInteger(1, hash));
			        bw.write(str+",");
			        bw.write(hashstr);//or is it hex?
			        bw.write("\n");
//			        String noE = replaceE(st);
//		    		String noI = replaceI(st);
//		    		String noO = replaceO(st);
//		    		String allVowels = replaceVowels(st);
//		    		String twovowels1 = replace2Vowels1(st);
//		    		String twovowels2 = replace2Vowels2(st);
//		    		String twovowels3 = replace2Vowels3(st);
//		    		msdDigest.update(noE.getBytes("UTF-8"), 0, noE.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(noE+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(noI.getBytes("UTF-8"), 0, noI.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(noI+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(noO.getBytes("UTF-8"), 0, noO.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(noO+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(twovowels3.getBytes("UTF-8"), 0, twovowels3.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(twovowels3+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(allVowels.getBytes("UTF-8"), 0, allVowels.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(allVowels+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(twovowels1.getBytes("UTF-8"), 0, twovowels1.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(twovowels1+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(twovowels2.getBytes("UTF-8"), 0, twovowels2.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(twovowels2+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
	    			//allWords.add(str);
	    		}
//	    		String noE = replaceE(st);
//	    		String noI = replaceI(st);
//	    		String noO = replaceO(st);
//	    		String allVowels = replaceVowels(st);
//	    		String twovowels1 = replace2Vowels1(st);
//	    		String twovowels2 = replace2Vowels2(st);
//	    		String twovowels3 = replace2Vowels3(st);
//	    		
//	    		msdDigest.update(noE.getBytes("UTF-8"), 0, noE.length());
//    			hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(noE+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//		        msdDigest.update(noI.getBytes("UTF-8"), 0, noI.length());
//    			hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(noI+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//		        msdDigest.update(noO.getBytes("UTF-8"), 0, noO.length());
//    			hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(noO+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//		        msdDigest.update(twovowels3.getBytes("UTF-8"), 0, twovowels3.length());
//    			hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(twovowels3+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//		        msdDigest.update(allVowels.getBytes("UTF-8"), 0, allVowels.length());
//    			hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(allVowels+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//		        msdDigest.update(twovowels1.getBytes("UTF-8"), 0, twovowels1.length());
//    			hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(twovowels1+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//		        msdDigest.update(twovowels2.getBytes("UTF-8"), 0, twovowels2.length());
//    			hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(twovowels2+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//	    		List<String> noVowelNumbers = addNumbers(noVowels);
//	    		//allWords.add(noVowels);
//	    		msdDigest.update(noVowels.getBytes("UTF-8"), 0, noVowels.length());
//		        hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(noVowels+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//	    		for(String s : noVowelNumbers) {
//	    			msdDigest.update(s.getBytes("UTF-8"), 0, s.length());
//			        hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(s+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//	    			//allWords.add(s);
//	    		}
//	    		String reversed = backwards(st);
//	    		msdDigest.update(reversed.getBytes("UTF-8"), 0, reversed.length());
//		        hash = msdDigest.digest();
//		        hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(reversed+",");
//		        bw.write(hashstr);//or is it hex?
//		        bw.write("\n");
//	    		List<String> backwardsNumbers = addNumbers(reversed);
//	    		//allWords.add(reversed);
//	    		for(String stri : backwardsNumbers) {
//	    			msdDigest.update(stri.getBytes("UTF-8"), 0, stri.length());
//			        hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(stri+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//	    			//allWords.add(stri);
//	    		}
	    		List<String> comboWords = makeCombos(st, words);
//	    		List<String> comboThree = makeCombosThree(st, comboWords, words);
//	    		for(String str : comboThree) {
//	    			msdDigest.update(str.getBytes("UTF-8"), 0, str.length());
//    				byte[] hash = msdDigest.digest();
//			        String hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(str+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//	    			List<String> comboWithNumbers = addNumbers(str);
//	    			for(String s : comboWithNumbers) {
//	    				msdDigest.update(s.getBytes("UTF-8"), 0, s.length());
//	    				hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(s+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
//		    			//allWords.add(s);
//		    		}
//	    		}
	    		for(String stuff : comboWords) {
	    			//allWords.add(stuff);
	    			msdDigest.update(stuff.getBytes("UTF-8"), 0, stuff.length());
			        hash = msdDigest.digest();
			        hashstr = String.format("%040x", new BigInteger(1, hash));
			        bw.write(stuff+",");
			        bw.write(hashstr);//or is it hex?
			        bw.write("\n");
//			        noE = replaceE(stuff);
//		    		noI = replaceI(stuff);
//		    		noO = replaceO(stuff);
//		    		allVowels = replaceVowels(stuff);
//		    		twovowels1 = replace2Vowels1(stuff);
//		    		twovowels2 = replace2Vowels2(stuff);
//		    		twovowels3 = replace2Vowels3(stuff);
//		    		
//		    		msdDigest.update(noE.getBytes("UTF-8"), 0, noE.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(noE+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(noI.getBytes("UTF-8"), 0, noI.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(noI+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(noO.getBytes("UTF-8"), 0, noO.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(noO+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(twovowels3.getBytes("UTF-8"), 0, twovowels3.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(twovowels3+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(allVowels.getBytes("UTF-8"), 0, allVowels.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(allVowels+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(twovowels1.getBytes("UTF-8"), 0, twovowels1.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(twovowels1+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
//			        msdDigest.update(twovowels2.getBytes("UTF-8"), 0, twovowels2.length());
//	    			hash = msdDigest.digest();
//			        hashstr = String.format("%040x", new BigInteger(1, hash));
//			        bw.write(twovowels2+",");
//			        bw.write(hashstr);//or is it hex?
//			        bw.write("\n");
	    			List<String> comboWithNumbers = addNumbers(stuff);
	    			for(String s : comboWithNumbers) {
	    				msdDigest.update(s.getBytes("UTF-8"), 0, s.length());
	    				hash = msdDigest.digest();
				        hashstr = String.format("%040x", new BigInteger(1, hash));
				        bw.write(s+",");
				        bw.write(hashstr);//or is it hex?
				        bw.write("\n");
//				        noE = replaceE(s);
//			    		noI = replaceI(s);
//			    		noO = replaceO(s);
//			    		allVowels = replaceVowels(s);
//			    		twovowels1 = replace2Vowels1(s);
//			    		twovowels2 = replace2Vowels2(s);
//			    		twovowels3 = replace2Vowels3(s);
//			    		msdDigest.update(noE.getBytes("UTF-8"), 0, noE.length());
//		    			hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(noE+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
//				        msdDigest.update(noI.getBytes("UTF-8"), 0, noI.length());
//		    			hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(noI+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
//				        msdDigest.update(noO.getBytes("UTF-8"), 0, noO.length());
//		    			hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(noO+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
//				        msdDigest.update(twovowels3.getBytes("UTF-8"), 0, twovowels3.length());
//		    			hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(twovowels3+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
//				        msdDigest.update(allVowels.getBytes("UTF-8"), 0, allVowels.length());
//		    			hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(allVowels+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
//				        msdDigest.update(twovowels1.getBytes("UTF-8"), 0, twovowels1.length());
//		    			hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(twovowels1+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
//				        msdDigest.update(twovowels2.getBytes("UTF-8"), 0, twovowels2.length());
//		    			hash = msdDigest.digest();
//				        hashstr = String.format("%040x", new BigInteger(1, hash));
//				        bw.write(twovowels2+",");
//				        bw.write(hashstr);//or is it hex?
//				        bw.write("\n");
		    			//allWords.add(s);
		    		}
	    		}
	    	}
	    	//try combos and with numbers...
	    	//word with i replaced with 1
	    	//word with e replaced with 3
	    	//File file = new File("C:\\Users\\Owner\\Downloads\\Networksecurity_Project\\Networksecurity_Project\\output.txt");
	    	//BufferedWriter bw = new BufferedWriter(new FileWriter(file));
//	    	for(String word : allWords) {
//	    		MessageDigest msdDigest = MessageDigest.getInstance("SHA-1");
//		        msdDigest.update(word.getBytes("UTF-8"), 0, word.length());
//		        byte[] hash = msdDigest.digest();
//		        String hashstr = String.format("%040x", new BigInteger(1, hash));
//		        bw.write(word+",");
//		        bw.write(hashstr);//or is it hex?
//		        //map.put(word, hashstr);
//		        bw.write("\n");
//	    	}
	        bw.close();
	    } catch (NoSuchAlgorithmException | IOException e) {
	        System.out.println(e.getMessage());
	    }
	    return true;
	}
	
	
	public static List<String> makeCombos(String word, List<String> words) {
		List<String> list = new ArrayList<String>();
		for(String str : words) {
			if(!str.equals(word)) {
				list.add(word+str);
			}
			
		}
		return list;
	}
	
	public static List<String> makeCombosThree(String word, List<String> comboWords, List<String> allwords) {
		List<String> list = new ArrayList<String>();
		for(String s : allwords) {
			for(String st : comboWords) {
				list.add(st+s);
			}
		}
//		for(String str : comboWords) {
//			if(!str.contains(word)) {
//				list.add(word+str);
//			}
//			
//		}
		return list;
	}
	
	public static List<String> addNumbers(String str) {
		List<String> list = new ArrayList<String>();
//		//0-10
//		for(int i = 0; i < 10 ; i++) {
//			list.add(str+i);
//		}
//		//00-20
//		list.add(str+00);
//		for(int j = 0; j < 20; j++) {
//			if(j < 10) {
//				list.add(str+0+j);
//			}
//			else {
//				list.add(str+j);
//			}
//		}
		//100-900
//		for(int i = 1; i < 10 ; i++) {
//			list.add(str+i+"00");
//		}
		//111-999
//		for(int i = 1; i < 10 ; i++) {
//			list.add(str+i+i+i);
//		}
		//001-009
//		for(int i = 1; i < 10 ; i++) {
//			list.add(str+"00"+i);
//		}
		//1960-2000
//		for(int i = 1960; i < 2000 ; i++) {
//			list.add(str+i);
//		}
//		list.add(str+"12");
//		list.add(str+"123");
//		list.add(str+"1234");
//		list.add(str+"12345");
//		list.add(str+"123456");
//		list.add(str+"1234567");
//		list.add(str+"12345678");
//		list.add(str+"123456789");
		
//		for(int i = 100; i < 998 ; i++) {
//			list.add(str+i);
//		}
		
		for(int i = 20; i < 100; i++) {
			list.add(str+i);
		}
		return list;
	}
	
	public static String replaceE(String word) {
		return word.replaceAll("[eE]", "3");
	}
	
	public static String replaceO(String word) {
		return word.replaceAll("[oO]", "0");
	}
	
	public static String replaceI(String word) {
		return word.replaceAll("[iI]", "1");
	}
	
	public static String replaceVowels(String word) {
		word.replaceAll("[eE]", "3");
		word.replaceAll("[oO]", "0");
		return word.replaceAll("[iI]", "1");
	}
	
	public static String replace2Vowels1(String word) {
		word.replaceAll("[eE]", "3");
		return word.replaceAll("[oO]", "0");
	}
	
	public static String replace2Vowels2(String word) {
		word.replaceAll("[eE]", "3");
		return word.replaceAll("[iI]", "1");
	}
	
	public static String replace2Vowels3(String word) {
		word.replaceAll("[oO]", "0");
		return word.replaceAll("[iI]", "1");
	}
	
	
	public static String backwards(String word) {
		StringBuilder sb = new StringBuilder(word);
        String reversedString = sb.reverse().toString();
        return reversedString;
	}
	
	public static boolean checkHashes() {
		File hashesFile = new File("E:\\sha-1\\output.txt");
		File passwordFile = new File("E:\\sha-1\\passwords.txt");
		File outputFile = new File("E:\\sha-1\\output2.txt");
		BufferedReader br;
		BufferedReader br2;
		BufferedWriter bw;
		try {
			br = new BufferedReader(new FileReader(hashesFile));	
			br2 = new BufferedReader(new FileReader(passwordFile));
			bw = new BufferedWriter(new FileWriter(outputFile));
			
			List<String> passwords = new ArrayList<String>();
			//String[] hashes = new String[];
			//String[] words = new String[];
			String str;
			
			 while ((str = br2.readLine()) != null) {
				 String line = str;
				 String[] splitLine = line.split(" ");
				 passwords.add(splitLine[splitLine.length-1]);
			}
			
			 br2.close();
			 
			 while ((str = br.readLine()) != null) {
					String line = str;
					String[] splitLine = line.split(",");
					String word = splitLine[0];
					String ha = splitLine[1];
					if(passwords.contains(ha)) {
						int ind = passwords.indexOf(ha);
						bw.write(word+" is ");
						bw.write(passwords.get(ind)+"\n");
					}
					
					 //hashes.add(str);
				}
//			 for(String s : passwords) {
//				 while ((str = br.readLine()) != null) {
//						String line = str;
//						 String[] splitLine = line.split(",");
//						 //hashes.add(str);
//					}
//			 }
			 br.close();
				// if(map.containsValue(s)) {
					 //for (Map.Entry<String, String> entry : map.entrySet()) {
						   // String key = entry.getKey();
						   // String value = entry.getValue();
						   // if(value.equals(s)) {
						    //	bw.write(key + " is " + value);
							 	//bw.write("\n");
						   // }
						//}
					 	
				// }
			 //}
			 bw.close();
			 
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		return true;
	}
	
	public static void main(String[] args) {
		//List<String> read = readFile();
		//boolean compute = computeHashes(read);
		boolean check = checkHashes();
	}
}
