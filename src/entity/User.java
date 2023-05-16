package entity;

public class User {
    private int idUser;
    private String login;
    private String password;
    private boolean isLibrarian;

    public User() {
    }

    public User(String login, String password, boolean isLibrarian) {
        this.login = login;
        this.password = password;
        this.isLibrarian = isLibrarian;

    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLibrarian() {
        return isLibrarian;
    }

    public void setLibrarian(boolean isLibrarian) {
        this.isLibrarian = isLibrarian;
    }

    @Override
    public String toString() {
        return "User [idUser=" + idUser + ", login=" + login + ", password=" + password + ", isLibrarian=" + isLibrarian
                + "]";
    }

}
