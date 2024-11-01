package br.com.fiap.fiapstore.exception;

public class DBException extends Exception {

//     Sobrescrever métodos do Exception para tratar os erros
//     Como eu não quero que a minha Classe tenha o comportamento da Classe mãe, sobrescrevemos os construtores


    public DBException() {
    }

    public DBException(String message) {
        super(message);
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }

    public DBException(Throwable cause) {
        super(cause);
    }

    public DBException(String message,
                       Throwable cause,
                       boolean enableSuppression,
                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
