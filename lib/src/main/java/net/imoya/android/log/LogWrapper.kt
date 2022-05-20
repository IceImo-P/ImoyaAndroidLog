package net.imoya.android.log

import android.util.Log

/**
 * [android.util.Log] wrapper
 *
 * @param minLevel Minimum output log level
 */
@Suppress("unused")
class LogWrapper(private val minLevel: LogLevel = LogLevel.INFO) {
    fun v(tag: String?, msg: String) {
        if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msg)
    }

    fun v(tag: String?, msgCallback: () -> String) {
        if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msgCallback())
    }

    fun v(tag: String?, msg: String?, tr: Throwable?) {
        if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msg, tr)
    }

    fun v(tag: String?, msgCallback: () -> String, tr: Throwable?) {
        if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msgCallback(), tr)
    }

    fun v(tag: String?, tr: Throwable) {
        if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, tr.toString(), tr)
    }

    fun d(tag: String?, msg: String) {
        if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msg)
    }

    fun d(tag: String?, msgCallback: () -> String) {
        if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msgCallback())
    }

    fun d(tag: String?, msg: String?, tr: Throwable?) {
        if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msg, tr)
    }

    fun d(tag: String?, msgCallback: () -> String, tr: Throwable?) {
        if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msgCallback(), tr)
    }

    fun d(tag: String?, tr: Throwable) {
        if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, tr.toString(), tr)
    }

    fun i(tag: String?, msg: String?) {
        if (shouldOutput(LogLevel.INFO)) Log.i(tag, msg!!)
    }

    fun i(tag: String?, msgCallback: () -> String) {
        if (shouldOutput(LogLevel.INFO)) Log.i(tag, msgCallback())
    }

    fun i(tag: String?, msg: String?, tr: Throwable?) {
        if (shouldOutput(LogLevel.INFO)) Log.i(tag, msg, tr)
    }

    fun i(tag: String?, msgCallback: () -> String, tr: Throwable?) {
        if (shouldOutput(LogLevel.INFO)) Log.i(tag, msgCallback(), tr)
    }

    fun i(tag: String?, tr: Throwable) {
        if (shouldOutput(LogLevel.INFO)) Log.i(tag, tr.toString(), tr)
    }

    fun w(tag: String?, msg: String) {
        if (shouldOutput(LogLevel.WARN)) Log.w(tag, msg)
    }

    fun w(tag: String?, msgCallback: () -> String) {
        if (shouldOutput(LogLevel.WARN)) Log.w(tag, msgCallback())
    }

    fun w(tag: String?, msg: String?, tr: Throwable?) {
        if (shouldOutput(LogLevel.WARN)) Log.w(tag, msg, tr)
    }

    fun w(tag: String?, msgCallback: () -> String, tr: Throwable?) {
        if (shouldOutput(LogLevel.WARN)) Log.w(tag, msgCallback(), tr)
    }

    fun w(tag: String?, tr: Throwable?) {
        if (shouldOutput(LogLevel.WARN)) Log.w(tag, tr)
    }

    fun e(tag: String?, msg: String) {
        if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msg)
    }

    fun e(tag: String?, msgCallback: () -> String) {
        if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msgCallback())
    }

    fun e(tag: String?, msg: String?, tr: Throwable?) {
        if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msg, tr)
    }

    fun e(tag: String?, msgCallback: () -> String, tr: Throwable?) {
        if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msgCallback(), tr)
    }

    fun e(tag: String?, tr: Throwable) {
        if (shouldOutput(LogLevel.ERROR)) Log.e(tag, tr.toString(), tr)
    }

    fun wtf(tag: String?, msg: String?) {
        if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msg)
    }

    fun wtf(tag: String?, msgCallback: () -> String) {
        if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msgCallback())
    }

    fun wtf(tag: String?, msg: String?, tr: Throwable?) {
        if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msg, tr)
    }

    fun wtf(tag: String?, msgCallback: () -> String, tr: Throwable?) {
        if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msgCallback(), tr)
    }

    fun wtf(tag: String?, tr: Throwable) {
        if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, tr)
    }

    private fun shouldOutput(request: LogLevel): Boolean {
        return LogLevel.shouldOutput(minLevel, request)
    }
}