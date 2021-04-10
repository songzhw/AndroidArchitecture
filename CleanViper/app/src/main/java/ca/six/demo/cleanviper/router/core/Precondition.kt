package ca.six.demo.cleanviper.router.core

// precondition满足就直接继续往下走, 所以没有successStation这一参数了
class Precondition(
    val precondition: () -> Boolean,
    val failStationName: String
)