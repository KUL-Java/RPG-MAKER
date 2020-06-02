package pl.rpg.storyteller.minions.chornicles;

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
