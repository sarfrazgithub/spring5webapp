package guru.springframework.spring5webapp.bootsrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import guru.springframework.spring5webapp.domain.Authour;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthourRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner{
 
   private final AuthourRepository authourRepo;
   private final BookRepository bookRepo;
   private final PublisherRepository publisherRepo;
   
  
	
	public BootstrapData(AuthourRepository authourRepo, BookRepository bookRepo, PublisherRepository publisherRepo) {
	this.authourRepo = authourRepo;
	this.bookRepo = bookRepo;
	this.publisherRepo = publisherRepo;
}



	@Override
	public void run(String... args) throws Exception {
		
		Publisher publisher = new Publisher("Basha Publications", "Shree Gardens", "Angalakurichi", "Tamilnadu","642007");
		publisherRepo.save(publisher);
		Authour auth1 = new Authour("Sarfraznawaz", "Basha");
		Authour auth2 = new Authour("Yazar Arafath", "Basha");
		Book book1 = new Book("Road to PR in Australia", "ISBN1001");
		Book book2 = new Book("101 tips for Parenting", "ISBN1002");
		
		auth1.getBooks().add(book1);
		book1.getAuthours().add(auth1);
		
		auth2.getBooks().add(book2);
		book2.getAuthours().add(auth2);
		
		
		book1.setPublisher(publisher);
		
		book2.setPublisher(publisher);
		
		
		authourRepo.save(auth1);
		authourRepo.save(auth2);
		
		bookRepo.save(book1);
		bookRepo.save(book2);
		
		publisher.getBooks().add(book1);
		publisher.getBooks().add(book2);
		publisherRepo.save(publisher);
		
		
		
		
		
		System.out.println("Loading data in bootstrap");
		System.out.println("Total Authours:" + authourRepo.count()+"\n Total Books:"+bookRepo.count()+"\n Total Publishers:"+publisherRepo.count());
		
		
		
	}

}
