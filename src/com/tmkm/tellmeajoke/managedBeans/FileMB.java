package com.tmkm.tellmeajoke.managedBeans;

import javax.faces.bean.ManagedBean;

import org.apache.myfaces.trinidad.model.UploadedFile;
import org.primefaces.event.FileUploadEvent;

import com.sun.istack.logging.Logger;
import com.tmkm.tellmeajoke.model.FileService;
import com.tmkm.tellmeajoke.model.FileServiceImpl;

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

	private String saveFile(UploadedFile file) {
		FileService fileService = new FileServiceImpl();//TODO: refactor to use injection in the future
		if (fileService.saveJokeFile(file)){
			return "joke-uploaded";//TODO: create jole-uploaded page
		} else{
			return "joke-not-uploaded";//TODO: create page. actually was wondering just to send error message
		}

	}
}
