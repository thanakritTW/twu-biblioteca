package com.twu.biblioteca.menu;

import com.twu.biblioteca.Library;

public class CheckOutMenu implements Menu{
    private Library library;
    private String description;

    public CheckOutMenu(Library library, String description) {
        this.library = library;
        this.description = description;
    }

    @Override
    public String show(){
        return null;
    }

    @Override
    public String getDescription() {
        return description;
    }
}
