package core;

import java.io.File;
import java.util.ArrayList;
import java.util.Vector;

import utility.TestApp;

/**
 * Submits a pdf to ABBYY for OCR if the pdf only contains images. Otherwise, we
 * could just extract the pdf text directly.
 * 
 * @author connie
 * 
 */
public class AbbyyClient {

	/**
	 * Submits a pdf file to Abbyy for OCR. If the job is successfully
	 * completed, the extracted text from the pdf file will be stored in an
	 * intermediate data directory in the form of a .txt file
	 * 
	 * @param pdfFile
	 */
	public static void submitFile(File pdfFile) {
		try {
			// TODO TODO TODO
			// Need to build an argsList consisting of the pdfFile to submit and
			// the output file to send the results to
			Vector<String> argsList = new Vector<String>();
			argsList.add(pdfFile.getName());

			// Consider making an intermediate data dir
			String intermediatePath = "intermediatedata/";
			String xmlResultFile = pdfFile.getName() + "result.xml";
			String finalXMLResult = intermediatePath + xmlResultFile;
			argsList.add(finalXMLResult);

			TestApp.performRecognition(argsList);

			// Now ask for a txt file
			argsList.remove(argsList.size() - 1);
			String txtResultFile = pdfFile.getName() + "result.txt";
			String finalTextResult = intermediatePath + txtResultFile;
			argsList.add(finalTextResult);

			TestApp.performRecognition(argsList);

			notifyEntryBuilder(xmlResultFile, txtResultFile);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Notifies the entry builder that text has been extracted. 
	 * 
	 * @param xmlResultFilePath
	 * @param txtResultFilePath
	 */
	private static void notifyEntryBuilder(String xmlResultFilePath,
			String txtResultFilePath) {
		File xmlResultFile = new File(xmlResultFilePath);
		File txtResultFile = new File(txtResultFilePath);
		EntryBuilder.onExtracted(xmlResultFile, txtResultFile);
	}
}