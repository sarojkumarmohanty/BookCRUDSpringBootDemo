package tech.csm.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import tech.csm.model.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

	List<Book> findByIsDeleted(String isDelete, Pageable page);
	
	@Query("select count(*) from Book where isDeleted='NO'")
	Long countActiveBooks();
}
