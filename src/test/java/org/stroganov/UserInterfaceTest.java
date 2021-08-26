package org.stroganov;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.stroganov.exeptions.InputExpressionException;

import java.io.BufferedReader;
import java.io.IOException;

@RunWith(MockitoJUnitRunner.class)
public class UserInterfaceTest {

    @InjectMocks
    UserInterface userInterface;
    @Mock
    BufferedReader reader;
    // UserInterface userInterface = Mockito.mock(UserInterface.class);

    @Test(expected = Exception.class)
    public void getValidExpressionFromUser_Throw_InputExpressionException_Test() throws InputExpressionException, IOException {
        Mockito.when(reader.readLine()).thenReturn(null);
        userInterface.getStringFromUser(reader);
    }




}