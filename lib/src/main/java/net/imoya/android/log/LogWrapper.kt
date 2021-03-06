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

/**
 * [android.util.Log] wrapper
 *
 * @param minLevel Minimum output log level
 */
@Suppress("unused")
class LogWrapper(private val minLevel: LogLevel = LogLevel.INFO) {
    /**
     * Send a VERBOSE log message if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun v(tag: String?, msg: String): Int {
        return if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msg) else 0
    }

    /**
     * Send a VERBOSE log message if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    fun v(tag: String?, msgCallback: () -> String): Int {
        return if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msgCallback()) else 0
    }

    /**
     * Send a VERBOSE log message and log the exception if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun v(tag: String?, msg: String?, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msg, tr) else 0
    }

    /**
     * Send a VERBOSE log message and log the exception if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    fun v(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, msgCallback(), tr) else 0
    }

    /**
     * Send a VERBOSE log the exception if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    fun v(tag: String?, tr: Throwable): Int {
        return if (shouldOutput(LogLevel.VERBOSE)) Log.v(tag, tr.toString(), tr) else 0
    }

    /**
     * Send a DEBUG log message if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun d(tag: String?, msg: String): Int {
        return if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msg) else 0
    }

    /**
     * Send a DEBUG log message if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    fun d(tag: String?, msgCallback: () -> String): Int {
        return if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msgCallback()) else 0
    }

    /**
     * Send a DEBUG log message and log the exception if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun d(tag: String?, msg: String?, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msg, tr) else 0
    }

    /**
     * Send a DEBUG log message and log the exception if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    fun d(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, msgCallback(), tr) else 0
    }

    /**
     * Send a DEBUG log the exception if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    fun d(tag: String?, tr: Throwable): Int {
        return if (shouldOutput(LogLevel.DEBUG)) Log.d(tag, tr.toString(), tr) else 0
    }

    /**
     * Send a INFO log message if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun i(tag: String?, msg: String?): Int {
        return if (shouldOutput(LogLevel.INFO)) Log.i(tag, msg!!) else 0
    }

    /**
     * Send a INFO log message if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    fun i(tag: String?, msgCallback: () -> String): Int {
        return if (shouldOutput(LogLevel.INFO)) Log.i(tag, msgCallback()) else 0
    }

    /**
     * Send a INFO log message and log the exception if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun i(tag: String?, msg: String?, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.INFO)) Log.i(tag, msg, tr) else 0
    }

    /**
     * Send a INFO log message and log the exception if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    fun i(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.INFO)) Log.i(tag, msgCallback(), tr) else 0
    }

    /**
     * Send a INFO log the exception if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    fun i(tag: String?, tr: Throwable): Int {
        return if (shouldOutput(LogLevel.INFO)) Log.i(tag, tr.toString(), tr) else 0
    }

    /**
     * Send a WARN log message if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun w(tag: String?, msg: String): Int {
        return if (shouldOutput(LogLevel.WARN)) Log.w(tag, msg) else 0
    }

    /**
     * Send a WARN log message if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    fun w(tag: String?, msgCallback: () -> String): Int {
        return if (shouldOutput(LogLevel.WARN)) Log.w(tag, msgCallback()) else 0
    }

    /**
     * Send a WARN log message and log the exception if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun w(tag: String?, msg: String?, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.WARN)) Log.w(tag, msg, tr) else 0
    }

    /**
     * Send a WARN log message and log the exception if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    fun w(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.WARN)) Log.w(tag, msgCallback(), tr) else 0
    }

    /**
     * Send a WARN log the exception if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    fun w(tag: String?, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.WARN)) Log.w(tag, tr) else 0
    }

    /**
     * Send a ERROR log message if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun e(tag: String?, msg: String): Int {
        return if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msg) else 0
    }

    /**
     * Send a ERROR log message if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    fun e(tag: String?, msgCallback: () -> String): Int {
        return if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msgCallback()) else 0
    }

    /**
     * Send a ERROR log message and log the exception if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun e(tag: String?, msg: String?, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msg, tr) else 0
    }

    /**
     * Send a ERROR log message and log the exception if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    fun e(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.ERROR)) Log.e(tag, msgCallback(), tr) else 0
    }

    /**
     * Send a ERROR log the exception if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    fun e(tag: String?, tr: Throwable): Int {
        return if (shouldOutput(LogLevel.ERROR)) Log.e(tag, tr.toString(), tr) else 0
    }

    /**
     * Send a WTF log message if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    fun wtf(tag: String?, msg: String?): Int {
        return if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msg) else 0
    }

    /**
     * Send a WTF log message if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    fun wtf(tag: String?, msgCallback: () -> String): Int {
        return if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msgCallback()) else 0
    }

    /**
     * Send a WTF log message and log the exception if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    fun wtf(tag: String?, msg: String?, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msg, tr) else 0
    }

    /**
     * Send a WTF log message and log the exception if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    fun wtf(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, msgCallback(), tr) else 0
    }

    /**
     * Send a WTF log the exception if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    fun wtf(tag: String?, tr: Throwable): Int {
        return if (shouldOutput(LogLevel.WTF)) Log.wtf(tag, tr) else 0
    }

    /**
     * Low-level logging call.
     *
     * @param priority The priority/type of this log message
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     * @see [Log.println]
     */
    fun println(priority: Int, tag: String?, msg: String): Int {
        return if (shouldOutput(LogLevel.fromLogConstant(priority))) {
            Log.println(priority, tag, msg)
        } else {
            0
        }
    }

    /**
     * Low-level logging call.
     *
     * @param level The priority/type of this log message
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @return The number of bytes written.
     * @see [Log.println]
     */
    fun println(level: LogLevel, tag: String?, msg: String): Int {
        return if (shouldOutput(level)) Log.println(level.toLogConstant(), tag, msg) else 0
    }

    /**
     * Determine requested log should send
     *
     * @param request Log level to send
     * @return true if requested log should send, otherwise false.
     */
    private fun shouldOutput(request: LogLevel): Boolean {
        return LogLevel.shouldOutput(minLevel, request)
    }
}