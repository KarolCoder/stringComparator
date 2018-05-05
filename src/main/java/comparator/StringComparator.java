package comparator;



import java.util.ArrayList;
import java.util.List;

public class StringComparator {

    private String firstString;
    private String secondString;
    private char charFromSecondString;
    private char charFromFirstString;
    private boolean checkFirstChar=true;
    private String result;
    private int iter;
    private int iter2;
    private List tableForStars;


    public StringComparator(String firstString, String secondString)
    {
        this.firstString = firstString;
        this.secondString = secondString;
    }


    public String checkStrings()
    {
        if (!checkLength())
        {
            return "Second String is too long";
        }

        if(isStar())
        {
            if(compareLengthOfSecondStringWithStar())
            {
                return "Second string is a Substring";
            }

            getIndexOfStars();
            if(isBackslashAfterStars())
            {
                checkStringsWithStarAndBackslash(0,0);
                return checkResultSlash();
            }
            else
            {
                return  checkStringsWithStar();
            }
        }
        else
        {
            checkStringsWithoutStar(0);
            return checkResult();

        }


    }

    private boolean checkLength()
    {
        if(secondString.length()>firstString.length())
        {
            return false;
        }
        return true;
    }

    private boolean compareLengthOfSecondStringWithStar()
    {
        if(secondString.length()==1&&secondString.charAt(0)=='*')
        {
            return true;
        }
        return false;
    }

    private Boolean isStar()
    {

        for(int i=0;i<secondString.length();i++)
        {
            charFromSecondString=this.secondString.charAt(i);
            if (charFromSecondString=='*')
            {
                return true;
            }

        }
        return false;

    }

    private Boolean isBackslashAfterStars()
    {
        for(int i=0;i<tableForStars.size();i++)
        {
            if((int)tableForStars.get(i)==secondString.length()-1)
            {
                return false;
            }
            charFromSecondString=secondString.charAt((int)tableForStars.get(i)+1);
            if (charFromSecondString!='\\')
            {
                return false;
            }

        }
        return true;
    }

    private List<Integer> getIndexOfStars() {
        tableForStars = new ArrayList();
        for (int i = 0; i < secondString.length(); i++) {
            if(secondString.charAt(i)=='*')
            {
                tableForStars.add(i);
            }
        }
        return tableForStars;
    }

    private String checkStringsWithStar()
    {
        if(tableForStars.size()==1)
        {
            if ((int)tableForStars.get(0)==0)
            {
                checkStringsWithStar(0,1);
                return checkResultSlash();
            }
            else if ((int)tableForStars.get(0)==secondString.length()-1)
            {
                checkStringsWithoutStar(0);
                return checkResult();
            }
            else
            {
                checkStringsWithStar(0,0);
                return checkResultStar();
            }

        }
        else
        {
            checkStringsWithStar(0,0);
            return checkResultStar();

        }


    }

    private String checkStringsWithStar(int iteration, int iteration1)
    {
        iter=iteration;
        iter2=iteration1;
        label1:
        for (int i=iteration1; i<secondString.length();i++)
        {
            iteration1++;
            charFromSecondString = secondString.charAt(i);

            label2:
            for (int j = iteration; j < firstString.length();j++)
            {

                if(charFromSecondString=='*') {
                    result+='y';
                    iter2=i+1;
                    iter=j;
                    break label2;
                }
                iteration++;
                charFromFirstString = firstString.charAt(j);

                if (checkFirstChar == true)
                {
                    if (charFromSecondString == charFromFirstString)
                    {
                        result="y";
                        checkFirstChar=false;
                        break label2;
                    }
                }
                else
                {
                    if (charFromSecondString == charFromFirstString)
                    {
                        result+="y";
                        break label2;
                    }

                    else if (charFromSecondString != charFromFirstString)
                    {
                        result+="n";
                        checkStringsWithStar(iter+1,iter2);
                        break label1;
                    }

                }


            }

        }
        return result;
    }



