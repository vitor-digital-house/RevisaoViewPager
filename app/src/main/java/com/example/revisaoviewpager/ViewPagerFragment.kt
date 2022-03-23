package com.example.revisaoviewpager

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class ViewPagerFragment : Fragment(R.layout.fragment_view_pager) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val meuViewPager = view.findViewById<ViewPager>(R.id.view_pager)
        configuraViewPager(meuViewPager)

        val meuTabLayout: TabLayout = view.findViewById(R.id.tab_layout)
        configuraTabLayout(meuTabLayout, meuViewPager)
    }

    private fun configuraViewPager(viewPager: ViewPager) {
        // CRIO O ADAPTER
        val meuAdapter = MeuViewPagerAdapter(fragmentManager = childFragmentManager)

        // CRIO MEUS FRAGMENTS
        val primeiroFragment = PrimeiroFragment.criar()
        val segundoFragment = SegundoFragment.criar()

        // ADICIONO MEUS FRAGMENTS AO ADAPTER, JUNTO AO TITULO DE CADA TAB
        meuAdapter.addFragment(primeiroFragment, "1")
        meuAdapter.addFragment(segundoFragment, "2")

        // ADICIONO O ADPTER AO VIEWPAGER
        viewPager.adapter = meuAdapter
    }

    private fun configuraTabLayout(tabLayout: TabLayout, viewPager: ViewPager) {
        // ADICIONA O VIEWPAGER AO TABLAYOUT
        tabLayout.setupWithViewPager(viewPager)
    }
}