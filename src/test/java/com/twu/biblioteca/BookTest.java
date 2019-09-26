package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class BookTest {
    @Test
    public void ShouldReturnNameWhenGetName(){
        Book book = new Book("BookName1", "AuthorName1", 1997);

        assertThat("BookName1", is(book.getName()));
        assertThat("AuthorName1", is(book.getAuthor()));
        assertThat(1997, is(book.getPublishedYear()));
    }
}
