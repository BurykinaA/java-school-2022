package Task13;

import java.util.*;

public class Task13 {

    static List<String> films = List.of(new String[]{"1,Мстители: Финал", "2,Хатико", "3,Дюна", "4,Унесенные призраками"});
    static List<String> history = List.of(new String[]{"2,1,3", "1,4,3", "2,2,2,2,2,3"});

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>(); // список с колличеством просмотров

        for(int i = 0; i<history.size(); i++){
            for(String s: history.get(i).split(",")){
                if(map.containsKey(s))
                    map.put(s, map.get(s)+1);
                else
                    map.put(s, 1);
            }
        }

        Scanner scanner = new Scanner(System.in);
        String title = scanner.nextLine();

        ArrayList<Integer> relevant_index = new ArrayList<>(); // индексы подходящих пользователей

        List<String> new_user = List.of(title.split(","));
        Set<String> new_user_set = new HashSet<String>(new_user);

        for(int i=0; i< history.size(); i++){
            int cnt =0;
            Set<String> his_set = new HashSet<String>((List.of(history.get(i).split(","))));
            for(String s: his_set){
                if(new_user_set.contains(s)){
                    cnt++;
                }
            }
            if(cnt >= 0.5*new_user_set.size())
                relevant_index.add(i);
        }

        String best_film = null;
        Integer best_score = 0;

        for(int i=0; i<relevant_index.size(); i++){
            Set<String> his_set = new HashSet<String>((List.of(history.get(i).split(","))));
            for(String s: his_set){
                if(!new_user_set.contains(s) && map.get(s) > best_score){
                    best_score = map.get(s);
                    best_film = s;
                }
            }
        }

        for(String s : films){
            if(s.startsWith(best_film)){
                for(int i= s.indexOf(',') +1; i<s.length(); i++){
                    System.out.print(s.charAt(i));
                }
            }
                
        }



    }
}