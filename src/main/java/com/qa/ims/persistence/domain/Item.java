package com.qa.ims.persistence.domain;

public class Item {
	
	private Long Itemid;
	private String itemName;
	private float value;

	public Item(String itemName, float value) {
		this.setItemName(itemName);
		this.setValue(value);
	}

	public Item(Long Itemid, String itemName, float value) {
		this.setItemId(Itemid);
		this.setItemName(itemName);
		this.setValue(value);
	}
	
	public Long getItemId() {
		return Itemid;
	}

	public void setItemId(Long Itemid) {
		this.Itemid = Itemid;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public float getValue() {
		return value;
	}

	public void setValue(float value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "id:" + Itemid + " Item name:" + itemName + " Value:" + value;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemName == null) ? 0 : itemName.hashCode());
		result = prime * result + ((Itemid == null) ? 0 : Itemid.hashCode());
		// result = prime * result + ((value == null) ? 0 : value.hashCode());
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
		if (Itemid == null) {
			if (other.Itemid != null)
				return false;
		} else if (!Itemid.equals(other.Itemid))
			return false;
		if (value == null) {
			if (other.value != null)
				return false;
		} else if (!value.equals(other.value))
			return false;
		return true;
	}

	

}
