package com.eviro.assessment.grad001.SefisoMonama.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.eviro.assessment.grad001.SefisoMonama.service.FileUploadingService;

@RestController
@RequestMapping("/api/*")
public class FileUploadingController {

	@Autowired
	private FileUploadingService fileUploadingService;
	
	@PostMapping("uploadFile")
	public String fileUpload(@RequestParam("file") MultipartFile file) {
		return fileUploadingService.fileUploading(file);
		
	}
	
}
