package lcwu;
import java.util.*;
public class Solution554 {
    public int leastBricks(List<List<Integer>> wall) {
        int max=0;
        int min =Integer.MAX_VALUE;
        for(List l: wall){
            max=Math.max(max,l.size());
            min=Math.min(min,l.size());
        }
        if(max==min&&max==1)return wall.size();

        int sum =0;
        for(Integer a:wall.get(0)){
            sum+=a;
        }
        System.out.println(sum);
        int[]temp = new int[sum+1];

        Arrays.stream(temp).sum();
        for (int i = 0; i <wall.size() ; i++) {
            int tempsum=0;
            for (int j = 0; j <wall.get(i).size() ; j++) {
                tempsum+=wall.get(i).get(j);
                temp[tempsum]++;
            }
        }
        Arrays.sort(temp);
        for(int i=0;i<temp.length;i++){
            System.out.println(temp[i]);
        }
        return wall.size()-temp[temp.length-2];
    }
}
