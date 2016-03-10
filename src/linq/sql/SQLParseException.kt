package linq.sql

/**
 * Created by thoma on 09/03/2016.
 */
class SQLParseException(p0 : String?) : Exception(p0) {
    override val message: String?
        get() = super.message
}