
public class TestViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mData;
    public TestViewPagerAdapter(FragmentManager fm, List<Fragment> fragments) {
        super(fm);
        this.mData=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return mData.get(position);
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
//        super.destroyItem(container, position, object);
    }
}
