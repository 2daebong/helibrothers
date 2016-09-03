package com.helibrothers.dico.exception;

/**
 * Created by LeeDaebeom-Mac on 2016. 8. 31..
 */
public class NotEnoughStockException extends RuntimeException {
    public NotEnoughStockException(String s) {
        super(s);
    }
}
