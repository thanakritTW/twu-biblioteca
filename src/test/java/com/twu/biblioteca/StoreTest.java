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


public class StoreTest {
    private Store store;
    private Library library;
    private List<Book> books;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        library = mock(Library.class);
        store = new Store(library, printStream, bufferedReader);

    }

    @Test
    public void ShouldSayWelcome(){
        store.welcome();

        verify(this.printStream).println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }

    @Test
    public void GetNotifiedWhenSubmittingWrongOption() {

        store.checkAction("wrong action");

        verify(this.printStream).println("Please select a valid option!");

    }

    @Test
    public void QuitTheProgramAfterSubmittingQuit() {

        store.checkAction("quit");

        verify(this.printStream).println("Bye Bye");
    }

    @Test
    public void EachBookShouldHaveAuthorAndYearPublished() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);

        when(library.getBooks()).thenReturn(books);

        store.listBooks();

        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        verify(this.printStream).println(expected);
    }

    @Test
    public void CheckedOutBookShouldNotBeOnTheList() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        Book book2 = new Book("Second Book", "Second Author", 1990);
        books.add(book2);


        book2.borrowBook();

        when(library.getBooks()).thenReturn(books);

        store.listBooks();

        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        verify(this.printStream).println(expected);
    }

    @Test
    public void ShowMenuAndNavigateToListOfBooksAfterSelect1() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        when(library.getBooks()).thenReturn(books);

        store.checkAction("1");
        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        verify(this.printStream).println(expected);
    }

    @Test
    public void ShouldTellUsefulMessageAfterSuccessfullyCheckingOutBook() throws IOException {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        Book book2 = new Book("Second Book", "Second Author", 1990);
        books.add(book2);

        when(library.checkOut("Second Book")).thenReturn(true);

        when(bufferedReader.readLine()).thenReturn("Second Book");

        store.checkOutMenu();

        verify(this.printStream).println("Thank you! Enjoy the book");
    }

    @Test
    public void ShouldTellUsefulMessageAfterUnSuccessfullyCheckingOutBook() throws IOException {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);

        when(bufferedReader.readLine()).thenReturn("Second Book");
        store.checkOutMenu();

        verify(this.printStream).println("Sorry, that book is not available");
    }

    @Test
    public void ShouldTellUsefulMessageAfterSuccessfullyReturnBook() throws IOException {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        Book book2 = new Book("Second Book", "Second Author", 1990);
        books.add(book2);
        // Checking out the book
        book2.borrowBook();
        when(library.returnBook("Second Book")).thenReturn(true);

        when(bufferedReader.readLine()).thenReturn("Second Book");
        store.returningMenu();

        verify(this.printStream).println("Thank you for returning the book");
    }

    @Test
    public void ShouldTellUsefulMessageAfterUnSuccessfullyReturnOutBook() throws IOException {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);

        when(bufferedReader.readLine()).thenReturn("Second Book");
        store.returningMenu();

        verify(this.printStream).println("Sorry that is not a valid book to return");
    }
}
