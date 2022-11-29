import java.util.List;
import java.util.Set;

public interface BlackListFilter {

    /**
     * From the given list of comments removes ones
     * that contain words from the black list.
     *
     * @param comments  list of comments; every comment
     *                  is a sequence of words, separated
     *                  by spaces, punctuation or line breaks
     * @param blackList list of words that should not
     *                  be present in a comment
     */
    void filterComments(List<String> comments, Set<String> blackList);
}

class Relies implements  BlackListFilter{

    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {

        List<String> comments_new = null;
        for(int i=0; i<comments.size(); i++){
            Boolean flag = true;
            for (String j: comments.get(i).split(" ")) {
                if(blackList.contains(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                comments_new.add(comments.get(i));
            }
        }

        comments = comments_new;

    }
}
