package com.question.community;

import com.question.community.util.MailClient;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@SpringBootTest
public class MailTest {

    @Autowired
    private MailClient mailClient;

    @Autowired
    private TemplateEngine templateEngine;

    @Test
    public void mailTextTest(){
        mailClient.sendMail("425854220@qq.com","TEST","test-test");
    }

    @Test
    public void mailHtmlTest(){
        Context context = new Context();
        context.setVariable("username","yyds");

        String content = templateEngine.process("/mail/demo", context);
        System.out.println(content);

        mailClient.sendMail("425854220@qq.com","html",content);
    }

}
