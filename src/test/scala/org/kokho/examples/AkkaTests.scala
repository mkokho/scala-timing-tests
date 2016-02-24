package org.kokho.examples

import akka.actor.ActorSystem
import akka.testkit.TestKit
import scala.concurrent.duration._
import org.kokho.examples.utils.ConcurrentAction
import org.kokho.examples.utils.TimingMixins

/**
 * @author: Mikhail Kokho
 * @date: 2/24/2016.
 */
class AkkaTests extends TestKit(ActorSystem("test-system")) with TimingMixins {

  object Ping
  
  it("should pass when timefactor is scaled") {
    val self = testActor
    val action = new ConcurrentAction(500.millis, { self ! Ping })

    expectMsg(200.millis, Ping)
  }

}
