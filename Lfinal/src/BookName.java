

public class BookName {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BookName(String name) {
		super();
		this.name = name;
	}

	@Override
	public boolean equals(Object obj) {
		
		if(obj instanceof BookName){
			return name.equals(((BookName) obj).getName());
		}
		return false;
	}

	@Override
	public int hashCode() {
		
		
		return name.length();
	}
	

}
