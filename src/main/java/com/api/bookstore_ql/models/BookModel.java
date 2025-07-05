package com.api.bookstore_ql.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "TB_BOOK")
public class BookModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String publisher;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "author_id")
    private AuthorModel author;
}
