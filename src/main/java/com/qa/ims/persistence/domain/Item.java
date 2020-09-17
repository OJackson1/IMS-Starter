package com.qa.ims.persistence.domain;

public class Item {
	
	private Long itemid;
	private String itemName;
	private Float value;

	public Item(String itemName, Float value) {
		this.setItemName(itemName);
		this.setValue(value);
	}

	public Item(Long itemid, String itemName, Float value) {
		this.setItemId(itemid);
		this.setItemName(itemName);
		this.setValue(value);
	}
	
	public Long getItemId() {
		return itemid;
	}

	public void setItemId(Long itemid) {
		this.itemid = itemid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Float getValue() {
		return value;
	}
	
	public void setValue(Float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "item ID: " + itemid + " item Name: " + itemName + " Value: £" + value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((itemid == null) ? 0 : itemid.hashCode());
		result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		Item other = (Item) obj;
		if (getItemName() == null) {
			if (other.getItemName() != null)
				return false;
		} else if (!getItemName().equals(other.getItemName()))
			return false;
		if (itemid == null) {
			if (other.itemid != null)
				return false;
		} else if (!itemid.equals(other.itemid))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	

}
