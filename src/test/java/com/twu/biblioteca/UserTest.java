package com.twu.biblioteca;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class UserTest {

    @Test
    public void UserIsLoggedIn_ShouldReturnFalse_RightAfterIniting(){
        User user = new User("142-7777", "Gwan","gwangwan@thoughtworks.com","0800000000");

        boolean result = user.isLoggedIn();

        assertThat(result,is(false));
    }
}
