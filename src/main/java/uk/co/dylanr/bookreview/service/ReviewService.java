package uk.co.dylanr.bookreview.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.dylanr.bookreview.persistence.domain.Book;
import uk.co.dylanr.bookreview.persistence.domain.Review;
import uk.co.dylanr.bookreview.persistence.repo.ReviewRepo;
import uk.co.dylanr.bookreview.exceptions.ReviewNotFoundException;
import uk.co.dylanr.bookreview.rest.dto.BookDto;
import uk.co.dylanr.bookreview.rest.dto.ReviewDto;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReviewService {

    private ReviewRepo repo;
    private ModelMapper mapper;

    @Autowired
    public ReviewService(ReviewRepo repo) {
        this.repo = repo;
    }

    public ReviewDto create(Review review) {
        Book book = review.getBook();
//
//        try {
//            .create(book);
//        } catch (NullPointerException npe){
//            npe.printStackTrace();
//            return null;
//        }

        Review returnReview = this.repo.save(review);
        return this.mapper.map(returnReview, ReviewDto.class);
    }

    public ReviewDto readById(Long id) {
        Review review =this.repo.findById(id).orElseThrow(ReviewNotFoundException::new);

        return this.mapper.map(review, ReviewDto.class);
    }

    public List<ReviewDto> readAll() {
        List<Review> review = this.repo.findAll();

        return review
                .stream()
                .map(x -> this.mapper.map(Review.class, ReviewDto.class))
                .collect(Collectors.toList());
    }

    public ReviewDto updateById(Long id, Review newReview) {
        Review oldReview = this.repo.findById(id).orElseThrow(ReviewNotFoundException::new);

        oldReview.setBody(newReview.getBody());
        oldReview.setBook(newReview.getBook());

        Review returnReview = this.repo.save(oldReview);

        return this.mapper.map(returnReview, ReviewDto.class);
    }

    public boolean deleteById(Long id) {
        this.repo.deleteById(id);
        return  !this.repo.existsById(id);
    }


//    public List<ReviewDto> readByBookTitle(String bookTitle) throws ReviewNotFoundException{
//        try {
//            return this.repo.findAllByBookTitle(bookTitle);
//        } catch (ReviewNotFoundException cnfe){
//            cnfe.printStackTrace();
//            return null;
//        }
//    }

}
