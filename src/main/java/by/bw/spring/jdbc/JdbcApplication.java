package by.bw.spring.jdbc;

import by.bw.spring.jdbc.models.Book;
import by.bw.spring.jdbc.reposotory.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;

// CREATE TABLE `springtest`.`books` ( `id` INT NOT NULL AUTO_INCREMENT , `name` VARCHAR(255) NOT NULL , `author` VARCHAR(255) NOT NULL , PRIMARY KEY (`id`)) ENGINE = InnoDB;

@SpringBootApplication
public class JdbcApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(JdbcApplication.class, args);
	}

	@Autowired
	BookRepository bookRepository;

	@Override
	public void run(String... args) throws Exception {
		Book newBook1 = new Book("Незнайка", "Носов");
		Book newBook2 = new Book("Война и мир", "Толстой");
		Book newBook3 = new Book("Руслан и Людмила", "Пушкин");
		List<Book> books = Arrays.asList(newBook1, newBook2, newBook3);
		bookRepository.saveAll(books);

		System.out.println("name >>>>>>" + bookRepository.findByName("Незнайка"));
		System.out.println("author >>>>" + bookRepository.findByAuthor("Носов"));
		System.out.println("id >>>>>>>>" + bookRepository.findById(2));
//		System.out.println("LIST>>>>>>>" + bookRepository.findAllOrderedBYName());
		System.out.println("==========================================================");
		System.out.println(bookRepository.findAll());
	}
}
