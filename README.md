# BaseComponent
**Base Components for base activities（BaseActivity、BaseTitleBarActivity、BaseTabBarActivity）and base fragments（LazyLoadFragment、BaseFragment）:**<br>
## BaseActivity
The base class for Activity:
1) Provide **StateView** for the Activity for **showing loading view layout、empty view layout and error view layout**;<br>
2) Provide abstract methods like **initView()** 、**initData()** and so on for sub Activity class to override to initialize relative views and datas 
## BaseTitleBarActivity
The base class for BaseTitleBarActivity which extends BaseActivity. The BaseTitleBarActivity provides the base title view 、callbacks when the title views are clicked and provides methods to change the style for the title view for sub Activity
## BaseTabBarActivity
The base class for BaseTabBarActivity which extends BaseTitleBarActivity. The BaseTabBarActivity is the base implementation for **TabLayout + ViewPager + Fragment** and provides abstract methods like **createFragments()**、**createPagerTitles()** for sub Activity to implement.The sub Activity just focus on providing Fragments and titles and don't need to care about the implementation for TabLayout + ViewPager + Fragment. 
## LazyLoadFragment
The base class for Fragment which provides **lazy load**.It will invoke **onFragmentVisibleChange(boolean)** method when the visibility for the fragment changes and invoke **onFragmentFirstVisible()** method when the fragment is the first time visible to the user,so if you need to load data while the fragment is first time visible to the user or do something when the visibility for user changes,you just need the lazy load framgnet.
## BaseFragment
The base class for Fragment which extends LazyLoadFragment:
1) Provide **StateView** for the Activity for **showing loading view layout、empty view layout and error view layout**;<br>
2) Provide abstract methods like **initView()** 、**initData()** 、 **loadData()** (load internet data when the Fragment is the first time visible to user)and so on for sub Fragment class to override to initialize and load relative views and datas 
