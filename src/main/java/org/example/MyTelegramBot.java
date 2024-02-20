package org.example;


import org.example.controller.CallBackController;
import org.example.controller.MainController;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.*;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.BotOptions;
import org.telegram.telegrambots.meta.generics.LongPollingBot;


public class MyTelegramBot extends TelegramLongPollingBot {
    private MainController mainController = new MainController();

    private CallBackController callBackController;

    public MyTelegramBot() {
        callBackController = new CallBackController(this);
    }

     @Override
     public void onUpdateReceived(Update update) {
         try {
             if (update.hasMessage()) {
                 Message message = update.getMessage();
                 SendMessage sendMessage = mainController.handle(message.getText(), message);
                 sendMsg(sendMessage);
             } else if (update.hasCallbackQuery()) {
                 CallbackQuery callbackQuery = update.getCallbackQuery();
                 String data = callbackQuery.getData();
                 User user = callbackQuery.getFrom();
                 Message message = callbackQuery.getMessage();
                 callBackController.handle(data,message,user);
             }
         } catch (RuntimeException e) {
             e.printStackTrace();
         }
     }

    public void sendMsg(EditMessageText editMessageText) {
        try {
            execute(editMessageText);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }


    public void sendMsg(SendMessage sendMessage) {
        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String getBotUsername() {
        return "Calculator_java_bot";
    }

    @Override
    public String getBotToken() {
        return "7151749928:AAFjcfNnEmneAlBHJ8Ly2xavlPfCiUr9-lI";
    }
}
