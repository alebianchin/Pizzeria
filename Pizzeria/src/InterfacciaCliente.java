import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;

import java.util.ArrayList;

import javax.swing.JFrame;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Canvas;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class InterfacciaCliente {
	private Text text;
	private Text text_1;
	private String nome;
	private Lista l;
	private Main m;
	
	//private ArrayList<Lista> l = new ArrayList();
	
	/**
	 * Launch the application.
	 * @param args
	 */
	/*public static void main(String[] args) {
		try {
			InterfacciaCliente window = new InterfacciaCliente(null);
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/

	public InterfacciaCliente(Main m2, Lista lista) {
		this.m = m2;
		l = lista;
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display d = Display.getDefault();
		Shell shell = new Shell();
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(250, 300);
		shell.setText("SWT Application");
		
		text = new Text(shell, SWT.BORDER);
		text.setBounds(10, 176, 214, 45);
		
		text_1 = new Text(shell, SWT.BORDER);
		text_1.setBounds(73, 10, 89, 21);
		
		Label lblInsNome = new Label(shell, SWT.NONE);
		lblInsNome.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblInsNome.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		lblInsNome.setBounds(10, 13, 55, 15);
		lblInsNome.setText("Ins. nome:");
		
		Label lblNewLabel = new Label(shell, SWT.NONE);
		lblNewLabel.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		lblNewLabel.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		lblNewLabel.setAlignment(SWT.CENTER);
		lblNewLabel.setBounds(90, 150, 55, 15);
		lblNewLabel.setText("Nome pizza");
		
		Canvas canvas = new Canvas(shell, SWT.NONE);
		canvas.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		canvas.setBounds(85, 60, 64, 64);
		

		
		Button btnConferma = new Button(shell, SWT.NONE);
		btnConferma.setFont(SWTResourceManager.getFont("MS Sans Serif", 9, SWT.NORMAL));
		btnConferma.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				nome = text.getText();
				l.aggiungiPizza(nome);
				shell.close();
				//m.aggiungi(nome);
				//m.lista.pizzeInLista();
			}
		});
		btnConferma.setBounds(73, 227, 89, 25);
		btnConferma.setText("Conferma!");

		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!d.readAndDispatch()) {
				d.sleep();
			}
		}
		
	}
}
