import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class FreqTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("<--Pi4J--> GPIO Control Example ... started.");
        int delayBetween = 20;
        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // provision gpio pin #01 as an output pin and turn on
        final GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "MyLED", PinState.HIGH);


        // set shutdown state for this pin
        pin.setShutdownOptions(true, PinState.LOW);
        for (int i = 0; i < 100; i++) {

            pin.high();
            System.out.println("--> GPIO state should change --> TRY: " + i);

            Thread.sleep(delayBetween);

            // turn off gpio pin #01
            pin.low();
            System.out.println("--> GPIO state should change --> TRY: " + i);

            Thread.sleep(delayBetween);


        }
        gpio.shutdown();

        System.out.println("Exiting ControlGpioExample");
    }
}
//END SNIPPET: control-gpio-snippet


