package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Authour {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long authourId;
	private String firstName;
	private String lastName;
	
	@ManyToMany(mappedBy = "authours")
	private Set<Book> books = new HashSet<Book>();
	
	public Authour() {
		// TODO Auto-generated constructor stub
	}
	
	public Authour(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}

	public Long getAuthourId() {
		return authourId;
	}

	public void setAuthourId(Long authourId) {
		this.authourId = authourId;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((authourId == null) ? 0 : authourId.hashCode());
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
		Authour other = (Authour) obj;
		if (authourId == null) {
			if (other.authourId != null)
				return false;
		} else if (!authourId.equals(other.authourId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Authour [authourId=" + authourId + ", firstName=" + firstName + ", lastName=" + lastName + ", books="
				+ books + "]";
	}
	
	
	
	

}
