package com.eviro.assessment.grad001.SefisoMonama.service.impl;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.eviro.assesment.grad001.sefisomonama.entity.AccountProfile;
import com.eviro.assessment.grad001.SefisoMonama.config.ApplicationConfig;
import com.eviro.assessment.grad001.SefisoMonama.repository.FileUploadRepository;
import com.eviro.assessment.grad001.SefisoMonama.service.FileUploadingService;
import com.eviro.assessment.grad001.SefisoMonama.utils.FileStorageUtils;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.enums.CSVReaderNullFieldIndicator;

@Service
public class FileUploadingServiceImpl implements FileUploadingService {

	@Autowired
	FileStorageUtils fileStorageUtils;
	
	@Autowired
	private ApplicationConfig config;
	
	@Autowired
	FileUploadRepository fileUploadRepository;
	
	@Override
	public String fileUploading(MultipartFile file) {

		Pair<Boolean, String> storedPair = fileStorageUtils.storeFile(file);
		
		if(storedPair.getFirst()) {
			return "succeefully stored "+storedPair.getSecond();
			
			//need to read csv file and then convert it to the entity
			
			//need to pass the director along with filename
			try(Reader reader = new FileReader(config.getUploadDir()+File.separator+storedPair.getSecond())){
				CsvToBean<AccountProfile> csvToBean = new CsvToBeanBuilder<AccountProfile>(reader)
						.withType(AccountProfile.class)
						.withIgnoreLeadingWhiteSpace(true)
						.withFieldAsNull(CSVReaderNullFieldIndicator.BOTH)
						.build();
				
			
			
				
		List<AccountProfile> accountProfile = csvToBean.parse();
			//finally we get entity
			//repository
			this.fileUploadRepository.saveAll(accountProfile);
			
			}catch(Exception e) {
				return "error occured while reding and writting file";
			}
		}
		
		return null;
	}

}
