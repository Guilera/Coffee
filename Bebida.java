public abstract class Bebida{
	private double preco;
	private char tamanho;
	private String status;

	public Bebida(double preco, char tamanho){
		this.tamanho = tamanho;
		this.preco = preco;
		status = "Pedida";
	}

	public void setStatus(String s){
		status = s;
	}

	public boolean checaAcucar(int acucar){
		if(acucar <= Estoque.getAcucar()){
			recalculaPreco(acucar);
			return true;
		}
		return false;
	}

	public void adicionaAcucar(int acucar){
		Estoque.consomeAcucar(acucar);
	}

	public void recalculaPreco(int acucar){
		preco+=acucar*0.10;
	}

	public boolean venda(double money){
		if(money >= preco){
			setStatus("Vendida");
			return true;
		}
		setStatus("Interrompida. Motivo: Dinheiro insuficiente");
		return false;
	}

	public void cancelamento(){
		setStatus("Cancelada pelo cliente");
	}
	
	public abstract void fazBebida(char tamanho);
	public abstract boolean checaIngredientes(char tamanho);

}
