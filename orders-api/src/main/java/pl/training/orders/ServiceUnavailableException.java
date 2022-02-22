package pl.training.orders;

public class ServiceUnavailableException extends RuntimeException{

    public ServiceUnavailableException(Throwable cause) {
        super(cause);
    }

}
