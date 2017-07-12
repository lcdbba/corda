package net.corda.core

import com.google.common.base.Throwables
import java.time.Duration
import java.util.stream.Stream

val Int.days: Duration get() = Duration.ofDays(this.toLong())
val Int.hours: Duration get() = Duration.ofHours(this.toLong())
val Int.minutes: Duration get() = Duration.ofMinutes(this.toLong())
val Int.seconds: Duration get() = Duration.ofSeconds(this.toLong())
val Int.millis: Duration get() = Duration.ofMillis(this.toLong())

val Throwable.rootCause: Throwable get() = Throwables.getRootCause(this)

@Suppress("UNCHECKED_CAST") // When toArray has filled in the array, the component type is no longer T? but T (that may itself be nullable).
inline fun <reified T> Stream<out T>.toTypedArray() = toArray { size -> arrayOfNulls<T>(size) } as Array<T>