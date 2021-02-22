package uk.co.dylanr.bookreview.persistence.domain;

import com.sun.istack.NotNull;

import javax.persistence.*;

@Entity
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String first_name;

    @Column
    @NotNull
    private String last_name;

    @Column
    private String middle_names;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getMiddle_names() {
        return middle_names;
    }

    public void setMiddle_names(String middle_names) {
        this.middle_names = middle_names;
    }
}
