package com.ml.helloworld.controllers;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import net.fortuna.ical4j.data.CalendarOutputter;
import net.fortuna.ical4j.model.Date;
import net.fortuna.ical4j.model.ValidationException;
import net.fortuna.ical4j.model.component.VEvent;
import net.fortuna.ical4j.util.UidGenerator;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.StringWriter;
import java.net.SocketException;
import java.util.UUID;

@RestController
@RequestMapping("/ba")
@Api(value = "user", description = "Rest API for user operations", tags = "User API")
public class BathAuthICalController
{

    @RequestMapping(value = "/ical/{name}", method = RequestMethod.GET, produces = "text/plain")
    @ApiOperation(value = "Display greeting message to non-admin user", response = String.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "The resource not found")
    }
    )
    public String message(@PathVariable String name) {
        java.util.Calendar calendar = java.util.Calendar.getInstance();
        calendar.set(java.util.Calendar.MONTH, java.util.Calendar.DECEMBER);
        calendar.set(java.util.Calendar.DAY_OF_MONTH, 25);

        // initialise as an all-day event..
        VEvent christmas = new VEvent(new Date(calendar.getTime()), "Christmas Day to " + name + " " + System.currentTimeMillis());

        // Generate a UID for the event..
        UidGenerator ug = null;
        try
        {
            ug = new UidGenerator(UUID.randomUUID().toString());
        }
        catch (SocketException e)
        {
            e.printStackTrace();
        }
        christmas.getProperties().add(ug.generateUid());

        net.fortuna.ical4j.model.Calendar cal = new net.fortuna.ical4j.model.Calendar();
        cal.getComponents().add(christmas);

        System.out.println(cal);
        CalendarOutputter outputter = new CalendarOutputter();
        StringWriter sw = new StringWriter();
        try
        {
            outputter.output(cal, sw);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        catch (ValidationException e)
        {
            e.printStackTrace();
        }
        System.out.println(sw.toString());
        return cal.toString();
    }

}
