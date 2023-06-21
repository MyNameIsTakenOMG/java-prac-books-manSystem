package org.example.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

//@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ControlPanelTest {

    @Mock
    private ManSystem bookSysMock;
    @Mock
    private Scanner userInputMock;

    private ControlPanel controlPanel;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
        controlPanel = new ControlPanel(bookSysMock,userInputMock);
    }

    @Test
    void getBooksByName() {
        when(userInputMock.nextLine()).thenReturn("great");
        controlPanel.getBooksByName();
        verify(bookSysMock).getBooksByName(ArgumentMatchers.eq("great"));
    }

    @Test
    void getBookById() {
        when(userInputMock.nextLine()).thenReturn("0");
        when(bookSysMock.getBooks()).thenReturn(new ArrayList<>());
        assertThrows(IndexOutOfBoundsException.class, controlPanel::getBookById);
    }

    @Test
    void addBook() {
        when(userInputMock.nextLine()).thenReturn("a","great","q");
        controlPanel.start();
        verify(bookSysMock).addBook(ArgumentMatchers.eq("great"));
        verify(bookSysMock).getCurrentBookId();
    }

    @Test
    void addUser() {
        when(userInputMock.nextLine()).thenReturn("u","John","q");
        controlPanel.start();
        verify(bookSysMock).createUser(ArgumentMatchers.eq("John"));
        verify(bookSysMock).addUser(ArgumentMatchers.any());
        verify(bookSysMock).getUser(ArgumentMatchers.anyInt());
    }

    @Test
    void borrowOrReturn() {

    }

    @Test
    void generateList() {
        when(userInputMock.nextLine()).thenReturn("1","y","2","n");
        var actual = controlPanel.generateList();
        Integer[] expected = {1,2};
        assertArrayEquals(expected, actual.toArray(new Integer[0]));
    }
}