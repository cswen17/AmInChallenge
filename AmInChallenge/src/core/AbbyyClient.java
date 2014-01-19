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
	public void submitFile(File pdfFile) {
		try {
			// TODO TODO TODO
			// Need to build an argsList consisting of the pdfFile to submit and
			// the output file to send the results to
			Vector<String> argsList = new Vector<String>();

			// Consider making an intermediate data dir
			String intermediatePath = "intermediatedata/";
			String resultFile = pdfFile.getName() + "result.txt";
			String finalResult = intermediatePath + resultFile;
			argsList.add(finalResult);

			TestApp.performRecognition(argsList);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}