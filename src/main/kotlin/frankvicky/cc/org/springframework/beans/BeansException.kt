package frankvicky.cc.org.springframework.beans


class BeansException : RuntimeException {
    constructor(msg: String?) : super(msg)
    constructor(msg: String?, cause: Throwable?) : super(msg, cause)
}