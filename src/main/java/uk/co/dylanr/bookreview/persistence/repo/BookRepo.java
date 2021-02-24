package uk.co.dylanr.bookreview.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uk.co.dylanr.bookreview.persistence.domain.Book;
import uk.co.dylanr.bookreview.persistence.domain.Review;

import java.util.List;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {
}
