package guru.springframework.spring5webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Auther;
import guru.springframework.spring5webapp.domain.Books;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repository.AuthorRepository;
import guru.springframework.spring5webapp.repository.BookRepository;
import guru.springframework.spring5webapp.repository.PublisherRepository;

@Component
public class BootStrap implements CommandLineRunner {

	private final AuthorRepository authorRepository;
	private final BookRepository bookRepository;
	private final PublisherRepository publisherRepository;
	
	public BootStrap(AuthorRepository authorRepository, BookRepository bookRepository , PublisherRepository publisherRepository) {
		super();
		this.authorRepository = authorRepository;
		this.bookRepository = bookRepository;
		this.publisherRepository = publisherRepository;
	}

	
	
	@Override
	public void run(String... args) throws Exception {
		
		Auther eric = new Auther("lokesh" ,"nemade");
		Books book = new Books("Domain Design", "isbn:12345");
		Books book2 = new Books("Software Design", "isbn:12345");
		
		eric.getBooks().add(book);
		book.getAuther().add(eric);
		
		Publisher publisher = new Publisher("lokesh" , "pune" , "MH" , 425001);
	   publisherRepository.save(publisher);
		
		book.setPublisher(publisher);
		book2.setPublisher(publisher);
	    publisher.getBooks().add(book);	
	    publisher.getBooks().add(book2);	
	    
	    authorRepository.save(eric);
		bookRepository.save(book);
		publisherRepository.save(publisher);
		
		System.out.println("started in bootstrap");
		System.out.println("No of Books :"+ bookRepository.count());
		System.out.println("publisher has number of books :"+ publisher.getBooks().size());
		
	}

}
