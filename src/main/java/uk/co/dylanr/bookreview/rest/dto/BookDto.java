package uk.co.dylanr.bookreview.rest.dto;

import lombok.Data;
import uk.co.dylanr.bookreview.persistence.domain.Review;

import java.util.List;

@Data
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private List<Review> reviews;
}
