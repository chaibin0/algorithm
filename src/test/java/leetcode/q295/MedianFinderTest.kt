package leetcode.q295

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class MedianFinderTest : FunSpec({

    test("test1") {
        val medianFinder = MedianFinder()

        medianFinder.addNum(1)
        medianFinder.addNum(2)
        medianFinder.findMedian() shouldBe 1.5
        medianFinder.addNum(3)
        medianFinder.findMedian() shouldBe 2

    }
})
