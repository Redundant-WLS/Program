


public class TabThreeFrg extends Fragment {

    NFScrollView rvList;
    public ScrollView outer;
    public int header;
    public int content;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_three, null);
        rvList=(NFScrollView)view.findViewById(R.id.rv_list);

        rvList.parentScrollView=outer;
        rvList.HeaderId=header;
        rvList.ContentContainerId=content;

        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
