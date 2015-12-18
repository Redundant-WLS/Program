
public class Fragment3 extends Fragment {
    
    private View layout = null;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        this.layout = inflater.inflate(R.layout.lay3, null);
        
       
        Button b = (Button)this.layout.findViewById(R.id.button1);
        b.setOnClickListener(new ButtonListener());
        
        return this.layout;
    }
    
    public class ButtonListener implements OnClickListener {

        @Override
        public void onClick(View v) {
            
            Toast.makeText(getActivity(), "button1", Toast.LENGTH_SHORT).show();
        }
    }
}
