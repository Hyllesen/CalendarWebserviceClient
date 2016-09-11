/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author stefan
 */
public class CalendarTest {
    
    public CalendarTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    
    @Test
    public void addAppointmentTest() {
        try {
            DatatypeFactory df = DatatypeFactory.newInstance();
            XMLGregorianCalendar date = df.newXMLGregorianCalendar("2016-09-15");
            addAppointment(date, "Scrub toilets");
            assertEquals("Scrub toilets", getAppointment(date));
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(CalendarTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private static void addAppointment(javax.xml.datatype.XMLGregorianCalendar appointmentDate, java.lang.String appointmentText) {
        calendarclient.CalendarService service = new calendarclient.CalendarService();
        calendarclient.CalendarServicePortType port = service.getCalendarServicePortTypeBindingPort();
        port.addAppointment(appointmentDate, appointmentText);
    }

    private static String getAppointment(javax.xml.datatype.XMLGregorianCalendar dateInput) {
        calendarclient.CalendarService service = new calendarclient.CalendarService();
        calendarclient.CalendarServicePortType port = service.getCalendarServicePortTypeBindingPort();
        return port.getAppointment(dateInput);
    }

}
