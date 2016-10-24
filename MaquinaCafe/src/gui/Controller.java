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
import maquina.*;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    @FXML private VBox boxValores;

    @FXML private RadioButton definirValores;

    @FXML private TextField modelo, endereco, cafeP, cafeM, cafeG, leiteP, leiteM, leiteG, cappuP, cappuM, cappuG, chocoP, chocoM, chocoG;

    @FXML private Label valorCafeP, valorCafeM, valorCafeG, valorLeiteP, valorLeiteM, valorLeiteG, valorCappucinoP, valorCappucinoM, valorCappucinoG,
                        valorChocolateP, valorChocolateM, valorChocolateG, valorTotal, proporcaoLabel, resultado, valorFinal, erroPagamento;

    @FXML private TextField nome, cpf, username, senha, inputDinheiro;

    @FXML private Spinner<Integer> acucarSpinner;

    @FXML private ToggleButton cafeLeiteButton;

    @FXML private ToggleGroup bebidasGroup, tamanhoGroup;

    @FXML private Slider proporcao;

    @FXML private BorderPane mainPane;

    @Override
    public void initialize(URL location, ResourceBundle resources) {}

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
        stage.setScene(new Scene((Parent)loader.load()));
        stage.show();
        senha.requestFocus();
    }

    @FXML
    public void inicializaChaveMestra(ActionEvent e) throws IOException {
        Maquina.getInstance().adicionaChaveMestre(senha.getText().trim());

        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("estado0.fxml"));
        loader.setController(this);
        stage.setScene(new Scene((Parent) loader.load()));
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

    public void processaPedido(ActionEvent actionEvent) {
        try {
            char tamanho = tamanhoGroup.getSelectedToggle().getUserData().toString().charAt(0);
            String tipo = bebidasGroup.getSelectedToggle().getUserData().toString();
            double preco = Maquina.getInstance().getValorBebida(tipo, tamanho);
            Maquina.getInstance().processaBebida(tipo, preco, tamanho, proporcao.getValue() / 100);
        } catch (Exception e) {
            resultado.setText("pedido incompleto");
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
                stage.setScene(new Scene((Parent)loader.load()));
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
                ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
            }
        } catch (NumberFormatException e) {
            erroPagamento.setText("numero inválido");
        }
    }


    public void cancelar(ActionEvent actionEvent) {
        Maquina.getInstance().cancelar();
        ((Stage) ((Button) actionEvent.getSource()).getScene().getWindow()).close();
    }
}
