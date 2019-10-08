package com.twu.biblioteca;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieShopTest {
    private MovieShop movieShop;
    private List<Movie> movies;

    @Before
    public void setUp() throws Exception {
        movies = new ArrayList<>();
        movieShop = new MovieShop(movies);
        Movie movie = new Movie("BookName1", "AuthorName1", 1997, 10);
        movies.add(movie);
    }


    @Test
    public void CheckOut_ShouldReturnTrue_IfItHasTheBook(){
        boolean output = movieShop.checkOut("BookName1");

        assertThat(output,is(true));
    }

    @Test
    public void CheckOut_ShouldReturnFalse_IfItDoesNotHaveTheBook(){
        boolean output = movieShop.checkOut("BookName2");

        assertThat(output,is(true));
    }

}
