package io.dsub.creational.abstractfactory.example;

// Abstract Factory
public abstract class CreditCardFactory {

    public static CreditCardFactory getCreditCardFactory(int creditScore) {
        if (creditScore > 650) {
            return new VisaFactory();
        } else {
            // imagine as it is another implementation
            return new VisaFactory();
        }
    }

    public abstract CreditCard getCreditCard(CardType cardType);
    public abstract Validator getValidator(CardType cardType);

}
