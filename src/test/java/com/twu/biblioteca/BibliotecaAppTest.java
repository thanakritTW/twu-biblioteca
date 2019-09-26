package com.twu.biblioteca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import org.junit.Test;
import org.junit.Before;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.mock;

public class BibliotecaAppTest {
    private BibliotecaApp app;

    private PrintStream printStream;
    private BufferedReader bufferedReader;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
    }

    @Test
    public void WhenStartTheAppItShouldSayHello() {

        app.start();

        verify(this.printStream).println("Welcome to Biblioteca. Your one-stop-shop for great books in Bangalore!");
    }
}
