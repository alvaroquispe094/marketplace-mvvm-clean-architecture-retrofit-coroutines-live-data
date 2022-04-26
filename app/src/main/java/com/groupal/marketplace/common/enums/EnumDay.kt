package com.groupal.marketplace.common.enums

enum class EnumDay {
    MONDAY(1, "Monday"),
    TUESDAY(2, "Tuesday"),
    WEDNESDAY(3, "Wednesday"),
    THURSDAY(4, "Thursday"),
    FRIDAY(5, "Friday"),
    SATURDAY(6, "Saturday"),
    SUNDAY(7, "Sunday"); // end of the constants

    // custom properties with default values
    private var numberDay: Int? = null
    private var nameDay : String? = null

    constructor()

    constructor(
        numberDay: Int,
        nameDay: String
    ) {
        this.numberDay = numberDay
        this.nameDay = nameDay
    }

    // find name day by number of day
    fun findLabelByDay(numberDay:Int): String? {
        for (day in values()) {
            if (day.numberDay == numberDay) return day.nameDay
        }
        return "[${numberDay}] -> $nameDay"
    }
}