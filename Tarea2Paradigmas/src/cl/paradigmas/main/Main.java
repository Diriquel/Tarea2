package cl.paradigmas.main;

import cl.paradigmas.gui.Ventana;
import cl.paradigmas.gui.eventos.EventBuilder;
import java.awt.event.MouseAdapter;
import javax.swing.JToggleButton;

public class Main{
	
	public static void main(String[] args){
		Ventana ventana = new Ventana();
		
		ventana.getToolbar().getBtnLimpiar().addActionListener(EventBuilder.botonlimpiar(ventana));
		ventana.getToolbar().addBtn("LINEA", new JToggleButton("LINEA"));
		ventana.getToolbar().addBtn("CIRCULO", new JToggleButton("CIRCULO"));
		ventana.getToolbar().getBtn("LINEA").addActionListener(EventBuilder.crearlinea(ventana));
		ventana.getToolbar().getBtn("CIRCULO").addActionListener(EventBuilder.crearcirculo(ventana));
		MouseAdapter a=EventBuilder.dibcanv(ventana);
		ventana.getCanvas().addMouseMotionListener(a);
		ventana.getCanvas().addMouseListener(a);

		ventana.setVisible(true);
	}

}
