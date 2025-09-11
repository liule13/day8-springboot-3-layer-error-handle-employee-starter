package com.example.demo.respository;

import com.example.demo.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICompanyRepository extends JpaRepository<Company,Integer> {
}
