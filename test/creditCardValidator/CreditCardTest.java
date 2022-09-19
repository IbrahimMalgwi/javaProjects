package creditCardValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CreditCardTest {
//    private CreditCard creditCard;
//    @BeforeEach
//    void setUp() {
//        creditCard = new CreditCard();
//    }

    @Test
    void creditCardIsValidTest(){
        boolean isValid = CreditCard.isValidLength("45673452678988");
        assertTrue(isValid);
    }

    @Test
    void trowExceptionForInvalidCardNumberLengthTest(){
        assertThrows(CreditCardLengthException.class, ()-> CreditCard.isValidLength("23456789"));
    }

    @Test
    void trowInvalidCreditCardNumberExceptionTest(){
        assertThrows(InvalidCreditCardNumberException.class, ()->CreditCard.isValidNumber("89096754531234674"));
    }

    @Test
    @DisplayName("Test for start with 4, 5, 6 and 37")
    void creditCardNumberIsAValidTest(){
        boolean isValidNumber = CreditCard.isValidNumber("4567456734524178");
        assertTrue(isValidNumber);

        boolean isValidNumber1 = CreditCard.isValidNumber("5645234567892536");
        assertTrue(isValidNumber1);

        boolean isValidNumber2 = CreditCard.isValidNumber("6645234567892536");
        assertTrue(isValidNumber2);

        boolean isValidNumber3 = CreditCard.isValidNumber("3745234567892536");
        assertTrue(isValidNumber3);
    }

    @Test
    @DisplayName("Double Every Second Digit From Right To Left to get a single digit," +
            "if result is double digit add the two digit to get a single digit")
    void sumOfDoubleEvenDigitTest(){
        String cardNumber = "4388576018402626";
        assertEquals(37, CreditCard.sumOfDoubleEvenDigit(cardNumber));
    }

    @Test
    void sumOfOddPlaceDigitTest(){
        String cardNumber = "4388576018402626";
        assertEquals(38, CreditCard.sumOfOddPlaceDigit(cardNumber));
    }

    @Test
    void add_SumOfOddPlace_And_EvenPlaceResultTest(){
        String cardNumber = "4388576018402626";
        assertEquals(75, CreditCard.add(cardNumber));
    }

    @Test
    void creditCardValidityTest(){
        String cardNumber = "4388576018410707";
        boolean isValidCreditCard = CreditCard.isValidCreditCard(cardNumber);
        assertTrue(isValidCreditCard);
    }




}