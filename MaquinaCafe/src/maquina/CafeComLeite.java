package maquina;

public class CafeComLeite extends Cafe{
	private final double leiteP = 16;
	private final double leiteM = 32;
	private final double leiteG = 48;
	private double proporcaoLeite;
	
	public CafeComLeite(double preco, char tamanho, double proporcaoLeite){
		super(preco,tamanho);
		this.proporcaoLeite = proporcaoLeite;
	}

	@Override
	public void fazBebida(){
		if(getTamanho() == 'P'){
			Estoque.consomeCafe(getCafeP()*(1-proporcaoLeite));
			Estoque.consomeLeite(leiteP*proporcaoLeite);
		}
		else if(getTamanho() == 'M'){
			Estoque.consomeCafe(getCafeM()*(1-proporcaoLeite));
			Estoque.consomeLeite(leiteM*proporcaoLeite);
		}
		else {
			Estoque.consomeCafe(getCafeG()*(1-proporcaoLeite));
			Estoque.consomeLeite(leiteG*proporcaoLeite);
		}
	}

	@Override
	public boolean checaIngredientes(){
		if(getTamanho() == 'P'){
			if(getCafeP()*(1-proporcaoLeite) <= Estoque.getCafe() && leiteP*proporcaoLeite <= Estoque.getLeite()){
				return true;
			}
		}
		else if(getTamanho() == 'M'){
			if(getCafeM()*(1-proporcaoLeite) <= Estoque.getCafe() && leiteM*proporcaoLeite <= Estoque.getLeite()){
				return true;
			}
		}
		else if(getCafeG()*(1-proporcaoLeite) <= Estoque.getCafe() && leiteM*proporcaoLeite <= Estoque.getLeite()){
			return true;
		}
		setStatus("Interrompido. Motivo: Falta de ingredientes");
		return false;
	}

	public double getLeiteP(){
		return leiteP;
	}

	public double getLeiteM(){
		return leiteM;
	}

	public double getLeiteG(){
		return leiteG;
	}

	public double getProporcaoLeite(){
		return proporcaoLeite;
	}
}
	
