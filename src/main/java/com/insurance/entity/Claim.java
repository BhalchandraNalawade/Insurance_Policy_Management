
package com.insurance.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name="claims")
public class Claim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long claimId;

    private String claimNumber;

	private String claimNominee

    private Double claimAmount;

    private String claimStatus;

    private LocalDate claimDate;

    @ManyToOne
    @JoinColumn(name="policy_id")
    private Policy policy;

	public Long getClaimId() {
		return claimId;
	}

	public void setClaimId(Long claimId) {
		this.claimId = claimId;
	}

	public String getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(String claimNumber) {
		this.claimNumber = claimNumber;
	}

	public Double getClaimAmount() {
		return claimAmount;
	}

	public void setClaimAmount(Double claimAmount) {
		this.claimAmount = claimAmount;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	@Override
	public String toString() {
		return "Claim [claimId=" + claimId + ", claimNumber=" + claimNumber + ", claimAmount=" + claimAmount
				+ ", claimStatus=" + claimStatus + ", claimDate=" + claimDate + ", policy=" + policy + "]";
	}
	
	
    
    
}
