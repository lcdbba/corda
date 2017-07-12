package net.corda.core.serialization.amqp

import org.junit.Test
import kotlin.test.*
import net.corda.core.serialization.test.mangleName
import org.apache.qpid.proton.codec.Data

class TestSerializationOutput(val strings : List<String>) : SerializationOutput() {
    override fun putObject(schema: Schema, data: Data) {
        println (schema)
        super.putObject(schema.mangleName(strings), data)
    }
}

class DeserializeNeedingCarpentryTests {
    fun testName() = Thread.currentThread().stackTrace[2].methodName
    inline fun classTestName(clazz: String) = "${this.javaClass.name}\$${testName()}\$$clazz"

    @Test
    fun oneType() {
        data class A(val a: Int, val b: String)
        val a = A(10, "20")

        val serA = TestSerializationOutput(listOf(classTestName("A"))).serialize(a)
        val deserA = DeserializationInput().deserialize(serA)
    }
}
