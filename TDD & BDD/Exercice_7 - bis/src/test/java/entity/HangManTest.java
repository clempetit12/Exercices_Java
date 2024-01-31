package entity;

import org.example.entity.Hangman;
import org.example.entity.WordGenerator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class HangManTest {

    @Mock
    private WordGenerator randomWords;
    private Hangman hangman;

    @BeforeEach
    void setUp() {
        Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        hangman = new Hangman(randomWords);
        hangman.makeMask();
    }

    @Test
    void testConvertWordToMask() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        //hangman.makeMask();
        Assertions.assertEquals("______", hangman.getMask());
    }
    @Test
    void testTryCharWithCorrectChar() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        boolean result = hangman.tryChar('g');
        Assertions.assertTrue(result);
    }
    @Test
    void testTryCharWithWrongChar() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        boolean result = hangman.tryChar('t');
        Assertions.assertFalse(result);
    }

    @Test
    void testTryCharWithCorrectCharShouldNotUpdateTryValue() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        int tryNumber = hangman.getTryNumber();
        hangman.tryChar('g');
        Assertions.assertEquals(tryNumber, hangman.getTryNumber());
    }

    @Test
    void testTryCharWithWrongCharShouldNotDecreaseTryValue() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        int tryNumber = hangman.getTryNumber();
        hangman.tryChar('a');
        Assertions.assertEquals(tryNumber-1, hangman.getTryNumber());
    }

    @Test
    void testTryCharWithCorrectCharShouldUpdateMask() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        hangman.tryChar('g');
        Assertions.assertEquals("g__g__", hangman.getMask());
    }

    @Test
    void testTryCharWithWrongCharShouldNotUpdateMask() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        hangman.tryChar('g');
        hangman.tryChar('a');
        Assertions.assertEquals("g__g__", hangman.getMask());
    }

    @Test
    void testHasLooseBecauseTryNumberUnder0() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        hangman.setTryNumber(-1);
        Assertions.assertFalse(hangman.hasWon());
    }

    @Test
    void testHasWonBecauseMaskEqualsToWinnerWord() {
        //Mockito.when(randomWords.getRandomWord()).thenReturn("google");
        hangman.setMask("google");
        Assertions.assertTrue(hangman.hasWon());
    }
}
