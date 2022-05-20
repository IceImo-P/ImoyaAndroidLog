package net.imoya.android.log

enum class LogLevel(private val level: Int) {
    NONE(Int.MAX_VALUE), VERBOSE(0), DEBUG(1), INFO(2), WARN(3), ERROR(4), WTF(5);

    companion object {
        @JvmStatic
        fun from(s: String?): LogLevel {
            return when (s) {
                "wtf" -> WTF
                "e", "error" -> ERROR
                "w", "warn" -> WARN
                "i", "info" -> INFO
                "d", "debug" -> DEBUG
                "v", "verbose" -> VERBOSE
                else -> NONE
            }
        }

        @JvmStatic
        fun shouldOutput(settings: LogLevel, request: LogLevel): Boolean {
            return settings.level <= request.level
        }
    }
}