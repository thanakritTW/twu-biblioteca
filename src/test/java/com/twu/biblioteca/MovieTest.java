package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class MovieTest {
    @Test
    public void Movie_ShouldReturnInformation_WhenCreatingObject(){
        Movie movie = new Movie("BookName1", "AuthorName1", 1997, 10);

        assertThat("BookName1", is(movie.getName()));
        assertThat("AuthorName1", is(movie.getDirector()));
        assertThat(1997, is(movie.getYear()));
    }

    @Test
    public void isAvailable_ShouldReturnTrue_RightAfterIniting(){
        Movie movie = new Movie("BookName1", "AuthorName1", 1997, 10);

        boolean expected = movie.isAvailable();

        assertThat(expected, is(true));
    }

}
