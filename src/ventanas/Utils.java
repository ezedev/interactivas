package ventanas;

import java.awt.Color;
import java.awt.Component;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JOptionPane;

public class Utils {

	public static Color COLOR_VERDE_CELDA = new Color(204, 255, 153);
	public static Color COLOR_ROJO_CELDA = new Color(255, 204, 153);

	public static String getFechaSalidaString() {

		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");
		return format1.format(getFechaSalida());
	}

	public static Date getFechaSalida() {

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.DATE, 1);
		calendar.set(Calendar.HOUR, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTime();
	}

	public static boolean fechaValida(String fecha) {
		Date date = Utils.parseFecha(fecha);
		return date != null;
	}

	public static Date parseFecha(String fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setLenient(false);
		try {
			Date date = sdf.parse(fecha);
			return date;
		} catch (ParseException e) {
			return null;
		}
	}

	public static String parseFecha(Date fecha) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		return sdf.format(fecha);
	}

	public static void mostrarError(Component parent, String mensaje) {
		JOptionPane.showMessageDialog(parent, mensaje, "Error",
				JOptionPane.ERROR_MESSAGE);
	}

	public static boolean numeroValido(String numero) {
		try {
			Integer.parseInt(numero);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}

}
