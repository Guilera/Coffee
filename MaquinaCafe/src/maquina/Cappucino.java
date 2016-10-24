package maquina;

public class Cappucino extends CafeComLeite{
	private final double chocolateP = 8;
	private final double chocolateM = 16;
	private final double chocolateG = 24;
	private final double canelaP = 4;
	private final double canelaM = 8;
	private final double canelaG = 16;
	
	public Cappucino(double preco, char tamanho){
		super(preco,tamanho,0.50);
	}

	@Override
	public boolean checaIngredientes(){
		if(getTamanho() == 'P'){
			if((getCafeP()*getProporcaoLeite()) <= Estoque.getCafe() && (getLeiteP()*getProporcaoLeite()) <= Estoque.getLeite() && chocolateP <= Estoque.getChocolate() && canelaP <= Estoque.getCanela()){
				return true;
			}
		}
		else if(getTamanho() == 'M'){
			if((getCafeM()*getProporcaoLeite()) <= Estoque.getCafe() && (getLeiteM()*getProporcaoLeite()) <= Estoque.getLeite() && chocolateM <= Estoque.getChocolate() && canelaM <= Estoque.getCanela()){
				return true;
			}
		}
		else if((getCafeG()*getProporcaoLeite()) <= Estoque.getCafe() && (getLeiteM()*getProporcaoLeite()) <= Estoque.getLeite() && chocolateG <= Estoque.getChocolate() && canelaG <= Estoque.getCanela()){
			return true;
		}
		setStatus("Interrompido. Motivo: Falta de ingredientes");
		return false;
	}

	@Override
	public void fazBebida(){
		if(getTamanho() == 'P'){
			Estoque.consomeCafe(getCafeP()*getProporcaoLeite());
			Estoque.consomeLeite(getLeiteP()*getProporcaoLeite());
			Estoque.consomeChocolate(chocolateP);
			Estoque.consomeCanela(canelaP);
		}
		else if(getTamanho() == 'M'){
			Estoque.consomeCafe(getCafeM()*getProporcaoLeite());
			Estoque.consomeLeite(getLeiteM()*getProporcaoLeite());
			Estoque.consomeChocolate(chocolateM);
			Estoque.consomeCanela(canelaM);
		}
		else {
			Estoque.consomeCafe(getCafeG()*getProporcaoLeite());
			Estoque.consomeLeite(getLeiteG()*getProporcaoLeite());
			Estoque.consomeChocolate(chocolateG);
			Estoque.consomeCanela(canelaG);
		}
	}
}
