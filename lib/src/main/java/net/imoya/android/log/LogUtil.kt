/*
 * Copyright (C) 2022 IceImo-P
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package net.imoya.android.log

import android.util.Log
import java.util.*

/**
 * Utilities for Android [android.util.Log]
 */
@Suppress("unused")
object LogUtil {
    /**
     * Returns date and time string for log
     *
     * @param calendar [Calendar]
     */
    @JvmStatic
    fun logString(calendar: Calendar): String {
        return calendar[Calendar.YEAR].toString() + "/" + String.format(
            Locale.US,
            "%02d",
            calendar[Calendar.MONTH] + 1
        ) + "/" + String.format(
            Locale.US,
            "%02d",
            calendar[Calendar.DAY_OF_MONTH]
        ) + " " + String.format(
            Locale.US,
            "%02d",
            calendar[Calendar.HOUR_OF_DAY]
        ) + ":" + String.format(
            Locale.US,
            "%02d",
            calendar[Calendar.MINUTE]
        ) + ":" + String.format(
            Locale.US,
            "%02d",
            calendar[Calendar.SECOND]
        )
    }

    /**
     * Returns string which represents [BooleanArray] for log
     *
     * @param array [BooleanArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: BooleanArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            if (it) "true" else "false"
        }
    }

    /**
     * Returns string which represents [IntArray] for log
     *
     * @param array [IntArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: IntArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    /**
     * Returns string which represents [LongArray] for log
     *
     * @param array [LongArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: LongArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    /**
     * Returns string which represents [ShortArray] for log
     *
     * @param array [ShortArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: ShortArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    /**
     * Returns string which represents [ByteArray] for log
     *
     * @param array [ByteArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: ByteArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    /**
     * Returns string which represents [FloatArray] for log
     *
     * @param array [FloatArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: FloatArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    /**
     * Returns string which represents [DoubleArray] for log
     *
     * @param array [DoubleArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: DoubleArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    /**
     * Returns string which represents [CharArray] for log
     *
     * @param array [CharArray]
     * @return String for log
     */
    @JvmStatic
    fun logString(array: CharArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    /**
     * Returns string which represents any object or null for log
     *
     * @param any Any object or null
     * @return String for log
     */
    @JvmStatic
    fun logString(any: Any?): String {
        return when (any) {
            null -> "null"
            is IntArray -> logString(any)
            is LongArray -> logString(any)
            is ShortArray -> logString(any)
            is ByteArray -> logString(any)
            is FloatArray -> logString(any)
            is DoubleArray -> logString(any)
            is CharArray -> logString(any)
            is BooleanArray -> logString(any)
            is Array<*> -> logString(any)
            else -> any.toString()
        }
    }

    @JvmStatic
    fun logString(array: Array<*>): String = array.contentDeepToString()

    @JvmStatic
    fun stackTraceString(tr: Throwable?): String {
        return if (tr != null) Log.getStackTraceString(tr) else ""
    }

    /**
     * Returns date and time string for log
     *
     * @param time RTC datetime
     * @return String for log
     */
    fun dateTimeString(time: Long): String {
        val calendar = Calendar.getInstance(TimeZone.getDefault(), Locale.US)
        calendar.timeInMillis = time
        return logString(calendar)
    }
}