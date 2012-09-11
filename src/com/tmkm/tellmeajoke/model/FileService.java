package com.tmkm.tellmeajoke.model;

import org.apache.myfaces.trinidad.model.UploadedFile;

import com.tmkm.tellmeajoke.entities.Joke;

public interface FileService {

	public boolean saveJokeFile(UploadedFile file);
}
