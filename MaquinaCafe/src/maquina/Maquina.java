package maquina;

import maquina.gerencia.Gerencia;

public class Maquina implements IMaquina {

    private String modelo, endereço;
    private double valorCafeP, valorCafeM, valorCafeG, valorCafeLeiteP, valorCafeLeiteM, valorCafeLeiteG, valorCappucinoP,
            valorCappucinoM, valorCappucinoG, valorChocolateP, valorChocolateM, valorChocolateG;
    private Gerencia adm;
    private Estoque estoque;

    private static Maquina instance = new Maquina("empty", "empty");

    public static Maquina getInstance() {
        return instance;
    }

    public static void setInstance(Maquina instance) {
        Maquina.instance = instance;
    }

    public Maquina(String modelo, String endereço) {
        this(modelo, endereço,2.50,5,7.50,3,6,9,3.50,7,10.50,3,6,9);
    }

    public Maquina(String modelo, String endereço, double valorCafeP, double valorCafeM, double valorCafeG, double valorCafeLeiteP, double valorCafeLeiteM, double valorCafeLeiteG, double valorCappucinoP, double valorCappucinoM, double valorCappucinoG, double valorChocolateP, double valorChocolateM, double valorChocolateG) {
        this.modelo = modelo;
        this.endereço = endereço;
        this.valorCafeP = valorCafeP;
        this.valorCafeM = valorCafeM;
        this.valorCafeG = valorCafeG;
        this.valorCafeLeiteP = valorCafeLeiteP;
        this.valorCafeLeiteM = valorCafeLeiteM;
        this.valorCafeLeiteG = valorCafeLeiteG;
        this.valorCappucinoP = valorCappucinoP;
        this.valorCappucinoM = valorCappucinoM;
        this.valorCappucinoG = valorCappucinoG;
        this.valorChocolateP = valorChocolateP;
        this.valorChocolateM = valorChocolateM;
        this.valorChocolateG = valorChocolateG;
        adm = new Gerencia();
    }

    public String getModelo() {
        return modelo;
    }

    public String getEndereço() {
        return endereço;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setEndereço(String endereço) {
        this.endereço = endereço;
    }

    public double getValorCafeP() {
        return valorCafeP;
    }

    public void setValorCafeP(double valorCafeP) {
        this.valorCafeP = valorCafeP;
    }

    public double getValorCafeM() {
        return valorCafeM;
    }

    public void setValorCafeM(double valorCafeM) {
        this.valorCafeM = valorCafeM;
    }

    public double getValorCafeG() {
        return valorCafeG;
    }

    public void setValorCafeG(double valorCafeG) {
        this.valorCafeG = valorCafeG;
    }

    public double getValorCafeLeiteP() {
        return valorCafeLeiteP;
    }

    public void setValorCafeLeiteP(double valorCafeLeiteP) {
        this.valorCafeLeiteP = valorCafeLeiteP;
    }

    public double getValorCafeLeiteM() {
        return valorCafeLeiteM;
    }

    public void setValorCafeLeiteM(double valorCafeLeiteM) {
        this.valorCafeLeiteM = valorCafeLeiteM;
    }

    public double getValorCafeLeiteG() {
        return valorCafeLeiteG;
    }

    public void setValorCafeLeiteG(double valorCafeLeiteG) {
        this.valorCafeLeiteG = valorCafeLeiteG;
    }

    public double getValorCappucinoP() {
        return valorCappucinoP;
    }

    public void setValorCappucinoP(double valorCappucinoP) {
        this.valorCappucinoP = valorCappucinoP;
    }

    public double getValorCappucinoM() {
        return valorCappucinoM;
    }

    public void setValorCappucinoM(double valorCappucinoM) {
        this.valorCappucinoM = valorCappucinoM;
    }

    public double getValorCappucinoG() {
        return valorCappucinoG;
    }

    public void setValorCappucinoG(double valorCappucinoG) {
        this.valorCappucinoG = valorCappucinoG;
    }

    public double getValorChocolateP() {
        return valorChocolateP;
    }

    public void setValorChocolateP(double valorChocolateP) {
        this.valorChocolateP = valorChocolateP;
    }

    public double getValorChocolateM() {
        return valorChocolateM;
    }

    public void setValorChocolateM(double valorChocolateM) {
        this.valorChocolateM = valorChocolateM;
    }

    public double getValorChocolateG() {
        return valorChocolateG;
    }

    public void setValorChocolateG(double valorChocolateG) {
        this.valorChocolateG = valorChocolateG;
    }

    @Override
    public boolean adicionaFuncionario(String nome, String cpf, String username, String senha) {
        return adm.adicionaFuncionario(nome, cpf, username, senha);
    }

    @Override
    public boolean adicionaGerente(String nome, String cpf, String username, String senha) {
        return adm.adicionaGerente(nome, cpf, username, senha);
    }

    @Override
    public boolean logar(String username, String senha) {
        return adm.logar(username, senha);
    }

    @Override
    public void deslogar() {
        adm.deslogar();
    }

    @Override
    public void adicionaChaveMestre(String senha) {
        adm.adicionaChaveMestre(senha);
    }
}
