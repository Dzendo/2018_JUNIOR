package kotlincourse.many

class ResearchClass {
    private inner class InternalOne

    protected inner class InternalTwo

    internal inner class InternalThree

    inner class InternalFour

    private class InternalStaticOne

    class InternalStaticTwo

    internal class InternalStaticThree

    class InternalStaticFour

    fun testInternal() {
        val inOne = InternalOne()
        val inTwo = InternalTwo()
        val inThree = InternalThree()
        val inFour = InternalFour()

        val inStOne = InternalStaticOne()
        val inStTwo = InternalStaticTwo()
        val inStThree = InternalStaticThree()
        val inStFour = InternalStaticFour()
    }
}
