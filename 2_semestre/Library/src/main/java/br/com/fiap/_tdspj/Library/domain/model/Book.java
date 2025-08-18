package br.com.fiap._tdspj.Library.domain.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "BOOK")
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private @Getter
    @Setter String id;

    @Column(length = 100)
    private @Getter
    @Setter String titulo;

    @Column(length = 20)
    private @Getter
    @Setter String isbn;

    @Temporal(TemporalType.DATE)
    @Column(name = "PUBLISH_DATE")
    private LocalDate publishDate;

    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private @Getter
    @Setter Author author;

    @ManyToOne(optional = false)
    private @Getter
    @Setter Category category;

    @Column(length = 1500)
    private @Getter @Setter String summary;

    @Column(length = 1000)
    private String cover;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", publishDate=" + publishDate +
                ", author=" + author +
                ", category=" + category +
                ", summary='" + summary + '\'' +
                ", cover='" + cover + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
