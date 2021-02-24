package uk.co.dylanr.bookreview.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import uk.co.dylanr.bookreview.persistence.repo.ReviewRepo;

@SpringBootTest
public class ReviewServiceUnit {
    @Autowired
    private ReviewService service;

    @MockBean
    private ReviewRepo repo;
}
