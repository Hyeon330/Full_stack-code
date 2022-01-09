package week_two.human;

import week_two.airplane.AirplaneChild;

public class Human implements Runnable, Speak {

    private AirplaneChild airplane = new AirplaneChild();
    private int speed;

    public AirplaneChild getAirplane() {
        return airplane;
    }

    public void setAirplane(AirplaneChild airplane) {
        this.airplane = airplane;
    }

    public int getSpeed() {
        return this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    @Override
    public void silent() {
        // TODO Auto-generated method stub

    }

    @Override
    public void loud() {
        // TODO Auto-generated method stub

    }

}
