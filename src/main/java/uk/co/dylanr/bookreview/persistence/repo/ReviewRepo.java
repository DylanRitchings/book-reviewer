package uk.co.dylanr.bookreview.persistence.repo;

import lombok.NonNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import uk.co.dylanr.bookreview.persistence.domain.Review;

import java.util.List;

public interface ReviewRepo extends JpaRepository<Review, Long> {

    // SELECT * from Review where book_title = '[bookTitle]';
    List<Review> findAllByBookTitle(@NonNull String bookTitle);

    // SELECT * from Review where author_name = '[authorName]';
    List<Review> findAllByAuthorName(@NonNull String authorName);


}