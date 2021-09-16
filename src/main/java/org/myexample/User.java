package org.myexample;

import javax.persistence.*;
import java.util.Set;
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //autoincrement
    private Long id;
    private String username;
    private String password;

    @Column(unique = true)
    private String login;

    @OneToMany(mappedBy =  "user")
    private Set<Movies> movies;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public User(){

    }

    public User(String username, String password, String login) {
        this.username = username;
        this.password = password;
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", login='" + login + '\'' +
                '}';
    }

    public Set<Movies> getMovies() {
        return movies;
    }

    public void setMovies(Set<Movies> movies) {
        this.movies = movies;
    }
}
