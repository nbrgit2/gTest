//Second Commit
import java.util.Arrays;
import java.util.*;



//Geeks for geeks solution
public class SmallWindow {

	public static void main(String[] args) {
		
		String str = "aabcbcdbcadbc"; 
	    
	    List<Character> dist=new ArrayList<>();
	    int dist_count=0;
	    
	    for(Character c: str.toCharArray())
	    {
	        if(!dist.contains(c))
	        {
	        	dist.add(c);dist_count++;
	        }
	            
	    }
	    
	    int start=0;
	    int start_index=0; 
	    int min_length=Integer.MAX_VALUE; 
	    int winCount=0;
	    
	    Map<Character,Integer> curMap=new HashMap<>();
	    
	    for(int i=0; i < str.length(); i++)
	    {
	        Character key=str.charAt(i);
	        if(!curMap.containsKey(key))
	        {
	            curMap.put(key,1);
	        }
	        else
	        {
	           int count=curMap.get(key);
	           curMap.put(key,count+1);
	        }
	        
	        if(curMap.get(key)==1)
	        	winCount++;
	        
	        if(winCount==dist_count)
	        {
	           
	             while(curMap.get(str.charAt(start)) > 1)
	             {
	                 int count=curMap.get(str.charAt(start));
	                 curMap.put(str.charAt(start),count-1);
	                 
	                 start++;
	             }
	             
	             int win_length=i-start+1;
	 	        
	 	        if(min_length > win_length)
	 	        {
	 	            min_length=win_length;
	 	            start_index=start;
	 	        } 
	        }
	        
	    }
	    System.out.println(str.substring(start_index,start_index+min_length));		} 
			
		 
		// This code is contributed by Sumit Ghosh 


	}

	
//My own Code
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;

class SmallWindow {
	
	public static void main (String[] args) {
		
		String str="abcdaaaaabbbbdddcccabd";
		String smallStr=str;
		
		int length=0;
		
		List<Character> list=new ArrayList<Character>();
	
		for(Character c: str.toCharArray())
		{
		  if(list.contains(c))
		          continue;
		  else
		   {
		      list.add(c);length++;
		   }
		}
	    
		for(int i=0; i <= str.length()-length; i++)
		{
		    
		    String subStr="";
		    int sublength=0;
		    List<Character> sublist=new ArrayList<Character>();
		    		    
		    for(int j=i; j < str.length(); j++)
		    {
		        if(sublist.contains(str.charAt(j)))
		            continue;
		        else
		        {
		        	sublist.add(str.charAt(j));sublength++;
		        }
		        
		        if(length==sublength)
		        {
		            subStr=str.substring(i,j+1);break;
		        }
		            
		    }
		    
		    if(subStr.length() < smallStr.length() && subStr!="")
		    {
		    	smallStr=subStr;
		    	if(subStr.length()==length)
		    		break;
		    }
		        
		    
		}
		
		System.out.println(smallStr);
	}
}
