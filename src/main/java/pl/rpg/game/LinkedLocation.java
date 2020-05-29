package pl.rpg.game;


import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class LinkedLocation {
    String exit;
    Location linkedLocation;
}