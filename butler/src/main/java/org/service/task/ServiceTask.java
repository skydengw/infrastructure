package org.service.task;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ServiceTask {
	Logger log = LoggerFactory.getLogger(ServiceTask.class);

	@Scheduled(cron = "0/10 * * * * ?")
	public void SpringTask() {
		log.error("假装有个错 十秒执行一次 五次满了就发送哦");
	}

	public void Test163() {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.qiye.163.com");
		senderImpl.setProtocol("smtp");
		senderImpl.setPort(25);
		senderImpl.setUsername("你的邮箱名");
		senderImpl.setPassword("你的邮箱密码");
		senderImpl.setDefaultEncoding("UTF-8");

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.timeout", 2500);
		senderImpl.setJavaMailProperties(properties);

		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(senderImpl.getUsername());
		smm.setTo("*******@qq.com");
		smm.setSubject("163邮箱测试");
		smm.setText("这是通过163邮箱发送的邮件");
		senderImpl.send(smm);
	}

	public void TestQQ() {
		JavaMailSenderImpl senderImpl = new JavaMailSenderImpl();
		senderImpl.setHost("smtp.qq.com");
		senderImpl.setProtocol("smtps");
		senderImpl.setPort(465);
		senderImpl.setUsername("你的邮箱名");
		senderImpl.setPassword("你的邮箱密码");
		senderImpl.setDefaultEncoding("UTF-8");

		Properties properties = new Properties();
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
		properties.put("mail.smtp.timeout", 2500);
		properties.put("mail.smtp.starttls.enable", true);
		senderImpl.setJavaMailProperties(properties);

		SimpleMailMessage smm = new SimpleMailMessage();
		smm.setFrom(senderImpl.getUsername());
		smm.setTo(new String[] { "**********@qq.com" });
		smm.setSubject("QQ邮箱测试");
		smm.setText("这是通过QQ邮箱发送的邮件");
		senderImpl.send(smm);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 1; i++) {
			//new ServiceTask().Test163();
			new ServiceTask().TestQQ();
		}
	}
}
