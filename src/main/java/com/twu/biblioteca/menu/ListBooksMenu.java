package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

public class ListBooksMenu implements Menu {
    private Library library;
    private String description;

    public ListBooksMenu(Library library, String description) {
        this.library = library;
        this.description = description;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public String show() {
        return null;
    }
}
