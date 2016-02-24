package org.kokho.examples

import org.kokho.examples.utils.TimingMixins
import org.scalatest.concurrent.Eventually
import org.scalatest.concurrent.Futures
import org.scalatest.concurrent.ScaledTimeSpans
import org.scalatest.concurrent.ScalaFutures

import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.Future

/**
 * @author: Mikhail Kokho
 * @date: 2/24/2016.
 */
class FutureTests extends TimingMixins with ScaledTimeSpans with Eventually with Futures with ScalaFutures {

  override def spanScaleFactor: Double = AkkaTestTimefactor
  override implicit val patienceConfig = PatienceConfig(
    timeout = scaled(200 millis),
    interval = scaled(100 millis)
  )

  describe("should pass when time factor is scaled") {
    it("option 1: Await.ready on future with scaled span") {
      //requires trait ScaledTimeSpan
      //no global timeout, scaled by `spanScaleFactor`

      val future = Future { Thread.sleep(500) }

      Await.ready(future, scaled(200 millis))
    }

    it("option 2: wrap in eventually {} ") {
      //requires Eventually
      //global timeout by implicit patience config

      val future = Future { Thread.sleep(500) }

      eventually {
        future shouldBe 'completed
      }
    }

    it("option 3: wrap in FutureConcept") {
      //requires org.scalatest.concurrent.Futures
      //required org.scalatest.concurrent.ScalaFutures
      //global timeout by implicit patience config

      val future: Future[Int] = Future { Thread.sleep(500); 1 }

      whenReady(future) { result: Int =>
        result shouldBe 1
      }
    }
  }

}
