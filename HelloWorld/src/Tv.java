public class Tv {

    private String color;
    private boolean power;
    private int channel;

    public String getColor() {
        return this.color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isPower() {
        return this.power;
    }

    public void setPower(boolean power) {
        this.power = power;
    }

    public int getChannel() {
        return this.channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public void power() {
        power = !power;
    }

    public void channelUp() {
        ++channel;
    }

    public void channelDown() {
        --channel;
    }
}
