package uk.co.dylanr.bookreview.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import uk.co.dylanr.bookreview.persistence.domain.Book;

@Data
@NoArgsConstructor
public class ReviewDto {

    private Long id;
    private String body;

}
