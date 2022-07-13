package co.com.sofka;


public class Email {

    private String email;
    private boolean emailSent;

    public Email(String email, boolean state) {
        this.email = email;
        this.emailSent = state;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isSent() {
        return emailSent;
    }

    public void setEstado(boolean state) {
        this.emailSent = state;
    }

}
