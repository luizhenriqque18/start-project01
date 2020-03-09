package br.com.icts.uqms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;
import br.com.icts.uqms.config.TelegramBot;

@SpringBootApplication
public class UqmsApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(UqmsApplication.class, args);
		
		TelegramBot bot = new TelegramBot();
		bot.sendMessage("I am a bot!");
	}

}
