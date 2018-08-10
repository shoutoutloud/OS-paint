/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paint;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.WritableImage;
import javax.imageio.ImageIO;

/**
 *
 * @author a
 */
public class PaintFXMLController implements Initializable {
    
   @FXML
   private ColorPicker colorpicker;
    
   @FXML
   private TextField bsize;
   @FXML
   private Canvas canvas;
   
   boolean toolselected =false;
   
   GraphicsContext brushtool;
   GraphicsContext clr;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        brushtool=canvas.getGraphicsContext2D();
        canvas.setOnMouseDragged(e -> {
            double size=Double.parseDouble(bsize.getText());
            double x=e.getX()-size/2;
            double y=e.getY()-size/2;
            if(toolselected&& !bsize.getText().isEmpty()){
                brushtool.setFill(colorpicker.getValue());
                brushtool.fillRoundRect(x, y, size, size, size, size);
            }
        });
    }

public void toolselected(ActionEvent e){
    toolselected=true;
}  

public void clearCanvs(ActionEvent e){
clr=canvas.getGraphicsContext2D();
clr.clearRect(0, 0, 1280, 720);
}


    
}
