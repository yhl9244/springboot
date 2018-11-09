package com.example.springbootjms;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.io.File;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootJmsApplicationTests {

	@Test
	public void contextLoads() {
	}

	@Autowired
	private JavaMailSenderImpl javaMailSender;

	/**
	 *  发送文本文件
	 */
	@Test
	public void sendTextMail() {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		// 设置收件人，寄件人
		simpleMailMessage.setTo(new String[] {"yuanbhuiliang@163.com"});
		simpleMailMessage.setFrom("yuanbhuiliang@163.com");
		simpleMailMessage.setSubject("Spring Boot Mail 邮件测试【文本】");
		simpleMailMessage.setText("这里是一段简单文本。");
		// 发送邮件
		javaMailSender.send(simpleMailMessage);

		System.out.print("邮件已发送!");
	}

	/**
	 * 发送包含HTML文本的邮件
	 */
	@Test
	public void sendHtmlMail() throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
		// 设置收件人，寄件人
		mimeMessageHelper.setTo(new String[] {"yuanbhuiliang@163.com"});
		mimeMessageHelper.setFrom("yuanbhuiliang@163.com");
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【HTML】");

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
		sb.append("</html>");

		mimeMessageHelper.setText(sb.toString(), true);

		javaMailSender.send(mimeMessage);

		System.out.print("邮件已发送!");
	}

	/**
	 * 发送包含内嵌图片的邮件
	 * @throws Exception
	 */
	@Test
	public void sendAttachedImageMail() throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		// multipart模式
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
		mimeMessageHelper.setTo(new String[] {"yuanbhuiliang@163.com"});
		mimeMessageHelper.setFrom("yuanbhuiliang@163.com");
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【图片】");

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p>");
		// cid为固定写法，imageId指定一个标识
		sb.append("<img src=\"cid:imageId\"/></body>");
		sb.append("</html>");

		// 启用html
		mimeMessageHelper.setText(sb.toString(), true);

		// 设置imageId
		FileSystemResource img = new FileSystemResource(new File("E:/212.jpg"));
		mimeMessageHelper.addInline("imageId", img);

		// 发送邮件
		javaMailSender.send(mimeMessage);

		System.out.println("邮件已发送");
	}

	/**
	 * 发送包含附件的邮件
	 * @throws Exception
	 */
	@Test
	public void sendAttendedFileMail() throws Exception {
		MimeMessage mimeMessage = javaMailSender.createMimeMessage();
		// multipart模式
		MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true, "utf-8");
		mimeMessageHelper.setTo(new String[] {"yuanbhuiliang@163.com"});
		mimeMessageHelper.setFrom("yuanbhuiliang@163.com");
		mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【附件】");

		StringBuilder sb = new StringBuilder();
		sb.append("<html><head></head>");
		sb.append("<body><h1>spring 邮件测试</h1><p>hello!this is spring mail test。</p></body>");
		sb.append("</html>");

		// 启用html
		mimeMessageHelper.setText(sb.toString(), true);
		// 设置附件
		FileSystemResource img = new FileSystemResource(new File("E:/212.jpg"));
		mimeMessageHelper.addAttachment("image.jpg", img);

		// 发送邮件
		javaMailSender.send(mimeMessage);

		System.out.println("邮件已发送");
	}

}
