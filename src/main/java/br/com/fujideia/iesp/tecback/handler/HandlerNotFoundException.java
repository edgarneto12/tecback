package br.com.fujideia.iesp.tecback.handler;

public class HandlerNotFoundException extends RuntimeException {
    public HandlerNotFoundException(String menssagem) {
        super(menssagem);
    }
}
