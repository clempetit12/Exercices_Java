package entity;

import org.example.entity.HangedMan;
import org.example.entity.RandomWords;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HangedManTest {

    private HangedMan hangedMan;
    @Mock
    private RandomWords randomWords;

    @BeforeEach
    void setup() {
        hangedMan = new HangedMan(randomWords);
        Mockito.when(randomWords.getWord()).thenReturn("bougie");
    }
    @Test
    void testGetRandowWord() {
        Assertions.assertEquals("bougie",hangedMan.play());
    }

    @Test
    void testGetCharInWord() {
        Assertions.assertTrue(hangedMan.charInWord('i'));
    }

    @Test
    void testHasWon() {
        hangedMan.setCurrentWord("bougie");
        Assertions.assertTrue(hangedMan.hasWon());
    }

}
