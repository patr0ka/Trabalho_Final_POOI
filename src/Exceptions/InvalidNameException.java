package Exceptions;

public class InvalidNameException extends Exception implements ExceptionsGame{
    public InvalidNameException(String mensagem) {
        super(mensagem);
    }
}