package zsy.base.android.wrapper.nav;

public abstract class NavListener implements PageListener, TabListener {

    private int pagePosition = -1;
    private int tabPosition = -1;


    public final void pageSelected(int position) {
        pagePosition = position;
//        onPageSelected(position);
        if (tabPosition != position) {
            onTabSelected(position);
        }
    }

    public final void tabSelected(int position) {
        tabPosition = position;
//        onTabSelected(position);
        if (pagePosition != position) {
            onPageSelected(position);
        }
    }


}
