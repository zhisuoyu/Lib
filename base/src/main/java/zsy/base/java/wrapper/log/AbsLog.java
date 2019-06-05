package zsy.base.java.wrapper.log;

public abstract class AbsLog implements ILog {


    private int level;
    private String baseTag;

    @Override
    public void l(String tag, String msg, int level) {
        if (level < getLevel()) {
            return;
        }
        println(tag, msg, level);
    }

    @Override
    public void setBaseTag(String baseTag) {
        this.baseTag = baseTag;
    }

    @Override
    public String getBaseTag() {
        return baseTag == null ? DEFAULT_BASE_TAG : baseTag;
    }

    @Override
    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public int getLevel() {
        return level;
    }

    protected int adjustLevel(int level) {
        return Math.max(VERBOSE, Math.min(ASSERT, level));
    }

    @Override
    public boolean isAvailable() {
        return true;
    }
}
