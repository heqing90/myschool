package com.fangyuan.myschool.utils;

public class MyUtil {
	public static int[] range(int start,int end,int step){
	    int sz =(end-start)/step;
	    int[] result=new int[sz];
	    for(int i=0;i<sz;i++)
	        result[i]=start+(i*step);
	    return result;
	}
}
