package leetcode.q635

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import io.kotest.mpp.log

class LogSystemTest : FunSpec({

    test("convertLocalDateTime") {
        val logSystem = LogSystem()
        logSystem.put(1, "2017:01:01:23:59:59")
        logSystem.put(2, "2017:01:01:22:59:59")
        logSystem.put(3, "2016:01:01:00:00:00")
        logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Year") shouldBe listOf(3, 2, 1)
        logSystem.retrieve("2016:01:01:01:01:01", "2017:01:01:23:00:00", "Hour") shouldBe listOf(2, 1)
    }
})
