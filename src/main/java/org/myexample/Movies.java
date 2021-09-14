package org.myexample;

import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;
@Entity
@Table(name = "MOVIE_TABLE")
public class Movies {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    @Column(name = "PUBLICATION_YEAR")
    private int publicationYear;
    private long time;

    @OneToOne(mappedBy = "movies")
    private Author author;

    @ManyToOne
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Movies(){
    }
    public Movies(String title, int publicationYear, long time) {
        this.title = title;
        this.publicationYear = publicationYear;
        this.time = time;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public int getPublicationYear() {
        return publicationYear;
    }
    public void setPublicationYear(int publicationYear) {
        this.publicationYear = publicationYear;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public Movies(Long id, String title, int publicationYear, long time) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
        this.time = time;
    }
    public Author getAuthor() {
        return author;
    }
    public void setAuthor(Author author) {
        this.author = author;
    }
    public void setId(Long id) {
        this.id = id;
    }


    @Override
    public String toString() {
        return "Movies{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", publicationYear=" + publicationYear +
                ", time=" + time +
                '}';
    }

}
