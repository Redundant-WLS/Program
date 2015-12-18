
public class TabOneFrg extends Fragment {


    NFRecyclerView rvList;
    public ScrollView outer;
    public int header;
    public int content;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frg_first, null);
        rvList=(NFRecyclerView)view.findViewById(R.id.rv_list);

        rvList.parentScrollView=outer;
        rvList.HeaderId=header;
        rvList.ContentContainerId=content;

        rvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        rvList.setAdapter(new TestAdapter());
        return view;
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}
