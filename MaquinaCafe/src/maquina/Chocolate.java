package maquina;

public class Chocolate extends Bebida{
	private final double chocolateP = 24;
	private final double chocolateM = 48;
	private final double chocolateG = 72;
	private final double leiteP = 16;
	private final double leiteM = 32;
	private final double leiteG = 48;
	
	public Chocolate(double preco, char tamanho){
		super(preco,tamanho);
	}

	@Override
	public boolean checaIngredientes(){
		if(getTamanho() == 'P'){
			if(chocolateP <= Estoque.getChocolate() && leiteP <= Estoque.getLeite()) return true;
		}
		else if(getTamanho() == 'M'){
			if(chocolateM <= Estoque.getChocolate() && leiteM <= Estoque.getLeite()) return true;
		}
		else if(chocolateG <= Estoque.getChocolate() && leiteG <= Estoque.getLeite()) return true;
		setStatus("Interrompido. Motivo: Falta de ingredientes");
		return false;
	}
	
	@Override
	public void fazBebida(){
		if(getTamanho() == 'P'){
			Estoque.consomeChocolate(chocolateP);
			Estoque.consomeLeite(leiteP);
		}
		else if(getTamanho() == 'M'){
			Estoque.consomeChocolate(chocolateM);
			Estoque.consomeLeite(leiteM);
		}
		else {
			Estoque.consomeChocolate(chocolateG);
			Estoque.consomeLeite(leiteG);
		}
	}

}
