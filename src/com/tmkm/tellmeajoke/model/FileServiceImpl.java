package com.tmkm.tellmeajoke.model;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.myfaces.trinidad.model.UploadedFile;

import com.sun.istack.logging.Logger;
import com.tmkm.tellmeajoke.entities.Joke;
import com.tmkm.tellmeajoke.managedBeans.FileMB;
import com.tmkm.tellmeajoke.utils.TellMeAJokeConstants;

public class FileServiceImpl implements FileService{
	
	Logger logger = Logger.getLogger(FileServiceImpl.class);
	
	public boolean saveJokeFile(UploadedFile file) {
		boolean saved = false;
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
			saved = true;

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
		return saved;
	}
}
