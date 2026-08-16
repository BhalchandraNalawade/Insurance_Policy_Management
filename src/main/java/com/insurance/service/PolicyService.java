
package com.insurance.service;

import com.insurance.entity.Policy;

import java.util.List;

public interface PolicyService {

    Policy createPolicy(Policy policy);

    Policy getPolicy(Long id);

    List<Policy> getAllPolicies();

    Policy updatePolicy(Long id, Policy policy);

    void deletePolicy(Long id);
}
