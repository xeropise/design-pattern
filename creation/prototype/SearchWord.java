package creation.prototype;

public class SearchWord {
    private String keyword;
    private long lastUpdateTime;

    public SearchWord(String keyword, long lastUpdateTime) {
        this.keyword = keyword;
        this.lastUpdateTime = lastUpdateTime;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public void setLastUpdateTime(long lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getKeyword() {
        return keyword;
    }

    public long getLastUpdateTime() {
        return lastUpdateTime;
    }

    public SearchWord clone() {
        return new SearchWord(this.keyword, this.lastUpdateTime);
    }

}
