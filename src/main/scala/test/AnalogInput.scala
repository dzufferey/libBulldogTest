package test

import org.bulldog.beagleboneblack.BBBNames
import org.bulldog.core.gpio.AnalogInput
import org.bulldog.core.platform.Platform
import org.bulldog.core.util.BulldogUtil

object AnalogInput {

  def main(args: Array[String]) {

    //Detect the board
    val board = Platform.createBoard();

    //Get some analogInputs
    val analogInput0 = board.getPin(BBBNames.AIN0).as(classOf[AnalogInput])
    val analogInput1 = board.getPin(BBBNames.AIN1).as(classOf[AnalogInput])
    val analogInput2 = board.getPin(BBBNames.AIN2).as(classOf[AnalogInput])

    //Sample those asynchronously
    val futureChannel0 = analogInput0.sampleAsync(10)
    val futureChannel1 = analogInput1.sampleAsync(1000, 50.0f)

    //Sample 2500 values on this thread with a frequency of 500Hz
    //Should take ~ 5 seconds
    println("SAMPLING STARTED: " + System.currentTimeMillis())
    analogInput2.sample(2500, 500)
    println("SAMPLING STARTED: " + System.currentTimeMillis())

    val channel0Values = futureChannel0.get()
    for(i <- 0 until channel0Values.length) {
      println("Channel 0 measured: " + channel0Values(i))
    }

    val channel1Values = futureChannel1.get()
    for(i <- 0 until channel1Values.length) {
      println("Channel 1 measured: " + channel1Values(i))
    }

    while(true) {
      //Just read channel1 every 50ms synchronously
      //We multiply by 1.8 because that is our voltage reference. You should
      //multiply it by your original input voltage before you brought it
      //down to the Beaglebone Pin levels
      println("VALUE ON AIN0: " + analogInput0.read() * 1.8)
      BulldogUtil.sleepMs(50)
    }
  }

}
