package ru.quizie.topdiamonds.top;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TopManager {

    private final List<TopPlayer> topPlayers = new ArrayList<>();

    public void addTopPlayer(TopPlayer topPlayer) {
        topPlayers.add(topPlayer);
    }

    public void sort() {
        topPlayers.sort(Collections.reverseOrder());
    }

    public String getTopPlayers(int showLines) {
        final StringBuilder top = new StringBuilder();
        final int playerCount = topPlayers.size();

        for (int i = 0; i < showLines; i++) {
            top.append(i + 1).append(". ");
            if (i < playerCount) {
                final TopPlayer player = topPlayers.get(i);
                top.append(player.getAuthor()).append(" - ").append(player.getDiamondAmount());
            } else {
                top.append("Пусто - Пусто");
            }
            top.append("\n");
        }

        return top.toString();
    }
}
