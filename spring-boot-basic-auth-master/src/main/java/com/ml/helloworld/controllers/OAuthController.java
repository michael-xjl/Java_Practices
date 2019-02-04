package com.ml.helloworld.controllers;

/**
 * @author Michael Liu
 */

import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.util.UidGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.net.SocketException;

@RestController
public class OAuthController
{

  @RequestMapping(value = "/oauth2/", method = RequestMethod.GET)
  public ResponseEntity<String> listAllUsers() {
    return new ResponseEntity<String>("Yeah you get it", HttpStatus.OK);
  }

  @RequestMapping(value = "/oauth2/ical", method = RequestMethod.GET)
  public ResponseEntity<String> getIcal() {
    java.util.Calendar calendar = java.util.Calendar.getInstance();
    calendar.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
    calendar.set(java.util.Calendar.DAY_OF_MONTH, 25);

    // initialise as an all-day event..
    VEvent christmas = new VEvent(new Date(calendar.getTime()), "Christmas Day to "  + " oauth2 " + System.currentTimeMillis());

    // Generate a UID for the event..
    UidGenerator ug = null;
    try
    {
      ug = new UidGenerator("1");
    }
    catch (SocketException e)
    {
      e.printStackTrace();
    }
    christmas.getProperties().add(ug.generateUid());

    net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
    cal.getComponents().add(christmas);

    return new ResponseEntity<String>(cal.toString(), HttpStatus.OK);
  }

}
