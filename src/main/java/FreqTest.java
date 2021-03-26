import com.pi4j.io.gpio.*;
import com.pi4j.wiringpi.Gpio;

public class FreqTest {


    int delayBetween = 1;

    public static void main(String[] args) throws InterruptedException {
        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput pin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "MyLED", PinState.HIGH);

        System.out.println("status -> " + gpio.getState(pin26));
        pin26.toggle();
        System.out.println("status -> " + gpio.getState(pin26));
//        Gpio.pinMode(26, Gpio.OUTPUT);
//        System.out.println("<--Pi4J--> GPIO Control Example ... started.");
//        pin.setShutdownOptions(true, PinState.LOW);
//        for (int i = 0; i < 100000000; i++) {
//            pin.toggle();
//        }
//        gpio.shutdown();
//        System.out.println("Exiting ControlGpioExample");

    }


}