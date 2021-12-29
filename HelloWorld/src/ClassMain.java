public class ClassMain {
    public static void main(String[] args) {
        Tv tv = new Tv();

        tv.setChannel(7);
        tv.channelUp();
        tv.channelUp();
        System.out.println(tv.getChannel());
        tv.channelDown();
        tv.channelDown();
        tv.channelDown();
        System.out.println(tv.getChannel());

    }
}