package org.example.util;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.LinkedList;
import java.util.List;

public class InlineKeyBoardUtil {
    public static InlineKeyboardButton button(String text, String callBack) {
        InlineKeyboardButton button = new InlineKeyboardButton(text);
        button.setCallbackData(callBack);
        return button;
    }

    public static InlineKeyboardMarkup getMenuKeyboard() {
        InlineKeyboardButton button1 = InlineKeyBoardUtil.button("7", "7");
        InlineKeyboardButton button2 = InlineKeyBoardUtil.button("8", "8");
        InlineKeyboardButton button3 = InlineKeyBoardUtil.button("9", "9");
        InlineKeyboardButton button4 = InlineKeyBoardUtil.button("/", "/");

        List<InlineKeyboardButton> row1 = new LinkedList<>();
        row1.add(button1);
        row1.add(button2);
        row1.add(button3);
        row1.add(button4);

        InlineKeyboardButton button5 = InlineKeyBoardUtil.button("4", "4");
        InlineKeyboardButton button6 = InlineKeyBoardUtil.button("5", "5");
        InlineKeyboardButton button7 = InlineKeyBoardUtil.button("6", "6");
        InlineKeyboardButton button8 = InlineKeyBoardUtil.button("*", "*");
        List<InlineKeyboardButton> row2 = new LinkedList<>();

        row2.add(button5);
        row2.add(button6);
        row2.add(button7);
        row2.add(button8);

        List<InlineKeyboardButton> row3 = new LinkedList<>();
        InlineKeyboardButton button9 = InlineKeyBoardUtil.button("1", "1");
        InlineKeyboardButton button10 = InlineKeyBoardUtil.button("2", "2");
        InlineKeyboardButton button11 = InlineKeyBoardUtil.button("3", "3");
        InlineKeyboardButton button12 = InlineKeyBoardUtil.button("-", "-");

        row3.add(button9);
        row3.add(button10);
        row3.add(button11);
        row3.add(button12);
        List<InlineKeyboardButton> row4 = new LinkedList<>();

        InlineKeyboardButton button13 = InlineKeyBoardUtil.button("0", "0");
        InlineKeyboardButton button14 = InlineKeyBoardUtil.button("=", "=");
        InlineKeyboardButton button15 = InlineKeyBoardUtil.button("+", "+");
        row4.add(button13);
        row4.add(button14);
        row4.add(button15);

        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
        List<List<InlineKeyboardButton>> rowList = new LinkedList<>();

        rowList.add(row1);
        rowList.add(row2);
        rowList.add(row3);
        rowList.add(row4);

        inlineKeyboardMarkup.setKeyboard(rowList);
        return inlineKeyboardMarkup;
    }
}
