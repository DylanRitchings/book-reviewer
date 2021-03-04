package uk.co.dylanr.bookreview.rest.controller;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import uk.co.dylanr.bookreview.persistence.domain.Review;
import uk.co.dylanr.bookreview.rest.controller.ReviewController;
import uk.co.dylanr.bookreview.service.ReviewService;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

import java.util.List;

@SpringBootTest
public class ReviewControllerUnitTest {

    @Autowired
    private ReviewController controller;

    @MockBean
    private ReviewService service;


    private final Review review = new Review(1L,"review text", "book title","Name Namington");
    private final Review reviewChanged = new Review(1L,"This is new text", "new title","Different author");
    private final Review review2 = new Review(2L,"great book", "This is a book","Name Namington");
    private final List<Review> reviews = List.of(review, review2);
    private final List<Review> reviewL = List.of(review);

    @Test
    void testCreate(){
        Mockito.when(this.service.create(review)).thenReturn(review);
        Assertions.assertThat(this.controller.create(review)).isEqualTo(new ResponseEntity<>(review, HttpStatus.CREATED));
        Mockito.verify(this.service, Mockito.times(1)).create(review);
    }

    @Test
    void testReadAll(){
        Mockito.when(this.service.readAll()).thenReturn(reviews);
        Assertions.assertThat(this.controller.readAll().getBody().isEmpty()).isFalse();
        Mockito.verify(this.service, Mockito.times(1)).readAll();
    }

    @Test
    void testUpdateById(){
        Mockito.when(this.service.updateById(review.getId(), reviewChanged)).thenReturn(reviewChanged);
        Assertions.assertThat(this.controller.updateById(review.getId(), reviewChanged)).isEqualTo(new ResponseEntity<>(reviewChanged, HttpStatus.ACCEPTED));
        Mockito.verify(this.service, Mockito.times(1)).updateById(review.getId(), reviewChanged);
    }

    @Test
    void testDeleteById(){
        Mockito.when(this.service.deleteById(review.getId())).thenReturn(false);
        Assertions.assertThat(this.controller.deleteById(review.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        Mockito.verify(this.service, Mockito.times(1)).deleteById(review.getId());

        Mockito.when(this.service.deleteById(review.getId())).thenReturn(true);
        Assertions.assertThat(this.controller.deleteById(review.getId())).isEqualTo(new ResponseEntity<>(HttpStatus.NO_CONTENT));
        Mockito.verify(this.service, Mockito.times(2)).deleteById(review.getId());
    }

    @Test
    void testReadById(){
        Mockito.when(this.service.readById(review.getId())).thenReturn(review);
        Assertions.assertThat(this.controller.readById(review.getId())).isEqualTo(new ResponseEntity<>(review, HttpStatus.OK));
        Mockito.verify(this.service, Mockito.times(1)).readById(review.getId());
    }


    @Test
    void testReadByBookTitle(){
        Mockito.when(this.service.readByBookTitle(review.getBookTitle())).thenReturn(reviewL);
        Assertions.assertThat(this.controller.readByBookTitle(review.getBookTitle())).isEqualTo(new ResponseEntity<>(reviewL, HttpStatus.OK));
        Mockito.verify(this.service, Mockito.times(1)).readByBookTitle(review.getBookTitle());
    }
    @Test
    void testReadByAuthorName(){
        Mockito.when(this.service.readByAuthorName(review.getAuthorName())).thenReturn(reviewL);
        Assertions.assertThat(this.controller.readByAuthorName(review.getAuthorName())).isEqualTo(new ResponseEntity<>(reviewL, HttpStatus.OK));
        Mockito.verify(this.service, Mockito.times(1)).readByAuthorName(review.getAuthorName());
    }

}
