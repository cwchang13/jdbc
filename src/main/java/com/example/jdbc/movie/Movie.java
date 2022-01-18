package com.example.jdbc.movie;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;

/**
 * @author David
 */
@Component
public class Movie {

    private Integer id;
    private String name;
    private LocalDate releaseDate;

    public Movie() {
    }

    public Movie(Integer id, String name, LocalDate releaseDate) {
        this.id = id;
        this.name = name;
        this.releaseDate = releaseDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", releaseDate=" + releaseDate +
                '}';
    }
}
