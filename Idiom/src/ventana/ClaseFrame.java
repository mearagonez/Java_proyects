package ventana;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;


public class ClaseFrame extends JFrame implements ActionListener
	{
		private Container contenedor;
		JLabel labelTitulo;/*declaramos el objeto Label*/
		JTextArea areaDeTexto;
		JButton botonAbrir;/*declaramos el objeto Boton*/
		JButton botonDetectar;/*declaramos el objeto Boton*/
		JScrollPane scrollPaneArea;
		JFileChooser fileChooser; /*Declaramos el objeto fileChooser*/
		String texto;
                StringBuilder prueba;
                analizador idiom;
                
    
		
		public ClaseFrame()//constructor
		{
			contenedor=getContentPane();
			contenedor.setLayout(null);
			
			/*Creamos el objeto*/
			fileChooser=new JFileChooser();
			
			/*Propiedades del Label, lo instanciamos, posicionamos y
			 * activamos los eventos*/
			labelTitulo= new JLabel();
			labelTitulo.setText("Idiom detection");
			labelTitulo.setBounds(150, 10, 180, 23);
			
			areaDeTexto = new JTextArea();
			//para que el texto se ajuste al area
			areaDeTexto.setLineWrap(true);
			//permite que no queden palabras incompletas al hacer el salto de linea
			areaDeTexto.setWrapStyleWord(true);
		   	scrollPaneArea = new JScrollPane();
			scrollPaneArea.setBounds(20, 50, 350, 270);
	        scrollPaneArea.setViewportView(areaDeTexto);
	       	
			/*Propiedades del boton, lo instanciamos, posicionamos y
			 * activamos los eventos*/
			botonAbrir= new JButton();
			botonAbrir.setText("Abrir");
			botonAbrir.setBounds(100, 330, 80, 23);                        
			botonAbrir.addActionListener(this);
			
			botonDetectar= new JButton();
			botonDetectar.setText("Detectar");
			botonDetectar.setBounds(220, 330, 95, 23);
			botonDetectar.addActionListener(this);
			
			/*Agregamos los componentes al Contenedor*/
			contenedor.add(labelTitulo);
			contenedor.add(scrollPaneArea);
			contenedor.add(botonAbrir);
			contenedor.add(botonDetectar);
       		//Asigna un titulo a la barra de titulo
			setTitle("Idiom Detect");
			//tamaño de la ventana
			setSize(400,400);
			//pone la ventana en el Centro de la pantalla
			setLocationRelativeTo(null);
			
	        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		}

		@Override
		public void actionPerformed(ActionEvent evento) {
			if (evento.getSource()==botonAbrir)
			{
                            areaDeTexto.setEditable(true);
                            String archivo=abrirArchivo();
                            areaDeTexto.setText(archivo);
			}
			
			if (evento.getSource()==botonDetectar)
			{
				prueba =new StringBuilder(areaDeTexto.getText().toLowerCase());
                                idiom=new analizador(prueba);
                                areaDeTexto.setText(idiom.init());
                                areaDeTexto.setEditable(false);
			}
		}

		/**
		 * Permite mostrar la ventana que carga 
		 * archivos en el area de texto
		 * @return
		 */
		private String abrirArchivo() {
					
			String aux=""; 		
	 		texto="";
		
	 		try{
                        /*llamamos el metodo que permite cargar la ventana*/
	    		fileChooser.showOpenDialog(this);
	    		/*abrimos el archivo seleccionado*/
	 			File abre=fileChooser.getSelectedFile();

	 			/*recorremos el archivo, lo leemos para plasmarlo
	 			 *en el area de texto*/
	 			if(abre!=null)
	 			{ 				
	 				FileReader archivos=new FileReader(abre);
	 				BufferedReader lee=new BufferedReader(archivos);
	 				while((aux=lee.readLine())!=null)
	 					{
                                                 String UTF8Str = new String(aux.getBytes(),"UTF-8");
	 					 texto+= UTF8Str+ "\n";
	 					}

	 		  		lee.close();
	 			} 			
	 		}catch(IOException ex){
			  JOptionPane.showMessageDialog(null,ex+"" +
			  		"\nNo se ha encontrado el archivo",
			  		"ADVERTENCIA!!!",JOptionPane.WARNING_MESSAGE);
			}
				return texto;
		}
		
                
                
}