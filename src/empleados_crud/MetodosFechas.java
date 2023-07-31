/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package empleados_crud;

import com.toedter.calendar.JDateChooser;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author ecpau
 */
public class MetodosFechas {
    public Date getFecha(JDateChooser selectorFecha) {
        java.util.Date fecha = selectorFecha.getDate();
        if (fecha != null) {
            long fechaEpoch = fecha.getTime();
            return new Date(fechaEpoch);
        }
        return null;
    }
    
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
