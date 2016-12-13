/*
 * Copyright 2016 HM Revenue & Customs
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package routes

import org.scalatest._
import uk.gov.hmrc.play.test.{UnitSpec, WithFakeApplication}

class RoutesSpec extends UnitSpec with WithFakeApplication with Matchers {

  "The URL for the HelloWorld.helloWorld action" should {
    "be equal to /income-tax-subscription-frontend/hello-world" in {
      controllers.routes.HelloWorldController.helloWorld().url shouldEqual "/income-tax-subscription-frontend/hello-world"
    }
  }
  "The URL for the timeout.timeout action" should {
    "be equal to /income-tax-subscription-frontend/session-timeout" in {
      controllers.routes.SessionTimeoutController.timeout().url shouldEqual "/income-tax-subscription-frontend/session-timeout"
    }
  }
}