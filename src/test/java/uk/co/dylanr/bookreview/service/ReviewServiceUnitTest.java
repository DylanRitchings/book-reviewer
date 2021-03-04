package uk.co.dylanr.bookreview.service;

import com.sun.xml.bind.v2.runtime.output.SAXOutput;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import uk.co.dylanr.bookreview.persistence.domain.Review;
import uk.co.dylanr.bookreview.persistence.repo.ReviewRepo;

import java.util.List;
import java.util.Optional;

@SpringBootTest
public class ReviewServiceUnitTest {
    @Autowired
    private ReviewService service;

    @MockBean
    private ReviewRepo repo;

    private final Review reviewUnchanged = new Review(1L,"review text", "book title","Name Namington");
    private final Review review = new Review(1L,"review text", "book title","Name Namington");
    private final Review reviewChanged = new Review(1L,"This is new text", "new title","Different author");
    private final Review review2 = new Review(2L,"great book", "This is a book","Name Namington");


    private List<Review> reviews = List.of(review, review2);

    private List<Review> reviewL = List.of(review);

    @Test
    void testCreate(){
        Mockito.when(this.repo.save(review)).thenReturn(review);
        Assertions.assertThat(this.service.create(review)).isEqualTo(review);
        Mockito.verify(this.repo, Mockito.times(1)).save(review);
    }

    @Test
    void testReadById(){
        Mockito.when(this.repo.findById(review.getId())).thenReturn(Optional.of(review));
        Assertions.assertThat(this.service.readById(review.getId())).isEqualTo(review);
        Mockito.verify(this.repo, Mockito.times(1)).findById(review.getId());
    }

    @Test
    void testReadAll(){
        Mockito.when(this.repo.findAll()).thenReturn(reviews);
        Assertions.assertThat(this.service.readAll().isEmpty()).isFalse();
        Mockito.verify(this.repo, Mockito.times(1)).findAll();
    }

    @Test
    void testUpdateById(){
        Mockito.when(this.repo.findById(review.getId())).thenReturn(Optional.of(review));
        Mockito.when(this.repo.save(reviewChanged)).thenReturn(reviewChanged);
        Assertions.assertThat(this.service.updateById(review.getId(),reviewChanged)).isEqualTo(reviewChanged);
        Mockito.verify(this.repo, Mockito.times(1)).findById(reviewUnchanged.getId());
        Mockito.verify(this.repo, Mockito.times(1)).save(reviewChanged);
    }

    @Test
    void testDeleteById(){
        Mockito.when(this.repo.findById(review.getId())).thenReturn(Optional.of(review));
        Mockito.when(this.repo.existsById(review.getId())).thenReturn(false);
        Assertions.assertThat(this.service.deleteById(review.getId())).isEqualTo(true);
        Mockito.verify(this.repo, Mockito.times(1)).findById(review.getId());
        Mockito.verify(this.repo, Mockito.times(1)).deleteById(review.getId());
        Mockito.verify(this.repo, Mockito.times(1)).existsById(review.getId());
    }

    @Test
    void testReadByBookTitle(){
        Mockito.when(this.repo.findAllByBookTitle(review.getBookTitle())).thenReturn(reviewL);
        Assertions.assertThat(this.service.readByBookTitle(review.getBookTitle())).isEqualTo(reviewL);
        Mockito.verify(this.repo, Mockito.times(1)).findAllByBookTitle(review.getBookTitle());
    }

    @Test
    void testReadByAuthorName(){
        Mockito.when(this.repo.findAllByAuthorName(review.getAuthorName())).thenReturn(reviews);
        Assertions.assertThat(this.service.readByAuthorName(review.getAuthorName())).isEqualTo(reviews);
        Mockito.verify(this.repo, Mockito.times(1)).findAllByAuthorName(review.getAuthorName());
    }
}
