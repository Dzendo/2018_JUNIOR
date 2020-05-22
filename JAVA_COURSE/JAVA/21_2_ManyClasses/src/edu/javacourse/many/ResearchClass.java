package edu.javacourse.many;

public class ResearchClass
{
    private class InternalOne {
    }

    protected class InternalTwo {
    }

    class InternalThree {
    }

    public class InternalFour {
    }
    
    static private class InternalStaticOne {
    }

    static protected class InternalStaticTwo {
    }

    static class InternalStaticThree {
    }

    static public class InternalStaticFour {
    }
    
    public void testInternal() {
        InternalOne inOne = new InternalOne();
        InternalTwo inTwo = new InternalTwo();
        InternalThree inThree = new InternalThree();
        InternalFour inFour = new InternalFour();
        
        InternalStaticOne inStOne = new InternalStaticOne();
        InternalStaticTwo inStTwo = new InternalStaticTwo();
        InternalStaticThree inStThree = new InternalStaticThree();
        InternalStaticFour inStFour = new InternalStaticFour();
    }
}
