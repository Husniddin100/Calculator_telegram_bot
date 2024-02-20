package org.example.controller;


import org.example.MyTelegramBot;
import org.example.util.InlineKeyBoardUtil;
import org.example.util.MathUtil;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.User;

import java.util.HashMap;
import java.util.Map;

public class CallBackController {

    private MyTelegramBot myTelegramBot;
    private MainController mainController;


    public CallBackController(MainController mainController) {
        this.mainController = mainController;

    }
    public CallBackController(MyTelegramBot myTelegramBot) {
        this.myTelegramBot = myTelegramBot;

    }

    public static Map<Long, StringBuilder> map = new HashMap<>();


    public void handle(String text, Message message, User user) {

        EditMessageText editMessageText = new EditMessageText();
        editMessageText.setChatId(message.getChatId());
        editMessageText.setMessageId(message.getMessageId());


        StringBuilder command;
        if (map.containsKey(user.getId())) {
            command = map.get(user.getId());
        } else {
            command = new StringBuilder();
            map.put(user.getId(), command);
        }

        if (text.equals("=")) {
            Integer result = MathUtil.calculate(command.toString());
            command.append(text);
            command.append(result);
            editMessageText.setText(command.toString());
            map.put(user.getId(), new StringBuilder());
        } else {
            command.append(text);
            editMessageText.setText(command.toString());
        }
        editMessageText.setReplyMarkup(InlineKeyBoardUtil.getMenuKeyboard());
        myTelegramBot.sendMsg(editMessageText);
    }

}
