package com.qa.ims.persistence.domain;

public class Orders {
	
	private Long orderid;
	private Long customerid;
	private Long itemid;
	private Long quantity;
	private Float total;
	private String customer;
	private Float value;
	private String itemName;
	
	public Orders(Long customerid) {
        this.setCustomerid(customerid);
        
	}
	
	public Orders(Long orderid,Long customerid) {
        this.setOrderid(orderid);
        this.setCustomerid(customerid);
    }
	public Orders(Long orderid, Long itemid, Long quantity) {
        this.setOrderid(orderid);
        this.setItemid(itemid);
        this.quantity = quantity;
    }
	
	public Orders (Long orderid, Long itemid, String customer, String itemName, Long quantity, Float value, Float total){
        this.setOrderid(orderid);
        this.setItemid(itemid);
        this.customer = customer;
        this.itemName = itemName;
        this.quantity = quantity;
        this.value = value;
        this.total = total;
    }
	
	public Long getOrderid() {
		return orderid;
	}

	public void setOrderid(Long orderid) {
		this.orderid = orderid;
	}

	public Long getCustomerid() {
		return customerid;
	}
	
	public Float getTotal() {
        return total;
	}
	
	public void setCustomerid(Long customerid) {
		this.customerid = customerid;
	}

	public Long getItemid() {
		return itemid;
	}

	public void setItemid(Long itemid) {
		this.itemid = itemid;
	}

	public Long getQuantity() {
		return quantity;
	}

	//public void setQuantity(Long quantity) {
	//	this.quantity = quantity;
	//}
	
	@Override
	public String toString() {
		return "Order - order ID = " + orderid + ", item ID = " + itemid +", customer = " + customer + ", item Name = " + itemName + ", quantity = " + quantity + ", value = £" + value +", total = £" + total +"";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((customerid == null) ? 0 : customerid.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((orderid == null) ? 0 : orderid.hashCode());
		result = prime * result + ((total == null) ? 0 : total.hashCode());
		result = prime * result + ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((customer == null) ? 0 : customer.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
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
		Orders other = (Orders) obj;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		if (orderid == null) {
			if (other.orderid != null)
				return false;
		} else if (!orderid.equals(other.orderid))
			return false;
		if (customerid == null) {
			if (other.customerid != null)
				return false;
		} else if (!customerid.equals(other.customerid))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (total == null) {
			if (other.total != null)
				return false;
		} else if (!total.equals(other.total))
			return false;
		if (customer == null) {
			if (other.customer != null)
				return false;
		} else if (!customer.equals(other.customer))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		if (itemName == null) {
			if (other.itemName != null)
				return false;
		} else if (!itemName.equals(other.itemName))
			return false;
		return true;
	}

}
