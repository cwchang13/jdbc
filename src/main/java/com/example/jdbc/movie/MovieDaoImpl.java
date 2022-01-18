package com.example.jdbc.movie;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author David
 */
@Repository
public class MovieDaoImpl implements MovieDao {

    private final JdbcTemplate jdbcTemplate;

    public MovieDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public List<Movie> selectMovies() {
        var sql = "SELECT TOP 100 id, name, release_date From movie";

        return jdbcTemplate.query(sql, new MovieRowMapper());
    }

    @Override
    public int insertMovie(Movie movie) {
        var sql = "INSERT INTO Movie(name, release_date) VALUES(?,?);";
        return jdbcTemplate.update(sql, movie.getName(), movie.getReleaseDate());
    }

    @Override
    public int deleteMovie(int id) {
        var sql ="DELETE FROM movie WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }

    @Override
    public Optional<Movie> selectMovieById(int id) {
        var sql = "SELECT id, name, release_date FROM movie WHERE id = ?";
        return jdbcTemplate.query(sql, new MovieRowMapper(), id).stream().findFirst();
    }

    @Override
    public int updateMovie(Movie movie) {
        var sql = "update Movie set name = ?, release_date = ? where id = ?";
        return jdbcTemplate.update(sql, movie.getName(), movie.getReleaseDate(), movie.getId());
    }
}
