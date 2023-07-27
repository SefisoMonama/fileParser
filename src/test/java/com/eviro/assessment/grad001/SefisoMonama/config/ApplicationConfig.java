package com.eviro.assessment.grad001.SefisoMonama.config;

import java.net.URI;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
public class ApplicationConfig {
	@Value("{$upload-dir}")
	private String uploadDir;

	public URI getUploadDir() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
