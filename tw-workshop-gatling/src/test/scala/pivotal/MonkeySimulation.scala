package pivotal

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class MonkeySimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:9002")
    .userAgentHeader("Gatling")

  val scn = scenario("MonkeySimulation")
    .repeat(10) {
      exec(http("GET /api/monkey").get("/api/monkey"))
    }

  setUp(
    scn.inject(constantUsersPerSec(10) during(20 seconds) randomized)
  ).protocols(httpProtocol)
}
