package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import javax.swing.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

public class LibraryTest {
    private Library library;
    private List<Book> books;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = new Library(books, printStream, bufferedReader);
    }

    @Test
    public void ShouldSayWelcome(){
        library.welcome();

        verify(this.printStream).println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }

    @Test
    public void EachBookShouldHaveAuthorAndYearPublished() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);

        library.listBooks();

        verify(this.printStream).println("First Book | First Author | 1997\n");
    }
}