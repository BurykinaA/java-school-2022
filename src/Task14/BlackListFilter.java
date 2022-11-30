import java.util.*;


public interface BlackListFilter<T1, T2> {

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
    Collection<T1> filterComments(Collection<T1> comments, Collection<T2> blackList);

}

class Relies implements  BlackListFilter{


    @Override
    public Collection filterComments(Collection comments, Collection blackList) {
        Collection comments_new = null;
        Iterator Iter = comments.iterator();
        while (Iter.hasNext()){
            Object tmp = Iter.next();
            Boolean flag = true;
            for (Object j: (tmp.toString().split(" "))) {
                if(blackList.contains(j)){
                    flag = false;
                    break;
                }
            }
            if(flag){
                comments_new.add(tmp);
            }
        }

        return comments_new;
    }
}
