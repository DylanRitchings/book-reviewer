package uk.co.dylanr.bookreview.persistence.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import uk.co.dylanr.bookreview.persistence.domain.Book;
import uk.co.dylanr.bookreview.persistence.domain.Review;

import java.util.List;

public interface BookRepo extends JpaRepository<Book, Long> {
}
