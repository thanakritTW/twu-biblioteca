package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

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

        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        verify(this.printStream).println(expected);
    }

    @Test
    public void ShowMenuAndNavigateToListOfBooksAfterSelect1() throws IOException{
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        when(bufferedReader.readLine()).thenReturn("1");

        library.showMenu();
        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        verify(this.printStream).println(expected);
    }
}