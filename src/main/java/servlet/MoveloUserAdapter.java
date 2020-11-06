package servlet;

public class MoveloUserAdapter extends Usuario {
    private MoveloUser movelo;

    public MoveloUserAdapter( String login, String password){
        movelo = new MoveloUser(login,password);
    }

    public String getLogin() {
        return movelo.getEmail();
    }

    public void setLogin(String login) {
        movelo.setEmail(login);
    }

    public String getPassword() {
        return movelo.getClave();
    }

    public void setPassword(String password) {
        movelo.setClave(password);
    }    
}
