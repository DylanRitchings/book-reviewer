package uk.co.dylanr.bookreview.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uk.co.dylanr.bookreview.persistence.domain.Review;
import uk.co.dylanr.bookreview.persistence.repo.ReviewRepo;
import uk.co.dylanr.bookreview.exceptions.ReviewNotFoundException;


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

    public Review create(Review review) {
//
//        try {
//            .create(book);
//        } catch (NullPointerException npe){
//            npe.printStackTrace();
//            return null;
//        }

        Review returnReview = this.repo.save(review);
        return returnReview;
    }

    public Review readById(Long id) {
        Review review =this.repo.findById(id).orElseThrow(ReviewNotFoundException::new);

        return review;
    }

    public List<Review> readAll() {
        List<Review> review = this.repo.findAll();

        return review;
    }

    public Review updateById(Long id, Review newReview) {
        Review oldReview = this.repo.findById(id).orElseThrow(ReviewNotFoundException::new);

        oldReview.setBody(newReview.getBody());
        oldReview.setBookTitle(newReview.getBookTitle());
        oldReview.setAuthorName(newReview.getAuthorName());
        Review returnReview = this.repo.save(oldReview);

        return returnReview;
    }

    public boolean deleteById(Long id) {
        this.repo.deleteById(id);
        return  !this.repo.existsById(id);
    }


    public List<Review> readByBookTitle(String bookTitle) throws ReviewNotFoundException{
        try {
            return this.repo.findAllByBookTitle(bookTitle);
        } catch (ReviewNotFoundException cnfe){
            cnfe.printStackTrace();
            return null;
        }
    }

    public List<Review> readByAuthorName(String authorName) throws ReviewNotFoundException{
        try {
            return this.repo.findAllByAuthorName(authorName);
        } catch (ReviewNotFoundException cnfe){
            cnfe.printStackTrace();
            return null;
        }
    }



}