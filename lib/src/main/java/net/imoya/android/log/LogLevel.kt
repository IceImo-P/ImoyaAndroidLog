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

import kotlin.jvm.Throws

/**
 * Log level definition
 */
enum class LogLevel(private val level: Int) {
    /**
     * Sends no log
     */
    NONE(Int.MAX_VALUE),

    /**
     * Sends all log
     */
    ALL(Int.MIN_VALUE),

    /**
     * Sends VERBOSE or more important log
     */
    VERBOSE(2),

    /**
     * Sends DEBUG or more important log
     */
    DEBUG(3),

    /**
     * Sends INFO or more important log
     */
    INFO(4),

    /**
     * Sends WARN or more important log
     */
    WARN(5),

    /**
     * Sends WARN or more important log
     */
    ERROR(6),

    /**
     * Sends ASSERT log
     */
    ASSERT(7),

    /**
     * Sends WTF log
     */
    WTF(7);

    @Throws(IllegalArgumentException::class)
    fun toLogConstant(): Int {
        return toNativeConversionTable[level] ?: throw IllegalArgumentException("Log constant definition for $name not found")
    }

    companion object {
        /**
         * Conversion table from [android.util.Log] constants to [LogLevel]
         */
        private val fromNativeConversionTable: Map<Int, LogLevel>

        /**
         * Conversion table from [LogLevel] to [android.util.Log] constants
         */
        private val toNativeConversionTable: Map<Int, Int>

        init {
            val fromMap = mutableMapOf<Int, LogLevel>()
            fromMap[android.util.Log.VERBOSE] = VERBOSE
            fromMap[android.util.Log.DEBUG] = DEBUG
            fromMap[android.util.Log.INFO] = INFO
            fromMap[android.util.Log.WARN] = WARN
            fromMap[android.util.Log.ERROR] = ERROR
            fromMap[android.util.Log.ASSERT] = ASSERT
            fromNativeConversionTable = fromMap.toMap()

            val toMap = mutableMapOf<Int, Int>()
            toMap[VERBOSE.level] = android.util.Log.VERBOSE
            toMap[DEBUG.level] = android.util.Log.DEBUG
            toMap[INFO.level] = android.util.Log.INFO
            toMap[WARN.level] = android.util.Log.WARN
            toMap[ERROR.level] = android.util.Log.ERROR
            toMap[ASSERT.level] = android.util.Log.ASSERT
            toMap[WTF.level] = android.util.Log.ASSERT
            toNativeConversionTable = toMap.toMap()
        }

        /**
         * Returns [LogLevel] from [String]
         *
         * @param string [String] represents [LogLevel]
         * @return [LogLevel], or [LogLevel.NONE] if string doesn't matches
         */
        @JvmStatic
        fun from(string: String?): LogLevel {
            return when (string?.lowercase()) {
                "wtf" -> WTF
                "assert" -> ASSERT
                "e", "error" -> ERROR
                "w", "warn" -> WARN
                "i", "info" -> INFO
                "d", "debug" -> DEBUG
                "v", "verbose" -> VERBOSE
                "all" -> ALL
                else -> NONE
            }
        }

        /**
         * Returns [LogLevel] from [android.util.Log] constants
         */
        @JvmStatic
        fun fromLogConstant(int: Int): LogLevel {
            return fromNativeConversionTable[int] ?: throw IllegalArgumentException("Insufficient priority value")
        }

        /**
         * Determine requested log should send
         *
         * @param minimum Minimum log level
         * @param request Log level to send
         * @return true if requested log should send, otherwise false.
         */
        @JvmStatic
        fun shouldOutput(minimum: LogLevel, request: LogLevel): Boolean {
            return minimum.level <= request.level
        }
    }
}