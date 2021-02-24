package uk.co.dylanr.bookreview.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.dylanr.bookreview.persistence.domain.Review;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BookDto {
    private Long id;
    private String title;
    private String author;
    private String genre;
    private List<ReviewDto> review = new ArrayList<>();
}
