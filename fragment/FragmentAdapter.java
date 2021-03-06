
public class FragmentAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragmentArray;
    
       public FragmentAdapter(FragmentManager fm, ArrayList<Fragment> fragmentArray) {
        this(fm);
        this.fragmentArray = fragmentArray;
    }
    
    public FragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    
       @Override
    public Fragment getItem(int arg0) {
        return this.fragmentArray.get(arg0);
    }

    @Override
    public int getCount() {
        return this.fragmentArray.size();
    }


}
