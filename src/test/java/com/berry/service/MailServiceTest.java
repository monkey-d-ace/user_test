package com.berry.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.thymeleaf.ITemplateEngine;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MailServiceTest {
    @Autowired
    private MailService mailService;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void testSimpleMail() throws Exception {
        mailService.sendSimpleMail("wangfengshu805@berrygenomics.com", "这是一封简单邮件", "大家好这是我的第一封邮件！");
    }

    @Test
    public void testHtmlMail() throws Exception {
        String stringBuffer = "<html>" + "\n" +
                "<body>" + "\n" +
                "<h3>hello world ! 这是一封html邮件！</h3>" +
                "\n" +
                "</body>" + "\n" +
                "</html>";
        mailService.sendHtmlMail("wangfengshu805@berrygenomics.com", "这是一封HTML邮件", stringBuffer);
    }

    @Test
    public void sendAttachmentsMail() {
        String filePath = "/home/luffy/text.xlsx";
        mailService.sendAttachmentsMail("wangfengshu805@berrygenomics.com", "主题：带附件的邮件", "有附件，请查收！", filePath);
    }

    @Test
    public void sendInlineResourceMail() {
        String rscId = "neo006";
        String content = "<html><body>这是有图片的邮件: <img src=\'cid:>" + rscId + "\'></body></html>";
        String imgPath = "/home/luffy/image.png";
        mailService.sendInlineResourceMail("wangfengshu805@berrygenomics.com", "主题：这是有图片的邮件", content, rscId, imgPath);
    }

    @Test
    public void sendTemplateMail() {
        Context context = new Context();
        context.setVariable("id", "006");
        String emailContent = templateEngine.process("emailTemplate", context);
        mailService.sendHtmlMail("wangfengshu805@berrygenomics.com", "主题：这是模板邮件", emailContent);
    }
}
