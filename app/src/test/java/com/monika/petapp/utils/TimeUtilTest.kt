package com.monika.petapp.utils

import com.monika.petapp.utils.TimeUtil.currentTimeInHHmm
import com.monika.petapp.utils.TimeUtil.currentToFloat
import com.monika.petapp.utils.TimeUtil.dayStringFormat
import org.junit.Assert
import org.junit.Test

class TimeUtilTest {

    @Test
    fun testCurrentTimeInHHmm() {
        Assert.assertEquals(currentTimeInHHmm(1662348600000L), 9.0)
        Assert.assertEquals(currentTimeInHHmm(1662382020000L), 18.17)
        Assert.assertEquals(currentTimeInHHmm(1662374100000L), 16.5)
    }

    @Test
    fun testCurrentToFloat() {
        Assert.assertEquals(currentToFloat("11:00"), 11.0)
        Assert.assertEquals(currentToFloat("09:05"), 09.05)
        Assert.assertEquals(currentToFloat("18:05"), 18.05)
    }

    @Test
    fun testDayStringFormat() {
        Assert.assertEquals(dayStringFormat(1662521400000L), 2)
        Assert.assertEquals(dayStringFormat(1662435000000L), 1)
        Assert.assertEquals(dayStringFormat(1662348600000L), 0)
    }
}