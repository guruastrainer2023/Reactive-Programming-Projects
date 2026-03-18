package com.training.bean.pack6;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class FeeDetail {
	private int id;
	private double feeAmount;
	private Set<FeePayment> payments;
	
	public FeeDetail(int id, double feeAmount, Set<FeePayment> payments) {
		super();
		this.id = id;
		this.feeAmount = feeAmount;
		this.payments = payments;
	}

	public FeeDetail(int id) {
		super();
		this.id = id;
	}

	public FeeDetail(double feeAmount, Set<FeePayment> payments) {
		super();
		this.feeAmount = feeAmount;
		this.payments = payments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getFeeAmount() {
		return feeAmount;
	}

	public void setFeeAmount(double feeAmount) {
		this.feeAmount = feeAmount;
	}

	public Set<FeePayment> getPayments() {
		return payments;
	}

	public void setPayments(Set<FeePayment> payments) {
		this.payments = payments;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FeeDetail other = (FeeDetail) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "\n FeeDetail [id=" + id + ", feeAmount=" + feeAmount + ", payments=" + payments + "]";
	}
	
	
	
}
