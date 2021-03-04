package uk.co.dylanr.bookreview.persistence.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NonNull
    private String body;

    @Column
    @NonNull
    private String bookTitle;

    @Column
    @NonNull
    private String authorName;

//    @Override
//    public boolean equals(Object o){
//        if (o == null){
//            return false;
//        }
//        if(o.getClass() != this.getClass()){
//            return false;
//        }
//        Review review = (Review) o;
//        return this.body.equals(review.body) || this.bookTitle.equals(review.bookTitle) || this.authorName.equals(review.authorName);
//
//    }

}
