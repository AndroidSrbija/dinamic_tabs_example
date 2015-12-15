# Tabbed Activity Example 

* * *

## Add and remove tabs while app is runing

* * *

### When creating tabbed activity set Navigation Style as Action Bar Tabs(with ViewPager)

### Create custom toolbar (see android-toolbar-example) and add imageButton and implements its onClick

```xml
<ImageButton
    android:id="@+id/addTab"
    android:layout_width="30dp"
    android:layout_height="30dp"
    android:layout_marginRight="20dp"
    android:background="@drawable/add_tab"
    android:onClick="addTabOnClick"/>
```

```java
public void addTabOnClick(View view) {
    mSectionsPagerAdapter.addTab();
}
```

### Set tabMode scrollable

```xml
<android.support.design.widget.TabLayout
    android:id="@+id/tabs"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:background="@color/colorPrimary"
    app:tabMode="scrollable"/>
```

### Create Fragment Page Adapter and owerride its methods

```java 
public class SectionsPagerAdapter extends FragmentPagerAdapter {      
    ArrayList<String> mTabs;
    public SectionsPagerAdapter(FragmentManager fm) {
         super(fm);
         mTabs=new ArrayList<>();
    }
}
```

```java
@Override
public Fragment getItem(int position) {
    return mTabs.get(position).getFragment();
}
```

```java
@Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
}
```

```java
@Override
public int getCount() {
    return mTabs.size();
}
```

```java
@Override
public CharSequence getPageTitle(int position) {
    return mTabs.get(position);
}
```

### Add method to add tab

```java
public void addTab(final ViewPager viewPager, TabLayout tabLayout){
    mTabs.add(new Tab("Tab ", (getCount() + 1), new TabFragment()));
    notifyDataSetChanged();
    tabLayout.setupWithViewPager(viewPager);
    viewPager.setCurrentItem(getCount() - 1, true);
}
```
 
### Override onCreate in main activiy
 
```java
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
    setSupportActionBar(toolbar);
    mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    mViewPager = (ViewPager) findViewById(R.id.container);
    mViewPager.setAdapter(mSectionsPagerAdapter);
    mTabLayout = (TabLayout) findViewById(R.id.tabs);
    mTabLayout.setupWithViewPager(mViewPager);
}
 ```