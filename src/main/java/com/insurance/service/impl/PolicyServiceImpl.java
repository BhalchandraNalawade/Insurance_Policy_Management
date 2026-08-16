

package com.insurance.service.impl;

import com.insurance.entity.Policy;
import com.insurance.exception.ResourceNotFoundException;
import com.insurance.repository.PolicyRepository;
import com.insurance.service.PolicyService;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService {
	
    private PolicyRepository repository;

	@Autowired
	public PolicyServiceImpl(PolicyRepository repository) {
	    this.repository = repository;
	}
    
    @Override
    public Policy createPolicy(Policy policy) {
        return repository.save(policy);
    }

    @Override
    public Policy getPolicy(Long id) {
        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Policy not found"));
    }

    @Override
    public List<Policy> getAllPolicies() {
        return repository.findAll();
    }

    @Override
    public Policy updatePolicy(Long id, Policy policy) {

        Policy existing = getPolicy(id);

        existing.setPolicyType(policy.getPolicyType());
        existing.setPremiumAmount(policy.getPremiumAmount());
        existing.setCoverageAmount(policy.getCoverageAmount());
        existing.setStatus(policy.getStatus());

        return repository.save(existing);
    }

    @Override
    public void deletePolicy(Long id) {
        repository.deleteById(id);
    }
}
