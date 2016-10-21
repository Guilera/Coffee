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
	public boolean checaIngredientes(char tamanho){
		if(tamanho == 'P'){
			if(chocolateP <= Estoque.getChocolate() && leiteP <= Estoque.getLeite()) return true;
		}
		else if(tamanho == 'M'){
			if(chocolateM <= Estoque.getChocolate() && leiteM <= Estoque.getLeite()) return true;
		}
		else if(chocolateG <= Estoque.getChocolate() && leiteG <= Estoque.getLeite()) return true;
		setStatus("Interrompido. Motivo: Falta de ingredientes");
		return false;
	}
	
	@Override
	public void fazBebida(char tamanho){
		if(tamanho == 'P'){
			Estoque.consomeChocolate(chocolateP);
			Estoque.consomeLeite(leiteP);
		}
		else if(tamanho == 'M'){
			Estoque.consomeChocolate(chocolateM);
			Estoque.consomeLeite(leiteM);
		}
		else {
			Estoque.consomeChocolate(chocolateG);
			Estoque.consomeLeite(leiteG);
		}
	}

}
