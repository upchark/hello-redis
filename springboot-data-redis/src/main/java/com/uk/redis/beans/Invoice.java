package com.uk.redis.beans;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Entity(name = "invoice")
@Table(name = "TEMP_INVOICE")
public class Invoice implements Serializable {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", updatable = false)
    private Long invId;

    @Column(name = "name", updatable = false)
    private String invName;

    @Column(name = "amount")
    private Double invAmount;

    @Column(name = "created_at")
    private Date createdAt;

    @Column(name = "updated_at")
    private Date updatedAt;

	public Long getInvId() {
		return this.invId;
	}

	public Double getInvAmount() {
		return this.invAmount;
	}

	public String getInvName() {
		return invName;
	}

	public void setInvName(String invName) {
		this.invName = invName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public void setInvId(Long invId) {
		this.invId = invId;
	}

	public void setInvAmount(Double invAmount) {
		this.invAmount = invAmount;
	}

	@Override
	public String toString() {
		return "Invoice [invId=" + invId + ", invName=" + invName + ", invAmount=" + invAmount + ", createdAt="
				+ createdAt + ", updatedAt=" + updatedAt + "]";
	}
}
