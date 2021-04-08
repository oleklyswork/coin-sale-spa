package com.coinsale.spa.controller

import org.apache.commons.lang3.time.DateUtils
import org.springframework.expression.ParseException
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import java.util.*


@Controller
@RequestMapping("/")
class IndexController {
    @GetMapping
    @Throws(ParseException::class)
    fun main(model: Model): String? {
        val endDate = DateUtils.addMinutes(Date(),15)
        model.addAttribute("endDate", endDate)
//        model.addAttribute("endDate", SimpleDateFormat("yyyy-MM-dd").parse("2022-01-01"))
        return "index"
    }
}
