package net.imoya.android.log

import android.util.Log
import java.util.*

/**
 * ログユーティリティ
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

    @JvmStatic
    fun logString(array: BooleanArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            if (it) "true" else "false"
        }
    }

    @JvmStatic
    fun logString(array: IntArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    @JvmStatic
    fun logString(array: LongArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    @JvmStatic
    fun logString(array: ShortArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    @JvmStatic
    fun logString(array: ByteArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    @JvmStatic
    fun logString(array: FloatArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    @JvmStatic
    fun logString(array: DoubleArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    @JvmStatic
    fun logString(array: CharArray): String {
        return array.joinToString(prefix = "[", postfix = "]") {
            it.toString()
        }
    }

    @JvmStatic
    fun logString(obj: Any?): String {
        return when (obj) {
            null -> "null"
            is IntArray -> logString(obj)
            is LongArray -> logString(obj)
            is ShortArray -> logString(obj)
            is ByteArray -> logString(obj)
            is FloatArray -> logString(obj)
            is DoubleArray -> logString(obj)
            is CharArray -> logString(obj)
            is BooleanArray -> logString(obj)
            is Array<*> -> logString(obj)
            else -> obj.toString()
        }
    }

    @JvmStatic
    fun logString(array: Array<*>): String = array.contentDeepToString()

    @JvmStatic
    fun stackTraceString(tr: Throwable): String {
        return Log.getStackTraceString(tr)
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