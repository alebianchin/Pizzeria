import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.ProgressBar;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.List;

public class Main {

	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		Display display = Display.getDefault();
		Shell shell = new Shell();
		shell.setSize(450, 300);
		shell.setText("SWT Application");
		
		Button btnApriPizzeria = new Button(shell, SWT.NONE);
		btnApriPizzeria.setBounds(10, 10, 75, 25);
		btnApriPizzeria.setText("Apri Pizzeria");
		
		Button btnArrivaCliente = new Button(shell, SWT.NONE);
		btnArrivaCliente.setBounds(209, 10, 75, 25);
		btnArrivaCliente.setText("Arriva Cliente");
		
		ProgressBar progressBar1 = new ProgressBar(shell, SWT.NONE);
		progressBar1.setBounds(10, 235, 170, 17);
		
		Label lblPrimoPizzaiolo = new Label(shell, SWT.NONE);
		lblPrimoPizzaiolo.setBounds(10, 214, 96, 15);
		lblPrimoPizzaiolo.setText("Primo Pizzaiolo");
		
		ProgressBar progressBar2 = new ProgressBar(shell, SWT.NONE);
		progressBar2.setBounds(254, 235, 170, 17);
		
		Label lblSecondoPizzaiolo = new Label(shell, SWT.NONE);
		lblSecondoPizzaiolo.setBounds(328, 214, 96, 15);
		lblSecondoPizzaiolo.setText("Secondo Pizzaiolo");
		
		List list = new List(shell, SWT.BORDER);
		list.setBounds(14, 95, 71, 68);
		
		List list_1 = new List(shell, SWT.BORDER);
		list_1.setBounds(178, 95, 71, 68);
		
		List list_2 = new List(shell, SWT.BORDER);
		list_2.setBounds(353, 95, 71, 68);
		
		Label lblPizzeOrdinate = new Label(shell, SWT.NONE);
		lblPizzeOrdinate.setBounds(10, 74, 75, 15);
		lblPizzeOrdinate.setText("Pizze ordinate");
		
		Label lblPizzeInCottura = new Label(shell, SWT.NONE);
		lblPizzeInCottura.setBounds(178, 74, 90, 15);
		lblPizzeInCottura.setText("Pizze in cottura");
		
		Label lblPizzePronte = new Label(shell, SWT.NONE);
		lblPizzePronte.setBounds(353, 74, 55, 15);
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
