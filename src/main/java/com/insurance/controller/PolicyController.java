package com.insurance.controller;

import com.insurance.entity.Policy;
import com.insurance.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {
	
    private final PolicyService service;

	@Autowired
    public PolicyController(PolicyService service) {
	    this.service = service;
	}

    @PostMapping
    public Policy create(@RequestBody Policy policy) {
        return service.createPolicy(policy);
    }

    @GetMapping("/{id}")
    public Policy get(@PathVariable Long id) {
        return service.getPolicy(id);
    }

    @GetMapping
    public List<Policy> getAll() {
        return service.getAllPolicies();
    }

    @PutMapping("/{id}")
    public Policy update(
            @PathVariable Long id,
            @RequestBody Policy policy) {

        return service.updatePolicy(id, policy);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {

        service.deletePolicy(id);
        return "Policy deleted successfully";
    }
}
