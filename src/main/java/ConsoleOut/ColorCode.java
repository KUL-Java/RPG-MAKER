package ConsoleOut;
import java.util.HashMap;
import java.util.Map;
public class ColorCode {
    private String codedColor;

    public ColorCode(String color) {
        Map<String, String> colorMap = new HashMap<>();
        colorMap.put("BLACK", "\u001B[30m");
        colorMap.put("RED", "\u001B[31m");
        colorMap.put("GREEN", "\u001B[32m");
        colorMap.put("YELLOW", "\u001B[33m");
        colorMap.put("BLUE", "\u001B[34m");
        colorMap.put("PURPLE", "\u001B[35m");
        colorMap.put("WHITE", "\u001B[37m");
        colorMap.put("CYAN", "\u001B[36m");
        codedColor = colorMap.get(color);
        if(!colorMap.containsKey(color))
            codedColor ="\u001B[37m";
    }
    public String getCodedColor() {
        return codedColor;
    }

}
