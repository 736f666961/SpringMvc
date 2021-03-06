package ma.youcode.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailServiceImpl implements MailService {

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendSimpleMessage(String to, String subject, String text) {
        try {
        	SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setTo(to);
            simpleMailMessage.setSubject(subject);
            simpleMailMessage.setText(text);

            javaMailSender.send(simpleMailMessage);
            
		} catch (Exception e) {
			System.out.println("Error: " + e.getMessage());
		}
    }

}
