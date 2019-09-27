package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.dataflow.qual.TerminatesExecution;
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
    public void ShowMenuAndNavigateToListOfBooksAfterSelect1() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);

        library.checkAction("1");
        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        verify(this.printStream).println(expected);
    }

    @Test
    public void GetNotifiedWhenSubmittingWrongOption() {

        library.checkAction("wrong action");

        verify(this.printStream).println("Please select a valid option!");

    }

    @Test
    public void QuitTheProgramAfterSubmittingQuit() {

        library.checkAction("quit");

        verify(this.printStream).println("Bye Bye");
    }

    @Test
    public void CheckedOutBookShouldNotBeOnTheList() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        Book book2 = new Book("Second Book", "Second Author", 1990);
        books.add(book2);

        library.checkOut(0);

        library.checkAction("1");
        String expected = "Name | Author | Published Year\n";
        expected += "Second Book | Second Author | 1990\n";

        verify(this.printStream).println(expected);
    }
}