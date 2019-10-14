package com.twu.biblioteca.menu;

import com.twu.biblioteca.Movie;
import com.twu.biblioteca.MovieShop;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;


public class ListMoviesMovieShopMenuTest {
    private List<Movie> movies;
    private ListMoviesMovieShopMenu menu;

    private MovieShop movieShop;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        movieShop = mock(MovieShop.class);
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);

        movies = new ArrayList<>();
        Movie movie1 = new Movie("Joker","Todd Phillips", 2019,9);
        Movie movie2 = new Movie("One Piece: Stampede","Takashi Otsuka", 2019,10);
        movies.add(movie1);
        movies.add(movie2);
        menu = new ListMoviesMovieShopMenu(movieShop, printStream, bufferedReader);
    }

    @Test
    public void Show_WhenThereAreMovies_ShouldShowDetails() {
        when(movieShop.getMovies()).thenReturn(movies);
        String expected = "Name | Director | Year | Rating\n";
        expected += "Joker | Todd Phillips | 2019 | 9\n";
        expected += "One Piece: Stampede | Takashi Otsuka | 2019 | 10\n";

        menu.show();

        verify(this.printStream).println(expected);
    }
}
