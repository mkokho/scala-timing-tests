package org.kokho.examples

import org.kokho.examples.utils.ConcurrentAction
import org.kokho.examples.utils.TimingMixins
import org.scalatest.concurrent.Eventually
import scala.concurrent.duration._

/**
 * @author: Mikhail Kokho
 * @date: 2/24/2016.
 */
class EventuallyTests extends TimingMixins with Eventually {

  override val spanScaleFactor = AkkaTestTimefactor
  override implicit val patienceConfig = PatienceConfig(
    timeout = scaled(1 second),
    interval = scaled(0.5 seconds)
  )

  it("should pass when patience config is scaled") {
    val action = new ConcurrentAction(delay = 500 millis)
    eventually {
      action.isFinished shouldBe true
    }
  }

}


