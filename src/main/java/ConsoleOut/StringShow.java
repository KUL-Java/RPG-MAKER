package ConsoleOut;

public class StringShow {
    void ShowString(String text, int delay, String color){
        for(int i=0; i<text.length();i++){
            System.out.print(color+text.charAt(i));
            try {
                Thread.sleep(delay);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.out.println();
    }
}
