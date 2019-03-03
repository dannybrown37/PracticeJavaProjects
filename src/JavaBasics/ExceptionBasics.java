package JavaBasics;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

public class ExceptionBasics {
	
	/* Basic syntax for throwing an exception: 
	 * throw someThrowableObject;
	 * 
	 * You can create your own exception classes, 
	 * you can throw only objects that inherit from this class:
	 * java.lang.Throwable
	 */
	
	/* Try-with-resources statements
	 * 
	 * A resource is an object that must e closed after the program
	 * is finished using it. The try-w-res statement ensures closure. 
	 */
	static String readFirstLineFromFile(String path) throws IOException {
		try (BufferedReader br = 
				new BufferedReader(new FileReader(path))) {
			return br.readLine();
		}
	}
	
	/* The finally block below is used to ensure that a resource is closed 
	 * regardless of whether the try statement completes abruptly or normally. 
	 */
	static String readFirstLineFromFileWithFinallyBlock(String path)
														 throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(path));
		try {
			return br.readLine();
		} finally {
			if (br != null) br.close();
		}
	}
	
	/* We can use one or more resources in a try-with-resources statement.
	 * Here's an example of a function that reads the file names from a zip
	 * file and creates a text file with the names of those files. 
	 * After exit for any reason, resources are closed in the order they are 
	 * named as arguments.
	 */
	public static void writeToFileZipFileContents(String zipFileName,
												  String outputFileName)
												  throws java.io.IOException {

		java.nio.charset.Charset charset =
				java.nio.charset.StandardCharsets.US_ASCII;
		java.nio.file.Path outputFilePath =
				java.nio.file.Paths.get(outputFileName);

		// Open zip file and create output file with 
		// try-with-resources statement

		try (
			java.util.zip.ZipFile zf =
				new java.util.zip.ZipFile(zipFileName);
			java.io.BufferedWriter writer = 
				java.nio.file.Files.newBufferedWriter(outputFilePath, charset)
		) {
			// Enumerate each entry
			for (java.util.Enumeration entries =
								zf.entries(); entries.hasMoreElements();) {
				// Get the entry name and write it to the output file
				String newLine = System.getProperty("line.separator");
				String zipEntryName =
						((java.util.zip.ZipEntry)entries.nextElement()).getName() +
						newLine;
				writer.write(zipEntryName, 0, zipEntryName.length());
			}
		}
	}
	
	// exception chapter practice problem; modified to compile
	public static void cat(File file) {
	    RandomAccessFile input = null;
	    String line = null;

	    try {
	        input = new RandomAccessFile(file, "r");
	        while ((line = input.readLine()) != null) {
	            System.out.println(line);
	        }
	        return;
	    } catch(FileNotFoundException fnf) {
	    	System.err.format("File: %s not found %n", file);
	    } catch(IOException io) {
	    	System.err.println(io.toString());
	    } finally {
	        if (input != null) {
	        	try {
	        		input.close();
	        	} catch(IOException io) {}
	        }
	    }
	}
	
	
	public static void main(String[] args) throws IOException {

		
		// try with resources statement test
		String abs = System.getProperty("user.dir");
		String path = abs +  "/src/JavaBasics/sampleLineInput.txt";
		System.out.println(readFirstLineFromFile(path));
		
		// finally block test
		System.out.println(readFirstLineFromFileWithFinallyBlock(path));
		
		// zip file names into file test
		String zipPath = abs + "/src/JavaBasics/zipSample.zip";
		String newPath = "sampleOutput.txt";
		writeToFileZipFileContents(zipPath, newPath);
		// the file is put into the base JavaProjects folder, not cd
		
		// test for cat exception problem
		File testFile = new File(path);
		File testFile2 = new File(path + 1);
		cat(testFile);
		cat(testFile2);
		
	}

}
