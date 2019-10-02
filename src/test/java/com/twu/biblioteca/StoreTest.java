package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.twu.biblioteca.menu.MenuInterface;
import org.junit.Test;
import org.junit.Before;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class StoreTest {
    private Store store;
    private Map<String, MenuInterface> menus;
    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        menus = new HashMap<>();
        store = new Store(menus, printStream, bufferedReader);
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
}
