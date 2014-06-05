package cl.paradigmas.gui.eventos;

import cl.paradigmas.modelo.Circulo;
import cl.paradigmas.modelo.Linea;
import java.awt.event.MouseAdapter;
import cl.paradigmas.gui.Ventana;
import cl.paradigmas.gui.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;

final public class EventBuilder{
	private EventBuilder(){
	}

	public static ActionListener crearlinea(final Ventana v){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				v.setSeleccionado(Ventana.LINEA);
			}
		};
	}
	public static ActionListener crearcirculo(final Ventana v){
		return new ActionListener()
		{@Override
			public void actionPerformed(ActionEvent e){
				v.setSeleccionado(Ventana.CIRCULO);
			}
		};
	}
	public static ActionListener botonlimpiar(final Ventana v){
		return new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e){
				v.getCanvas().limpiar();
			}
		};
	}
	public static MouseAdapter dibcanv(final Ventana v){
		return new MouseAdapter(){
			public void mouseDragged(MouseEvent e){
				int slc=v.getSeleccionado();
				Canvas c=v.getCanvas();
					if(c.isDibujandoTmp()){
						if(Ventana.LINEA==slc){
							Linea line=(Linea)v.getCanvas().getDibujableTmp();
							line.setFin(e.getPoint());
						}
					c.repaint();
				}		
			}
			
			public void mousePressed(MouseEvent e){
						v.getCanvas().setDibujandoTmp(true);
						if(v.getSeleccionado()==Ventana.LINEA){
							Linea line=new Linea(e.getPoint(), e.getPoint());
							v.getCanvas().setDibujableTmp(line);
						}
							if(v.getSeleccionado()==Ventana.CIRCULO){
								Circulo circle=new Circulo(e.getPoint(),75);
								v.getCanvas().setDibujableTmp(circle);
							}	
							v.getCanvas().repaint();
			}
			
			public void mouseReleased(MouseEvent e){
					if(v.getSeleccionado()==Ventana.LINEA){
						Linea line=(Linea)v.getCanvas().getDibujableTmp();
						v.getCanvas().setDibujableTmp(null);
						v.getCanvas().addDibujable(line);
					}
					if(Ventana.CIRCULO==v.getSeleccionado()){
						Circulo circle=(Circulo)v.getCanvas().getDibujableTmp();
						v.getCanvas().setDibujableTmp(null);
						v.getCanvas().addDibujable(circle);
					}
					v.getCanvas().setDibujandoTmp(false);
					v.getCanvas().repaint();
				}
		};
	}
}
