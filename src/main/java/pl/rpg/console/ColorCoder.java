package pl.rpg.console;

public enum ColorCoder {
    BLACK("\u001B[30m"), RED("\u001B[31m"), GREEN("\u001B[32m"), YELLOW("\u001B[33m"), BLUE("\u001B[34m"), PURPLE("\u001B[35m"), WHITE("\u001B[37m"), CYAN("\u001B[36m");
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
