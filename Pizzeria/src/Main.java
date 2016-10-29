import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		/*https://www.websequencediagrams.com/?lz=dGl0bGUgUGl6emVyaWEKCmludGVyZmFjY2lhLT5MaXN0YTpBcHJlIGxpc3RhABAOUGl6emFpb2xvOlRocmVhZCBwAAkIADgOKwBBBgAZBUluAE8FKCkKbm90ZSBsZWZ0IG9mIABjBgBICSBpbiBhdHRlc2EKAH4FLQCBAwggbm90aWZ5QWxsKCkAFAcAfAtyZXR1cm4AgQEGCgCBFQktAIEeDABQBiBwcmVwYXJhABoRAIEfDSBwcm9udGEoAIFSBQBnCACCDQgAdhMtAHoQCgCCQA91dGVudGU6YXJyaXZvIGNsaWVudGUsdACCNwYAFwYAggkOAIMCCzpwcmVtbyBzdQAJDAoKAE0GAIMiCG9yZGluZQCDEwUAgS4IAIJiBXJpZ2gAgl0LIHZlZGUgc2UgYyfDqCB1bgCCAQcsAIJeFQCBVRQAgUIHAIFfBw&s=napkin*/
		
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 400);
		shell.setText("SWT Application");
		
		Button btnApriPizzeria = new Button(shell, SWT.NONE);

		btnApriPizzeria.setBounds(96, 10, 75, 25);
		btnApriPizzeria.setText("Apri Pizzeria");
		
		Button btnArrivaCliente = new Button(shell, SWT.NONE);
		btnArrivaCliente.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
				//aprire interfaccia cliente
			}
		});
		btnArrivaCliente.setBounds(266, 10, 75, 25);
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
		
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(10, 95, 90, 80);
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setBounds(178, 95, 90, 80);
		
		List list_2 = new List(shell, SWT.BORDER);
		list_2.setBounds(337, 95, 90, 80);
		
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
}
