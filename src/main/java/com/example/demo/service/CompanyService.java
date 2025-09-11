package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.respository.ICompanyRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final ICompanyRepository companyRepository;

    public CompanyService(ICompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies(Integer page, Integer size) {
        if (page == null || size == null) {
            return companyRepository.findAll();
        }
        Pageable pageable = PageRequest.of(page-1, size);

        return companyRepository.findAll(pageable).toList();
    }

    public Company createCompany(Company company) {
        company.setActive(true);
        return companyRepository.save(company);
    }

    public Company updateCompany(int id, Company updatedCompany) {
        Company company = getCompanyById(id);
        company.setName(updatedCompany.getName());
        return companyRepository.save(company);
    }

    public Company getCompanyById(int id) {
        Optional<Company> company = companyRepository.findById(id);
        if (company.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Company not found with id: " + id);
        }
        return company.get();
    }

    public void deleteCompany(int id) {
        Company company = getCompanyById(id);
        companyRepository.delete(company);
    }

}
