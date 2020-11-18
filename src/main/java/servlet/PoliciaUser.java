package servlet;

// import java.util.ArrayList;

public class PoliciaUser extends Usuario{
    public PoliciaUser(String login,String password) {
        super.login = login;
        super.password = password;
    }

	public String getLogin() {
        return super.login;
    }
    public void setLogin(String login) {
        super.login = login;
    }

    public String getPassword() {
        return super.password;
    }
    public void setPassword(String password) {
        super.password = password;
    }
}
