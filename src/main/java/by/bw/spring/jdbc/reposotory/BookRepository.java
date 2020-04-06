package by.bw.spring.jdbc.reposotory;

import by.bw.spring.jdbc.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {
    List<Book> findByName(String name);
    List<Book> findByAuthor(String author);

    @Query("SELECT b FROM Book b ORDER BY name") //Book с заглвной как в Entity (Важно)
    List<Book> findAllOrderedBYName();
}
