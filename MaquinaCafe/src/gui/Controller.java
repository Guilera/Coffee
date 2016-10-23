package gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
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
import java.net.URL;
import java.rmi.activation.ActivationID;
import java.util.ResourceBundle;

public class Controller{

    private Maquina maq;

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

    public Controller() throws IOException {
    }

    @FXML
    public void toogleDefinirValor(ActionEvent e){
        boxValores.setVisible(!boxValores.isVisible());
    }

    public void initialize(ActionEvent e) throws IOException, NullPointerException {
        if(definirValores.isSelected()) {
            maq = new Maquina(modelo.getText().trim(), endereco.getText().trim(), Double.parseDouble(cafeP.getText().trim()), Double.parseDouble(cafeM.getText().trim()),
                    Double.parseDouble(cafeG.getText().trim()), Double.parseDouble(leiteP.getText().trim()), Double.parseDouble(leiteM.getText().trim()),
                    Double.parseDouble(leiteG.getText().trim()), Double.parseDouble(cappuP.getText().trim()), Double.parseDouble(cappuM.getText().trim()),
                    Double.parseDouble(cappuG.getText().trim()), Double.parseDouble(chocoP.getText().trim()), Double.parseDouble(chocoM.getText().trim()),
                    Double.parseDouble(chocoG.getText().trim()));
        }else {
            maq = new Maquina(modelo.getText().trim(), endereco.getText().trim());
            System.out.println("inicializada");
            System.out.println(maq.getValorCafeP());
        }
       /* valorCafeP.setText(Double.toString(maq.getValorCafeP()));
        valorCafeM.setText(Double.toString(maq.getValorCafeM()));
        valorCafeG.setText(Double.toString(maq.getValorCafeG()));
        valorLeiteP.setText(Double.toString(maq.getValorCafeLeiteP()));
        valorLeiteM.setText(Double.toString(maq.getValorCafeLeiteM()));
        valorLeiteG.setText(Double.toString(maq.getValorCafeLeiteG()));
        valorCappucinoP.setText(Double.toString(maq.getValorCappucinoP()));
        valorCappucinoM.setText(Double.toString(maq.getValorCappucinoM()));
        valorCappucinoG.setText(Double.toString(maq.getValorCappucinoG()));
        valorChocolateP.setText(Double.toString(maq.getValorChocolateP()));
        valorChocolateM.setText(Double.toString(maq.getValorChocolateM()));
        valorChocolateG.setText(Double.toString(maq.getValorChocolateG()));*/

        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("inicializaChaveMestra.fxml"))));
        stage.show();
    }

    public void inicializaChaveMestra(ActionEvent e) throws IOException {
        if(maq.adicionaChaveMestre(senha.getText().trim()))
            System.out.println("adicionou chave");
        System.out.println(maq.logar("adm", senha.getText().trim()));
        /*Parent estado0 = FXMLLoader.load(getClass().getResource("estado0.fxml"));
        Stage stage = (Stage) ((Button) e.getSource()).getScene().getWindow();
        stage.setScene(new Scene(estado0, 600, 300));
        stage.show();*/
    }


    public void changeCafe(ActionEvent e){

    }
}
