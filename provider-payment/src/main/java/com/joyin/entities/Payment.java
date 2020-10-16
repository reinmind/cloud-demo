package com.joyin.entities;



import java.io.Serializable;

/**
 * @author zx
 */

public class Payment implements Serializable {
    public Payment(Long id, String serial) {
        this.id = id;
        this.serial = serial;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    public Payment() {
    }

    private Long id;
    private String serial;
}
