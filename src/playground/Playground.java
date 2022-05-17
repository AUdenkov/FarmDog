package playground;

import java.io.Serializable;

public class Playground implements Serializable {
    private PlaygroundOneLevel playgroundOneLevel;
    private PlaygroundTwoLevel playgroundTwoLevel;
    private PlaygroundThreeLevel playgroundThreeLevel;
    private PlaygroundFourLevel playgroundFourLevel;

    public Playground() {
        playgroundOneLevel = new PlaygroundOneLevel();
        playgroundTwoLevel = new PlaygroundTwoLevel();
        playgroundThreeLevel = new PlaygroundThreeLevel();
        playgroundFourLevel = new PlaygroundFourLevel();
    }

    public PlaygroundOneLevel getPlaygroundOneLevel() {
        return playgroundOneLevel;
    }

    public void setPlaygroundOneLevel(PlaygroundOneLevel playgroundOneLevel) {
        this.playgroundOneLevel = playgroundOneLevel;
    }

    public PlaygroundTwoLevel getPlaygroundTwoLevel() {
        return playgroundTwoLevel;
    }

    public void setPlaygroundTwoLevel(PlaygroundTwoLevel playgroundTwoLevel) {
        this.playgroundTwoLevel = playgroundTwoLevel;
    }

    public PlaygroundThreeLevel getPlaygroundThreeLevel() {
        return playgroundThreeLevel;
    }

    public void setPlaygroundThreeLevel(PlaygroundThreeLevel playgroundThreeLevel) {
        this.playgroundThreeLevel = playgroundThreeLevel;
    }

    public PlaygroundFourLevel getPlaygroundFourLevel() {
        return playgroundFourLevel;
    }

    public void setPlaygroundFourLevel(PlaygroundFourLevel playgroundFourLevel) {
        this.playgroundFourLevel = playgroundFourLevel;
    }

    @Override
    public String toString() {
        return "Playground{" +
                "playgroundOneLevel=" + playgroundOneLevel +
                ", playgroundTwoLevel=" + playgroundTwoLevel +
                ", playgroundThreeLevel=" + playgroundThreeLevel +
                ", playgroundFourLevel=" + playgroundFourLevel +
                '}';
    }
}
