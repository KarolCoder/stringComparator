package comparator;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringComparatorTest {

    @Test
    public void stringWithoutStars()
    {
        StringComparator stringComparator = new StringComparator("Karol","Karol");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void stringWithoutStars2()
    {
        StringComparator stringComparator = new StringComparator("Karol","ol");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void stringWithoutStars3()
    {
        StringComparator stringComparator = new StringComparator("Kar\\ol","Kar\\");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void stringWithoutStars4()
    {
        StringComparator stringComparator = new StringComparator("Karolkaw","kaw");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringIsLonger()
    {
        StringComparator stringComparator = new StringComparator("Karol","KarolGodlewski");
        assertEquals("Second String is too long",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringHasStarsWithBackslashes()
    {
        StringComparator stringComparator = new StringComparator("Karol*kar*wa","rol*\\kar*\\wa");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringIsOnlyOneStar()
    {
        StringComparator stringComparator = new StringComparator("Karol","*");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringsHasStarAtFirstChar()
    {
        StringComparator stringComparator = new StringComparator("Karol","*ol");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringsHasStarAtMiddle()
    {
        StringComparator stringComparator = new StringComparator("Karol","K*ol");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringsHasManyStars()
    {
        StringComparator stringComparator = new StringComparator("karoldawda","*ar*da*");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringsHasManyStars2()
    {
        StringComparator stringComparator = new StringComparator("Karol","K*ol*");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

    @Test
    public void SecondStringsHasManyStars3()
    {
        StringComparator stringComparator = new StringComparator("Karol","*a*r");
        assertEquals("Second string is a Substring",stringComparator.checkStrings());
    }

}
