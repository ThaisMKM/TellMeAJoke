package com.tmkm.tellmeajoke.managedBeans;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.faces.bean.ManagedBean;

import org.apache.myfaces.trinidad.model.UploadedFile;
import org.primefaces.event.FileUploadEvent;

import com.sun.istack.logging.Logger;
import com.tmkm.tellmeajoke.utils.TellMeAJokeConstants;

@ManagedBean
public class FileMB {
	
	Logger logger = Logger.getLogger(FileMB.class);

	public void uploadFile(FileUploadEvent event) {
		UploadedFile file = (UploadedFile) event.getFile();
		long fileSize = file.getLength();

		if (fileSize > 500000) {
			// send error message
		} else {
			saveFile(file);
		}

		// Save myInputStream in a directory of your choice and store that path
		// in DB
	}

	private void saveFile(UploadedFile file) {
		String pathToJoke = TellMeAJokeConstants.PATH_TO_JOKES.getValue();
		InputStream fileInputStream = null;
		OutputStream fileOutputStream = null;
		try {
			fileInputStream = file.getInputStream();
			fileOutputStream = new FileOutputStream(new File(pathToJoke + File.pathSeparator + file.getFilename() + "_"+System.currentTimeMillis()));
			 
			int read = 0;
			byte[] bytes = new byte[1024];
		 
			while ((read = fileInputStream.read(bytes)) != -1) {
				fileOutputStream.write(bytes, 0, read);
			}
		 			
			fileOutputStream.flush();
			

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} finally{
			try{
				fileInputStream.close();
				fileOutputStream.close();
			} catch(Exception e){
				logger.fine("Issue closing streams");
			}
		}

	}
}
