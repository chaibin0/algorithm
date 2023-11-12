package leetcode.problems.q2514

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class SolutionTest : FunSpec({

    test("case1") {
        val s = "too hot"
        Solution().countAnagrams(s) shouldBe 18
    }


    test("case2") {
        val s = "ptx cccbhbq"
        Solution().countAnagrams(s) shouldBe 2520
    }

    test("case3") {
        val s = "ukgqajqsuset kk hm"
        Solution().countAnagrams(s) shouldBe 119750400
    }

    test("case4") {
        val s = "b okzojaporykbmq tybq zrztwlolvcyumcsq jjuowpp"
        Solution().countAnagrams(s) shouldBe 210324488
    }

    test("case5") {
        val s = "b okzojaporykbmq"
        Solution().countAnagrams(s) shouldBe 264857551
    }

    test("case6") {
        val s = "eoblsuqjnpsrfawprqcqxykbududpvimwtvfyvdsgpcn wmyikoakqwjsutgrucubmpatibfzjoewubqgfinxcznzemjckfacxikbfjygaamsidynhjrwjftneeujuymvznxdu fqaeeqcrlvjj hrqhhqrjbeijmicpdmayeybcedzhicvsfdgrakbaxesjzguqfprcgkgybgzwhxccljpxxjlrjjnddplklqfcsuunt qzbmkqbrhxpasniftpkviphnhfbacfifxkfsjmbgmpzd fanh dous"
        Solution().countAnagrams(s) shouldBe 770563105
    }








})
