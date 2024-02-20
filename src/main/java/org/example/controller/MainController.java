package org.example.controller;

import org.example.util.InlineKeyBoardUtil;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

public class MainController {

    public SendMessage handle(String text, Message message) {
        User user = message.getFrom();
        SendMessage sendMessage = new SendMessage();
        if (text.equals("/start")){
            sendMessage.setChatId(user.getId());
            sendMessage.setText("Salom " +
                    "Calculatordan foydalanmoqchi bolsangiz /calculator ni bosing");
            return sendMessage;
        }
        if (text.equals("/calculator")) {
            sendMessage.setChatId(user.getId());
            sendMessage.setText("Salom. Xush kelibsiz");
            sendMessage.setReplyMarkup(InlineKeyBoardUtil.getMenuKeyboard());
            CallBackController.map.remove(message.getChatId());
            return sendMessage;
        }
        sendMessage.setChatId(user.getId());
        sendMessage.setText("STARTNI BOSING");
        return sendMessage;
    }
}
