//Sobrecarga checaIngredientes
public abstract class ControleMaquinaBebida{

	public ControleMaquinaBebida(){}
	
	public boolean fazBebida(int idBebida, char tamanho){ // 1- cafe 2- cafe com leite 3- chocolate 4- cappucino
		if(idBebida == 1){
			if(checaIngredientes(Cafe.cafeNecessario(tamanho)) == true)
				return new Cafe(Cafe.calculaPreco(tamanho), tamanho, Cafe.cafeNecessario(tamanho));
		}
		else if(idBebida == 2){
			if(checaIngredientes(CafeComLeite.cafeNecessario(tamanho), cafeComLeite.leiteNecessario(tamanho), true) == true)
				return new Cafe(CafeComLeite.calculaPreco(tamanho), tamanho, CafeComLeite.cafeNecessario(tamanho), CafeComLeite.leiteNecessario(tamanho));
		}
		else if(idBebida == 3){
			if(checaIngredientes(Chocolate.chocolateNecessario(tamanho), Chocolate.leiteNecessario(tamanho), false) == true)
				return new Cafe(Chocolate.calculaPreco(tamanho), tamanho, Chocolate.chocolateNecessario(tamanho), Chocolate.leiteNecessario(tamanho));
		}
		else if(idBebida == 4){
			if(checaIngredientes(Cappucino.cafeNecessario(tamanho), Cappucino.leiteNecessario(tamanho), Cappucino.chocolateNecessario(tamanho), Cappucino.canelaNecessario(tamanho)) == true)
				return new Cafe(Cappucino.calculaPreco(tamanho), tamanho, Cappucino.cafeNecessario(tamanho), Cappucino.leiteNecessario(tamanho), Cappucino.chocolateNecessario(tamanho), Cappucino.canelaNecessario(tamanho));
		}
		else {
			//cafe com leite tipo 2
		}
		return null;
	}

	public boolean checaIngredientes(double c){ //checa Cafe
		if(c <= Estoque.getCafe()) return true;
		return false;
	}

	public boolean checaIngredientes(double cch, double l, boolean cafe){ //checa cafe com leite/chocolate
		if(cafe){
			if(cch <= Estoque.getCafe() && l <= Estoque.getLeite()) return true;
		}
		else if(cch <= Estoque.getChocolate() && l <= Estoque.getLeite()) return true;
		return false;
	}

	public boolean checaIngredientes(double c, double l, double ch, double ca){
		if(c <= Estoque.getCafe() && l <= Estoque.getLeite() && ch <= Estoque.getChocolate() && ca <= Estoque.getCanela()) return true;
		return false;
	}

}
