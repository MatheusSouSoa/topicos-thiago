package com.example.demo.service;

import com.example.demo.model.entities.Investment;
import com.example.demo.repository.InvestmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvestmentService {

    private final InvestmentRepository investmentRepository;

    @Autowired
    public InvestmentService(InvestmentRepository investmentRepository) {
        this.investmentRepository = investmentRepository;
    }

    public List<Investment> getAll() {
        return investmentRepository.findAll();
    }

    public List<Investment> getInvestmentsByUserId(Long userId) {
        return investmentRepository.findByUserId(userId);
    }

    public Investment create(Investment investment) {
        return investmentRepository.save(investment);
    }

    public Optional<Investment> getById(Long id) {
        return investmentRepository.findById(id);
    }

    public void delete(Long id) {
        investmentRepository.deleteById(id);
    }
}
