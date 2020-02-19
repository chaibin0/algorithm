package problems.romanToInteger;

class Solution {
    public int romanToInt(String s) {
        int answer=0;
        int[] value= {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] symbol= {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        boolean flag=true;
        int position=0;
        for(int i=0;i<symbol.length;i++) {
            flag=true;

            while(flag) {
                if(position+symbol[i].length()>s.length()) break;
                if(symbol[i].equals(s.substring(position,position+symbol[i].length()))) {
                    answer+=value[i];
                    position+=symbol[i].length();

                }
                else
                    flag=false;
            }
        }

        return answer;
    }
}