package pivotal

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class CircuitBreakerSimulation extends Simulation {

  val httpProtocol = http
    .baseURL("http://localhost:9002")
    .userAgentHeader("Gatling")

  val scn = scenario("CircuitBreakerSimulation")
    .repeat(10) {
      exec(http("GET /orders with CircuitBreaker").get("/orders?shop_id=444"))
    }

  setUp(
    scn.inject(atOnceUsers(10))
  ).protocols(httpProtocol)
}
