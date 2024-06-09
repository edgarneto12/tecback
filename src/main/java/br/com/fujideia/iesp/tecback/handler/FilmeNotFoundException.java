package br.com.fujideia.iesp.tecback.handler;

public class FilmeNotFoundException extends RuntimeException {
    public FilmeNotFoundException(Integer filmeId) {
        super("Filme " + filmeId + " not found");
    }
}
