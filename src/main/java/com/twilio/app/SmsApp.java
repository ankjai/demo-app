package com.twilio.app;

import com.twilio.sdk.verbs.Sms;
import com.twilio.sdk.verbs.TwiMLException;
import com.twilio.sdk.verbs.TwiMLResponse;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by ankit on 4/27/14.
 */
public class SmsApp extends HttpServlet {
    public void service(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String from = request.getParameter("From");

        TwiMLResponse twiml = new TwiMLResponse();

        Sms sms = new Sms("Hello from ankit!");
        sms.setTo(from);

        try {
            twiml.append(sms);
        } catch (TwiMLException e) {
            e.printStackTrace();
        }
        response.setContentType("application/xml");
        response.getWriter().print(twiml.toXML());
    }
}
