package com.ydnsa.koinmvi.di


import com.ydnsa.koinmvi.data.fake.FakeJsonReader
import com.ydnsa.koinmvi.data.fake.LoginApi
import com.ydnsa.koinmvi.data.network.repository.LoginRepository
import com.ydnsa.koinmvi.data.network.repository.LoginRepositoryImpl
import com.ydnsa.koinmvi.domain.usecase.LoginUseCase
import com.ydnsa.koinmvi.presentation.home.HomeViewModel
import com.ydnsa.koinmvi.presentation.login.LoginModelView
import com.ydnsa.koinmvi.presentation.noteitemlist.NoteItemListViewModel
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import org.koin.androidx.viewmodel.dsl.viewModel



val appModule= module{
    single { LoginApi() }

    single<LoginRepository> { LoginRepositoryImpl(get()) }
    factory { LoginUseCase(get()) }
    factory { FakeJsonReader() }
    viewModel{
        LoginModelView(get())
    }
    viewModel { HomeViewModel(get()) }
    viewModel { NoteItemListViewModel(get()) }


}