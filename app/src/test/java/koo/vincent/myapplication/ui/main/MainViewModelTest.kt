package koo.vincent.myapplication.ui.main

import org.junit.Test

import org.junit.Assert.*

class MainViewModelTest {

    @Test
    fun add() {
        var mainViewModel = MainViewModel()

        val result = mainViewModel.add()

        assertEquals(4, result)
    }

}