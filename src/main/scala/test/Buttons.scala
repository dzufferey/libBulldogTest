package test

import org.bulldog.beagleboneblack.BBBNames
import org.bulldog.core.Signal
import org.bulldog.core.gpio.DigitalInput
import org.bulldog.core.platform.Platform
import org.bulldog.core.util.BulldogUtil
import org.bulldog.devices.switches.Button
import org.bulldog.devices.switches.ButtonListener

object Button {

  def main(args: Array[String]) {
    //Grab the platform the application is running on
    val board = Platform.createBoard()
                            
    //Set up a digital input
    val buttonSignal = board.getPin(BBBNames.P8_12).as(classOf[DigitalInput])
                                                        
    //Create the button with this DigitalInput
    val button = new Button(buttonSignal, Signal.Low)

    //Add a button listener
    button.addListener(new ButtonListener() {

      def buttonPressed() {
        println("PRESSED")
      }

      def buttonReleased() {
        println("RELEASED")
      }

    })

    while(true) {
      BulldogUtil.sleepMs(50)
    }
  }

}
