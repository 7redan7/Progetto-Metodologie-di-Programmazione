package progetto.mp.net.utils;

import progetto.mp.net.NetContent;

public class MockNetContent implements NetContent {
	
	private String owner;
	private String data;
	
	public MockNetContent(String owner, String data) {
		this.owner = owner;
		this.data = data;
	}
	
	public MockNetContent() {
		this.owner = "";
		this.data = "";
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
		return result;
	}
	
	@Override
	public void visualize() {
		//does nothing
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MockNetContent other = (MockNetContent) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}
}
