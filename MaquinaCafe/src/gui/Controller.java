package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import maquina.Maquina;

import java.io.IOException;

public class Controller{

    @FXML
    private VBox boxValores;
    @FXML
    private RadioButton definirValores;

    @FXML
    private TextField modelo, endereco, cafeP, cafeM, cafeG, leiteP, leiteM, leiteG, cappuP, cappuM, cappuG, chocoP, chocoM, chocoG;

    @FXML
    private Label valorCafeP, valorCafeM, valorCafeG, valorLeiteP, valorLeiteM, valorLeiteG, valorCappucinoP, valorCappucinoM, valorCappucinoG,
            valorChocolateP, valorChocolateM, valorChocolateG;

    @FXML
    private TextField nome, cpf, username, senha;

    public Controller() throws IOException {}

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
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("inicializaChaveMestra.fxml"))));
        stage.show();
    }

    @FXML
    public void inicializaChaveMestra(ActionEvent e) throws IOException {
        System.out.println(Maquina.getInstance());
        System.out.println(Maquina.getInstance().getEndereço());
        Maquina.getInstance().adicionaChaveMestre(senha.getText().trim());
        Parent estado0 = FXMLLoader.load(getClass().getResource("estado0.fxml"));
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(estado0, 600, 300));
        stage.show();

        System.out.println(Maquina.getInstance().getValorCafeP());
        valorCafeP.setText("lixo aqui");
       /* valorCafeM.setText(Double.toString(Maquina.getInstance().getValorCafeM()));
        valorCafeG.setText(Double.toString(Maquina.getInstance().getValorCafeG()));
        valorLeiteP.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteP()));
        valorLeiteM.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteM()));
        valorLeiteG.setText(Double.toString(Maquina.getInstance().getValorCafeLeiteG()));
        valorCappucinoP.setText(Double.toString(Maquina.getInstance().getValorCappucinoP()));
        valorCappucinoM.setText(Double.toString(Maquina.getInstance().getValorCappucinoM()));
        valorCappucinoG.setText(Double.toString(Maquina.getInstance().getValorCappucinoG()));
        valorChocolateP.setText(Double.toString(Maquina.getInstance().getValorChocolateP()));
        valorChocolateM.setText(Double.toString(Maquina.getInstance().getValorChocolateM()));
        valorChocolateG.setText(Double.toString(Maquina.getInstance().getValorChocolateG()));*/
    }
}
