package com.afterhours.game.inventory;

import java.util.List;

public class ItemUtils {
    public static String generateListOfItems(List<Item> items) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < items.size(); i++) {
            sb.append(article(items.get(i).getItemName()));
            sb.append(", ");
        }

        return sb.toString();
    }

    private static String article(String itemName) {
        return startsWithAVowel(itemName) ? "an " + itemName : "a " + itemName;
    }

    private static boolean startsWithAVowel(String itemText) {
        return itemText.substring(0, 1).equalsIgnoreCase("a") ||
                itemText.substring(0, 1).equalsIgnoreCase("e") ||
                itemText.substring(0, 1).equalsIgnoreCase("i") ||
                itemText.substring(0, 1).equalsIgnoreCase("o") ||
                itemText.substring(0, 1).equalsIgnoreCase("u");
    }

    public static String buildItem(String[] input) {
        StringBuilder builder = new StringBuilder();
        for (int index=1; index < input.length; index++) {
            builder.append(input[index]);
            builder.append(" ");
        }
        return builder.toString().trim();
    }
}
