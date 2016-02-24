package org.kokho.examples.utils

import com.typesafe.config.ConfigFactory
import org.scalatest.FunSpecLike
import org.scalatest.Matchers

/**
 * @author: Mikhail Kokho
 * @date: 2/24/2016.
 */
trait TimingMixins extends FunSpecLike with Matchers {
  implicit val ec = scala.concurrent.ExecutionContext.Implicits.global

  val AkkaTestTimefactor = ConfigFactory.load().getDouble("akka.test.timefactor")

  println("---")
  println(s"--- AKKA_TEST_TIMEFACTOR = $AkkaTestTimefactor")
  println("---")

}
