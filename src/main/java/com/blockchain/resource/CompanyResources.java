package com.blockchain.resource;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blockchain.DTO.CompanyDTO;
import com.blockchain.entities.Company;
import com.blockchain.services.CompanyServices;

@RestController
@RequestMapping(value = "/companies")
public class CompanyResources {

	@Autowired
	private CompanyServices service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<CompanyDTO>> findAll() {
		List<Company> listCompany = service.findAll();
		List<CompanyDTO> listCompanyDTO = listCompany.stream().map(x->new CompanyDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listCompanyDTO);
	}

	@RequestMapping(method = RequestMethod.GET , value = "/{id}")
	public ResponseEntity<CompanyDTO> findById(@PathVariable String id) {
		Company company = service.findById(id);
		return ResponseEntity.ok().body(new CompanyDTO(company));
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public ResponseEntity<Company> update(@PathVariable String id, @RequestBody Company company){
		Company obj = service.findById(id);
		obj.setId(id);
		obj = service.update(company);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody CompanyDTO objDTO){
		Company obj = service.fromDTO(objDTO);
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).build();
		}
	
	@RequestMapping(method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@RequestBody String id){
		service.deleteByID(id);
		return ResponseEntity.noContent().build();
	}
}
