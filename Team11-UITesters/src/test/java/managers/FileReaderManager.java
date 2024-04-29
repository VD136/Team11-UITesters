package managers;

import readers.ConfigFileReader;
import readers.ExcelReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigFileReader configFileReader;
	private static ExcelReader excelReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigFileReader getConfigReader() {
		 return (configFileReader == null) ? new ConfigFileReader() : configFileReader;
	 }
	 
	 public ExcelReader getExcelReader() {
		 return (excelReader == null) ? new ExcelReader() : excelReader;
	 }
}