package com.max.indicatorseekbar

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout
import com.max.indicatorseekbar.donation.BaseActivity
import com.max.indicatorseekbar.donation.DonationFragment
import com.max.indicatorseekbar.fragment.ContinuousFragment
import com.max.indicatorseekbar.fragment.CustomFragment
import com.max.indicatorseekbar.fragment.DiscreteFragment
import com.max.indicatorseekbar.fragment.IndicatorFragment
import com.max.indicatorseekbar.fragment.JavaBuildFragment


/**
 * MainActivity is the primary activity of the application, responsible for setting up fragments and views.
 *
 * Developed by destin55.
 */
class MainActivity : BaseActivity() {

    private val sType = arrayOf("continuous", "discrete", "custom", "java", "indicator", "donation")
    private val mFragmentList = mutableListOf<Fragment>()

    override fun getLayoutResId(): Int {
        return R.layout.activity_main
    }

    override fun initCreate() {
        super.initCreate()
        initFragment()
        initViews()
    }

    private fun initFragment() {
        mFragmentList.add(ContinuousFragment())
        mFragmentList.add(DiscreteFragment())
        mFragmentList.add(CustomFragment())
        mFragmentList.add(JavaBuildFragment())
        mFragmentList.add(IndicatorFragment())
        mFragmentList.add(DonationFragment())
    }

    private fun initViews() {
        val viewPager = findViewById<ViewPager>(R.id.viewPager)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)

        viewPager.adapter = PagerAdapter(supportFragmentManager)
        tabLayout.setupWithViewPager(viewPager)

        for (s in sType) {
            val textView = TextView(this)
            textView.text = s
            tabLayout.newTab().setCustomView(textView)
        }
    }

    private inner class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

        override fun getItem(position: Int): Fragment {
            return mFragmentList[position]
        }

        override fun getCount(): Int {
            return sType.size
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return sType[position]
        }
    }
}
