package ru.quizie.topdiamonds.top;

import lombok.*;
import org.jetbrains.annotations.NotNull;

@ToString @AllArgsConstructor
@EqualsAndHashCode @Getter
public class TopPlayer implements Comparable<TopPlayer> {

    private int diamondAmount;
    private String author;

    @Override
    public int compareTo(@NotNull TopPlayer o) {
        return Integer.compare(diamondAmount, o.diamondAmount);
    }
}
