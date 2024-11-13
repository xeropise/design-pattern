package creation.prototype;

import java.util.HashMap;
import java.util.List;

/**
 * 깊은 복사로 모든 데이터를 갱신하여 시간 및 메모리를 필요하는 것보다
 * 얕은 복사 + 깊은 복사로 필요한 데이터만 갱신하는 것이 효율적이다.
 *
 */
public class Demo {
    private HashMap<String, SearchWord> currentKeywords = new HashMap<>();
    private long lastUpdateTime = -1;

    public void refresh() {
        // Shallow Copy, java의 clone() 메서드는 얕은 복사를 수행한다.
        HashMap<String, SearchWord> newKeywords = (HashMap<String, SearchWord>) currentKeywords
                .clone();

        List<SearchWord> toBeUpdatedSearchWords = getSearchWords(lastUpdateTime);

        long maxNewUpdatedTime = lastUpdateTime;

        assert toBeUpdatedSearchWords != null;

        // HashMap에 담긴 SearchWord 중 갱신이 필요한 객체들만 갱신한다. Deep Copy
        for (SearchWord searchWord : toBeUpdatedSearchWords) {
            if (searchWord.getLastUpdateTime() > maxNewUpdatedTime) {
                maxNewUpdatedTime = searchWord.getLastUpdateTime();
            }

            newKeywords.remove(searchWord.getKeyword());
            newKeywords.put(searchWord.getKeyword(), searchWord);
        }
        lastUpdateTime = maxNewUpdatedTime;

        currentKeywords = newKeywords;
    }


    private List<SearchWord> getSearchWords(long lastUpdatedTime) {
        // 데이터베이스 갱신 시간이 lastUpdatedTime 보다 큰 데이터를 가져온다.
        return null;
    }
}
