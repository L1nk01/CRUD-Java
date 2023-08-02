package empleados_crud;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * Este archivo contiene una clase que proporciona métodos para trabajar con fechas con la librería JDateChooser
 * para su uso con bases de datos.
 * 
 * @author Emmanuel Campos 2022-1855
 */

public class MetodosFechas {
    /**
     * Obtiene la fecha de un JDateChooser y la devuelve como un objeto java.sql.Date
     * para poder agregarlo a un registro de base de datos.
     * 
     * @param selectorFecha El JDateChooser del cual se quiere obtener la fecha
     * @return La fecha seleccionada como un objeto java.sql.Date, o null si no hay fecha seleccionada.
     */
    public Date getFecha(JDateChooser selectorFecha) {
        java.util.Date fecha = selectorFecha.getDate();
        if (fecha != null) {
            long fechaEpoch = fecha.getTime();
            return new Date(fechaEpoch);
        }
        return null;
    }
    
    /**
     * Convierte una cadena de fecha en formato String "yyyy-MM-dd" en un objeto java.util.Date
     * 
     * @param input La fecha en forma de String que se quiere convertir a java.util.Date
     * @return Objeto java.util.date representando la fecha si la conversión exitosa o null si hay un error de formato.
     */
    public java.util.Date convertStringToDate(String input) {
        String dateFormat = "yyyy-MM-dd";
        
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        
        try
        {
            java.util.Date date = sdf.parse(input);
            return date;
        }
        catch (ParseException e)
        {
            System.out.println("Error convirtiendo el String: " + e);
            return null;
        }
    }
}
