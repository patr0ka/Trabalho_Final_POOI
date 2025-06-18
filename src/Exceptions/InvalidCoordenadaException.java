package Exceptions;

public class InvalidCoordenadaException extends Exception implements ExceptionsGame{
    public InvalidCoordenadaException(String mensagem) {
        super(mensagem);
    }
}
