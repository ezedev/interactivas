package ventanas;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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

}
