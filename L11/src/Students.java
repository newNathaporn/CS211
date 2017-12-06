
public class Students implements Comparable<Student>{
	int id;
	String name;
	int score;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Students(int id, String name, int score) {
		super();
		this.id = id;
		this.name = name;
		this.score = score;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", score=" + score + "]";
	}
	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Student)) return false;
		Students s = (Students)obj;
		return this.id == s.id;
	}
	@Override
	public int hashCode() {
		return id;	
	}
	@Override
	public int compareTo(Student o) {
		return -(this.score-o.score);
	}
	
}
