package gui;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import maquina.Estoque;
import maquina.Maquina;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private VBox boxValores;

    @FXML private RadioButton definirValores;

    @FXML private TextField modelo, endereco, cafeP, cafeM, cafeG, leiteP, leiteM, leiteG, cappuP, cappuM, cappuG, chocoP, chocoM, chocoG,
                            cafePGerencia, cafeMGerencia, cafeGGerencia, leitePGerencia, leiteMGerencia, leiteGGerencia, cappuPGerencia,
                            cappuMGerencia, cappuGGerencia, chocoPGerencia, chocoMGerencia, chocoGGerencia;

    @FXML private Label valorCafeP, valorCafeM, valorCafeG, valorLeiteP, valorLeiteM, valorLeiteG, valorCappucinoP, valorCappucinoM, valorCappucinoG,
                        valorChocolateP, valorChocolateM, valorChocolateG, proporcaoLabel, resultado, valorFinal, erroPagamento, erroLogin,
                        nivelCafe, nivelLeite, nivelCanela, nivelChoco, nivelAcucar, faturamento;

    @FXML private TextField nomeCompleto, cpf, usernameLogin, senhaChaveMestra, inputDinheiro, usernameCadastro, senhaCadastro;

    @FXML private PasswordField senhaLogin;

    @FXML private Spinner<Integer> acucarSpinner;

    @FXML private ToggleButton cafeLeiteButton;

    @FXML private ToggleGroup bebidasGroup, tamanhoGroup;

    @FXML private Slider proporcao;

    @FXML private CheckBox gerenteChoice;

    @FXML private BorderPane mainPane;

    @FXML private Tab tab2, tab3, tab4, tab5;

    @FXML private TextArea logArea;

    @Override
    public void initialize(URL location, ResourceBundle resources){}

    @FXML
    public void toogleDefinirValor(ActionEvent e){
        boxValores.setVisible(!boxValores.isVisible());
    }

    @FXML
    public void initializeButton(ActionEvent e) throws IOException {
        if(definirValores.isSelected()) {
            Maquina.setInstance(new Maquina(modelo.getText().trim(), endereco.getText().trim(), Double.parseDouble(cafeP.getText().trim()), Double.parseDouble(cafeM.getText().trim()),
                    Double.parseDouble(cafeG.getText().trim()), Double.parseDouble(leiteP.getText().trim()), Double.parseDouble(leiteM.getText().trim()),
                    Double.parseDouble(leiteG.getText().trim()), Double.parseDouble(cappuP.getText().trim()), Double.parseDouble(cappuM.getText().trim()),
                    Double.parseDouble(cappuG.getText().trim()), Double.parseDouble(chocoP.getText().trim()), Double.parseDouble(chocoM.getText().trim()),
                    Double.parseDouble(chocoG.getText().trim())));
        }else {
            Maquina.setInstance(new Maquina(modelo.getText().trim(), endereco.getText().trim()));
        }
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("inicializaChaveMestra.fxml"));
        loader.setController(this);
        stage.setScene(new Scene((Parent)loader.load(), 600, 300));
        stage.show();
        senhaChaveMestra.requestFocus();
    }

    public void inicializaMainPane(ActionEvent e) throws IOException {
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("mainPane.fxml"));
        loader.setController(this);
        stage.setScene(new Scene((Parent) loader.load(), 800, 500));
        stage.show();

        valorCafeP.setText(Double.toString(Maquina.getInstance().getValorCafeP()));
        valorCafeM.setText(Double.toString(Maquina.getInstance().getValorCafeM()));
        valorCafeG.setText(Double.toString(Maquina.getInstance().getValorCafeG()));
        valorLeiteP.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteP()));
        valorLeiteM.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteM()));
        valorLeiteG.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteG()));
        valorCappucinoP.setText(Double.toString(Maquina.getInstance().getValorCappucinoP()));
        valorCappucinoM.setText(Double.toString(Maquina.getInstance().getValorCappucinoM()));
        valorCappucinoG.setText(Double.toString(Maquina.getInstance().getValorCappucinoG()));
        valorChocolateP.setText(Double.toString(Maquina.getInstance().getValorChocolateP()));
        valorChocolateM.setText(Double.toString(Maquina.getInstance().getValorChocolateM()));
        valorChocolateG.setText(Double.toString(Maquina.getInstance().getValorChocolateG()));
        SpinnerValueFactory<Integer> range = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, (int) Maquina.getInstance().getAcucar(), 0);
        acucarSpinner.setValueFactory(range);
        cafeLeiteButton.selectedProperty().addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                if(cafeLeiteButton.isSelected()) {
                    proporcao.setDisable(false);
                    proporcaoLabel.setDisable(false);
                }else {
                    proporcao.setDisable(true);
                    proporcaoLabel.setDisable(true);
                }
            }
        });
    }

    @FXML
    public void inicializaChaveMestra(ActionEvent e) throws IOException {
        Maquina.getInstance().adicionaChaveMestre(senhaChaveMestra.getText().trim());

        inicializaMainPane(e);
    }

    public void processaPedido(ActionEvent actionEvent) {
        try {
            char tamanho = tamanhoGroup.getSelectedToggle().getUserData().toString().charAt(0);
            String tipo = bebidasGroup.getSelectedToggle().getUserData().toString();
            double preco = Maquina.getInstance().getValorBebida(tipo, tamanho);
            Maquina.getInstance().processaBebida(tipo, preco, tamanho, proporcao.getValue() / 100);
        } catch (Exception e) {
            resultado.setText("pedido incompleto");
            return;
        }
        if(Maquina.getInstance().checaIngrediente()){
            Maquina.getInstance().adicionaAcucar(Integer.parseInt(acucarSpinner.getValue().toString()));
            resultado.setText("Valor Total (R$): " + String.format("%.2f", Maquina.getInstance().getTotal()));
        }else{
            resultado.setText("Ingredientes Insuficientes");
        }
    }

    @FXML
    public void goToPagamentoDialog(ActionEvent actionEvent) {
        processaPedido(actionEvent);
        if(!Maquina.getInstance().temBebidaEmProcesso()){
            resultado.setText("Bebida não selecionada");
        }else{
            Stage stage = new Stage();
            try{
                FXMLLoader loader = new FXMLLoader(getClass().getResource("dialogPagamento.fxml"));
                loader.setController(this);
                stage.setScene(new Scene((Parent)loader.load(), 600, 300));
                stage.initModality(Modality.APPLICATION_MODAL);
                stage.initOwner(mainPane.getScene().getWindow());
                valorFinal.setText("Valor Total (R$): " + String.format("%.2f", Maquina.getInstance().getTotal()));
                resultado.setText("");
                bebidasGroup.getSelectedToggle().setSelected(false);
                tamanhoGroup.getSelectedToggle().setSelected(false);
                SpinnerValueFactory<Integer> range = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, (int) Maquina.getInstance().getAcucar(), 0);
                acucarSpinner.setValueFactory(range);
                stage.showAndWait();
            }catch(Exception ex){
                System.out.println("não foi possivel fazer o load do dialog\n" + ex.getMessage());
                return;
            }
        }
    }

    public void pagamento(ActionEvent actionEvent) {
        try {
            if(inputDinheiro.getText().trim().isEmpty()){
                erroPagamento.setText("Nenhum valor de input");
            }else if(!Maquina.getInstance().vendeBebida(Double.parseDouble(inputDinheiro.getText()))){
                erroPagamento.setText("Valor insuficiente");
            }else{
                System.out.println("bebida vendida com sucesso");
                ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
                SpinnerValueFactory<Integer> range = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, (int) Maquina.getInstance().getAcucar(), 0);
                acucarSpinner.setValueFactory(range);
            }
        } catch (NumberFormatException e) {
            erroPagamento.setText("numero inválido");
        }
    }


    public void cancelar(ActionEvent actionEvent) {
        Maquina.getInstance().cancelar();
        ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void openLoginDialog(ActionEvent actionEvent) {
        try {
            Stage stage = new Stage();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("loginDialog.fxml"));
            loader.setController(this);
            stage.setScene(new Scene((Parent)loader.load(), 600, 300));
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.initOwner(mainPane.getScene().getWindow());
            stage.showAndWait();

        }catch (IOException e){
            System.out.println("não foi possivel abrir loginDialog" + e.getMessage());
        }
    }

    public void logIn(ActionEvent actionEvent) throws IOException {
        if(Maquina.getInstance().logar(usernameLogin.getText().trim(), senhaLogin.getText().trim())) {
            ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
            Stage stage = (Stage) mainPane.getScene().getWindow();
            FXMLLoader loader = new FXMLLoader(getClass().getResource("gerencia.fxml"));
            loader.setController(this);
            stage.setScene(new Scene((Parent) loader.load(), 800, 500));
            stage.show();
            if(Maquina.getInstance().isGerenteLogado()){
                tab2.setDisable(false);
                tab3.setDisable(false);
                tab4.setDisable(false);
                tab5.setDisable(false);
            }
            nivelCafe.setText(Double.toString(Estoque.getCafe()) + "g");
            nivelLeite.setText(Double.toString(Estoque.getLeite()) + "g");
            nivelCanela.setText(Double.toString(Estoque.getCanela()) + "g");
            nivelChoco.setText(Double.toString(Estoque.getChocolate()) + "g");
            nivelAcucar.setText(Double.toString(Estoque.getAcucar()) + "g");
            faturamento.setText(Double.toString(Maquina.getInstance().getFaturamento()));
            cafePGerencia.setText(Double.toString(Maquina.getInstance().getValorCafeP()));
            cafeMGerencia.setText(Double.toString(Maquina.getInstance().getValorCafeM()));
            cafeGGerencia.setText(Double.toString(Maquina.getInstance().getValorCafeG()));
            leitePGerencia.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteP()));
            leiteMGerencia.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteM()));
            leiteGGerencia.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteG()));
            cappuPGerencia.setText(Double.toString(Maquina.getInstance().getValorCappucinoP()));
            cappuMGerencia.setText(Double.toString(Maquina.getInstance().getValorCappucinoM()));
            cappuGGerencia.setText(Double.toString(Maquina.getInstance().getValorCappucinoG()));
            chocoPGerencia.setText(Double.toString(Maquina.getInstance().getValorChocolateP()));
            chocoMGerencia.setText(Double.toString(Maquina.getInstance().getValorChocolateM()));
            chocoGGerencia.setText(Double.toString(Maquina.getInstance().getValorChocolateG()));
            logArea.setText(Maquina.getInstance().getLog());
        }else{
            erroLogin.setText("Usuario Inexistente ou senha incorreta");
        }

    }

    public void cancelarLogIn(ActionEvent actionEvent) {
        ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
    }

    public void adicionaFuncionario(ActionEvent actionEvent) {
        if(gerenteChoice.isSelected())
            Maquina.getInstance().adicionaGerente(nomeCompleto.getText(), cpf.getText(), usernameCadastro.getText(), senhaCadastro.getText());
        else
            Maquina.getInstance().adicionaFuncionario(nomeCompleto.getText(), cpf.getText(), usernameCadastro.getText(), senhaCadastro.getText());
        limpaCampos(actionEvent);
        logArea.setText(Maquina.getInstance().getLog());
    }

    public void limpaCampos(ActionEvent actionEvent) {
        nomeCompleto.setText("");
        cpf.setText("");
        usernameCadastro.setText("");
        senhaCadastro.setText("");
    }

    public void excluirFuncionario(ActionEvent actionEvent) {
        Maquina.getInstance().excluirUser(usernameCadastro.getText().trim());
        logArea.setText(Maquina.getInstance().getLog());
    }

    public void recolherFaturamento(ActionEvent actionEvent) {
        Maquina.getInstance().recolherFaturamento();
        faturamento.setText("0");
        logArea.setText(Maquina.getInstance().getLog());
    }

    public void refillAcucar(ActionEvent actionEvent) {
        Estoque.completaAcucar();
        nivelAcucar.setText("1000g");
    }

    public void refilChocolate(ActionEvent actionEvent) {
        Estoque.completaChocolate();
        nivelChoco.setText("1000g");
    }

    public void refilCanela(ActionEvent actionEvent) {
        Estoque.completaCanela();
        nivelCanela.setText("1000g");
    }

    public void refilLeite(ActionEvent actionEvent) {
        Estoque.completaLeite();
        nivelLeite.setText("1000g");
    }

    public void refilCafe(ActionEvent actionEvent) {
        Estoque.completaCafe();
        nivelCafe.setText("1000g");
    }

    public void atualizaPreco(ActionEvent actionEvent) {
        Maquina.getInstance().setValorCafeP(Double.parseDouble(cafePGerencia.getText()));
        Maquina.getInstance().setValorCafeM(Double.parseDouble(cafeMGerencia.getText()));
        Maquina.getInstance().setValorCafeG(Double.parseDouble(cafeGGerencia.getText()));
        Maquina.getInstance().setValorCafeLeiteP(Double.parseDouble(leitePGerencia.getText()));
        Maquina.getInstance().setValorCafeLeiteM(Double.parseDouble(leiteMGerencia.getText()));
        Maquina.getInstance().setValorCafeLeiteG(Double.parseDouble(leiteGGerencia.getText()));
        Maquina.getInstance().setValorCappucinoP(Double.parseDouble(cappuPGerencia.getText()));
        Maquina.getInstance().setValorCappucinoM(Double.parseDouble(cappuMGerencia.getText()));
        Maquina.getInstance().setValorCappucinoG(Double.parseDouble(cappuGGerencia.getText()));
        Maquina.getInstance().setValorChocolateP(Double.parseDouble(chocoPGerencia.getText()));
        Maquina.getInstance().setValorChocolateM(Double.parseDouble(chocoMGerencia.getText()));
        Maquina.getInstance().setValorChocolateG(Double.parseDouble(chocoGGerencia.getText()));
    }

    public void logout(ActionEvent actionEvent) throws IOException {
        Maquina.getInstance().deslogar();
        inicializaMainPane(actionEvent);
    }
}
