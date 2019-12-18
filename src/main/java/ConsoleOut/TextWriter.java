package ConsoleOut;

public class TextWriter {
    void Write(String text, int delay, String color){
        for(char c:text.toCharArray()) {
            System.out.print(color+c);
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
