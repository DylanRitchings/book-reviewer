package uk.co.dylanr.bookreview.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uk.co.dylanr.bookreview.persistence.domain.Book;
import uk.co.dylanr.bookreview.rest.dto.BookDto;
import uk.co.dylanr.bookreview.service.BookService;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    private final BookService service;

    @Autowired
    public BookController(BookService service){
        super();
        this.service = service;
    }

    @PostMapping("/create")
    public ResponseEntity<BookDto> create(@RequestBody Book book){
        BookDto createdObject = this.service.create(book);
        return new ResponseEntity<>(createdObject, HttpStatus.CREATED);
    }

    @GetMapping("/readAll")
    public ResponseEntity<List<BookDto>> readAll() {
        return ResponseEntity.ok(this.service.readAll());
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<BookDto> updateById(@PathVariable Long id, @RequestBody Book book) {
        BookDto updatedObject = this.service.updateById(id, book);
        return new ResponseEntity<>(updatedObject, HttpStatus.ACCEPTED);
    }


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<BookDto> deleteById(@PathVariable Long id){
        if (this.service.deleteById(id)){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/read/{id}")
    public ResponseEntity<BookDto> readById(@PathVariable Long id){
        return ResponseEntity.ok(this.service.readById(id));
    }

//    @GetMapping("/read/byTitle/{bookTitle}")
//    public ResponseEntity<List<Book>> readByBookTitle(@PathVariable String bookTitle){
//        return ResponseEntity.ok(this.service.readByBookTitle(bookTitle));
//    }

}