    private String checkStringsWithoutStar(int iteration)
    {
        iter=iteration;

        label1:
        for (int i=0; i<secondString.length();i++)
        {
            charFromSecondString = secondString.charAt(i);
            if(charFromSecondString=='*')
            {
                result+="y";
                break label1;
            }
            label2:
            for (int j = iteration; j < firstString.length();j++)
            {
                iteration++;
                charFromFirstString = firstString.charAt(j);
                if (checkFirstChar == true)
                {
                    if (charFromSecondString == charFromFirstString)
                    {
                        result="y";
                        checkFirstChar=false;
                        break label2;
                    }
                }
                else
                {
                    if (charFromSecondString == charFromFirstString)
                    {
                        result+="y";
                        break label2;
                    }

                    else if (charFromSecondString != charFromFirstString)
                    {
                        result+="n";
                        checkStringsWithoutStar(iter+1);
                        break label1;
                    }

                }


            }

        }
        return result;
    }


    private Boolean checkStringsWithStarAndBackslash(int iteration, int iteration1)
    {
        iter=iteration;
        iter2=iteration1;
        label1:
        for (int i=iteration1; i<secondString.length();i++)
        {
            iteration1++;
            charFromSecondString = secondString.charAt(i);

                label2:
                for (int j = iteration; j < firstString.length(); j++) {
                    iteration++;
                    if(charFromSecondString=='*') {
                        result+='y';
                        i++;
                        break label2;
                    }
                    charFromFirstString = firstString.charAt(j);

                    if (checkFirstChar == true) {
                        if (charFromSecondString == charFromFirstString) {
                            result = "y";
                            checkFirstChar = false;
                            break label2;
                        }
                    } else {
                        if (charFromSecondString == charFromFirstString) {
                            result += "y";
                            break label2;
                        } else if (charFromSecondString != charFromFirstString) {
                            result += "n";
                            checkStringsWithStarAndBackslash(iter + 1, iter2);
                            return false;
                        }

                    }


                }
            }


        return true;
    }

    private String checkResult()
    {
        for (int i =result.length(); i>result.length()-secondString.length();i--)
        {
            if(result.charAt(i-1)=='n')
            {
                return "Second string is not a Substring";
            }
        }
        return "Second string is a Substring";
    }

    private String checkResultStar()
    {
        if ((int)tableForStars.get(0)==0&&(int)tableForStars.get(tableForStars.size()-1)==secondString.length()-1)
        {
            for(int i = 1; i<tableForStars.size()-1;i++)
            {
                    for (int j =(int)tableForStars.get(i); j>(int) tableForStars.get(i-1);j--)
                    {

                        if(result.charAt(i-1)=='n')
                        {
                            return "Second string is not a Substring";
                        }
                    }
                    return "Second string is a Substring";
            }

        }
        else if ((int)tableForStars.get(0)==0)
        {
            for(int i = 1; i<tableForStars.size();i++)
            {
                for (int j =result.length(); j>(int) tableForStars.get(i-1);j--)
                {

                    if(result.charAt(i-1)=='n')
                    {
                        return "Second string is not a Substring";
                    }
                }
                return "Second string is a Substring";
            }

        }
        else if ((int)tableForStars.get(tableForStars.size()-1)==secondString.length()-1)
        {
            for(int i = 1; i<tableForStars.size();i++)
            {
                for (int j =(int)tableForStars.get(i); j>(int) tableForStars.get(i-1);j--)
                {

                    if(result.charAt(i-1)=='n')
                    {
                        return "Second string is not a Substring";
                    }
                }
                return "Second string is a Substring";
            }

        }
        else
        {
            for(int i = 0; i<tableForStars.size()+1;i++)
            {
                for (int j =(int)tableForStars.get(i); j>(int) tableForStars.get(i);j--)
                {

                    if(result.charAt(i-1)=='n')
                    {
                        return "Second string is not a Substring";
                    }
                }
                return "Second string is a Substring";
            }

        }
       return "";

    }
    private String checkResultSlash()
    {
        for (int i =result.length(); i>result.length()-secondString.length()+tableForStars.size();i--)
        {

            if(result.charAt(i-1)=='n')
            {
                return "Second string is not a Substring";
            }
        }
        return "Second string is a Substring";
    }

}














