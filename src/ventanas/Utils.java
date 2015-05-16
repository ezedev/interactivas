package ventanas;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Utils {

	public static Color COLOR_VERDE_CELDA = new Color(204, 255, 153);

	public static Color COLOR_ROJO_CELDA = new Color(255, 204, 153);

	public static String getFechaSalida() {
		
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 1);
		SimpleDateFormat format1 = new SimpleDateFormat("dd/MM/yyyy");

		return format1.format(cal.getTime());
	}

}
