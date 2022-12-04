public class SleepThread {
    public static void main(String[] args) {
        Race tuzi = new Race();
        Race wugui = new Race();
        wugui.setSleep(500);
        new Thread(tuzi,"兔子").start();
        new Thread(wugui,"乌龟").start();
    }
}