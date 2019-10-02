package com.twu.biblioteca.menu;

import com.twu.biblioteca.Book;
import com.twu.biblioteca.Library;
import com.twu.biblioteca.Store;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class ListBooksMenuTest {
    private ListBooksMenu menu;
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
        menu = new ListBooksMenu(library, printStream, bufferedReader);
    }

    @Test
    public void Show_WhenThereIsABook_ShouldShowDetails() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        when(library.getBooks()).thenReturn(books);
        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        menu.show();

        verify(this.printStream).println(expected);
    }

    @Test
    public void Show_WhenBookIsCheckedOut_ShouldNotShowTheBook() {
        Book book = new Book("First Book", "First Author", 1997);
        books.add(book);
        Book book2 = new Book("Second Book", "Second Author", 1990);
        books.add(book2);
        when(library.getBooks()).thenReturn(books);
        String expected = "Name | Author | Published Year\n";
        expected += "First Book | First Author | 1997\n";

        book2.setAvailable(false);
        menu.show();

        verify(this.printStream).println(expected);
    }
}
