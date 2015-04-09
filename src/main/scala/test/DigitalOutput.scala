package test

import org.bulldog.beagleboneblack.BBBNames
import org.bulldog.core.Signal
import org.bulldog.core.platform.Platform
import org.bulldog.core.util.BulldogUtil


object DigitalOutput {

  def main(args: Array[String]) {
    //Detect the board we are running on
    val board = Platform.createBoard()

    //Set up a digital output
    val output = board.getPin(BBBNames.P8_12).as(classOf[org.bulldog.core.gpio.DigitalOutput])

    //Set a high signal on the output
    output.write(Signal.High)

    //Toggle it
    output.toggle()
    BulldogUtil.sleepMs(500)

    //Set it high
    output.high()
    BulldogUtil.sleepMs(500)

    //Set it low
    output.low()
    BulldogUtil.sleepMs(500)

    //Yet another way of applying a signal
    output.applySignal(Signal.High)
    BulldogUtil.sleepMs(500)

    //Let it blink 3 times
    output.blinkTimes(500, 3)
    output.awaitBlinkingStopped()

    //Let it blink 5 seconds, 10 times a second
    output.startBlinking(100, 5000)
    output.awaitBlinkingStopped()

    //Let it blink 5 times a second indefinitely
    output.startBlinking(200)

    while(true) {
      BulldogUtil.sleepMs(50)
    }
  }

}
