package br.com.fiap._tdspj.Library.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Table(name = "AUTHOR")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter
    @Setter String id;

    @Column(length = 100)
    private @Getter
    @Setter String name;

    @Column(length = 100)
    private @Getter
    @Setter String email;

    @OneToMany(fetch = FetchType.EAGER)
    private @Getter
    @Setter List<Book> bookList;


}
