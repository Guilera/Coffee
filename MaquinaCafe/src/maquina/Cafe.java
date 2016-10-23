package maquina;

public class Cafe extends Bebida{
	private final double cafeP = 16;
	private final double cafeM = 32;
	private final double cafeG = 48;
	
	public Cafe(double preco, char tamanho){
		super(preco,tamanho);
	}

	@Override
	public void fazBebida(char tamanho){
		if(tamanho == 'P'){
			Estoque.consomeCafe(cafeP);
		}
		else if(tamanho == 'M'){
			Estoque.consomeCafe(cafeM);
		}
		else {
			Estoque.consomeCafe(cafeG);
		}
	}
	
	@Override
	public boolean checaIngredientes(char tamanho){
		if(tamanho == 'P'){
			if(cafeP <= Estoque.getCafe()){
				return true;
			}
		}
		else if(tamanho == 'M'){
			if(cafeM <= Estoque.getCafe()){
				return true;
			}
		}
		else if(cafeG <= Estoque.getCafe()){
			return true;
		}
		setStatus("Interrompido. Motivo: Falta de ingredientes");
		return false;
	}

	public double getCafeP(){
		return cafeP;
	}

	public double getCafeM(){
		return cafeM;
	}

	public double getCafeG(){
		return cafeG;
	}
		

}
	
	
