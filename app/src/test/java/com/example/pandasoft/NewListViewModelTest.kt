package com.example.pandasoft

import androidx.lifecycle.MutableLiveData
import com.example.pandasoft.ui.login.LoginFragment
import com.example.pandasoft.ui.news.model.DataItem
import com.example.pandasoft.ui.news.page.newList.NewListFragment
import com.example.pandasoft.ui.news.page.newList.NewListRepository
import com.example.pandasoft.util.PreferenceData
import kotlinx.android.synthetic.main.login_fragment.*
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class NewListViewModelTest {

    @Mock
    private lateinit var view : NewListFragment

    @Mock
    private lateinit var newsData : MutableLiveData<List<DataItem>>

    @Mock
    private lateinit var newsDataSelected : MutableLiveData<DataItem>

    @Mock
    private lateinit var pref : PreferenceData

    @Mock
    private lateinit var repo : NewListRepository

    @Before
    fun setUp(){
        MockitoAnnotations.initMocks(this)
        newsData = MutableLiveData<List<DataItem>>()
    }

    @Test
    fun CheckUserName(){
//        `when`(view.).thenReturn("")
    }


}