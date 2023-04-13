package prof.person;

public class VoteListAttr {
	private String name;
	private String email;
	private String vote;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getVote() {
		return vote;
	}
	public void setVote(String vote) {
		this.vote = vote;
	}
	public String toString() {
		return "VoteListAttr [name=" + name + ", vote="+ vote + ", email=" + email + "]";
	}
}
