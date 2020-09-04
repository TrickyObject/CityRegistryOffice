package mts.city.register.view;

import java.io.Serializable;

public class PersonResponse implements Serializable {

    private boolean registered;
    private boolean temporal;
    private StringBuilder error;

    public PersonResponse() {
        this.registered = false;
        this.temporal = false;
        this.error = new StringBuilder("");
    }

    @Override
    public String toString() {
        return "PersonResponse{" +
                "registered=" + registered +
                ", temporal=" + temporal +
                ", error=" + error +
                '}';
    }

    public boolean isRegistered() {
        return registered;
    }

    public void setRegistered(boolean registered) {
        this.registered = registered;
    }

    public boolean isTemporal() {
        return temporal;
    }

    public void setTemporal(boolean temporal) {
        this.temporal = temporal;
    }

    public StringBuilder getError() {
        return error;
    }

    public void setError(StringBuilder error) {
        this.error = error;
    }
}
