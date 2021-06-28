package com.example.demo.service;

import com.example.demo.dao.MailDao;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Call;
import com.twilio.type.PhoneNumber;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.*;
import java.io.IOException;
import java.net.URI;
import java.util.Date;
import java.util.Properties;

@Service
public class SendEmail implements MailDao {

    private final static String ACCOUNT_SID = "ACf4626eacde5db8ec235a924f65c1d229";
    private final static String AUTH_TOKEN = "57b9af0a6e35494a4608c4470d12da71";

    static {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
    }

    @Override
    public String sendMail() {

        try {
            return sendmail();
        } catch (MessagingException e) {
            e.printStackTrace();
            return "Cannot send mail";
        } catch (IOException e) {
            e.printStackTrace();
            return "Cannot send mail";
        }
    }

    @Override
    public String sendSms() {
        return sendsms();
    }

    @Override
    public String makeCall() {
        return makecall();
    }

    public String sendmail() throws AddressException, MessagingException, IOException{
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuth(){
                return new PasswordAuthentication("yukenautodev@gmail.com", "bestofkings");
            }
        });

        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress("yukenautodev@gmail.com", false));

        //send mail with text only
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("oladapoyuken59@gmail.com"));
        msg.setSubject("Yuken Automation SpringBoot");
        msg.setContent("I'm Oladapo Yusuf AKA Yuken, the founder of Yuken Automation", "text/html");
        msg.setSentDate(new Date());

        //send mail with attachment
        MimeBodyPart mbp = new MimeBodyPart();
        mbp.setContent("Yuken Automation mail", "text/html");
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(mbp);
        MimeBodyPart attachPart = new MimeBodyPart();

        String path = System.getProperty("user.dir") + "\\Uploads\\boy.png";

        attachPart.attachFile(path);
        multipart.addBodyPart(attachPart);
//        msg.setContent(multipart);
        Transport.send(msg, "yukenautodev@gmail.com", "bestofkings");

        return "Email sent Successfully";
    }

    public String sendsms(){
        try{
            com.twilio.rest.api.v2010.account.Message.creator(
                    new PhoneNumber("+2348161183988"),
                    new PhoneNumber("+12407633585"),
                    "Hello from springboot"
            ).create();

            return "SMS sent successfully";
        }
        catch (Exception e){
            return "Sorry, cannot send SMS";
        }
    }

    public String makecall(){
        try{
            Call call = Call.creator(
                    new PhoneNumber("+2348161183988"),
                    new PhoneNumber("+12407633585"),
                    new URI("http://demo.twilio.com/docs/voice.xml")
            ).create();

            return "Calling..."+ call.getSid();
        }
        catch (Exception e){
            e.printStackTrace();
            return e.getLocalizedMessage();
        }
    }
}
