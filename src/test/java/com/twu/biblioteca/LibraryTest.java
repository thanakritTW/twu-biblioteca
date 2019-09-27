package com.twu.biblioteca;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.Before;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.*;


public class LibraryTest {
    private Library library;
    private List<Book> books;

    @Before
    public void setUp() throws Exception {
        books = new ArrayList<>();
        library = new Library(books);
    }

    @Test
    public void CheckedOutBookShouldNotBeOnTheList() {
        Book firstBook = new Book("First Book", "First Author", 1997);
        books.add(firstBook);
        Book secondBook = new Book("Second Book", "Second Author", 1990);
        books.add(secondBook);

        library.checkOut("First Book");

        assertThat(books, not(hasItems(firstBook)));
    }

    @Test
    public void ReturningNotExistBookShouldReturnFalse() {
        Book firstBook = new Book("First Book", "First Author", 1997);
        books.add(firstBook);
        Book secondBook = new Book("Second Book", "Second Author", 1990);
        books.add(secondBook);

        assertThat(library.returnBook("First Book"), is(false));
    }

    @Test
    public void ReturningBookShouldReturnMarkedAsAvailbleAndReturnTrue() {
        Book firstBook = new Book("First Book", "First Author", 1997);
        books.add(firstBook);
        Book secondBook = new Book("Second Book", "Second Author", 1990);
        books.add(secondBook);

        library.checkOut("First Book");
        assertThat(library.returnBook("First Book"), is(true));
    }

}