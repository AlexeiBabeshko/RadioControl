import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RadioTest {
    @Test
    public void testSetCurrentStationOverMaximum() {
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.setCurrentStation(14);

        int actual = radio.getCurrentStation();
        int expected = 7;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testSetCurrentStationUnderMinimum() {
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.setCurrentStation(-14);
        int actual = radio.getCurrentStation();
        int expected = 7;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextRadioStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 8;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testNextRadioStationMax() {
        Radio radio = new Radio();

        radio.setCurrentStation(9);
        radio.next();
        int actual = radio.getCurrentStation();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevRadioStation() {
        Radio radio = new Radio();

        radio.setCurrentStation(7);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 6;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testPrevRadioStationMin() {
        Radio radio = new Radio();

        radio.setCurrentStation(0);
        radio.prev();
        int actual = radio.getCurrentStation();
        int expected = 9;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolume() {
        Radio radio = new Radio();

        for (int i = 0; i < 3; i++) {
            radio.increaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 3;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testIncreaseVolumeMax() {
        Radio radio = new Radio();

        for (int i = 0; i < 130; i++) {
            radio.increaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 100;

        Assertions.assertEquals(expected, actual);
    }


    @Test
    public void testDecreaseVolume() {
        Radio radio = new Radio();

        for (int i = 0; i < 3; i++) {
            radio.decreaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 0;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void testDeclineVolume() {
        Radio radio = new Radio();

        for (int i = 0; i < 30; i++) {
            radio.increaseVolume();
        }
        for (int i = 0; i < 10; i++) {
            radio.decreaseVolume();
        }
        int actual = radio.getCurrentVolume();
        int expected = 20;

        Assertions.assertEquals(expected, actual);
    }
}
