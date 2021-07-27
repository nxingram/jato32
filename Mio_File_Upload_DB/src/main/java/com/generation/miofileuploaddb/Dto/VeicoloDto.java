package com.generation.miofileuploaddb.Dto;

import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

import com.generation.miofileuploaddb.entity.Veicolo;

public class VeicoloDto {

	private int id;
	private String name;
	private String fileName;
	private String type;
	private String url;
	private long size;
	
	public VeicoloDto() {
	}

	public VeicoloDto( String name, String fileName, String type, String url, long size) {
		this.name = name;
		this.fileName = fileName;
		this.type = type;
		this.url = url;
		this.size = size;
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	
	
}
