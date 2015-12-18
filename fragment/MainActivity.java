public class MainActivity extends FragmentActivity {
	private ViewPager mPager;
	private List<View> listViews; 
	private ImageView cursor;
	private View t1, t2, t3 , t4;
	private float offset = 0;
	private int m_screenW;
	private int currIndex = 0;
	private int bmpW;

	private int mResIds[];
    private ImageButton mTab_btns[];

    private static final int nTabCnt = 4;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.fragment_main);
		InitImageView();
		InitView();
		InitViewPager();
	}

	
	private void InitView() {
		t1 =  findViewById(R.id.tab1);
		t2 =  findViewById(R.id.tab2);
		t3 =  findViewById(R.id.tab3);
		t4 =  findViewById(R.id.tab4);
		
		listViews = new ArrayList<View>();
		listViews.add(t1);
		listViews.add(t2);
		listViews.add(t3);
		listViews.add(t4);
		t1.setOnClickListener(new MyOnClickListener(0));
		t2.setOnClickListener(new MyOnClickListener(1));
		t3.setOnClickListener(new MyOnClickListener(2));
		t4.setOnClickListener(new MyOnClickListener(3));
		
		mResIds   = new int[2 * nTabCnt];
		
		mResIds[0] = R.drawable.icon_receives_normal;
		mResIds[1] = R.drawable.icon_receives_selected;
		mResIds[2] = R.drawable.icon_release_normal;
		mResIds[3] = R.drawable.icon_release_selected;
		mResIds[4] = R.drawable.icon_finished_normal;
		mResIds[5] = R.drawable.icon_finished_selected;
		mResIds[6] = R.drawable.icon_del_normal;
		mResIds[7] = R.drawable.icon_del_selected;
		
		mTab_btns = new ImageButton[nTabCnt];	
		
		mTab_btns[0] = (ImageButton) findViewById(R.id.tab_icon1);
		mTab_btns[1] = (ImageButton) findViewById(R.id.tab_icon2);
		mTab_btns[2] = (ImageButton) findViewById(R.id.tab_icon3);
		mTab_btns[3] = (ImageButton) findViewById(R.id.tab_icon4);
		
	}


	private void InitViewPager() {
		mPager = (ViewPager) findViewById(R.id.viewpager);
		
		ArrayList<Fragment> fragmentArray = new ArrayList<Fragment>();
		fragmentArray.add(new Fragment1());
		fragmentArray.add(new Fragment2());
		fragmentArray.add(new Fragment3());
		fragmentArray.add(new FragmentDel());
		mPager.setAdapter(new FragmentAdapter(getSupportFragmentManager(), fragmentArray));
		mPager.setCurrentItem(0);
		mPager.setOnPageChangeListener(new MyOnPageChangeListener());
	}


	private void InitImageView() {
		cursor = (ImageView) findViewById(R.id.active_bar);
		
		bmpW = BitmapFactory.decodeResource(getResources(), R.drawable.a)
				.getWidth();
		DisplayMetrics dm = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(dm);
		int screenW = dm.widthPixels;
		m_screenW = screenW;
		offset = (screenW / nTabCnt - bmpW) / 2f;// ¼ÆËãÆ«ÒÆÁ¿
	}


	public class MyOnClickListener implements View.OnClickListener {
		private int index = 0;

		public MyOnClickListener(int i) {
			index = i;
		}

		@Override
		public void onClick(View v) {
			mPager.setCurrentItem(index);
		}
	};

	
	public class MyOnPageChangeListener implements OnPageChangeListener {

		@Override
		public void onPageSelected(int arg0) {
			Animation animation = null;
			
			for(View item : listViews){
				((TextView) item.findViewById(R.id.tab_text)).setTextColor(Color.GRAY);
				
			}
			
			((TextView)listViews.get(arg0).findViewById(R.id.tab_text)).setTextColor(Color.GREEN);
			
			float nStart = 0;
			float nDelta =(arg0-currIndex) * m_screenW/nTabCnt;
			if (currIndex > 0)
			{
				nStart = currIndex * m_screenW/nTabCnt ;
			}
			
			if (3 == arg0)
			{
				nDelta+= 2*offset;
			}
			
			animation = new TranslateAnimation(nStart, nDelta + nStart, 0, 0);
			mTab_btns[arg0].setImageResource(mResIds[arg0*2+1]);
			mTab_btns[currIndex].setImageResource(mResIds[currIndex*2]);
			currIndex = arg0;
			
			animation.setFillAfter(true);
			cursor.startAnimation(animation);
		}

		@Override
		public void onPageScrolled(int arg0, float arg1, int arg2) {
		}

		@Override
		public void onPageScrollStateChanged(int arg0) {
		}
	}
}
