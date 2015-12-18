
public class TabTwoFrg extends Fragment {


    NFWebView rvList;
    public ScrollView outer;
    public int header;
    public int content;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_two, null);
        rvList=(NFWebView)view.findViewById(R.id.rv_list);
        rvList.setVerticalScrollBarEnabled(false);
        rvList.setVerticalScrollbarOverlay(false);
        rvList.setHorizontalScrollBarEnabled(false);
        rvList.setHorizontalScrollbarOverlay(false);
        rvList.getSettings().setJavaScriptEnabled(true);
        rvList.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return super.shouldOverrideUrlLoading(view, url);
            }
        });
        rvList.parentScrollView=outer;
        rvList.HeaderId=header;
        rvList.ContentContainerId=content;

        rvList.loadUrl("http://www.baidu.com");
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
