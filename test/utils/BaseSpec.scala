/*
 * Copyright 2020 HM Revenue & Customs
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

package utils

import com.kenshoo.play.metrics.Metrics
import org.scalatest.BeforeAndAfter
import org.scalatest.mockito.MockitoSugar
import org.scalatestplus.play.OneAppPerSuite
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder
import uk.gov.hmrc.play.test.UnitSpec
import play.api.inject.bind


trait BaseSpec extends UnitSpec with OneAppPerSuite with MockitoSugar with BeforeAndAfter with AwrsTestJson {

  override def fakeApplication(): Application = GuiceApplicationBuilder()
    .configure(
      "metrics.enabled" -> false,
      "microservice.metrics.graphite.enabled" -> false
    )
  .overrides(bind[Metrics].toInstance(MockMetrics))
  .build()

}
