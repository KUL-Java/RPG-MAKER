package pl.rpg.game;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Page {
    private String content;

    @Override
    public String toString() {
        return "*** " + content + " ***";
    }
}
