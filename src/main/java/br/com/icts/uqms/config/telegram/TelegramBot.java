package br.com.icts.uqms.config.telegram;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component
public class TelegramBot extends TelegramLongPollingBot {
    private SendMessage response = new SendMessage();
    private Long chatId = new Long("-1001437064714");

    @Override
    public void onUpdateReceived(Update update) {
        if(update.hasMessage()) {
			Message message = update.getMessage();
			SendMessage response = new SendMessage();
			Long chatId = message.getChatId();
			response.setChatId(chatId);
			String text = message.getText();
			response.setText(text);
			try {
				execute(response);
			} catch (TelegramApiException e) {
			}
		}
    }

    @Override
    public String getBotUsername() {
        return "sfhie_bot";
    }

    @Override
    public String getBotToken() {
        return "1091844225:AAG0bkGyegpz-j8RihTYAVHDcFnEFX2dPcM";
    }

    public void sendMessage(String message) {
        this.response.setChatId(this.chatId);
        this.response.setText(message);
        try {
            execute(this.response);
        } catch (TelegramApiException e) {
        }
    }

    @PostConstruct
    public void start() {}
}