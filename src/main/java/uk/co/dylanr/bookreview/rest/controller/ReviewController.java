package uk.co.dylanr.bookreview.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.dylanr.bookreview.persistence.domain.Review;
import uk.co.dylanr.bookreview.rest.dto.ReviewDto;
import uk.co.dylanr.bookreview.service.ReviewService;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/review")
public class ReviewController {

    private final ReviewService service;

    @Autowired
    public ReviewController(ReviewService service){
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<ReviewDto> create(@RequestBody Review review){
        ReviewDto createdObject = this.service.create(review);
        return new ResponseEntity<>(createdObject, HttpStatus.CREATED);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<ReviewDto>> readAll() {
        return ResponseEntity.ok(this.service.readAll());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<ReviewDto> updateById(@PathVariable Long id, @RequestBody Review review) {
        ReviewDto updatedObject = this.service.updateById(id, review);
        return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ReviewDto> deleteById(@PathVariable Long id){
        if (this.service.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<ReviewDto> readById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.readById(id));
    }

//    @GetMapping("/read/byBook/{bookTitle}")
//    public ResponseEntity<List<ReviewDto>> readByBookTitle(@PathVariable String bookTitle){
//        return ResponseEntity.ok(this.service.readByBookTitle(bookTitle));
//    }



}
