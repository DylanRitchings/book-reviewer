package uk.co.dylanr.bookreview.persistence.domain;

import com.sun.istack.NotNull;
import com.sun.xml.bind.v2.TODO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.awt.print.Book;

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


    public Review(String body, String bookTitle){
        this.body = body;
        this.bookTitle = bookTitle;
    }
}
