package guru.springframework.spring5webapp.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Book {
    
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long bookId;
	

	private String title;
	private String isbn;
	
	@ManyToMany
	@JoinTable(name ="authour_book" ,joinColumns = @JoinColumn(name = "book_bookId") ,
	inverseJoinColumns = @JoinColumn(name = "authour_authourId"))
	private Set<Authour> authours = new HashSet<Authour>();
	
	@ManyToOne
	@JoinColumn(name = "publisher_publisherId")
	private Publisher publisher;
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(String title, String isbn) {
		this.title = title;
		this.isbn = isbn;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public Set<Authour> getAuthours() {
		return authours;
	}

	public void setAuthours(Set<Authour> authours) {
		this.authours = authours;
	}
	
	public long getBookId() {
		return bookId;
	}

	public void setBookId(long bookId) {
		this.bookId = bookId;
	}

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (bookId ^ (bookId >>> 32));
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
		Book other = (Book) obj;
		if (bookId != other.bookId)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Book [bookId=" + bookId + ", title=" + title + ", isbn=" + isbn + ", authours=" + authours + "]";
	}

	
	
	
}
