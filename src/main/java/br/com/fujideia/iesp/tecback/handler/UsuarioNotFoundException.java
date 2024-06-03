package br.com.fujideia.iesp.tecback.handler;

public class UsuarioNotFoundException extends RuntimeException {
    public UsuarioNotFoundException(Integer userId) {
        super("Nenhum usuario com id:" + userId + "não encontrado");
    }

}
