package com.eviro.assessment.grad001.SefisoMonama.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.eviro.assessment.grad001.SefisoMonama.entity.AccountProfile;

@Repository
public interface FileUploadRepository extends JpaRepository<AccountProfile, Long>{

	

}
