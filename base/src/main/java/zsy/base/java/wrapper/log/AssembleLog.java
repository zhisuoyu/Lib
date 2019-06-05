package zsy.base.java.wrapper.log;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class AssembleLog extends AbsLog implements IAssembleLog {


   public static final SimpleDateFormat SDF = new SimpleDateFormat("MM-dd HH:mm:ss sss", Locale.CHINA);
   public static final String BK = "\n";
   public static final String BORDER_H = "────────────────────────────────────────────────────────────────────────────────────────────────────────────";
   public static final String DIVIDER = "┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄┄";
   public static final String BORDER_V = "│";
   public static final String LEFT_TOP = "┌";
   public static final String LEFT_MIDDLE = "├";
   public static final String LEFT_BOTTOM = "└";
   public static final String TAB = "   ";
   public static final String SPACE = " ";

   public static final int MAX_LINE_LEN = 120;

    public static void main(String[] args) {
        new AssembleLog().l("AssembleLog", "hellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohellohello", 8);
    }

//    @Override
//    public void l(String tag, String msg, int level) {
//        String rt = assemble(getBaseTag(), tag, msg);
//
//        if (level <= INFO) {
//            System.out.println(rt);
//        } else {
//            System.err.println(rt);
//        }
//    }


    @Override
    public void println(String tag, String msg, int level) {
        String rt = assemble(getBaseTag(), tag, msg);
        if (level <= INFO) {
            System.out.println(rt);
        } else {
            System.err.println(rt);
        }
    }

    @Override
    public String assemble(String baseTag, String tag, String msg) {
        String content = String.valueOf(msg);
        String prefix = prefix();

        return topBorder(prefix) +
                BK +
                des(prefix, getBaseTag(), tag) +
                BK +
                divider(prefix) +
                content(prefix, content) +
                BK +
                bottomBorder(prefix);
    }

    @Override
    public String prefix() {
        return datetimeInfo();
    }

    @Override
    public String threadInfo() {
        Thread thread = Thread.currentThread();
        return "thread:" + thread.getName() + "(" + thread.getId() + ")";
    }

    @Override
    public String tagInfo(String baseTag, String tag) {
        return baseTag + "-" + tag;
    }

    @Override
    public String datetimeInfo() {
        return SDF.format(System.currentTimeMillis()) + " : ";
    }

    @Override
    public String topBorder(String prefix) {
        return prefix + LEFT_TOP + BORDER_H;
    }

    @Override
    public String bottomBorder(String prefix) {
        return prefix + LEFT_BOTTOM + BORDER_H;
    }

    @Override
    public String divider(String prefix) {
        return prefix + LEFT_MIDDLE + DIVIDER;
    }

    @Override
    public String des(String prefix, String baseTag, String tag) {
        return prefix + BORDER_V + SPACE + threadInfo() + TAB + tagInfo(baseTag, tag);
    }

    @Override
    public String content(String prefix, String content) {
        StringBuilder sb = new StringBuilder(content);
        int size = sb.length() / MAX_LINE_LEN;

        for (int i = size; i >= 0; i--) {
            sb.insert(i * MAX_LINE_LEN, BK + prefix + BORDER_V + SPACE);
        }
        return sb.toString();
    }


}
