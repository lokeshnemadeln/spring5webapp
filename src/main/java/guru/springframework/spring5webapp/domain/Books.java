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
public class Books {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title;
	private String isbn;
	
	@ManyToOne
	private Publisher publisher;

	@ManyToMany
	@JoinTable(name = "auther_book",joinColumns = @JoinColumn(name="book_id"),
	inverseJoinColumns = @JoinColumn(name="auther_id"))
	private Set<Auther> auther = new HashSet<>();
	
	public Books()
	{
		
	}
	
	public Set<Auther> getAuther() {
		return auther;
	}

	public void setAuther(Set<Auther> auther) {
		this.auther = auther;
	}

	public Books(String title, String isbn) {
		super();
		this.title = title;
		this.isbn = isbn;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}

	@Override
	public int hashCode() {
		return id != null ? id.hashCode() : 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Books other = (Books) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Books [id=" + id + ", title=" + title + ", isbn=" + isbn + ", auther=" + auther + "]";
	}
	
}
