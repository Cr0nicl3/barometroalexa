package com.mycompany.barometrofx;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class Barometro {
    public static final int SOLEADO=1;
    public static final int SOLEADONUBE=2;
    public static final int LLUVIA=3;
    public static final int TORMENTA=4;
    Controlador c=new Controlador();
    @FXML
    private TextField valor;
    @FXML
    private TextField hora;
    @FXML
    private TextField nivel;
    @FXML
    private Button calibrar;
    @FXML
    private TextField minuto;
    @FXML
    private TextField segundo;
    @FXML
    private TextField dia;
    @FXML
    private TextField mes;
    @FXML
    private TextField año;
    @FXML
    private Button escribir;
    @FXML
    private TextArea lecturas;
    @FXML
    private ImageView icono;
    @FXML
    private void escribir(){
        try{
            c.registrarValor(hora.getText(), minuto.getText(), dia.getText(), mes.getText(), año.getText(), Integer.parseInt(valor.getText()));
            
        }
        catch(Exception e){
            escribir.styleProperty().set(".button-error");
        }
        c.mostrarValores(lecturas);
    }
    @FXML
    private void nivelar(){
        c.setNivel(Integer.parseInt(nivel.getText()));
        c.predecir(icono,Integer.parseInt(valor.getText()));
    }
    @FXML
    private void onChangeListener(){
        String error="-fx-border-color:red;-fx-text-fill:orange;";
       if(año.getText()==""||mes.getText()==""||dia.getText()==""||segundo.getText()==""||minuto.getText()==""||hora.getText()==""||valor.getText()==""){escribir.setDisable(true);
            escribir.setStyle(error);
                if(Integer.parseInt(hora.getText())>24||Integer.parseInt(hora.getText())<0){
                    hora.setStyle(error);
                }
                if(Integer.parseInt(hora.getText())<24&&Integer.parseInt(hora.getText())>0){
                    hora.setStyle("");
                }
                if(Integer.parseInt(minuto.getText())>60||Integer.parseInt(minuto.getText())<0){
                    minuto.setStyle(error);
                }
                if(Integer.parseInt(minuto.getText())<60&&Integer.parseInt(minuto.getText())>0){
                    minuto.setStyle("");
                }
                if(Integer.parseInt(segundo.getText())>60||Integer.parseInt(segundo.getText())<0){
                    segundo.setStyle(error);
                }
                if(Integer.parseInt(segundo.getText())<60&&Integer.parseInt(segundo.getText())>0){
                    segundo.setStyle("");
                }
            if(Integer.parseInt(dia.getText())>31||Integer.parseInt(dia.getText())<=0){
                dia.setStyle(error);
            }
            if(Integer.parseInt(dia.getText())<31){
                dia.setStyle("");
            }
            if(Integer.parseInt(mes.getText())>12||Integer.parseInt(mes.getText())<=0){
                mes.setStyle(error);
            }if(Integer.parseInt(mes.getText())<12) {mes.setStyle("");}
            
            if(Integer.parseInt(año.getText())<1970){
                año.setStyle(error);
            }if(Integer.parseInt(año.getText())>=1970) {año.setStyle("");}
       }else{
           escribir.setDisable(false);
           escribir.setStyle("");
       }
       calibrar.setDisable(nivel.getText()=="");
    }
}
