package org.kokho.examples.utils

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import scala.concurrent.duration.FiniteDuration
import scala.concurrent.duration._

/**
 * @author: Mikhail Kokho
 * @date: 2/24/2016.
 */
class ConcurrentAction(
  delay: FiniteDuration = 100.millis,
  action: => Unit = {}
)(implicit ec: ExecutionContext) {

  private var finished = false

  def isFinished = finished

  Future {
    Thread.sleep(delay.toMillis)
    action
    finished = true
  }
}
