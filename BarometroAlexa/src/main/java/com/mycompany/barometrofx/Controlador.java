package com.mycompany.barometrofx;
import static com.mycompany.barometrofx.Barometro.*;
import java.io.File;
import java.util.*;
import java.time.LocalDateTime;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
/**
 *
 * @author Cronicle
 */
class Medida{
    public LocalDateTime fecha;
    public int valor,nivel;
    public Medida(int hora,int minuto,int dia,int mes,int año,int valor,int nivel){
        this.valor=valor;
        fecha=LocalDateTime.of(año, mes, dia, hora, minuto);
        this.nivel=nivel;
    }
}
public class Controlador {
    private ArrayList<Medida> medidas;
    private int nivel;
    public Controlador(){
        nivel=0;
        medidas=new ArrayList<Medida>();
    }
    public void setNivel(int nivel){
        this.nivel=nivel;
    }
    public void registrarValor(String hora,String minuto,String dia,String mes,String año,int valor){
        
        medidas.add(medidas.size(),new Medida(Integer.parseInt(hora),Integer.parseInt(minuto),Integer.parseInt(dia),Integer.parseInt(mes),Integer.parseInt(año),valor,nivel));
    }
    
    /*public void predecir(){
        if(medidas.size()>3){
        int aux=Integer.parseInt(medidas.get(medidas.size()));
        int aux2=Integer.parseInt(medidas.get(medidas.size()-1));
        int aux3=Integer.parseInt(medidas.get(medidas.size()-2));
        }else System.out.println("No hay suficientes datos para hacer una prediccion");
    }*/

    void mostrarValores(TextArea lecturas) {
        lecturas.setText("");
        for(int i=0;i<medidas.size();i++){
            lecturas.setText(lecturas.getText()+medidas.get(i).fecha.toString()+" (nivel del mar:"+medidas.get(i).nivel+")"+"= "+medidas.get(i).valor+"\n");
        }
    }
    public void cambiarImagen(ImageView frame,int tipo){
        String path= "src\\main\\resources\\iconos\\";
        switch(tipo){
            case SOLEADO:
                path=path+"soleado.jpg";
                break;
            case LLUVIA:
                path=path+"lluvia.jpg";
                break;
            case SOLEADONUBE:
                path=path+"soleadonube.jpg";
                break;
            case TORMENTA:
                path=path+"tormenta.png";
                break;
        }
        File f=new File(path);
        Image imagen=new Image(f.toURI().toString());
        frame.setImage(imagen);
    }
}
