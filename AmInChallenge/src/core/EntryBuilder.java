package core;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import entryInfoType.Country;
import entryInfoType.TortureMethod;
import entryInfoType.Year;

public class EntryBuilder {

	public static void onExtracted(File xmlFile, File textFile) {
		extractData(xmlFile, textFile);
	}

	/**
	 * Extracts relevant data from a large text file that pertains to torture,
	 * hopefully within sections subtitled "Torture".
	 * 
	 * @param textFile
	 *            A .txt file that will hopefully contain data about torture
	 *            incidences.
	 * @return A String containing all entries related to torture
	 */
	public static String extractData(File xmlFile, File textFile) {
		try {
			Scanner sc = new Scanner(textFile);
			// If an instance of "torture" is found, we check the xml file
			// and scan it for a different font size or some other
			// divider to know when our section is complete.
			// todo: Figure out a way to parse the xml file for the 
			// corresponding section on torture.
			
			// update: actually, we were supposed to parse the xml file first,
			// then find the corresponding section in the text file. Oops.
			boolean found = false;
			while (sc.hasNextLine()) {
				String line = sc.nextLine();
				List<Integer> tortureIndices = matchIndex(line, "Torture");
				if (!tortureIndices.isEmpty()) {
					found = true;
					for (Integer index : tortureIndices) {
						
					}
				} else {
					tortureIndices = matchIndex(line, "torture");
				}
			}
		} catch (FileNotFoundException f) {
		}
		return null;
	}

	/* Finds the pattern using a rolling hash */
	private static List<Integer> matchIndex(String corpus, String pattern) {
		int primeModulus = 71;
		ArrayList<Integer> result = new ArrayList<Integer>();

		// preprocess the pattern
		char[] patternRaw = pattern.toCharArray();
		short[] patternBits = stringToBits(patternRaw);
		if (patternBits == null)
			return new ArrayList<Integer>();
		int patternHash = patternHash(patternBits, primeModulus, 0,
				patternRaw.length);

		// Begin processing corpus
		char[] corpusRaw = corpus.toCharArray();
		short[] corpusBits = stringToBits(corpusRaw);
		if (corpusBits == null)
			return new ArrayList<Integer>();
		int corpusStartHash = patternHash(corpusBits, primeModulus, 0,
				patternRaw.length);

		if (corpusStartHash == patternHash) {
			result.add(0);
		}

		for (int i = patternBits.length; i < corpusBits.length; i++) {
			corpusStartHash = corpusStartHash << 1;
			corpusStartHash += corpusBits[i];
			corpusStartHash = corpusStartHash % primeModulus;
			if (corpusStartHash == patternHash) {
				if (i - patternBits.length >= 0)
					result.add(i - patternBits.length);
			}
		}

		return result;
	}

	/* Gets the bits of the String */
	private static short[] stringToBits(char[] s) {
		if (s.length * 7 < 0) // overflow
			return null;
		short[] result = new short[s.length * 7];
		int counter = 0;
		for (int i = 0; i < s.length; i++) {
			char currChar = s[i];
			for (short j = 6; j >= 0; j--) {
				short tmpBit = (short) (((currChar) >> j) & 0x1);
				result[counter] = tmpBit;
				counter++;
			}
		}
		return result;
	}

	private static int patternHash(short[] string, int modulus, int s, int e) {
		if (string == null || e < s || modulus <= 0 || e >= string.length
				|| s < 0) {
			// modulus should be prime.
			// e is the ending index, s is the starting index
			throw new IllegalArgumentException();
		}
		int result = string[s];
		for (int i = s + 1; i < e; i++) {
			short nextBit = string[i];
			result = result << 1;
			result += nextBit;
		}
		return result % modulus;
	}

	/**
	 * Attempts to find the country that the torture incident occurred in, given
	 * a corpus of report data. If no country is found, returns null. Otherwise,
	 * a collection of custom entryInfoType.Country Objects is constructed and
	 * returned.
	 * 
	 * @param corpus
	 * @return
	 */
	public static List<Country> findCountry(String corpus) {
		return null;
	}

	/**
	 * Attempts to find the years when the torture incident occurred, given a
	 * corpus of report data. If no years are found, returns null. Otherwise, a
	 * collection of custom entryInfoType.Year Objects is constructed and
	 * returned.
	 * 
	 * @param corpus
	 * @return
	 */
	public static List<Year> findTimes(String corpus) {
		return null;
	}

	/**
	 * Attempts to find the methods used to torture the victim(s), given a
	 * corpus of report data. If no methods are found, returns null. Otherwise,
	 * a collection of custom entryInfoType.TortureMethod Objects is constructed
	 * and returned.
	 * 
	 * @param corpus
	 * @return
	 */
	public static List<TortureMethod> findMethods(String corpus) {
		return null;
	}
}