import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JOptionPane;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.wb.swt.SWTResourceManager;

public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static int controllo=0;
	public static Lista lista;
	public ArrayList<String> listaPizze;
	public List list_ordinate,list_cottura,list_pronte;
	private static Clip clip;
	private Text text;
	Button btnChiudiPizzeria;
	public static void main(String[] args) {
		try {
			Main window = new Main();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
		
		
	public void playClip() { 
		  clip.setFramePosition(0); // Riavvolgi il suono.
		  clip.start();     // Esegui il suono.
		}
	public void stopClip(){
		if (clip.isRunning())
		      clip.stop();   // Ferma il suono se è ancora in esecuzione.
	}
	public void open() {
		  try {
		      // Usa URL (invece di File) per leggere dal disco.
		      File fileSuono = new File("apertura.wav");
		      // Crea uno stream d'input audio dal file del suono.
		      AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(fileSuono);
		      // Ottieni il clip.
		      clip = AudioSystem.getClip();
		     // Apri l'audio del clip.
		     clip.open(audioInputStream);
		  } catch (UnsupportedAudioFileException e) {
		     e.printStackTrace();
		  } catch (IOException e) {
		    e.printStackTrace();
		  } catch (LineUnavailableException e) {
		    e.printStackTrace();
		  }
		/*https://www.websequencediagrams.com/?lz=dGl0bGUgUGl6emVyaWEKCmludGVyZmFjY2lhLT5MaXN0YTpBcHJlIGxpc3RhABAOUGl6emFpb2xvOlRocmVhZCBwAAkIADgOKwBBBgAZBUluAE8FKCkKbm90ZSBsZWZ0IG9mIABjBgBICSBpbiBhdHRlc2EKAH4FLQCBAwggbm90aWZ5QWxsKCkAFAcAfAtyZXR1cm4AgQEGCgCBFQktAIEeDABQBiBwcmVwYXJhABoRAIEfDSBwcm9udGEoAIFSBQBnCACCDQgAdhMtAHoQCgCCQA91dGVudGU6YXJyaXZvIGNsaWVudGUsdACCNwYAFwYAggkOAIMCCzpwcmVtbyBzdQAJDAoKAE0GAIMiCG9yZGluZQCDEwUAgS4IAIJiBXJpZ2gAgl0LIHZlZGUgc2UgYyfDqCB1bgCCAQcsAIJeFQCBVRQAgUIHAIFfBw&s=napkin*/
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 400);
		shell.setText("Pizzzzeria Mammma mia");
		Main m = this;
		lista  = new Lista(m);
		
		text = new Text(shell, SWT.CENTER);
		text.setForeground(SWTResourceManager.getColor(SWT.COLOR_WIDGET_FOREGROUND));
		text.setEnabled(false);
		text.setEditable(false);
		text.setBounds(178, 41, 90, 21);
		
		
		
		Button btnApriPizzeria = new Button(shell, SWT.NONE);
		btnApriPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				btnChiudiPizzeria.setEnabled(true);
				text.setText(" ");
				playClip();
				stopClip();
				controllo = 1;
				Pizzaiolo1 p1= new Pizzaiolo1(lista,m);
				Thread thp1 = new Thread(p1);
				Pizzaiolo1 p2= new Pizzaiolo1(lista,m);
				Thread thp2 = new Thread(p2);
				
				thp1.start();
				thp2.start();
			}
		});

		btnApriPizzeria.setBounds(10, 10, 75, 25);
		btnApriPizzeria.setText("Apri Pizzeria");
		
		Button btnChiudiPizzeria = new Button(shell, SWT.NONE);
		btnChiudiPizzeria.setEnabled(false);
		btnChiudiPizzeria.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				controllo = 0;
				text.setText("Pizzeria Chiusa");
				if( controllo == 0 ){
					
					
				}
			}
		});
		btnChiudiPizzeria.setBounds(178, 10, 90, 25);
		btnChiudiPizzeria.setText("Chiudi Pizzeria");
		
		Button btnArrivaCliente = new Button(shell, SWT.NONE);
		btnArrivaCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//aprire interfaccia cliente
				if(controllo!=0){
					InterfacciaCliente iu = new InterfacciaCliente(m,lista);
					iu.open();
				}else{
					JOptionPane.showMessageDialog(null, "La pizzeria non è aperta", "Warning",
					        JOptionPane.WARNING_MESSAGE);
				  
				}
			}
		});
		btnArrivaCliente.setBounds(349, 10, 75, 25);
		btnArrivaCliente.setText("Arriva Cliente");
		
		ProgressBar progressBar1 = new ProgressBar(shell, SWT.NONE);
		progressBar1.setBounds(10, 235, 170, 17);
		
		Label lblPrimoPizzaiolo = new Label(shell, SWT.NONE);
		lblPrimoPizzaiolo.setBounds(50, 214, 96, 15);
		lblPrimoPizzaiolo.setText("Primo Pizzaiolo");
		
		ProgressBar progressBar2 = new ProgressBar(shell, SWT.NONE);
		progressBar2.setBounds(254, 235, 170, 17);
		
		Label lblSecondoPizzaiolo = new Label(shell, SWT.NONE);
		lblSecondoPizzaiolo.setBounds(289, 214, 96, 15);
		lblSecondoPizzaiolo.setText("Secondo Pizzaiolo");
		
		
		list_ordinate = new List(shell, SWT.BORDER);
		list_ordinate.setBounds(10, 95, 90, 80);
		
		
		list_cottura = new List(shell, SWT.BORDER);
		list_cottura.setBounds(178, 95, 90, 80);
		
		list_pronte = new List(shell, SWT.BORDER);
		list_pronte.setBounds(337, 95, 90, 80);
		
		Label lblPizzeOrdinate = new Label(shell, SWT.NONE);
		lblPizzeOrdinate.setAlignment(SWT.CENTER);
		lblPizzeOrdinate.setBounds(10, 74, 90, 15);
		lblPizzeOrdinate.setText("Pizze ordinate");
		
		Label lblPizzeInCottura = new Label(shell, SWT.NONE);
		lblPizzeInCottura.setAlignment(SWT.CENTER);
		lblPizzeInCottura.setBounds(178, 74, 90, 15);
		lblPizzeInCottura.setText("Pizze in cottura");
		
		Label lblPizzePronte = new Label(shell, SWT.NONE);
		lblPizzePronte.setAlignment(SWT.CENTER);
		lblPizzePronte.setBounds(337, 74, 90, 15);
		lblPizzePronte.setText("Pizze Pronte");
		
		
		
		

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}
	
	public void aggiungi(String pizza){
		Display.getDefault().asyncExec(new Runnable(){
			public void run(){
				list_ordinate.add(pizza);
			}
		});
	}
	public void aggiungi_cottura(String pizza){
		Display.getDefault().asyncExec(new Runnable(){
			public void run(){
				list_cottura.add(pizza);
				//list_ordinate.remove(list_ordinate.getItemCount());
			}
		});
	}
}
