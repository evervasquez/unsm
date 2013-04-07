package librerias;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;

public class scroll implements OnScrollListener{
    private int visibleThreshold = 5;
    private int currentPage = 0;
    private int previousTotal = 0;
    private boolean loading = true;
    private onScrollEndListener onScrollEnd;
    
    public interface onScrollEndListener {void onEnd(int page);}
    
    public scroll(onScrollEndListener onScrollEnd) {
     super();
     this.onScrollEnd = onScrollEnd;
    }
    public scroll(int visibleThreshold, onScrollEndListener onScrollEnd) {
     super();
        this.visibleThreshold = visibleThreshold;
        this.onScrollEnd = onScrollEnd;
    }


    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        if (loading) {
            if (totalItemCount > previousTotal) {
                loading = false;
                previousTotal = totalItemCount;
                currentPage++;
            }
        }
        if (!loading && (totalItemCount - visibleItemCount) <= (firstVisibleItem + visibleThreshold)) {
            loading = true;    
            if(totalItemCount > visibleThreshold)
             onScrollEnd.onEnd(currentPage);
        }
    }


    public void onScrollStateChanged(AbsListView view, int scrollState) {     
    }
    
  
}