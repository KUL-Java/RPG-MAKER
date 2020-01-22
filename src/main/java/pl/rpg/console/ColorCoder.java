package pl.rpg.console;

public enum ColorCoder {
    BLACK("#000000"), RED("#FF0000"), GREEN("#008000"), YELLOW("#FFFF00"), BLUE("#0000FF"), PURPLE("#800080"), WHITE("#FFFFFF"), CYAN("#00FFFF");
    private final String colorCode;

    ColorCoder(String code) {
        colorCode = code;
    }

    public static String getColorCode(String color) {
        for (ColorCoder value : values()) {
            if (value.name().equals(color.toUpperCase())) {
                return value.colorCode;
            }
        }
        return WHITE.colorCode;
    }
}
