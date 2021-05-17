package notion.api.v1.endpoint

import java.net.URLEncoder
import notion.api.v1.http.UserAgent

interface EndpointsSupport {
  val token: String

  fun buildRequestHeaders(additionalOnes: Map<String, String>): Map<String, String> {
    return mapOf(
            "Authorization" to "Bearer $token",
            "Notion-Version" to "2021-05-13",
            "User-Agent" to UserAgent.buildUserAgent())
        .plus(additionalOnes)
  }

  fun urlEncode(value: String): String = URLEncoder.encode(value, "UTF-8")

  fun contentTypeJson(): Map<String, String> =
      mapOf("Content-Type" to "application/json; charset=utf-8")
}
