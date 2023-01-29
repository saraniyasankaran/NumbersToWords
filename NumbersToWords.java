package NumbersToWords;

import java.util.*;

public class NumbersToWords {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int number = sc.nextInt();
		int i;
		int count = 0;
		for(i=number; i>0; i/=10) {
			count++;
		}
		if(number == 0) {
			System.out.println("Zero");
		}
		else {
		
		String stringNum = String.valueOf(number);
		int len = stringNum.length();
		char lst = stringNum.charAt(len-1);
        int lstNum = Integer.parseInt(String.valueOf(lst));
		String str = "";
		int value=0,forTeen=0;
		int place=0;
		int convSub=0;
		String subSt = "";
	//	int last = stringNum.charAt(len-2);
		for(i=count-1; i>=0; i--) {
			char ch = stringNum.charAt(i);
			value = Integer.valueOf(String.valueOf(ch));
			String uptoNineteen[] = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine","Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen",
					"Sixteen","Seventeen","Eighteen","Nineteen"};
			String ty[] = {"","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
			
			if(i>0){
			
		    	subSt = stringNum.substring(i-1,i+1);
		    	convSub = Integer.valueOf(subSt);
			}
		     else {
			convSub = 22;
			}
		
	    if(place==2) {
	    	if(value!=0) {
	    		str = "hundred "+str;
	    	}
	    	forTeen=0;
	    }
	    if(place==3) {
	    	if(value!=0) {
	    	str = "thousand "+str;
	    }
	    	forTeen=0;
	    }
	    
	    if(convSub<20 && place!=1 && place==0)  
        {
            str=uptoNineteen[convSub]+" "+str;
            //System.out.println("teen1");
            forTeen++;
            place++;
            i--;  
        }
	    else if(convSub<20 && place!=1 && place%2!=0) {
	    	str=uptoNineteen[convSub]+" "+str;
	    	forTeen++;
	    	place++;
	    	i--;
	    	
	    }
		else if(forTeen%2 == 0) {
			str = uptoNineteen[value] + " "+str;
			
		}
		else {
			 if(value==9 && lstNum==1){
                 str=ty[value]+"-"+str;
             }
		    else if(value>=2 && value<9 && lstNum!=0) {
			str = ty[value]+"-"+str;
			}
			else {
				str = ty[value]+" "+str;
			}
		}
		forTeen++;
		place++;
		}
		System.out.println(str);
	}
	}

}
