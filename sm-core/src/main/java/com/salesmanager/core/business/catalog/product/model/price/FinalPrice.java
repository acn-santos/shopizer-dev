package com.salesmanager.core.business.catalog.product.model.price;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Transient entity used to display
 * different price information in the catalogue
 * @author casams1
 *
 */
public class FinalPrice {
	
	private BigDecimal discountedPrice = null;
	private BigDecimal originalPrice = null;
	private boolean discounted = false;
	private int discountPercent = 0;
	
	private Date discountEndDate = null;



	public BigDecimal getOriginalPrice() {
		return originalPrice;
	}

	public void setOriginalPrice(BigDecimal originalPrice) {
		this.originalPrice = originalPrice;
	}



	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public Date getDiscountEndDate() {
		return discountEndDate;
	}

	public void setDiscountEndDate(Date discountEndDate) {
		this.discountEndDate = discountEndDate;
	}

	public boolean isDiscounted() {
		return discounted;
	}

	public void setDiscounted(boolean discounted) {
		this.discounted = discounted;
	}

	public void setDiscountedPrice(BigDecimal discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public BigDecimal getDiscountedPrice() {
		return discountedPrice;
	}

}
