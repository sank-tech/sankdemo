/** 
 * Creating log function to store logs using sql
 * This program is an integration towards accessing the objects of book class
 * 
 * Note: Getters and Setters have been generated generated and to string method is used to overide the method. 
 *  
 * @author Ramkrishna Dakwa (Great Learning FSD 10th Batch)
 * @version 17.0 
 * @since 2nd April 2022 
 */
package com.logs;
import java.io.File;
import java.util.logging.*;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.*;
import java.util.logging.FileHandler;
public class log {
	public Logger logger;
	FileHandler fh;
	public log (String file_name) throws IOException {
		File f = new File(file_name);
		if(f.exists()) {
			f.createNewFile();
		}
		fh = new FileHandler(file_name,true);
	}
}
