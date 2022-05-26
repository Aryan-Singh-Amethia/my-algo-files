import java.util.Arrays;
import java.util.List;
public class Main {
    public static int bs(Integer arr[],int t,int s,int f){
        int m=s+(f-s)/2;
        if(m>=arr.length || m<0 || s>f) return -1;
        if(arr[m]==t) return m;
        else if(arr[m]>t)
           return bs(arr,t,s,m-1);
        else 
            return bs(arr,t,m+1,f);

    }

    public static void main(String[]args){
        System.out.println(bs(new Integer[]{1,1,2,2,4,4,4,4,6,6,6},2,0,10));
        int idx=-1,count=0;
        Integer arr[]=new Integer[]{1,1,2,2,4,4,4,4,6,6,6};
        idx=bs(new Integer[]{1,1,2,2,4,4,4,4,6,6,6},2,0,10);
        if(idx!=-1){
            int i=idx-1,j=idx;
            while(i>=0 && arr[i]==2) i--;
            while(j<11 && arr[j]==2) j++;
            count=j-i-1;
        }
        System.out.println(count);

        List<Integer> list=Arrays.asList(new Integer[]{1,1,2,2,4,4,4,4,6,6,6});
        System.out.println(list);
    }
}
