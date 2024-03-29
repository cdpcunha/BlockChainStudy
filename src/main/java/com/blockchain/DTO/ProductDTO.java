package com.blockchain.DTO;

import java.io.Serializable;

import com.blockchain.entities.Product;

public class ProductDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String id;
	private String prodName;
	
	public ProductDTO() {
		
	}
	
	public ProductDTO(Product product) {
		this.id = product.getId();
		this.prodName = product.getProdName();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProductDTO other = (ProductDTO) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "ProductDTO [id=" + id + ", prodName=" + prodName + "]";
	}

	
}
