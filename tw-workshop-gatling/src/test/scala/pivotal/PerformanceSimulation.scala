package pivotal

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class PerformanceSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:9002")
    .userAgentHeader("Gatling")

  val scn = scenario("PerformanceSimulation")
    .repeat(10) {
      exec(http("GET /orders").get("/orders?shop_id=1"))
    }

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpProtocol)
}
