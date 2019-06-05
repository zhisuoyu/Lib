package zsy.base.java.wrapper.log;

public interface IAssembleLog {

    String assemble(String baseTag, String tag, String msg);

    String prefix();

    String threadInfo();

    String datetimeInfo();

    String tagInfo(String baseTag, String tag);

    String topBorder(String prefix);

    String bottomBorder(String prefix);

    String divider(String prefix);

    String des(String prefix, String baseTag, String tag);

    String content(String prefix, String content);

}
