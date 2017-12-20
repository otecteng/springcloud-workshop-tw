package pivotal

import io.gatling.core.Predef._
import io.gatling.http.Predef._
import scala.concurrent.duration._

class BFFMonkeySimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:9000")
    .userAgentHeader("Gatling")

  val scn = scenario("BFFMonkeySimulation")
    .repeat(10) {
      exec(http("GET /api/v1/monkey").get("/api/v1/monkey"))
    }

  setUp(
    scn.inject(constantUsersPerSec(10) during(20 seconds) randomized)
  ).protocols(httpProtocol)
}
