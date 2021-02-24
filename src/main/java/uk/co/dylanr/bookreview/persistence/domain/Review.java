package uk.co.dylanr.bookreview.persistence.domain;

import com.sun.istack.NotNull;
import com.sun.xml.bind.v2.TODO;
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

    @NonNull
    @ManyToOne
    private Book book;


    public Review(String body, Book book){
        this.body = body;
        this.book = book;
    }

}
