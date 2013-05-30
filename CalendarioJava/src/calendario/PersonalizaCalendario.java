package calendario;import java.awt.Color;import java.awt.Component;import java.util.Calendar;import javax.swing.JTable;import javax.swing.table.DefaultTableCellRenderer;@SuppressWarnings("serial")public class PersonalizaCalendario extends DefaultTableCellRenderer {		private Color fundoPadrao = Color.WHITE;	private Color foregroundPadrao = Color.BLACK;	private Color foregroundSpecial = new Color(255, 137, 0);	private Color backgroundSelected = new Color(220, 220, 220);	private Calendar diaAtual;	private FeriadosAno feriados;	private int linhaMouseUp = -1;	private int colunaMouseUp = -1;				public PersonalizaCalendario(Calendar diaAtual, FeriadosAno feriados){		this.diaAtual = diaAtual;		this.feriados = feriados;	}		@Override	public Component getTableCellRendererComponent(final JTable table, final Object value, 			final boolean isSelected, final boolean hasFocus, final int row, final int column) {			Component c =super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);		            setHorizontalAlignment(CENTER);            setBackground(fundoPadrao);            setForeground(foregroundPadrao);            int b = (getText() != "") ? Integer.parseInt(getText()) : 0;                        if(column == 0){                setForeground(foregroundSpecial);            }            if(column == colunaMouseUp && row == linhaMouseUp) {            	setBackground(foregroundSpecial);            	setForeground(Color.white);            }            if(feriados.hasFeriado(diaAtual.get(Calendar.MONTH), b)) {                setForeground(Color.red);				setToolTipText(feriados.getFeriado(diaAtual.get(Calendar.MONTH), b));            } else {            	setToolTipText(null);            }            if(diaAtual.get(Calendar.DAY_OF_MONTH) == b)            	setBackground(backgroundSelected);            return c;	}		public void mudarCorSelecionado(int linhaMouseUp, int colunaMouseUp) {		this.linhaMouseUp = linhaMouseUp;		this.colunaMouseUp = colunaMouseUp;	}}