package com.blockchain.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blockchain.DTO.CompanyDTO;
import com.blockchain.entities.Company;
import com.blockchain.repository.CompanyRepository;
import com.blockchain.services.exceptions.ObjectNotFound;

@Service
public class CompanyServices {

	@Autowired
	private CompanyRepository companyRepo;

	public List<Company> findAll() {
		return companyRepo.findAll();
	}

	public Company findById(String id) {
		Optional<Company> company = companyRepo.findById(id);
		return company.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado"));
	}

	public Company update(Company company) {
		Company newCompany = new Company();
		newCompany.setId(company.getId());
		updateData(newCompany, company);
		return companyRepo.save(newCompany);
	}

	private void updateData(Company newCompany, Company company) {
		newCompany.setcompanyName(company.getcompanyName());
	}
	
	public Company insert(Company company) {
		return companyRepo.insert(company);
	}
	
	public Company fromDTO(CompanyDTO dto) {
		return new Company(dto.getId(),dto.getCompanyName());
	}
	
	public void deleteByID(String id) {
		findById(id); //valida a existência do Id
		companyRepo.deleteById(id);
	}
}
