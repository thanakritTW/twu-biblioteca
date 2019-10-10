package com.twu.biblioteca.menu;

import com.twu.biblioteca.MovieShop;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class CheckOutMovieShopMenuTest {
    private CheckOutMovieShopMenu menu;
    private MovieShop movieShop;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        movieShop = mock(MovieShop.class);
        menu = new CheckOutMovieShopMenu(movieShop, printStream, bufferedReader);
    }

    @Test
    public void Show_WhenSuccessfullyCheckOut_ShouldShowThankYou() throws IOException {
        when(movieShop.checkOut("Second Movie")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("Second Movie");

        menu.show();

        verify(this.printStream).println("Thank you! Enjoy the movie");
    }

    @Test
    public void Show_WhenUnSuccessfullyCheckOut_ShouldShowSorry() throws IOException {
        when(movieShop.checkOut("Second Movie")).thenReturn(false);
        when(bufferedReader.readLine()).thenReturn("Second Movie");

        menu.show();

        verify(this.printStream).println("Sorry, that movie is not available");
    }

}