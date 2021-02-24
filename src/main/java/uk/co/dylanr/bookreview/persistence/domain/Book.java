package uk.co.dylanr.bookreview.persistence.domain;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique=true)
    @NonNull
    private String title;

    @Column
    @NonNull
    private String author;

    @Column
    private String genre;
//, fetch = FetchType.EAGER
    @OneToMany(mappedBy = "book", fetch = FetchType.EAGER)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @NonNull
    private List<Review> review = new ArrayList<>();

    public Book (String author, String genre){
        this.author = author;
        this.genre = genre;
    }

//    public void addReview(Review review) {
//        if (review == null) {
//            return;
//        } else {
//            if (reviews == null) {
//                reviews = new ArrayList<Review>();
//            }
//            reviews.add(review);
//        }
//    }


}
