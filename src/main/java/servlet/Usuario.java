package servlet;

public abstract class Usuario {
	protected String login;
	protected String password;
	abstract public String getLogin(); 
	abstract public void setLogin(String login);
	abstract public String getPassword(); 
	abstract public void setPassword(String password);
}
