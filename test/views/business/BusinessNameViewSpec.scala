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

package views.business

import assets.MessageLookup
import assets.MessageLookup.{BusinessName => messages}
import forms.BusinessNameForm
import org.jsoup.Jsoup
import org.scalatestplus.play.{OneAppPerTest, PlaySpec}
import play.api.i18n.Messages.Implicits._
import play.api.test.FakeRequest

class BusinessNameViewSpec extends PlaySpec with OneAppPerTest {

  lazy val page = views.html.business.business_name(
    businessNameForm = BusinessNameForm.businessNameForm,
    postAction = controllers.business.routes.BusinessNameController.submitBusinessName()
  )(FakeRequest(), applicationMessages)
  lazy val document = Jsoup.parse(page.body)

  "The Business Name view" should {

    s"have the title '${messages.title}'" in {
      document.title() mustBe messages.title
    }

    s"have the heading (H1) '${messages.heading}'" in {
      document.select("h1").text() mustBe messages.heading
    }

    "has a form" which {

      s"has the hint text '${MessageLookup.BusinessName.hint}'" in {
        document.select("span.form-hint").text() mustBe MessageLookup.BusinessName.hint
      }

      "has a text input field for the business name" in {
        document.select("input[name=BusinessName]").isEmpty mustBe false
      }

      "has a continue button" in {
        document.select("#continue-button").isEmpty mustBe false
      }

      s"has a post action to '${controllers.business.routes.BusinessNameController.submitBusinessName().url}'" in {
        document.select("form").attr("action") mustBe controllers.business.routes.BusinessNameController.submitBusinessName().url
        document.select("form").attr("method") mustBe "POST"
      }

    }

  }
}