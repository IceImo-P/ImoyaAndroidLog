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

import android.content.Context
import android.util.Log
import androidx.annotation.StringRes

/**
 * Template class for static log object
 */
@Suppress("unused")
open class StaticLogTemplate {
    /**
     * Initialize with [LogLevel]
     *
     * @param logLevel [LogLevel]
     */
    constructor(logLevel: LogLevel) {
        logWrapper = LogWrapper(logLevel)
    }

    /**
     * Initialize with [LogLevel.NONE]
     */
    constructor() : this(LogLevel.NONE)

    /**
     * [LogWrapper]
     */
    private var logWrapper: LogWrapper

    /**
     * Initialize log output
     *
     * @param logLevel [LogLevel]
     */
    @Suppress("weaker")
    protected fun init(logLevel: LogLevel) {
        logWrapper = LogWrapper(logLevel)
    }

    /**
     * Initialize log output by [LogLevel] string resource ID
     *
     * @param context [Context]
     * @param id String resource ID
     */
    protected fun init(context: Context, @StringRes id: Int) {
        init(LogLevel.from(context.getString(id)))
    }

    /**
     * Send a VERBOSE log message if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    protected fun vImpl(tag: String?, msg: String): Int {
        return logWrapper.v(tag, msg)
    }

    /**
     * Send a VERBOSE log message if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    protected fun vImpl(tag: String?, msgCallback: () -> String): Int {
        return logWrapper.v(tag, msgCallback)
    }

    /**
     * Send a VERBOSE log message and log the exception if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    protected fun vImpl(tag: String?, msg: String?, tr: Throwable?): Int {
        return logWrapper.v(tag, msg, tr)
    }

    /**
     * Send a VERBOSE log message and log the exception if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    protected fun vImpl(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return logWrapper.v(tag, msgCallback, tr)
    }

    /**
     * Send a VERBOSE log the exception if minimum output log level <= [LogLevel.VERBOSE]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    protected fun vImpl(tag: String?, tr: Throwable): Int {
        return logWrapper.v(tag, tr)
    }

    /**
     * Send a DEBUG log message if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    protected fun dImpl(tag: String?, msg: String): Int {
        return logWrapper.d(tag, msg)
    }

    /**
     * Send a DEBUG log message if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    protected fun dImpl(tag: String?, msgCallback: () -> String): Int {
        return logWrapper.d(tag, msgCallback)
    }

    /**
     * Send a DEBUG log message and log the exception if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    protected fun dImpl(tag: String?, msg: String?, tr: Throwable?): Int {
        return logWrapper.d(tag, msg, tr)
    }

    /**
     * Send a DEBUG log message and log the exception if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    protected fun dImpl(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return logWrapper.d(tag, msgCallback, tr)
    }

    /**
     * Send a DEBUG log the exception if minimum output log level <= [LogLevel.DEBUG]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    protected fun dImpl(tag: String?, tr: Throwable): Int {
        return logWrapper.d(tag, tr)
    }

    /**
     * Send a INFO log message if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    protected fun iImpl(tag: String?, msg: String?): Int {
        return logWrapper.i(tag, msg)
    }

    /**
     * Send a INFO log message if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    protected fun iImpl(tag: String?, msgCallback: () -> String): Int {
        return logWrapper.i(tag, msgCallback)
    }

    /**
     * Send a INFO log message and log the exception if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    protected fun iImpl(tag: String?, msg: String?, tr: Throwable?): Int {
        return logWrapper.i(tag, msg, tr)
    }

    /**
     * Send a INFO log message and log the exception if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    protected fun iImpl(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return logWrapper.i(tag, msgCallback, tr)
    }

    /**
     * Send a INFO log the exception if minimum output log level <= [LogLevel.INFO]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    protected fun iImpl(tag: String?, tr: Throwable): Int {
        return logWrapper.i(tag, tr)
    }

    /**
     * Send a WARN log message if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    protected fun wImpl(tag: String?, msg: String): Int {
        return logWrapper.w(tag, msg)
    }

    /**
     * Send a WARN log message if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    protected fun wImpl(tag: String?, msgCallback: () -> String): Int {
        return logWrapper.w(tag, msgCallback)
    }

    /**
     * Send a WARN log message and log the exception if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    protected fun wImpl(tag: String?, msg: String?, tr: Throwable?): Int {
        return logWrapper.w(tag, msg, tr)
    }

    /**
     * Send a WARN log message and log the exception if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    protected fun wImpl(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return logWrapper.w(tag, msgCallback, tr)
    }

    /**
     * Send a WARN log the exception if minimum output log level <= [LogLevel.WARN]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    protected fun wImpl(tag: String?, tr: Throwable?): Int {
        return logWrapper.w(tag, tr)
    }

    /**
     * Send a ERROR log message if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    protected fun eImpl(tag: String?, msg: String): Int {
        return logWrapper.e(tag, msg)
    }

    /**
     * Send a ERROR log message if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    protected fun eImpl(tag: String?, msgCallback: () -> String): Int {
        return logWrapper.e(tag, msgCallback)
    }

    /**
     * Send a ERROR log message and log the exception if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    protected fun eImpl(tag: String?, msg: String?, tr: Throwable?): Int {
        return logWrapper.e(tag, msg, tr)
    }

    /**
     * Send a ERROR log message and log the exception if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    protected fun eImpl(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return logWrapper.e(tag, msgCallback, tr)
    }

    /**
     * Send a ERROR log the exception if minimum output log level <= [LogLevel.ERROR]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    protected fun eImpl(tag: String?, tr: Throwable): Int {
        return logWrapper.e(tag, tr)
    }

    /**
     * Send a WTF log message if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     */
    protected fun wtfImpl(tag: String?, msg: String?): Int {
        return logWrapper.wtf(tag, msg)
    }

    /**
     * Send a WTF log message if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     */
    protected fun wtfImpl(tag: String?, msgCallback: () -> String): Int {
        return logWrapper.wtf(tag, msgCallback)
    }

    /**
     * Send a WTF log message and log the exception if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msg The message you would like logged.
     * @param tr An exception to log
     */
    protected fun wtfImpl(tag: String?, msg: String?, tr: Throwable?): Int {
        return logWrapper.wtf(tag, msg, tr)
    }

    /**
     * Send a WTF log message and log the exception if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param msgCallback The function which returns message you would like logged.
     * @param tr An exception to log
     */
    protected fun wtfImpl(tag: String?, msgCallback: () -> String, tr: Throwable?): Int {
        return logWrapper.wtf(tag, msgCallback, tr)
    }

    /**
     * Send a WTF log the exception if minimum output log level <= [LogLevel.WTF]
     *
     * @param tag Used to identify the source of a log message.
     *            It usually identifies the class or activity where the log call occurs.
     * @param tr An exception to log
     */
    protected fun wtfImpl(tag: String?, tr: Throwable): Int {
        return logWrapper.wtf(tag, tr)
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
    fun printlnImpl(priority: Int, tag: String?, msg: String): Int =
        logWrapper.println(priority, tag, msg)

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
    fun printlnImpl(level: LogLevel, tag: String?, msg: String): Int =
        logWrapper.println(level, tag, msg)
}