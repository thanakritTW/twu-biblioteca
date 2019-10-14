package com.twu.biblioteca.menu;

import com.twu.biblioteca.User;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class LogInMenuTest {
    private List<User> users;
    private PrintStream printStream;
    private BufferedReader bufferedReader;
    private LogInMenu menu;

    @Before
    public void setUp() throws Exception {
        printStream = mock(PrintStream.class);
        bufferedReader = mock(BufferedReader.class);
        users = new ArrayList<>();
        User user = new User("142-7777", "Gwan",
                "gwangwan@thoughtworks.com","0800000000");
        User user2 = new User("144-2777", "Gwan2",
                "gwangwan@thoughtworks.com","0800000000");
        user.setPassword("hashedpassword");
        users.add(user);
        users.add(user2);

        menu = new LogInMenu(users, printStream, bufferedReader);
    }

    @Test
    public void Show_WhenSuccessfullyAuthenticated_ShowYouHaveLoggedIn() throws IOException {
        when(bufferedReader.readLine()).thenReturn("142-7777").thenReturn("hashedpassword");

        menu.show();

        verify(this.printStream).println("Successfully logged in");
    }

    @Test
    public void Show_WhenTypeWrongUsernameOrPassword_ShowFailure() throws IOException {
        when(bufferedReader.readLine()).thenReturn("142-7777").thenReturn("wrongpassword");

        menu.show();

        verify(this.printStream).println("username or password incorrect");
    }
}
