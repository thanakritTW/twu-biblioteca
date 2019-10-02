package com.twu.biblioteca.menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Store;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class CheckOutMenuTest {
    private CheckOutMenu menu;
    private Library library;
    private List<Book> books;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        menu = new CheckOutMenu(library, printStream, bufferedReader);
    }

    @Test
    public void Show_WhenSuccessfullyCheckOut_ShouldShowThankYou() throws IOException {
        when(library.checkOut("Second Book")).thenReturn(true);
        when(bufferedReader.readLine()).thenReturn("Second Book");

        menu.show();

        verify(this.printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void Show_WhenUnSuccessfullyCheckOut_ShouldShowSorry() throws IOException {
        when(library.checkOut("Second Book")).thenReturn(false);
        when(bufferedReader.readLine()).thenReturn("Second Book");

        menu.show();

        verify(this.printStream).println("Sorry, that book is not available");
    }

}