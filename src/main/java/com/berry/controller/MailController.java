package com.berry.controller;

import com.berry.component.MailResult;
import com.berry.service.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MailController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private MailService mailService;

    @RequestMapping("/sendSimpleMail")
    public MailResult sendSimpleMail(String to, String subject, String content) {
        MailResult mailResult = new MailResult();
        if (StringUtils.isEmpty(to) || !to.contains("@")) {
            mailResult.setRspCode("01");
            mailResult.setRspMsg("邮件格式不正确");
        }
        if (StringUtils.isEmpty(content)) {
            mailResult.setRspCode("03");
            mailResult.setRspMsg("邮件正文不能为空！");
        }
        try {
            mailService.sendSimpleMail(to, subject, content);
            logger.info("简单邮件已发送，");
        } catch (Exception e) {
            mailResult.setRspCode("04");
            mailResult.setRspMsg("邮件发送出现异常");
            logger.error("sendSimpleMail Exception ", e);
        }
        return mailResult;
    }
}
