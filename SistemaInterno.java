import java.util.ArrayList;
public class SistemaInterno implements IGerencia{
	private static ArrayList<Funcionario> funcionario = new ArrayList<Funcionario>();
	private static Funcionario logado = null;
	
	public SistemaInterno(){}

	public static boolean logar(String user, String pass){
		int i=0;
		for(int i=0; i<funcionario.size() && !funcionario.get(i).getUsername().equals(user); i++);
		if(i < funcionario.size()){
			if(funcionario.get(i).logar(pass)){
				logado = funcionario.get(i);
				return true;
			}
			else return false;
		}
		return false;
	} //no main, ao receber false imprimir "login e/ou senha invalido(s)".

	public static void deslogar(){
		if(logado != null) logado = null;
	}
	
