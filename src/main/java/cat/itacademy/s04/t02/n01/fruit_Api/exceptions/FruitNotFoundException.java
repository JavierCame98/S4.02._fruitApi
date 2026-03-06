package cat.itacademy.s04.t02.n01.fruit_Api.exceptions;

public class FruitNotFoundException extends RuntimeException {
    public FruitNotFoundException(String message) {
        super(message);
    }
}
