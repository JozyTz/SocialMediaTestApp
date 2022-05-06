package com.example.combined;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

public class validationTest
{
    @Test
    public void profileName()
    {
        assertEquals(LoginActivity.getUsername(), ProfileActivity.getUsername());
    }

    @Test
    public void logout()
    {
        assertEquals(LoginActivity.getUsername(), ProfileActivity.getUsername());
    }

    @Test
    public void followerCount()
    {
        assertEquals(LoginActivity.getUsername(), ProfileActivity.getUsername());
    }

    @Test
    public void settingsPage()
    {
        assertEquals(LoginActivity.getUsername(), ProfileActivity.getUsername());
    }
}
