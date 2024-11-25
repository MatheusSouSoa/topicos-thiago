package com.example.demo.api;

import com.example.demo.model.entities.Investment;
import com.example.demo.service.InvestmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/investments")
public class InvestmentController {

    private final InvestmentService investmentService;

    public InvestmentController(InvestmentService investmentService) {
        this.investmentService = investmentService;
    }

    @GetMapping
    public List<Investment> getAll() {
        return investmentService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<Investment> getByUserId(@PathVariable Long userId) {
        return investmentService.getInvestmentsByUserId(userId);
    }

    @PostMapping
    public Investment create(@RequestBody Investment investment) {
        return investmentService.create(investment);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        investmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
