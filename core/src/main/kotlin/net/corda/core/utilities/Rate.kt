package net.corda.core.utilities

import java.time.Duration
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

/**
 * [Rate] holds a quantity denoting the frequency of some event e.g. 100 times per second or 2 times per day.
 */
data class Rate(
        val numberOfEvents: Long,
        val perTimeUnit: TimeUnit
) {
    /**
     * Returns the interval between two subsequent events.
     */
    fun toInterval(): Duration {
        return Duration.of(TimeUnit.NANOSECONDS.convert(1, perTimeUnit) / numberOfEvents, ChronoUnit.NANOS)
    }

    /**
     * Converts the number of events to the given unit.
     */
    operator fun times(inUnit: TimeUnit): Long {
        return inUnit.convert(numberOfEvents, perTimeUnit)
    }
}

operator fun Long.div(timeUnit: TimeUnit) = Rate(this, timeUnit)
