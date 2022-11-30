import java.util.*;

public class Main {

    static int maxx = 0;

    public static void main(String[] args) {
        Map<String,Integer> vertex = new HashMap<String, Integer>();

        Scanner in = new Scanner(System.in);

        int cnt = in.nextInt();
        ArrayList<ArrayList<Integer>> g = new ArrayList<ArrayList<Integer>>(cnt);
        ArrayList<ArrayList<Integer>> len = new ArrayList<ArrayList<Integer>>(cnt);

        int curr_ind = 0;
//
//        System.out.println(cnt);

        for(int i=0; i<cnt; i++){ //создали граф
            System.out.println(in.hasNextLine());
            //System.out.println(in.nextLine());
//            String tmp = in.nextLine();
            String[] hlp = in.nextLine().split(",");
//            System.out.println(tmp);
            if(vertex.containsKey(hlp[1])){
                curr_ind = getCurr_ind(vertex, g, curr_ind, hlp, len);
            }
            else{
                vertex.put(hlp[1], curr_ind);
                curr_ind++;
                curr_ind = getCurr_ind(vertex, g, curr_ind, hlp, len);
            }
        }

        List<Boolean> used = new ArrayList<Boolean>(cnt);

        for(int i=0; i<cnt; i++) used.set(i, false);
        dfs(0, -1,used, 0, maxx, len, g);

        System.out.println(maxx);
    }

    static void dfs(int v, int pr, List<Boolean> used, int dist, int maxx, List<ArrayList<Integer>> len, List<ArrayList<Integer>> g){
        used.set(v, true);
        if(pr!=-1) dist+= len.get(pr).get(v);
        for(int i: g.get(v)){
            if(!used.get(i))
                dfs(i, v, used, dist, maxx, len, g);
        }
        dist-=len.get(pr).get(v);

        if(maxx<dist) maxx = dist;

    }

    private static int getCurr_ind(Map<String, Integer> vertex, List<ArrayList<Integer>> g, int curr_ind, String[] hlp, List<ArrayList<Integer>> len) {
        vertex.put(hlp[0], curr_ind);
        curr_ind++;
        g.get(vertex.get(hlp[1])).add(vertex.get(hlp[0]));
        len.get(vertex.get(hlp[1])).add(Integer.valueOf(hlp[2]));
        return curr_ind;
    }
}