package core;

import java.io.File;
import java.util.List;

import entryInfoType.Country;
import entryInfoType.TortureMethod;
import entryInfoType.Year;

public class EntryBuilder {

	/**
	 * Extracts relevant data from a large text file that pertains to torture,
	 * hopefully within <Torture></Torture>-like sections.
	 * 
	 * @param textFile
	 *            A .txt file that will hopefully contain data about torture
	 *            incidences.
	 * @return A String containing all entries related to torture
	 */
	public static String extractData(File textFile) {
		return null;
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
	 * Attempts to find the methods used to torture the victim(s), given a corpus
	 * of report data. If no methods are found, returns null. Otherwise, a
	 * collection of custom entryInfoType.TortureMethod Objects is constructed
	 * and returned.
	 * 
	 * @param corpus
	 * @return
	 */
	public static List<TortureMethod> findMethods(String corpus) {
		return null;
	}
}