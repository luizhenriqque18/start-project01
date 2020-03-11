package br.com.icts.uqms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.telegram.telegrambots.ApiContextInitializer;
import br.com.icts.uqms.config.telegram.TelegramBot;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableSwagger2
public class UqmsApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(UqmsApplication.class, args);
		
		TelegramBot bot = new TelegramBot();
		bot.sendMessage("I am a bot!");
	}

}
