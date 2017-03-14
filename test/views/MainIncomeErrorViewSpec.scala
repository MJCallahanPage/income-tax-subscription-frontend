/*
 * Copyright 2017 HM Revenue & Customs
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

package views

import assets.MessageLookup
import org.jsoup.Jsoup
import play.api.i18n.Messages.Implicits._
import play.api.test.FakeRequest
import utils.UnitTestTrait

class MainIncomeErrorViewSpec extends UnitTestTrait {

  lazy val backUrl: String = controllers.routes.IncomeSourceController.showIncomeSource().url
  lazy val page = views.html.main_income_error(backUrl = backUrl)(FakeRequest(), applicationMessages, appConfig)
  lazy val document = Jsoup.parse(page.body)

  "The Main Income Error view" should {

    s"have the title '${MessageLookup.MainIncomeError.title}'" in {
      document.title() must be(MessageLookup.MainIncomeError.title)
    }

    s"have the heading (H1) '${MessageLookup.MainIncomeError.heading}'" in {
      document.getElementsByTag("H1").text() must be(MessageLookup.MainIncomeError.heading)
    }

    s"have the paragraph (P) '${MessageLookup.MainIncomeError.para1}'" in {
      document.getElementsByTag("P").text() must include(MessageLookup.MainIncomeError.para1)
    }

    s"have the paragraph (P) '${MessageLookup.MainIncomeError.para2}'" in {
      document.getElementsByTag("P").text() must include(MessageLookup.MainIncomeError.para2)
    }

    s"have the paragraph (LI) '${MessageLookup.MainIncomeError.bullet1}'" in {
      document.getElementsByTag("LI").text() must include (MessageLookup.MainIncomeError.bullet1)
    }

    s"have the paragraph (LI) '${MessageLookup.MainIncomeError.bullet2}'" in {
      document.getElementsByTag("LI").text() must include (MessageLookup.MainIncomeError.bullet2)
    }

    s"have the paragraph (LI) '${MessageLookup.MainIncomeError.bullet3}'" in {
      document.getElementsByTag("LI").text() must include (MessageLookup.MainIncomeError.bullet3)
    }
  }
}