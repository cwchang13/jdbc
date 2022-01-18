package com.example.jdbc.movie;

import com.example.jdbc.exception.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author David
 */
@Service
public class MovieService {

    private final MovieDao movieDao;

    public MovieService(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    public List<Movie> getMovies() {
        return movieDao.selectMovies();
    }

    public void addNewMovie(Movie movie) {
        int result = movieDao.insertMovie(movie);
        if (result != 1) {
            throw new IllegalStateException("Something went wrong !!");
        }
    }

    public void deleteMovie(int id) {
        Optional<Movie> movies = movieDao.selectMovieById(id);
        movies.ifPresentOrElse(movie -> {
            int result = movieDao.deleteMovie(id);
            if (result != 1) {
                throw new IllegalStateException("Could not delete movie !!");
            }
        }, () -> {
            throw new IllegalStateException(String.format("Movie with id %s not found !!", id));
                }
        );
    }

    public Movie getMovie(int id) {
        return movieDao.selectMovieById(id).orElseThrow(() -> new NotFoundException(String.format("Movie with id %s not found", id)));
    }

    public void updateMovie(Movie updateMovie) {
        Optional<Movie> movies = movieDao.selectMovieById(updateMovie.getId());
        movies.ifPresentOrElse(movie -> {
            int result = movieDao.updateMovie(updateMovie);
            if (result != 1) {
                throw new IllegalStateException("Could not update movie !!");
            }
        }, () -> {
            throw  new IllegalStateException(String.format("Movie with id %s not found !!", updateMovie.getId()));
                }
        );
    }
}
