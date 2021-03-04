package uk.co.dylanr.bookreview.rest.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import uk.co.dylanr.bookreview.persistence.domain.Review;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import uk.co.dylanr.bookreview.persistence.repo.ReviewRepo;



import java.util.List;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles(profiles = "test")
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ReviewControllerIntegrationTest {
    @Autowired
    private MockMvc mock;

    @Autowired
    private ObjectMapper toJson;

    @Autowired
    private ReviewRepo repo;

    private final Review review = new Review(2L,"review text", "book title","Name Namington");
    private final Review review2Changed = new Review(1L,"This is new text", "new title","Different author");
    private final Review review2 = new Review(1L,"great book", "This is a book","Name Namington");
    private final Review review3 = new Review(2L,"This is the best book ever", "Book name","Jerry jerry");
    private final Review review4 = new Review(3L,"q weji qlwke jlkqwjeklf lkfsdjlksdf", "dasjkd AWhje ","asdaks dhajsdhjkasd");
    private final List<Review> reviews = List.of(review2,review3,review4);
    private final List<Review> reviewL = List.of(review);
    private final List<Review> review3L = List.of(review3);

    @BeforeEach
    public void setup() {
        this.repo.flush();
        this.repo.saveAll(reviews);
    }

    @Test
    void testCreate() throws Exception {
        this.mock
                .perform(post("/review/create")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.toJson.writeValueAsString(review)))
                .andExpect(status().isCreated())
                .andExpect(content().json(this.toJson.writeValueAsString(review)));
    }

    @Test
    void testReadAll() throws Exception {
        this.mock
                .perform(get("/review/readAll")
                    .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.toJson.writeValueAsString(reviews)));
    }

    @Test
    void testUpdateById() throws Exception {
        this.mock
                .perform(put("/review/update/"+review2.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(this.toJson.writeValueAsString(review2Changed)))
                .andExpect(status().isAccepted())
                .andExpect(content().json(this.toJson.writeValueAsString(review2Changed)));
    }

    @Test
    void testDeleteById() throws Exception {
        this.mock
            .perform(delete("/review/delete/"+review4.getId())
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isNoContent());
    }

    @Test
    void testReadById() throws Exception {
        this.mock
                .perform(get("/review/read/"+review3.getId())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.toJson.writeValueAsString(review3)));
    }


    @Test
    void testReadByBookTitle() throws Exception {
        this.mock
                .perform(get("/review/read/byBook/"+review3.getBookTitle())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.toJson.writeValueAsString(review3L)));
    }
    @Test
    void testReadByAuthorName()throws Exception{
        this.mock
                .perform(get("/review/read/byAuthor/"+review3.getAuthorName())
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().json(this.toJson.writeValueAsString(review3L)));
    }

}
