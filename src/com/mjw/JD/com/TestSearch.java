package com.mjw.JD.com;

public class TestSearch {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array = {1,2,3,4,5,6,8,16,18,25,36,66,88,88,99};
		int index = biSearchFirst(array, 88);
		System.out.println("����Ǳ꣺" + index);
	}
	
	// �ǵݹ����
	public static int biSearch(int []array,int a){
        int lo=0;
        int hi=array.length-1;
        int mid;
        while(lo<=hi){
            mid=(lo+hi)/2;
            if(array[mid]==a){
                return mid+1;
            }else if(array[mid]<a){
                lo=mid+1;
            }else{
                hi=mid-1;
            }
        }
        return -1;
    }
	
	// ���ҵ�һ��Ԫ�س��ֵ�λ�ã�Ԫ�������ظ���
	public static int biSearchFirst(int []array,int a){
        int n=array.length;
        int low=0;
        int hi=n-1;
        int mid=0;
        while(low<hi){
            mid=(low+hi)/2;
            if(array[mid]<a){
                low=mid+1;
            }else{
                hi=mid;
            }
        }
        if(array[low]!=a){
            return -1;
        }else{
            return low;
        }
    }

	// ��ѯԪ�����һ�γ��ֵ�λ��
	public static int biSearchLast(int []array,int a){
        int n=array.length;
        int low=0;
        int hi=n-1;
        int mid=0;
        while(low<hi){
            mid=(low+hi+1)/2;
            if(array[mid]<=a){
                low=mid;
            }else{
                hi=mid-1;
            }
        }
    
        if(array[low]!=a){
            return -1;
        }else{
            return hi;
        }
    }
}
