import java.util.*;
public class ArrOperation {
	
	public int largestMirror(int[] array)
	{
		int mirrorLength=0;
		int largestLength=0;
		for(int i=0;i<array.length;i++)
		{
			for(int j=array.length-1;j>i;j--)
			{
				mirrorLength=0;
				if(array[i]==array[j])
				{
					int index=i;
					int mirrorIndex=j;
					while(index<array.length && mirrorIndex>=0)
					{
						if(array[index]==array[mirrorIndex])
						{
						    mirrorLength++;
						    index++;
						    mirrorIndex--;
						}
						else
						{
							break;
						}
					}
					if(largestLength<mirrorLength)
					{
						largestLength=mirrorLength;
						mirrorLength=0;
					}
				}
			}
		}
		return largestLength;
	}
	
	public int countClumps(int[] array)
	{
		int numClumps=0;
		for(int i=0;i<array.length-1;i++)
		{
			if(array[i]==array[i+1])
			{
				if(i==0)
				{
					numClumps++;
				}
				else if(array[i-1]!=array[i])
				{
					numClumps++;
				}
			}
		}
		return numClumps;
	}
	
	public int[] fixXY(int[] array,int x,int y)
	{
		int indexY=0;
		int[] fix=array;
		
		outer:for(int i=0;i<fix.length;i++)
		{
			if(fix[i]==x)
			{
				if(i==fix.length-1)
				{
					fix=null;
					break;//throw assertion error
				}
				else if(fix[i+1]==x)
				{
					fix=null;
					break;//throw assertion error
				}
				else if(fix[i+1]!=y)
				{
				    for(int j=indexY;j<fix.length;j++)
				    {
					    if(fix[j]==y)
					    {
						    if(j==0)
						    {
						        int swap=fix[i+1];
						        fix[i+1]=fix[j];
						        fix[j]=swap;
						        indexY=j+1;
						        break;
						    }
						    else if(fix[j-1]!=x)
						    {
							    int swap=fix[i+1];
						        fix[i+1]=fix[j];
						        fix[j]=swap;
						        indexY=j+1;
						        break;
						     }
					    }
					    else if(j==fix.length-1);
					    {
						    fix=null;
						    break outer;//throw assertion error
					    }
				    }
				}
			}
		}
		return fix;
	}
	
	public int splitArray(int[] array)
	{
		int index=0;
		int sumLeft=0;
		int sumRight=0;
		for(int i=0,j=array.length-1;i<=j;)
		{
			if(sumLeft==sumRight)
			{
				if(i==j)
				{
					index=-1;
					break;
				}
				else
				{
					sumLeft=sumLeft+array[i];
					sumRight=sumRight+array[j];
					index=j;
					i++;
					j--;
				}
			}
			else if(sumLeft>sumRight)
			{
				sumRight=sumRight+array[j];
				index=j;
				j--;
			}
			else
			{
				sumLeft=sumLeft+array[i];
				i++;
			}
		}
		return index;
	}
	
/*	public static void main(String args[])
	{
		Scanner sc=new Scanner(System.in);
		int arr[]=new int[7];
		System.out.println("Enter array elements");
		for(int i=0;i<7;i++)
		{
			arr[i]=sc.nextInt();
		}
		ArrOperation a=new ArrOperation();
		int[] array=a.fixXY(arr, 4, 5);
		if(array==null)
		{
			System.out.println("-1");
			return;
		}
		for(int i=0;i<array.length;i++)
		{
		    System.out.println(array[i]);
		}
	}
*/
}
