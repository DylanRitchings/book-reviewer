package uk.co.dylanr.bookreview.service;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uk.co.dylanr.bookreview.exceptions.ReviewNotFoundException;
import uk.co.dylanr.bookreview.persistence.domain.Book;
import uk.co.dylanr.bookreview.persistence.repo.BookRepo;
import uk.co.dylanr.bookreview.exceptions.BookNotFoundException;
import uk.co.dylanr.bookreview.rest.dto.BookDto;
import uk.co.dylanr.bookreview.rest.dto.ReviewDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {


    private BookRepo repo;
    private ModelMapper mapper;

    @Autowired
    public BookService(BookRepo repo, ModelMapper mapper) {
        super();
        this.repo = repo;
        this.mapper = mapper;
    }

    public BookDto create(Book book) {
        Book returnBook = this.repo.save(book);
        return this.mapper.map(returnBook, BookDto.class);
    }

    public BookDto readById(Long id) {
        Book book = this.repo.findById(id).orElseThrow(BookNotFoundException::new);
        return this.mapper.map(book, BookDto.class);
    }

    public List<BookDto> readAll() {
        List<Book> books = this.repo.findAll();

        return books
                .stream()
                .map(x -> this.mapper.map(Book.class, BookDto.class))
                .collect(Collectors.toList());
    }

    public BookDto updateById(Long id, Book newBook) {
        Book oldBook = this.repo.findById(id).orElseThrow(BookNotFoundException::new);

        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setTitle(newBook.getTitle());
        oldBook.setAuthor(newBook.getAuthor());
        oldBook.setGenre(newBook.getGenre());

        Book returnBook = this.repo.save(oldBook);

        return this.mapper.map(returnBook, BookDto.class);
    }


    public boolean deleteById(Long id) {
        this.repo.deleteById(id);

        return  !this.repo.existsById(id);
    }

    //TODO on frontend check if book with title already exists
//    public List<BookDto> readByTitle(String bookTitle) throws ReviewNotFoundException {
//        try {
//             this.repo.findAllByBookTitle(bookTitle);
//            return
//        } catch (ReviewNotFoundException cnfe){
//            cnfe.printStackTrace();
//            return null;
//        }
//
//    }

}
